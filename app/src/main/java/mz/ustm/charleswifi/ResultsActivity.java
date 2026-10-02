package mz.ustm.charleswifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

 private TextView txtSummary;
 private RecyclerView recyclerView;
 private WifiAdapter adapter;
 private List<WifiNetwork> wifiList;
 private WifiManager wifiManager;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_results);

  txtSummary = findViewById(R.id.txtSummary);
  recyclerView = findViewById(R.id.recyclerWifi);

  recyclerView.setLayoutManager(new LinearLayoutManager(this));

  wifiList = new ArrayList<>();
  adapter = new WifiAdapter(wifiList);
  recyclerView.setAdapter(adapter);

  wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

  // Captura o filtro enviado e remove espaços em branco
  String filter = getIntent().getStringExtra("FILTER");
  if (filter != null) {
   filter = filter.trim();
  } else {
   filter = "";
  }

  if (isLocationServiceEnabled()) {
   scanAndLoadWifiNetworks(filter);
  } else {
   txtSummary.setText("Localização desativada.");
   Toast.makeText(this, "Por favor, ative a Localização/GPS para detetar redes Wi-Fi.", Toast.LENGTH_LONG).show();
  }
 }

 private boolean isLocationServiceEnabled() {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
   android.location.LocationManager locationManager =
           (android.location.LocationManager) getSystemService(Context.LOCATION_SERVICE);
   return locationManager != null && locationManager.isLocationEnabled();
  } else {
   try {
    int mode = Settings.Secure.getInt(
            getContentResolver(),
            Settings.Secure.LOCATION_MODE
    );
    return mode != Settings.Secure.LOCATION_MODE_OFF;
   } catch (Settings.SettingNotFoundException e) {
    return false;
   }
  }
 }

 private void scanAndLoadWifiNetworks(String filter) {
  if (wifiManager == null) {
   txtSummary.setText("Wi-Fi indisponível.");
   Toast.makeText(this, "Wi-Fi não disponível neste dispositivo.", Toast.LENGTH_SHORT).show();
   return;
  }

  try {
   List<ScanResult> scanResults = wifiManager.getScanResults();
   wifiList.clear();

   if (scanResults != null) {
    for (ScanResult result : scanResults) {
     String ssid = result.SSID;

     // Ignora redes sem nome ou ocultas
     if (ssid == null || ssid.trim().isEmpty()) {
      continue;
     }

     // Limpa aspas que o Android adiciona ao SSID
     String cleanSsid = ssid.replace("\"", "").trim();

     // Se não houver filtro OU se o nome da rede começar exatamente pela letra/termo
     if (filter.isEmpty() || cleanSsid.toLowerCase().startsWith(filter.toLowerCase())) {
      wifiList.add(new WifiNetwork(cleanSsid, result.level));
     }
    }
   }

   // Ordena as redes pelo sinal mais forte (RSSI)
   Collections.sort(wifiList, new Comparator<WifiNetwork>() {
    @Override
    public int compare(WifiNetwork o1, WifiNetwork o2) {
     return Integer.compare(o2.getRssi(), o1.getRssi());
    }
   });

   // Atualiza o adaptador na interface
   adapter.notifyDataSetChanged();

   int totalEncontradas = wifiList.size();
   if (filter.isEmpty()) {
    txtSummary.setText(totalEncontradas + " rede(s) encontrada(s)");
   } else {
    txtSummary.setText(totalEncontradas + " rede(s) a começar por \"" + filter + "\"");
   }

   if (wifiList.isEmpty()) {
    Toast.makeText(this, "Nenhuma rede encontrada com a inicial \"" + filter + "\".", Toast.LENGTH_SHORT).show();
   }

  } catch (SecurityException e) {
   txtSummary.setText("Sem permissão de acesso.");
   Toast.makeText(this, "Permissão negada para aceder ao Wi-Fi.", Toast.LENGTH_SHORT).show();
  }
 }
}
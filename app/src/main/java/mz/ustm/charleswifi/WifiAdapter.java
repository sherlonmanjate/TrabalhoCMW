package mz.ustm.charleswifi;
import android.view.*; import android.widget.*; import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView; import java.util.List;
public class WifiAdapter extends RecyclerView.Adapter<WifiAdapter.ViewHolder>{
 private final List<WifiNetwork> networks;
 public WifiAdapter(List<WifiNetwork> networks){this.networks=networks;}
 @NonNull public ViewHolder onCreateViewHolder(@NonNull ViewGroup p,int v){
  return new ViewHolder(LayoutInflater.from(p.getContext()).inflate(R.layout.item_wifi,p,false));
 }
 public void onBindViewHolder(@NonNull ViewHolder h,int pos){
  WifiNetwork n=networks.get(pos); h.ssid.setText(n.getSsid());
  h.rssi.setText("Sinal: "+n.getRssi()+" dBm"); h.quality.setText(n.getQuality());
 }
 public int getItemCount(){return networks.size();}
 static class ViewHolder extends RecyclerView.ViewHolder{
  TextView ssid,rssi,quality; ViewHolder(View v){super(v);
  ssid=v.findViewById(R.id.txtSsid);rssi=v.findViewById(R.id.txtRssi);quality=v.findViewById(R.id.txtQuality);}
 }
}

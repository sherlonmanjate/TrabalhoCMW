package mz.ustm.charleswifi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

 private EditText edtNetwork; // ou TextInputEditText

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  edtNetwork = findViewById(R.id.edtNetwork);
  Button btnSearch = findViewById(R.id.btnSearch);

  btnSearch.setOnClickListener(v -> openResults());
 }

 private void openResults() {
  String filter = "";
  if (edtNetwork != null && edtNetwork.getText() != null) {
   filter = edtNetwork.getText().toString().trim(); // Limpa espaços extras
  }

  Intent intent = new Intent(this, ResultsActivity.class);
  intent.putExtra("FILTER", filter);
  startActivity(intent);
 }
}
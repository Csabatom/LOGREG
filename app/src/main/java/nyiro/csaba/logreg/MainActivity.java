package nyiro.csaba.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTXT_felhasznaloNev;
    EditText editTXT_jelszo;
    Button BTN_bejelentkezes;
    Button BTN_regisztracio;
    Database adatbazis;

    SharedPreferences felhasznaloAdatok;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        BTN_bejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bejelentkezes();
            }
        });

        BTN_regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        editTXT_felhasznaloNev = findViewById(R.id.editTXT_felhasznaloNev);
        editTXT_jelszo = findViewById(R.id.editTXT_jelszo);
        BTN_bejelentkezes = findViewById(R.id.BTN_bejelentkezes);
        BTN_regisztracio = findViewById(R.id.BTN_regisztracio);

        adatbazis = new Database(MainActivity.this);

        felhasznaloAdatok = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        editor = felhasznaloAdatok.edit();
    }

    private void bejelentkezes() {
        if(!(editTXT_felhasznaloNev.getText().toString().isEmpty() && editTXT_jelszo.getText().toString().isEmpty())) {
            Cursor adatok = adatbazis.Bejelentkezes(editTXT_felhasznaloNev.getText().toString(), editTXT_jelszo.getText().toString());
            if(adatok.getCount() == 1) {
                Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                while (adatok.moveToNext()){
                    intent.putExtra("nev", adatok.getString(0));
                }
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Helytelen felhasználói adatok", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Adjon meg felhasználói adatokat!", Toast.LENGTH_SHORT).show();
        }
    }
}

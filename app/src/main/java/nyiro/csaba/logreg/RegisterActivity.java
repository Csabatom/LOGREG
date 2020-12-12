package nyiro.csaba.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editTXT_email;
    EditText editTXT_felhasznaloNev;
    EditText editTXT_jelszo;
    EditText editTXT_teljesNev;
    Button BTN_Regisztracio;
    Button BTN_Vissza;

    Database adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        BTN_Regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regisztracio();
            }
        });

        BTN_Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        editTXT_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!editTXT_email.getText().toString().isEmpty() && !editTXT_felhasznaloNev.getText().toString().isEmpty() && !editTXT_jelszo.getText().toString().isEmpty() && !editTXT_teljesNev.getText().toString().isEmpty()) {
                    BTN_Regisztracio.setEnabled(true);
                } else {
                    BTN_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTXT_felhasznaloNev.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!editTXT_email.getText().toString().isEmpty() && !editTXT_felhasznaloNev.getText().toString().isEmpty() && !editTXT_jelszo.getText().toString().isEmpty() && !editTXT_teljesNev.getText().toString().isEmpty()) {
                    BTN_Regisztracio.setEnabled(true);
                } else {
                    BTN_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTXT_teljesNev.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!editTXT_email.getText().toString().isEmpty() && !editTXT_felhasznaloNev.getText().toString().isEmpty() && !editTXT_jelszo.getText().toString().isEmpty() && !editTXT_teljesNev.getText().toString().isEmpty()) {
                    BTN_Regisztracio.setEnabled(true);
                } else {
                    BTN_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTXT_jelszo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!editTXT_email.getText().toString().isEmpty() && !editTXT_felhasznaloNev.getText().toString().isEmpty() && !editTXT_jelszo.getText().toString().isEmpty() && !editTXT_teljesNev.getText().toString().isEmpty()) {
                    BTN_Regisztracio.setEnabled(true);
                } else {
                    BTN_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void init() {
        editTXT_email = findViewById(R.id.editTXT_email);
        editTXT_felhasznaloNev = findViewById(R.id.editTXT_felhasznaloNev);
        editTXT_jelszo = findViewById(R.id.editTXT_jelszo);
        editTXT_teljesNev = findViewById(R.id.editTXT_teljesNev);
        BTN_Regisztracio = findViewById(R.id.BTN_regisztracio);
        BTN_Vissza = findViewById(R.id.BTN_vissza);
        adatbazis = new Database(RegisterActivity.this);
    }

    public void regisztracio() {
        if(!editTXT_email.getText().toString().isEmpty() && !editTXT_felhasznaloNev.getText().toString().isEmpty() && !editTXT_jelszo.getText().toString().isEmpty() && !editTXT_teljesNev.getText().toString().isEmpty() && editTXT_email.getText().toString().contains("@")) {
            boolean allapot = adatbazis.Regisztracio(editTXT_email.getText().toString(), editTXT_felhasznaloNev.getText().toString(), editTXT_jelszo.getText().toString(), editTXT_teljesNev.getText().toString());
            if(allapot = true) {
                Toast.makeText(this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Sikerestelen regisztráció!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Töltse ki az összes mezőt!", Toast.LENGTH_SHORT).show();
        }
    }
}

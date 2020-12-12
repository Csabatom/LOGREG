package nyiro.csaba.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    TextView TXTview_felhasznaloNev;
    Button BTN_kijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        init();

        BTN_kijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TXTview_felhasznaloNev.setText(getIntent().getStringExtra("nev"));
    }

    private void init() {
        TXTview_felhasznaloNev = findViewById(R.id.TXTview_felhasznaloNev);
        BTN_kijelentkezes = findViewById(R.id.BTN_kijelentkezes);
    }
}

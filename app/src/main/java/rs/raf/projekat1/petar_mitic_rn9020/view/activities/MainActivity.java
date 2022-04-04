package rs.raf.projekat1.petar_mitic_rn9020.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import rs.raf.projekat1.petar_mitic_rn9020.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        initView();
        initListeners();
    }

    private void initListeners() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(SplashActivity.PREFERENCES_LOGIN, MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();
                Toast.makeText(MainActivity.this, "Podaci uspesno obrisani", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        textView = findViewById(R.id.textView);
    }
}
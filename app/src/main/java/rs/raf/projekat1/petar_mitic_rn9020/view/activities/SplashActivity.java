package rs.raf.projekat1.petar_mitic_rn9020.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import rs.raf.projekat1.petar_mitic_rn9020.R;

public class SplashActivity extends AppCompatActivity {

    public static final String PREFERENCES_LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_splash);
        login();
    }

    private void login() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_LOGIN, MODE_PRIVATE);
        String login = sharedPreferences.getString("login", "");
        if(login.equals("user") || login.equals("admin")){
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
        }else{
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(i);
        }
        finish();
    }
}
package rs.raf.projekat1.petar_mitic_rn9020.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import rs.raf.projekat1.petar_mitic_rn9020.R;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername, editEmail, editPassword;
    Button btnLogin;
    public static final String PREFERENCES_USERNAME = "username";
    public static final String PREFERENCES_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init(){
        initView();
        initListeners();
    }

    private void initListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editUsername.getText().toString().isEmpty()
                        || editEmail.getText().toString().isEmpty()
                        || editPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Morate popuniti sva polja", Toast.LENGTH_SHORT).show();
                }else if(editPassword.getText().toString().length() < 5){
                    Toast.makeText(LoginActivity.this, "Password mora biti duzi od 5 karaktera", Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(editEmail.getText().toString()).matches()){
                    Toast.makeText(LoginActivity.this, "Pogresan format email adrese", Toast.LENGTH_SHORT).show();
                }else{
                    login(editUsername.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString());
                }
            }
        });
    }

    private void initView() {
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editUsername.setText("");
        editEmail.setText("");
        editPassword.setText("");
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void login(String username, String email, String password){
        if(password.equals("123456") && username.startsWith("user")) {
            SharedPreferences sharedPreferences = getSharedPreferences(SplashActivity.PREFERENCES_LOGIN, MODE_PRIVATE);
            SharedPreferences sharedPreferences1 = getSharedPreferences(PREFERENCES_USERNAME, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getSharedPreferences(PREFERENCES_EMAIL, MODE_PRIVATE);
            sharedPreferences1.edit().putString(PREFERENCES_USERNAME, username).apply();
            sharedPreferences2.edit().putString(PREFERENCES_EMAIL, email).apply();
            sharedPreferences.edit().putString(SplashActivity.PREFERENCES_LOGIN, "user").apply();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        } else if(password.equals("123456") && username.startsWith("admin")){
            SharedPreferences sharedPreferences = getSharedPreferences(SplashActivity.PREFERENCES_LOGIN, MODE_PRIVATE);
            SharedPreferences sharedPreferences1 = getSharedPreferences(PREFERENCES_USERNAME, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getSharedPreferences(PREFERENCES_EMAIL, MODE_PRIVATE);
            sharedPreferences1.edit().putString(PREFERENCES_USERNAME, username).apply();
            sharedPreferences2.edit().putString(PREFERENCES_EMAIL, email).apply();
            sharedPreferences.edit().putString(SplashActivity.PREFERENCES_LOGIN, "admin").apply();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, "Pogresno uneti podaci", Toast.LENGTH_SHORT).show();
        }
    }

}
package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.view.activities.LoginActivity;
import rs.raf.projekat1.petar_mitic_rn9020.view.activities.MainActivity;
import rs.raf.projekat1.petar_mitic_rn9020.view.activities.SplashActivity;

public class ProfileFragment extends Fragment {

    private TextView tvUsername;
    private TextView tvEmail;
    private Button btnLogOut;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }


    private void init(View view){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(LoginActivity.PREFERENCES_USERNAME, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        SharedPreferences sharedPreferences1 = this.getActivity().getSharedPreferences(LoginActivity.PREFERENCES_EMAIL, Context.MODE_PRIVATE);
        String email = sharedPreferences1.getString("email", "");
        SharedPreferences sharedPreferences2 = this.getActivity().getSharedPreferences(SplashActivity.PREFERENCES_LOGIN, Context.MODE_PRIVATE);
        String login = sharedPreferences2.getString("login", "");

        tvUsername = view.findViewById(R.id.username);
        tvEmail = view.findViewById(R.id.email);
        btnLogOut = view.findViewById(R.id.button);

        tvUsername.setText(username);
        tvEmail.setText(email);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                sharedPreferences1.edit().clear().apply();
                sharedPreferences2.edit().clear().apply();
                Toast.makeText(getActivity(), "Uspesno ste se odlogovali", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rs.raf.projekat1.petar_mitic_rn9020.R;

public class InProgressTicketFragment extends Fragment {

    TextView textView;

    public InProgressTicketFragment() {
        super(R.layout.fragment_inprogress_ticket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView3);
        textView.setText("123");
    }

}

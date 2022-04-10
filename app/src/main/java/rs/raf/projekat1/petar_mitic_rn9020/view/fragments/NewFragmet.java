package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;
import rs.raf.projekat1.petar_mitic_rn9020.viewmodels.TicketViewModel;

public class NewFragmet extends Fragment {

    private TicketViewModel ticketViewModel;

    private Spinner spinner1;
    private Spinner spinner2;
    private EditText days;
    private EditText ticketTitle;
    private EditText ticketDescription;
    private Button addNewTicket;

    public NewFragmet() {
        super(R.layout.fragment_new);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ticketViewModel = new ViewModelProvider(requireActivity()).get(TicketViewModel.class);
        super.onViewCreated(view, savedInstanceState);
                String[] arraySpinner = new String[] {
                "Bug", "Enhancement"
        };
        Spinner s = (Spinner) view.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        String[] arraySpinner2 = new String[] {
                "Highest", "High", "Medium", "Low", "Lowest"
        };
        Spinner s2 = (Spinner) view.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);
        init(view);
        initListeners();
    }

    private void initListeners() {
        addNewTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ulazi");
                if(days.getText().toString().isEmpty()
                || ticketTitle.getText().toString().isEmpty()
                || ticketDescription.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Morate popuniti sva polja", Toast.LENGTH_SHORT).show();
                }else{
                    Ticket ticket = new Ticket(TicketViewModel.counter++,
                            ticketTitle.getText().toString(),
                            ticketDescription.getText().toString(),
                            spinner1.getSelectedItem().toString(),
                            spinner2.getSelectedItem().toString(),
                            "todo",
                            Integer.parseInt(days.getText().toString()));
                    ticketViewModel.addTicket(ticket);
                }
            }
        });
    }

    private void init(View view) {
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);
        days = view.findViewById(R.id.days);
        ticketTitle = view.findViewById(R.id.ticketTitle);
        ticketDescription = view.findViewById(R.id.ticketDescription);
        addNewTicket = view.findViewById(R.id.addNewTicket);

        days.setText("");
        ticketTitle.setText("");
        ticketDescription.setText("");
    }
}

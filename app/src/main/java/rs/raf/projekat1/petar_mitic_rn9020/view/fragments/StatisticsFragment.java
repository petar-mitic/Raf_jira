package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;
import rs.raf.projekat1.petar_mitic_rn9020.viewmodels.TicketViewModel;

public class StatisticsFragment extends Fragment {

    TicketViewModel ticketViewModel;
    Ticket ticket;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;

    public StatisticsFragment() {
        super(R.layout.fragment_statistics);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ticketViewModel = new ViewModelProvider(requireActivity()).get(TicketViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){

        textView1 = view.findViewById(R.id.number1);
        textView2 = view.findViewById(R.id.number2);
        textView3 = view.findViewById(R.id.number3);
        textView4 = view.findViewById(R.id.number4);
        textView5 = view.findViewById(R.id.number5);
        textView6 = view.findViewById(R.id.number6);
        textView7 = view.findViewById(R.id.number7);
        textView8 = view.findViewById(R.id.number8);
        textView9 = view.findViewById(R.id.number9);

        textView7.setText(Integer.toString(ticketViewModel.getDoneTicketsList().size()));
        textView1.setText(Integer.toString(ticketViewModel.getToDoTicketsList().size()));
        textView4.setText(Integer.toString(ticketViewModel.getInProgressTicketsList().size()));

        int number2 = 0;
        int number3 = 0;
        int number5 = 0;
        int number6 = 0;
        int number8 = 0;
        int number9 = 0;

        for(Ticket t: ticketViewModel.getToDoTicketsList()){
            if(t.getType().equals("bug")){
                number2++;
            }else{
                number3++;
            }
        }
        for(Ticket t: ticketViewModel.getInProgressTicketsList()){
            if(t.getType().equals("bug")){
                number5++;
            }else{
                number6++;
            }
        }
        for(Ticket t: ticketViewModel.getDoneTicketsList()){
            if(t.getType().equals("bug")){
                number8++;
            }else{
                number9++;
            }
        }

        textView2.setText(Integer.toString(number2));
        textView3.setText(Integer.toString(number3));
        textView5.setText(Integer.toString(number5));
        textView6.setText(Integer.toString(number6));
        textView8.setText(Integer.toString(number8));
        textView9.setText(Integer.toString(number9));
    }
}

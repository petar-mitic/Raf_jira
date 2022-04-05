package rs.raf.projekat1.petar_mitic_rn9020.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;

public class TicketViewModel extends ViewModel {

    public static int number = 20;
    private final MutableLiveData<List<Ticket>> toDoTickets = new MutableLiveData<>();
    private final MutableLiveData<List<Ticket>> inProgressTickets = new MutableLiveData<>();
    private final MutableLiveData<List<Ticket>> doneTickets = new MutableLiveData<>();
    private final ArrayList<Ticket> toDoTicketsList = new ArrayList<>();
    private final ArrayList<Ticket> inProgressTicketsList = new ArrayList<>();
    private final ArrayList<Ticket> doneTicketsList = new ArrayList<>();

}

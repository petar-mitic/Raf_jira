package rs.raf.projekat1.petar_mitic_rn9020.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import rs.raf.projekat1.petar_mitic_rn9020.models.Ticket;

public class TicketViewModel extends ViewModel {

    public static int counter = 20;
    private final MutableLiveData<List<Ticket>> toDoTickets = new MutableLiveData<>();
    private final MutableLiveData<List<Ticket>> inProgressTickets = new MutableLiveData<>();
    private final MutableLiveData<List<Ticket>> doneTickets = new MutableLiveData<>();
    private final ArrayList<Ticket> toDoTicketsList = new ArrayList<>();
    private final ArrayList<Ticket> inProgressTicketsList = new ArrayList<>();
    private final ArrayList<Ticket> doneTicketsList = new ArrayList<>();

    public TicketViewModel(){
        for (int i = 0; i < counter; i++) {
            Ticket ticket = new Ticket(i, "Ticket_ToDo_" + i, "Description" + i, "bug" , "High", "todo", 10);
            toDoTicketsList.add(ticket);
        }
        for (int i = 0; i < counter; i++) {
            Ticket ticket = new Ticket(i, "Ticket_InProgress_" + i, "Description" + i, "bug" , "Low", "inprogress", 8);
            inProgressTicketsList.add(ticket);
        }
        for (int i = 0; i < counter; i++) {
            Ticket ticket = new Ticket(i, "Ticket_Done_" + i, "Description" + i, "Enhancement" , "Low", "done", 8);
            doneTicketsList.add(ticket);
        }
        ArrayList<Ticket> toDoListToSubmit = new ArrayList<>(toDoTicketsList);
        ArrayList<Ticket> inProgressListToSubmit = new ArrayList<>(inProgressTicketsList);
        ArrayList<Ticket> doneListToSubmit = new ArrayList<>(doneTicketsList);
        toDoTickets.setValue(toDoListToSubmit);
        inProgressTickets.setValue(inProgressListToSubmit);
        doneTickets.setValue(doneListToSubmit);
    }

    public LiveData<List<Ticket>> getToDoTickets(){
        return toDoTickets;
    }

    public LiveData<List<Ticket>> getInProgressTickets(){
        return inProgressTickets;
    }

    public LiveData<List<Ticket>> getDoneTickets(){
        return doneTickets;
    }

    public void addTicket(Ticket ticket){
        if(ticket.getState().equalsIgnoreCase("todo")){
            toDoTicketsList.add(ticket);
            ArrayList<Ticket> toDolistToSubmit = new ArrayList<>(toDoTicketsList);
            toDoTickets.setValue(toDolistToSubmit);
        }else if(ticket.getState().equalsIgnoreCase("inprogress")){
            inProgressTicketsList.add(ticket);
            ArrayList<Ticket> inProgresslistToSubmit = new ArrayList<>(inProgressTicketsList);
            inProgressTickets.setValue(inProgresslistToSubmit);
        }else if(ticket.getState().equalsIgnoreCase("done")){
            doneTicketsList.add(ticket);
            ArrayList<Ticket> doneListToSubmit = new ArrayList<>(doneTicketsList);
            doneTickets.setValue(doneTicketsList);
        }
    }

    public void removeTicket(Ticket ticket){
        if(ticket.getState().equalsIgnoreCase("todo")){
            toDoTicketsList.remove(ticket);
            ArrayList<Ticket> toDolistToSubmit = new ArrayList<>(toDoTicketsList);
            toDoTickets.setValue(toDolistToSubmit);
        }else if(ticket.getState().equalsIgnoreCase("inprogress")){
            inProgressTicketsList.remove(ticket);
            ArrayList<Ticket> inProgresslistToSubmit = new ArrayList<>(inProgressTicketsList);
            inProgressTickets.setValue(inProgresslistToSubmit);
        }else if(ticket.getState().equalsIgnoreCase("done")){
            doneTicketsList.remove(ticket);
            ArrayList<Ticket> doneListToSubmit = new ArrayList<>(doneTicketsList);
            doneTickets.setValue(doneTicketsList);
        }
    }

    public void filterTicketsToDo(String filter) {
        List<Ticket> filteredList = toDoTicketsList.stream().filter(ticket -> ticket.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        toDoTickets.setValue(filteredList);
    }
    public void filterTicketsInProgress(String filter) {
        List<Ticket> filteredList = inProgressTicketsList.stream().filter(ticket -> ticket.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        inProgressTickets.setValue(filteredList);
    }

    public ArrayList<Ticket> getToDoTicketsList() {
        return toDoTicketsList;
    }

    public ArrayList<Ticket> getInProgressTicketsList() {
        return inProgressTicketsList;
    }

    public ArrayList<Ticket> getDoneTicketsList() {
        return doneTicketsList;
    }
}

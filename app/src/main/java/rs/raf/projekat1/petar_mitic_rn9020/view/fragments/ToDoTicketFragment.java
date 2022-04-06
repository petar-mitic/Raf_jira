package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.view.recycler.adapter.ToDoAdapter;
import rs.raf.projekat1.petar_mitic_rn9020.view.recycler.differ.TicketDiffItemCallback;
import rs.raf.projekat1.petar_mitic_rn9020.viewmodels.TicketViewModel;

public class ToDoTicketFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText editText;

    private TicketViewModel ticketViewModel;
    private ToDoAdapter toDoAdapter;

    public ToDoTicketFragment() {
        super(R.layout.fragment_todo_ticket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ticketViewModel = new ViewModelProvider(requireActivity()).get(TicketViewModel.class);
        init(view);
    }

    private void init(View view) {
        initView(view);
//        initListeners();
        initObservers();
        initRecycler();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.listRv0);
        editText = view.findViewById(R.id.searchToDo);
    }
    private void initRecycler() {
        toDoAdapter = new ToDoAdapter(new TicketDiffItemCallback());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(toDoAdapter);
    }
    private void initObservers() {
        ticketViewModel.getToDoTickets().observe(getViewLifecycleOwner(), tickets -> {
            toDoAdapter.submitList(tickets);
        });
    }
}

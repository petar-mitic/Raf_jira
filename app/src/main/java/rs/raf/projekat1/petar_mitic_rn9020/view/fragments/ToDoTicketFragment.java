package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
    //private Button buttonPlus;
    //private Button buttonMinus;

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
        initListeners();
        initObservers();
        initRecycler();
    }

    private void initListeners() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ticketViewModel.filterTicketsToDo(s.toString());
            }
        });

//        addBtn.setOnClickListener(v -> {
//            showAddSnackBar(
//                    recyclerViewModel.addCar("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR9vMHQzf3GMYiI2WnYG9TUKnGAQFevruSgJF35VLAJe_odBMVd&usqp=CAU",
//                            "Ikea",
//                            "LILLABO")
//            );
//        });
    }
    private void initView(View view) {
        recyclerView = view.findViewById(R.id.listRv0);
        editText = view.findViewById(R.id.searchToDo);
        //buttonPlus = view.findViewById(R.id.buttonPlustodo);
        //buttonMinus = view.findViewById(R.id.buttonMinustodo);
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

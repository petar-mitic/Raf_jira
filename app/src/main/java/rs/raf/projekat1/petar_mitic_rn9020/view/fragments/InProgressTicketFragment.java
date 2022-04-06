package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.petar_mitic_rn9020.R;
import rs.raf.projekat1.petar_mitic_rn9020.view.recycler.adapter.InProgressAdapter;
import rs.raf.projekat1.petar_mitic_rn9020.view.recycler.differ.TicketDiffItemCallback;
import rs.raf.projekat1.petar_mitic_rn9020.viewmodels.TicketViewModel;

public class InProgressTicketFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText editText;

    private TicketViewModel ticketViewModel;
    private InProgressAdapter inProgressAdapter;

    public InProgressTicketFragment() {
        super(R.layout.fragment_inprogress_ticket);
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
                ticketViewModel.filterTicketsInProgress(s.toString());
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
        recyclerView = view.findViewById(R.id.listRv);
        editText = view.findViewById(R.id.searchInProgress);
    }

    private void initRecycler() {
        inProgressAdapter = new InProgressAdapter(new TicketDiffItemCallback());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(inProgressAdapter);
    }
//
//    private void initListeners() {
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                recyclerViewModel.filterCars(s.toString());
//            }
//        });
//
//        addBtn.setOnClickListener(v -> {
//            showAddSnackBar(
//                    recyclerViewModel.addCar("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR9vMHQzf3GMYiI2WnYG9TUKnGAQFevruSgJF35VLAJe_odBMVd&usqp=CAU",
//                            "Ikea",
//                            "LILLABO")
//            );
//        });
//    }
//
//    private void showAddSnackBar(int id) {
//        Snackbar
//                .make(mainLayout, "Item added", Snackbar.LENGTH_SHORT)
//                .setAction("Undo", view -> recyclerViewModel.removeCar(id))
//                .show();
//    }
//
    private void initObservers() {
        ticketViewModel.getInProgressTickets().observe(getViewLifecycleOwner(), tickets -> {
            inProgressAdapter.submitList(tickets);
        });
    }

}

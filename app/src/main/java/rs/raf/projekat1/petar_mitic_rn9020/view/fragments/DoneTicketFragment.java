package rs.raf.projekat1.petar_mitic_rn9020.view.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.petar_mitic_rn9020.R;

public class DoneTicketFragment extends Fragment {

    //treba da dodam kao polja RecyclrerView, TicketViewModel, DoneTicketAdapter
    //private RecyclerView recyclerView;

    public DoneTicketFragment() {
        super(R.layout.fragment_done_ticket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //treba da se inicijalizuje ViewModel----prihodViewModel = new ViewModelProvider(requireActivity()).get(PrihodViewModel.class);
        init(view);
    }

    private void init(View view) {
//        initView(view);
//        initObservers();
//        initRecycler();
    }

//    private void initView(View view) {
//        recyclerView = view.findViewById(R.id.prihodRv);
//    }

//    private void initObservers() {
//        prihodViewModel.getPrihodi().observe(getViewLifecycleOwner(), prihodi -> {
//            prihodAdapter.submitList(prihodi);
//        });



//    private void initRecycler() {
//        prihodAdapter = new PrihodAdapter(new PrihodDiffItemCallback(), prihod -> {
//
//            prihodViewModel.removePrihod(prihod);
//            return null;
//
//        }, edit -> {
//            Intent intent = new Intent(getActivity(), EditPrihodaActivity.class);
//            intent.putExtra("prihodEdit", edit);
//            startActivityForResult(intent, EDIT_KEY);
//            return null;
//
//        }, view -> {
//
//            Intent intent = new Intent(getActivity(), PrikazPrihodaActivity.class);
//            intent.putExtra("prihod", view);
//            startActivity(intent);
//            return null;
//        });
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(prihodAdapter);
//    }
}

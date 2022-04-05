package rs.raf.projekat1.petar_mitic_rn9020.view.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.DoneTicketFragment;
import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.InProgressTicketFragment;
import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.ToDoTicketFragment;

public class TabAdapter extends FragmentPagerAdapter {

    private final int FRAGMENT_COUNT = 3;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;
    public static final int FRAGMENT_3 = 2;

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1: fragment = new ToDoTicketFragment(); break;
            case FRAGMENT_2: fragment = new InProgressTicketFragment(); break;
            default: fragment = new DoneTicketFragment(); break;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case FRAGMENT_1: return "To do";
            case FRAGMENT_2: return "In progress";
            default: return "Done";
        }
    }

}

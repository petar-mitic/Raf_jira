package rs.raf.projekat1.petar_mitic_rn9020.view.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.NewFragmet;
import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.ProfileFragment;
import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.StatisticsFragment;
import rs.raf.projekat1.petar_mitic_rn9020.view.fragments.TicketsFragmet;

public class PagerAdapter extends FragmentPagerAdapter {

    private final int FRAGMENT_COUNT = 4;
    public static final int FRAGMENT_1 = 0;
    public static final int FRAGMENT_2 = 1;
    public static final int FRAGMENT_3 = 2;
    public static final int FRAGMENT_4 = 3;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case FRAGMENT_1: fragment = new StatisticsFragment(); break;
            case FRAGMENT_2: fragment = new NewFragmet(); break;
            case FRAGMENT_3: fragment = new TicketsFragmet(); break;
            default: fragment = new ProfileFragment(); break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case FRAGMENT_1: return "Statistics";
            case FRAGMENT_2: return "New";
            case FRAGMENT_3: return "Tickets";
            default: return "Profile";
        }
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}

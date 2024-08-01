package com.lnmiit.c_cell;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lnmiit.c_cell.fragments.fragment_ccell;
import com.lnmiit.c_cell.College_tab.fragment_college;
import com.lnmiit.c_cell.gymkhana.fragment_gymkhana;
import com.lnmiit.c_cell.fragments.fragment_home;
import com.lnmiit.c_cell.fragments.fragment_pyq;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new fragment_college();
            case 1:
                return new fragment_gymkhana();
            case 2:
                return new fragment_home();
            case 3:
                return new fragment_pyq();
            case 4:
                return new fragment_ccell();
            default:
                return new fragment_home();
        }
    }

    @Override
    public int getItemCount() {
        return 5; // Number of tabs
    }
}

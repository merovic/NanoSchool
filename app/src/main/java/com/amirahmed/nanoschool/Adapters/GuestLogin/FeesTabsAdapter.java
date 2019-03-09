package com.amirahmed.nanoschool.Adapters.GuestLogin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.amirahmed.nanoschool.Fragments.FeesFragment;
import com.athbk.ultimatetablayout.IFTabAdapter;

import java.util.List;

public class FeesTabsAdapter extends FragmentPagerAdapter implements IFTabAdapter {

    private int nu;

    List<String> NAMES;

    List<String> TITLES;

    public FeesTabsAdapter(FragmentManager fm, int nu) {
        super(fm);
        this.nu = nu;
    }

    @Override
    public Fragment getItem(int position) {
        return FeesFragment.newInstance(NAMES.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES.get(position);
    }

    @Override
    public int getCount() {
        return nu;
    }

    public void setNAMES(List<String> NAMES) {
        this.NAMES = NAMES;
    }

    public void setTITLES(List<String> TITLES) {
        this.TITLES = TITLES;
    }

    @Override
    public String getTitle(int position) {
        return TITLES.get(position);
    }

    @Override
    public int getIcon(int position) {
        return 0;
    }

    @Override
    public boolean isEnableBadge(int position) {
        if (position == 0){
            return true;
        }
        return false;
    }

}

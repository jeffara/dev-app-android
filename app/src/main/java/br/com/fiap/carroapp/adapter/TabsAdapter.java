package br.com.fiap.carroapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.fiap.carroapp.fragment.CarrosFragment;

/**
 * Created by jeff on 11/19/15.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {


    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CarrosFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}

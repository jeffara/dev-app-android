package br.com.fiap.carroapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.fiap.carroapp.R;
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

        Fragment carrosFragment = new CarrosFragment();
        Bundle args = new Bundle();

        switch (position) {
            case 0:
                args.putInt("tipo", R.raw.carros_classicos);
                break;
            case 1:
                args.putInt("tipo", R.raw.carros_esportivos);
                break;
            case 2:
                args.putInt("tipo", R.raw.carros_luxuosos);
                break;
        }

        //Realiza a associacao de um Bundle de parametros ao Fragment que sera retornado
        carrosFragment.setArguments(args);

        return carrosFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

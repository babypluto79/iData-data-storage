package com.example.msafi.idata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int numoftabs;
    public TabsAdapter(FragmentManager fm, int nooftabs){
        super(fm);
        this.numoftabs = nooftabs;
    }
    @Override
    public int getCount(){
        return numoftabs;
    }
    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                PassWords passWords = new PassWords();
                return passWords;
            case 1:
                Pins pins = new Pins();
                return pins;
            case 2:
                Acc acc = new Acc();
                return acc;
                default:
                    return null;
        }
    }
}

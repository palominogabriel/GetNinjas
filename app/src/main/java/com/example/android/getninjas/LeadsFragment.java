package com.example.android.getninjas;

/**
 * Created by Gabriel Palomino on 1/11/2017.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeadsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.leads, container, false);


        return rootView;
    }


}

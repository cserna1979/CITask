package com.example.csern.citask;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by csern on 03/09/2017.
 */

public class FragmentTask extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentmain, container);
        return view;
        minuto 20.15
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}

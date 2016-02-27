package com.miguelcr.dynamicfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlackFragment extends Fragment {
    TextView text;


    public BlackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_black, container, false);

        text = (TextView) v.findViewById(R.id.textViewBlackFragment);
        text.setText("I'm in the Dark side");

        return v;

    }

}

package com.miguelcr.dynamicfragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class WhiteFragment extends Fragment {
    TextView text;
    ImageView image;

    public WhiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_white, container, false);

        text = (TextView) v.findViewById(R.id.textViewWhiteFragment);
        image = (ImageView) v.findViewById(R.id.imageViewLight);

        Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "starwars.ttf");
        text.setTypeface(face);

        text.setText("The Light side");
        Picasso.with(getActivity()).load("http://www.renders-graphiques.fr/image/upload/normal/Star_Wars.png")
                .into(image);


        return v;
    }

}

package com.miguelcr.contextmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.miguelcr.contextmenu.entities.Fruit;

import java.util.List;

/**
 * Created by miguelcampos on 22/2/16.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    Context ctx;
    List<Fruit> studentsList;
    int layoutItemList;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);

        // We save the params in our properties.
        this.ctx = context;
        this.studentsList = objects;
        this.layoutItemList = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View childToAdd = inflater.inflate(layoutItemList, parent, false);

        Fruit current = studentsList.get(position);

        // get the reference for the template components
        TextView nameView = (TextView) childToAdd.findViewById(R.id.textViewName);

        nameView.setText(current.getName());

        return childToAdd;
    }
}

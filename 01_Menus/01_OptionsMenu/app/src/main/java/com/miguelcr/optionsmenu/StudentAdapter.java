package com.miguelcr.optionsmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 22/2/16.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    List<Student> studentsList;
    int layoutItemList;

    public StudentAdapter(Context context, int resource, List<Student> objects) {
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

        Student currentStudent = studentsList.get(position);

        // get the reference for the template components
        ImageView avatarView = (ImageView) childToAdd.findViewById(R.id.imageViewAvatar);
        TextView nameView = (TextView) childToAdd.findViewById(R.id.textViewName);
        TextView ageView = (TextView) childToAdd.findViewById(R.id.textViewAge);

        avatarView.setImageResource(currentStudent.getAvatar());
        nameView.setText(currentStudent.getName());
        ageView.setText(String.valueOf(currentStudent.getAge()+" years old"));

        return childToAdd;
    }
}

package com.miguelcr.studentdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcr.studentdatabase.entities.Student;

import java.util.List;

/**
 * Created by miguelcampos on 25/2/16.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    private final Context context;
    private final List<Student> values;


    public StudentAdapter(Context context, List<Student> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.item_list_student, parent, false);

        ImageView avatar = (ImageView) layout.findViewById(R.id.imageViewAvatar);
        TextView name = (TextView) layout.findViewById(R.id.textViewName);
        TextView age = (TextView) layout.findViewById(R.id.textViewAge);

        Student current = values.get(position);

        if(current.getSex().equals("male")) {
            avatar.setImageResource(R.drawable.ic_male);
        } else {
            avatar.setImageResource(R.drawable.ic_female);
        }

        name.setText(current.getName());
        age.setText(String.valueOf(current.getAge()));

        return layout;
    }
}

package com.example.android.safeeats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ChooA on 1/27/2018.
 */

public class listAllergiesAdapter extends ArrayAdapter<listAllergies> {

    public listAllergiesAdapter(Context context, ArrayList<listAllergies> arraylist) {
        super(context, 0, arraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        final listAllergies currentAllergy = getItem(position);

        TextView name = (TextView) listView.findViewById(R.id.showAllergy);
        name.setText(currentAllergy.getAllergies());

        return listView;

    }
}

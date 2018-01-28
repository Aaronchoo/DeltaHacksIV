package com.example.android.safeeats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ChooA on 1/27/2018.
 */

interface ListAllergiesDelegate {
    void setChecked(int position, boolean checked);
}
public class listAllergiesAdapter extends ArrayAdapter<listAllergies> {
    private final ListAllergiesDelegate delegate;

    public listAllergiesAdapter(Context context, ArrayList<listAllergies> arraylist, ListAllergiesDelegate delegate) {
        super(context, 0, arraylist);
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        final listAllergies currentAllergy = getItem(position);

        TextView name = (TextView) listView.findViewById(R.id.showAllergy);
        name.setText(currentAllergy.getAllergies());

        CheckBox box = (CheckBox) listView.findViewById(R.id.includeAllergy);

        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                listAllergies allergies = (listAllergies) getItem(position);
//                allergies.setChecked(b);
                delegate.setChecked(position, b);
            }
        });
        return listView;

    }
}

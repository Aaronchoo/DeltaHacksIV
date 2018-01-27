package com.example.android.safeeats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by ChooA on 8/15/2017.
 */

public class ListDetailsAdapter extends ArrayAdapter<ListDetails> {

    public ListDetailsAdapter(Context context, ArrayList<ListDetails> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.names_layout,parent,false);
        }
        //Get the current information about the desired list position
        final ListDetails currentDetail = getItem(position);

        //Assign the textview to the name of the possible choice
        TextView name = (TextView) listView.findViewById(R.id.name_part);
        //Show name
        name.setText(currentDetail.getName());

        //Assign the textview to the details of the information
         TextView detail = (TextView) listView.findViewById(R.id.detail_part);
        //Shows the detail
        detail.setText(currentDetail.getDetails());

        return  listView;

     }
}

package com.example.android.safeeats;

import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ChooA on 1/28/2018.
 */

public class PrefixAdapter extends ArrayAdapter<PrefixProducts> {


    public PrefixAdapter(Context context, ArrayList<PrefixProducts> arraylist) {
        super(context, 0, arraylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.show_preview, parent, false);
        }
        final PrefixProducts currentProduct = getItem(position);
        ImageView foodPicture = (ImageView) listView.findViewById(R.id.postedImage);
        Picasso.with(getContext()).load(currentProduct.getImage()).into(foodPicture);

        TextView foodName = (TextView) listView.findViewById(R.id.preName);
        foodName.setText(currentProduct.getNameIngred());

        TextView foodDesc = (TextView) listView.findViewById(R.id.preDescr);
        foodDesc.setText(currentProduct.getDescription());

        return listView;
    }
}

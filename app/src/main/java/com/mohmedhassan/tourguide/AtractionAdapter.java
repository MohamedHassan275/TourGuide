package com.mohmedhassan.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by akueisara on 9/29/2016.
 */
public class AtractionAdapter extends ArrayAdapter<Atraction> {

    public AtractionAdapter(Context context, ArrayList<Atraction> atractions) {
        super(context, 0, atractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Atraction currentAtraction = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentAtraction.getAttractionName());

        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone);
        if("".equals(currentAtraction.getAttractionPhone()))
            phoneTextView.setVisibility(View.GONE);
        else {
            phoneTextView.setVisibility(View.VISIBLE);
            phoneTextView.setText(currentAtraction.getAttractionPhone());
        }

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentAtraction.getAttractionAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Improve picture loading..
        Picasso.with(getContext())
                .load(currentAtraction.getImageResourceUrl())
                .resizeDimen(R.dimen.list_item_image_width,R.dimen.list_item_image_height)
                .centerInside()
                .into(imageView);

        return listItemView;
    }
}

package com.example.piotrek.radioonline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Piotrek on 2017-05-15.
 */

public class RadioAdapter extends ArrayAdapter<Radio> {

    public RadioAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Radio radio = getItem(position);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View listResults = layoutInflater.inflate(R.layout.list_radio, null);

        TextView radioName = (TextView) listResults.findViewById(R.id.radio_name);
        radioName.setText(radio.getName());

        TextView url = (TextView) listResults.findViewById(R.id.url);
        url.setText(radio.getUrl());

        return listResults;
    }
}

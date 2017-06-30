package com.example.piotrek.radioonline;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Piotrek on 2017-05-15.
 */

public class PlayerHelper {

    private ListView list;
    private TextView textView;
    private Button button;
    private RadioAdapter adapter;
    private Context context;
    private Radio chosenRadio;
    private static boolean radioOFF;

    public PlayerHelper(Context context, ListView list, TextView textView, Button button, RadioAdapter adapter) {
        this.context = context;
        this.list = list;
        this.textView = textView;
        this.button = button;
        this.adapter = adapter;
    }

    public void readList() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosenRadio = (Radio) parent.getItemAtPosition(position);
                textView.setText(chosenRadio.getName());
            }
        });
    }

    public void readButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioOFF == false) {
                    Intent intent = new Intent(context, PlaybackService.class);
                    intent.putExtra("url", chosenRadio.getUrl());
                    context.startService(intent);
                    button.setText("STOP");
                    radioOFF = true;
                } else {
                    Intent intent = new Intent(context, PlaybackService.class);
                    context.stopService(intent);
                    button.setText("PLAY");
                    radioOFF = false;
                }
            }
        });
    }
}

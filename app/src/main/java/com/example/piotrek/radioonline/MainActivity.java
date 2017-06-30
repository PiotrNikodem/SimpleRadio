package com.example.piotrek.radioonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private TextView textView;
    private Button button;
    private RadioAdapter adapter;
    private PlayerHelper playerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        this.list = (ListView) findViewById(R.id.radio_list);
        this.adapter = new RadioAdapter(this);
        this.list.setAdapter(this.adapter);
        this.textView = (TextView) findViewById(R.id.textView);
        this.button = (Button) findViewById(R.id.button);

        addSavedUrls();

        this.playerHelper = new PlayerHelper(this, list, textView, button, adapter);
        playerHelper.readList();
        playerHelper.readButton();

    }

    private void addSavedUrls() {
        adapter.add(new Radio("Radio 1", "http://waw01.ic2.scdn.smcloud.net/t008-1.mp3"));
        adapter.add(new Radio("Radio 2", "http://radiojazzfm.radiokitstream.org/radiojazzfm.mp3"));
        adapter.add(new Radio("Radio 3", "http://lemfm.radiokitstream.org/lemfm.mp3"));
    }
}

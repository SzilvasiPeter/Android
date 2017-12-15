package com.example.szilv.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView myVideoView = (VideoView) findViewById(R.id.myVideoView);
        myVideoView.setVideoPath("http://images.all-free-download.com/footage_preview/mp4/kebab_food_salad_yufka_markook_803.mp4");

        // Player control(play pause stop)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(myVideoView);
        myVideoView.setMediaController(mediaController);

        myVideoView.start();

        String[] foods = {"Meat", "Onion", "Sauce", "Tomato", "Salad"};

        ListAdapter myAdatper = new CustomAdapter(this, foods);
        final ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdatper);

        myListView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String food = String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(MainActivity.this, food, Toast.LENGTH_LONG).show();

                    Intent i = new Intent(view.getContext(), DetailActivity.class);
                    i.putExtra("foodName",food);

                    startActivity(i);

                }
            }
        );
    }
}

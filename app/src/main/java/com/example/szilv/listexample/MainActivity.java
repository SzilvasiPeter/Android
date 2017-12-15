package com.example.szilv.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //private TextView databaseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseText = (TextView) findViewById(R.id.databaseText);

        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Potato"};

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

    /*public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        databaseText.setText(dbString);
        myInput.setText("");
    }*/
}

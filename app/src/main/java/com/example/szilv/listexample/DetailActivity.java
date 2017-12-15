package com.example.szilv.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    EditText myInput;
    TextView myComment;
    MyDBHandler dbHandler;
    String listMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle listData = getIntent().getExtras();
        if(listData == null){
            return;
        }

        listMessage = listData.getString("foodName");
        final TextView detailText = (TextView) findViewById(R.id.detailText);
        detailText.setText(listMessage);

        myInput = (EditText) findViewById(R.id.myInput);
        myComment = (TextView) findViewById(R.id.myComment);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        myComment.setText(dbString);
        myInput.setText("");
    }

    public void addButtonClick(View view) {
        Foods food = new Foods(listMessage + "'s comment: " + myInput.getText().toString());
        dbHandler.addFood(food);
        printDatabase();
    }

    public void deleteButtonClick(View view) {
        dbHandler.deleteFoods();
        printDatabase();
    }
}

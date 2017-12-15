package com.example.szilv.listexample;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{

    CustomAdapter(@NonNull Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);

        TextView myText = (TextView) customView.findViewById(R.id.myText);
        ImageView myImage = (ImageView) customView.findViewById(R.id.myImage);
        myText.setText(singleFoodItem);

        if(singleFoodItem == "Meat") {
            myImage.setImageResource(R.drawable.meat);
        }else if(singleFoodItem == "Onion"){
            myImage.setImageResource(R.drawable.onion);
        }else if(singleFoodItem == "Tomato"){
            myImage.setImageResource(R.drawable.tomato);
        }else if(singleFoodItem == "Sauce"){
            myImage.setImageResource(R.drawable.sauce);
        }else if(singleFoodItem == "Salad"){
            myImage.setImageResource(R.drawable.salad);
        }

        return customView;
    }
}

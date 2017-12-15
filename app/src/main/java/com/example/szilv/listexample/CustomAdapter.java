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

        if(singleFoodItem == "Bacon") {
            myImage.setImageResource(R.drawable.bacon);
        }else if(singleFoodItem == "Ham"){
            myImage.setImageResource(R.drawable.ham);
        }else if(singleFoodItem == "Tuna"){
            myImage.setImageResource(R.drawable.tuna);
        }else if(singleFoodItem == "Candy"){
            myImage.setImageResource(R.drawable.candy);
        }else if(singleFoodItem == "Potato"){
            myImage.setImageResource(R.drawable.potato);
        }

        return customView;
    }
}

package com.project.befit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Food extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.food, container, false);
		ImageButton breakfast = (ImageButton)rootView.findViewById(R.id.breakfast);
		ImageButton lunch = (ImageButton)rootView.findViewById(R.id.lunch);
		ImageButton dinner = (ImageButton)rootView.findViewById(R.id.dinner);
		
		breakfast.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Breakfast");
				startActivity(i);
			}
		});
		
		lunch.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Lunch");
				startActivity(i);
			}
		});
		
		dinner.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Dinner");
				startActivity(i);
			}
		});
		
		return rootView;
	}
		
}


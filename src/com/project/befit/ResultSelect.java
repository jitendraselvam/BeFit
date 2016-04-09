package com.project.befit;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.project.befit.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class ResultSelect extends Fragment implements OnClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.resultselect, container, false);
		Button burn = (Button) rootView.findViewById(R.id.burnbut);
		Button review = (Button) rootView.findViewById(R.id.reviewbut);
		Button graph = (Button)rootView.findViewById(R.id.graph);
		
		burn.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.TotalCalories");
				startActivity(i);
			}
		});
		review.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.ListViewTab");
				startActivity(i);
			}
		});
		graph.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Graph");
				startActivity(i);
			}
		});
		return rootView;
	}
/*	public void totalres(View view){
		Intent i = new Intent("com.project.ListViewTab");
		startActivity(i);
	}
public void reviewres(View view){
	Intent i = new Intent("com.project.ListViewTab");
	startActivity(i);
	}*/

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}

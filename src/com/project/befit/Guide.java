package com.project.befit;


import android.app.Activity;

import com.project.befit.R;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Guide extends Fragment implements OnClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.guide, container, false);
		Button video1 = (Button)rootView.findViewById(R.id.video1);
		Button video2 = (Button)rootView.findViewById(R.id.video2);
		Button video3 = (Button)rootView.findViewById(R.id.video3);
		Button video4 = (Button)rootView.findViewById(R.id.video4);
		Button re = (Button)rootView.findViewById(R.id.button1);
		
		video1.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
			Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=tFMolqBIlnk"));
			startActivity(i);
			}
		});
		video2.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=vPKcShZzuPo"));
				startActivity(i);
			}
		});
		video3.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=ulKg8YV9o8c"));
				startActivity(i);
			}
		});
		video4.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=JhAb5kQuB4w"));
				startActivity(i);
			}
		});
		re.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Remainder");
				startActivity(i);
			}
		});
		return rootView;
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}

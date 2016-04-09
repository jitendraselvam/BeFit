package com.project.befit;



import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;

import com.project.befit.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainPage extends Fragment implements OnClickListener{

	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.mainpage, container, false);
		Button running = (Button)rootView.findViewById(R.id.running);
		Button swimming = (Button)rootView.findViewById(R.id.swimming);
		Button trekking = (Button)rootView.findViewById(R.id.trekking);
		Button jogging = (Button)rootView.findViewById(R.id.jogging);
		Button pullup = (Button)rootView.findViewById(R.id.pullup);
		Button pushup = (Button)rootView.findViewById(R.id.pushup);
		Button zumba = (Button)rootView.findViewById(R.id.zumba);
		Button  cycling= (Button)rootView.findViewById(R.id.cycling);
		Button aerobics = (Button)rootView.findViewById(R.id.aerobics);
		Button yoga = (Button)rootView.findViewById(R.id.yoga);
		Button custom = (Button)rootView.findViewById(R.id.custom);
		
		running.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Running");
				startActivity(i);
			}
		});
		swimming.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Swimming");
				startActivity(i);
			}
		});
		jogging.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Jogging");
				startActivity(i);
			}
		});
		trekking.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Trekking");
				startActivity(i);
			}
		});
		aerobics.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Aerobics");
				startActivity(i);
			}
		});
		custom.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.CustomExercise");
				startActivity(i);
			}
		});
		pullup.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Pullup");
				startActivity(i);
			}
		});
		pushup.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Pushup");
				startActivity(i);
			}
		});
		zumba.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Zumba");
				startActivity(i);
			}
		});
		cycling.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Cycling");
				startActivity(i);
			}
		});
		yoga.setOnClickListener(new OnClickListener(){
			public void onClick(View view1){
				Intent i = new Intent("com.project.Yoga");
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

	/*public void running(View butnview){
		Intent i = new Intent("com.project.Running");
		startActivity(i);
	}
public void swimming(View butnview1){
	Intent i = new Intent("com.project.Swimming");
	startActivity(i);
	}
public void trekking(View butnview2){
	Intent i = new Intent("com.project.Trekking");
	startActivity(i);
}
public void cycling(View butnview3){
	Intent i = new Intent("com.project.Cycling");
	startActivity(i);
}
public void yoga(View butnview4){
	Intent i = new Intent("com.project.Yoga");
	startActivity(i);
}
public void aerobics(View butnview5){
	Intent i = new Intent("com.project.Aerobics");
	startActivity(i);
}
public void jogging(View butnview6){
	Intent i = new Intent("com.project.Jogging");
	startActivity(i);
}
public void zumba(View butnview7){
	Intent i = new Intent("com.project.Zumba");
	startActivity(i);
}
public void pushup(View butnview8){
	Intent i = new Intent("com.project.Pushup");
	startActivity(i);
}
public void pullup(View butnview9){
	Intent i = new Intent("com.project.Pullup");
	startActivity(i);
}

public void Custom(View butnview10){
	Intent i = new Intent("com.project.CustomExercise");
	startActivity(i);
}

}*/
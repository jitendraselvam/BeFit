package com.project.befit;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TotalCalories extends Activity {
	Cursor c;
	TextView tv,tv1;
	int i=1;
	int sum=0;
	int temp;
	float weight;
	Button cal;
	DBAdapter db = new DBAdapter(this);
	int total[] = new int[30];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.totalcalories);
		tv = (TextView)findViewById(R.id.totalcalories);
		tv1 = (TextView)findViewById(R.id.totalweight);
		cal = (Button)findViewById(R.id.calcal);
	}
	public void onclick(View view){
		cal.setVisibility(View.GONE);
		db.open();
		 c = db.getAll();
		 if(c.moveToFirst())
		 {
			 do
			 {
				 converAndSum(c);
			 }while(c.moveToNext());
			 } db.close();
			 tv.setText( "Total calories = "+sum+ " cal");
			 weight=sum/3850;
			 if(weight==0){
				 Toast.makeText(getBaseContext(), "burn some more Calories!", Toast.LENGTH_SHORT).show();
			 }
			 else if(weight>1&&weight<5)
			 {
				 Toast.makeText(getBaseContext(), "Great job !", Toast.LENGTH_SHORT).show();
			 }
			 else if(weight >5){
				 Toast.makeText(getBaseContext(), "are your pants still fitting you ?", Toast.LENGTH_SHORT).show();
			 }
			 tv1.setText("Weight lost = "+weight+ "Kg");
			 
		 }
	private void converAndSum(Cursor c) {
		// TODO Auto-generated method stub
		
	temp=Integer.parseInt(c.getString(3));
	sum=sum+temp;
	}
	}



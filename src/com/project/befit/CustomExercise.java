package com.project.befit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomExercise extends Activity{
	TextView tv;
	EditText ettime,etcal;
	int calo,time,totalCalo;
	int request_Code=1;
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	String formattedDate = df.format(cal.getTime());
	
	DBAdapter db = new DBAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.custom);
		tv = (TextView)findViewById(R.id.cusrestext);
		ettime = (EditText)findViewById(R.id.custime);
		etcal = (EditText)findViewById(R.id.cuscalText);
	}
	
	public void cusUpdate(View view){
		String ed_text = ettime.getText().toString().trim();
		String ed_text1 = etcal.getText().toString().trim();
	    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null || ed_text1.isEmpty() || ed_text1.length() == 0 || ed_text1.equals("") || ed_text1 == null )
	    {
	    	Toast.makeText(getApplicationContext(), "no input", Toast.LENGTH_SHORT).show();}
	    else{
		Editable min = ettime.getText();
		String min1=min.toString();
		time = Integer.parseInt(min1);
		Toast.makeText(getBaseContext(), " "+min, Toast.LENGTH_SHORT).show();
		Editable cusCalo = etcal.getText();
		String cusCalo1 = cusCalo.toString();
		calo = Integer.parseInt(cusCalo1);
		totalCalo=calo*time;
		String result = String.valueOf(totalCalo);
		
		db.open();
		long id = db.insertExercise("Your Exercises", formattedDate, result);
		db.close();
		db.open();
		tv.setText(result+" Cal");
		
		Toast.makeText(getBaseContext(), "Updated to the Database", Toast.LENGTH_SHORT).show();
	} }
	
	public void cusRes(View view){
		String ed_text = ettime.getText().toString().trim();
		String ed_text1 = etcal.getText().toString().trim();
		
	    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null || ed_text1.isEmpty() || ed_text1.length() == 0 || ed_text1.equals("") || ed_text1 == null )
	    {
	    	Toast.makeText(getApplicationContext(), "no input", Toast.LENGTH_SHORT).show();}
	    else{
		Editable min = ettime.getText();
		String min1=min.toString();
		time = Integer.parseInt(min1);
		Editable cusCalo = etcal.getText();
		String cusCalo1 = cusCalo.toString();
		calo = Integer.parseInt(cusCalo1);
		totalCalo=calo*time;
		String result = String.valueOf(totalCalo);
		tv.setText(result+" Cal");
	} }
	public void timer(View view){
		
		startActivityForResult(new Intent("com.project.TimerActivity"),request_Code);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==request_Code){
			if(resultCode==RESULT_OK){
				
			ettime.setText(data.getData().toString());
				
			}
		}
	}
	
	
}

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

public class Pullup  extends Activity{
	TextView tv;
	EditText et;
	int calo;
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	String formattedDate = df.format(cal.getTime());
	int request_Code=1;
	
	DBAdapter db = new DBAdapter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pullup);
		tv = (TextView)findViewById(R.id.pullupresult);
		et = (EditText)findViewById(R.id.pulluptime);
	}
public void pullupressave(View view){
	String ed_text = et.getText().toString().trim();

    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
    {
    	Toast.makeText(getApplicationContext(), "no input", Toast.LENGTH_SHORT).show();}
    else{
    	
		Editable min = et.getText();
		String min1=min.toString();
		calo = Integer.parseInt(min1);
		calo= calo*8;
		String result = String.valueOf(calo);
		
		db.open();
		long id = db.insertExercise("pullup", formattedDate, result);
		db.close();
		db.open();
		tv.setText(result+" Cal");
		
		Toast.makeText(getBaseContext(), "Updated to the Database", Toast.LENGTH_SHORT).show();
		
	}
}
	public void pullupCalc(View view){
		String ed_text = et.getText().toString().trim();

	    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
	    {Toast.makeText(getApplicationContext(), "no input", Toast.LENGTH_SHORT).show();}
	    else{
		Editable min = et.getText();
		String min1=min.toString();
		calo = Integer.parseInt(min1);
		calo= calo*8;
		String result = String.valueOf(calo);
		tv.setText(result+" Cal");
	}
	}
	public void timer(View view){
		startActivityForResult(new Intent("com.project.TimerActivity"),request_Code);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==request_Code){
			if(resultCode==RESULT_OK){
		
			et.setText(data.getData().toString());
				
			}
		}
	}
}

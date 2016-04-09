package com.project.befit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity{
	
	SharedPreferences pref;
	SharedPreferences.Editor editor;
	EditText nameBox,heightBox,weightBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.register);
		nameBox =(EditText)findViewById(R.id.name);
		weightBox =(EditText)findViewById(R.id.weight);
		heightBox =(EditText)findViewById(R.id.height);
		pref = getSharedPreferences("testapp", MODE_PRIVATE);
		editor = pref.edit();
		editor.putString("register","true");
		String getStatus=pref.getString("register", "nil");
		if(getStatus.equals("true"))
		{
			Intent i =new Intent("com.project.SelectMenu");
			startActivity(i);
		}
		else{
			Toast.makeText(getBaseContext(), "Hey !", Toast.LENGTH_SHORT).show();
			nameBox.setText(pref.getString("name", "Enter name"));
			int setht=pref.getInt("height", 0);
			heightBox.setText(""+setht);
			int setwt=pref.getInt("weight", 0);
			weightBox.setText(""+setwt);
		}
	
	} 
	
	public void commit(View view){
		editor.putString("register","true");
		String weight=weightBox.getText().toString();
		int wt = Integer.parseInt(weight);
		String height=heightBox.getText().toString();
		int ht = Integer.parseInt(height);
		editor.putInt("height",ht);
		editor.putInt("weight",wt);
		editor.putString("name",nameBox.getText().toString());
		//Toast.makeText(getBaseContext(), nameBox.getText().toString()+" ///"+wt+" ///"+ht, Toast.LENGTH_SHORT).show();
		editor.commit();
		Intent i =new Intent("com.project.SelectMenu");
		startActivity(i);
	}

}


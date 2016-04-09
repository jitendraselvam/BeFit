package com.project.befit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StartPage extends Activity{
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.startpage);
		
		

	}
	public void onClickAbout(View view){
		Intent i = new Intent("com.project.AboutActivity");
		startActivity(i);
	}
	
	public void onClickExit(View view){
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
	    alert.setTitle("Are you sure you want to quit?");
	    // alert.setMessage("Message");

	    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {

	    		android.os.Process.killProcess(android.os.Process.myPid());
	            System.exit(1);
	        }
	    });

	    alert.setNegativeButton("No",
	        new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int whichButton) {
	            }
	        });

	    alert.show();

	}
	
	public void onClickStart(View view){
		Intent st = new Intent("com.project.Register");
		startActivity(st);
	}

}

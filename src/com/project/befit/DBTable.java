package com.project.befit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.Toast;

public class DBTable extends Activity{
	
	 TableLayout table_layout;
	 Button build_btn;
	 int rows;
	 int cols;
	 int cnt=0;
	 int i=0;
	 String exercisename;
	 
	 DBAdapter db = new DBAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dbresult);
		  build_btn = (Button) findViewById(R.id.build_btn_id);
		  table_layout = (TableLayout) findViewById(R.id.tableLayout1);
          exercisename= getIntent().getStringExtra("str1");
			
	build_btn.setOnClickListener(new OnClickListener() {


		   public void onClick(View v){
			   db.open();
				  Cursor c =db.getAll();

					 if( c.moveToFirst())
					 {
				  do
				  {
					  if(c.getString(1).equals(exercisename))
					   {
						  BuildTable();
						   break;
					   }
					  else{
						 
					  }
				   
				   
				  }while(c.moveToNext());
		   }}
		  });

		 }

		 private void BuildTable() {
		db.open();
		  Cursor c =db.getAll();

			 if( c.moveToFirst())
			 {
		  // outer for loop
		  do
		  {
		
			  
		   TableRow row = new TableRow(this);
		   row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
		     LayoutParams.WRAP_CONTENT));

		   // inner for loop
		   for (int j = 1; j <= 3; j++) {

		    TextView tv = new TextView(this);
		    tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
		      LayoutParams.WRAP_CONTENT));
		    tv.setBackgroundResource(R.layout.cell_shape);
		    tv.setPadding(5, 5, 5, 5);
		   if(!c.getString(1).equals(exercisename))
			   {break;
			   }
			   tv.setText(c.getString(j));
			   
		  

		    row.addView(tv);
		    

		   }
		   
		   table_layout.addView(row);

		  }while(c.moveToNext());
		  db.close();
			 }
			 build_btn.setVisibility(View.GONE);
		 }
	

		 }



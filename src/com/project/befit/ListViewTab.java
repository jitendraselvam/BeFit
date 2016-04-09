package com.project.befit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTab extends Activity {
   ListView listView ;
   int i=0;
   int maxlength;
    
    DBAdapter db = new DBAdapter(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.listview);
        
      
        listView = (ListView) findViewById(R.id.list);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Running", 
                                         "aerobics",
                                         "cycling",
                                         "jogging", 
                                         "pullup", 
                                         "pushup", 
                                         "yoga", 
                                         "swimming",
                                         "zumba",
                                         "trekking",
                                         "Your Exercises"
                                        };
      /*  db.open();
        Cursor c =db.getAll();

		 if( c.moveToFirst())
		 {
	  do
	  {   for(i=0;i<values.length;i++)
		  if(!c.getString(1).equalsIgnoreCase(values[i])){
			  maxlength=values.length + 1;
			  values[maxlength]=c.getString(1);
		  }
	  }while(c.moveToNext());
		 }db.close();
*/
  

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
		listView.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view,
			    int position, long id) {
				
		       // ListView Clicked item index
			   int itemPosition     = position;
			   
			   // ListView Clicked item value
			   String  itemValue    = (String) listView.getItemAtPosition(position);
				  
			   
			  //  startActivity(new Intent("com.project.DBTable"));Intent i = new 
			    Intent i = new Intent("com.project.DBTable");
    	//---use putExtra() to add new key/value pairs---            
    	i.putExtra("str1", itemValue);

           

    	startActivity(i);
    }
			  
			  

			
			});}
    
		
}

    
package com.project.befit;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Graph extends Activity{
	
	DBAdapter db = new DBAdapter(this);
	Cursor c;
	int temp;
	DataPoint[] point;
	LineGraphSeries<DataPoint> series;
	int i,j;
	int[] array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.graph);
		point = new DataPoint[] {
		          new DataPoint(0, 0),
		          new DataPoint(1, 0),
		          new DataPoint(2, 0),
		          new DataPoint(3, 0),
		          new DataPoint(4, 0),
		          new DataPoint(5, 0),
		          new DataPoint(6, 0),
		          new DataPoint(7, 0),
		          new DataPoint(8, 0)
		};
		i=0;j=0;
		array = new int[11];
		for(i=0;i<=10;i++)
		{
			array[i]=0;
		}
		GraphView graph = (GraphView) findViewById(R.id.graph);
		
		db.open();
		i=0;
		 c = db.getAll();
		 if(c.moveToFirst())
		 {
			 if( c.moveToFirst())
			 {
		  do
		  {
			  if(c.getString(1).equals("Running"))
			   {
				  array[i]= Integer.parseInt(c.getString(3));
				   i++;
			   }
			  else{
				 
			  }
		   
		   
		  }while(c.moveToNext());
			 db.close();
		 }
		 }
			for(i=0;i<=10;i++)
			{
				if(array[i]!=0)
				{
					Toast.makeText(getBaseContext(),  " "+array[i], Toast.LENGTH_SHORT).show();
					point[i]= new DataPoint(j++,array[i]);
				}
			}
		/*	LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
			          new DataPoint(0, array[0]),
			          new DataPoint(1, array[1]),
			          new DataPoint(2, array[2]),
			          new DataPoint(3, 2),
			          new DataPoint(4, 6)
			});*/
			
			LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(point);
			graph.addSeries(series);
	}
	
	private int converAndSum(Cursor c) {
	// TODO Auto-generated method stub
	
		temp=Integer.parseInt(c.getString(3));
		return temp;
	}
}


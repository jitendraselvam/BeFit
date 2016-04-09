package com.project.befit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Calc extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calc);
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		TextView tv2 = (TextView)findViewById(R.id.textView2);
		TextView tv3 = (TextView)findViewById(R.id.textView3);
		TextView tv4 = (TextView)findViewById(R.id.textView4);
		Bundle bundle = getIntent().getExtras();
		tv1.setText(bundle.getInt("running"));
		
	}

}

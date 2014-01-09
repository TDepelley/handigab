package com.example.handigab_porteur;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Account extends Activity {
	String msg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if((b.get("msg"))!=null) {
			msg = b.get("msg").toString();
		}
		
		StringTokenizer st = new StringTokenizer(msg,";");
		TextView tv= (TextView)this.findViewById(R.id.informationAccount) ;
		String s = st.nextToken();
		s=st.nextToken();
		tv.setText(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

	
	public void launchCard(View v){
		finish();
	}
}

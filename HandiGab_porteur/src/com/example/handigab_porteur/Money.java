package com.example.handigab_porteur;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Money extends Activity {
	private static int TIMEOUT= 3000;
	String msg=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_money);
		
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if((b.get("msg"))!=null) {
			msg = b.get("msg").toString();
		}
		
		StringTokenizer st = new StringTokenizer(msg,";");
		TextView tv= (TextView)this.findViewById(R.id.informationMoney) ;
		String s = st.nextToken();
		s=st.nextToken();
		tv.setText(s);
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent i = new Intent(Money.this, CardsActivity.class);
				startActivity(i);
				finish();
			}
		},TIMEOUT);
		
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.money, menu);
		return true;
	}
}

package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class WithdrawalActivity extends Activity {
	public static final String PREFS_NAME = "cardFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdrawal);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.withdrawal, menu);
		return true;
	}

	public void display(View v) {
		TextView tv = (TextView)this.findViewById(v.getId());
		
		String amount = tv.getText().toString();
		
		TextView amountTV = (TextView)this.findViewById(R.id.amount);
		amountTV.setText(amount);
	}
	
	public void launchAmount(View v) {
		Intent intent = new Intent(this, AmountActivity.class);
		startActivity(intent);
	}

	public void launchAuthentification(View v) {
		TextView tv = (TextView)this.findViewById(R.id.amount);
		String amount = tv.getText().toString();
				
		Intent intent = new Intent(this, AuthentificationActivity.class);
		intent.putExtra("amount", amount);
		intent.putExtra("service", "withdrawal");
		startActivity(intent);
	}
}

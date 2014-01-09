package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class WithdrawalActivity extends Activity {
	String pref_name=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdrawal);
		String amount="";
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		
		pref_name = b.getString("pref");
		
		if((b.get("amount"))!=null) {
			amount = b.get("amount").toString();
			TextView tv =(TextView)this.findViewById(R.id.amount);
			tv.setText(amount+"Û");
		}else{
			TextView tv =(TextView)this.findViewById(R.id.amount);
			tv.setText("Saisir montant");
		}
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
		intent.putExtra("pref", pref_name);
		startActivity(intent);
	}

	public void launchAuthentification(View v) {
		TextView tv = (TextView)this.findViewById(R.id.amount);
		String amount = tv.getText().toString();
		
		if (amount.indexOf("S")>=0) return;
		
		Intent intent = new Intent(this, AuthentificationActivity.class);
		intent.putExtra("amount", amount);
		intent.putExtra("pref", pref_name);
		startActivity(intent);
		finish();
	}
}

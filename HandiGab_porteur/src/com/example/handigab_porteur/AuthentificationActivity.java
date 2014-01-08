package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AuthentificationActivity extends Activity {
	String amount;
	public static final String PREFS_NAME = "cardFile";
	SharedPreferences settings;
	String pin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentification);
		
		settings = getSharedPreferences(PREFS_NAME, 0);
		
		 Intent intent= getIntent();
		 Bundle b = intent.getExtras();
		 if(b!=null) {
			 amount = b.get("amount").toString();
		 }
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.authentification, menu);
		return true;
	}
	
	public void display(View v) {
		TextView tv = (TextView)this.findViewById(v.getId());
		String amount = tv.getText().toString();
		
		TextView amountTV = (TextView)this.findViewById(R.id.pinCode);
		String txt = amountTV.getText().toString();

		if (txt.indexOf("Entrer Pin")>=0) txt="";
		amountTV.setText(txt+amount);
	}
	
	public void launchWait(View v){
		String cardNumber = settings.getString("cardNumber", "");
		//String lastName = settings.getString("lastName", "");
		//String firstName = settings.getString("firstName", "");
		String bankName = settings.getString("bankName", "");
		//String date = settings.getString("date", "");
		//int cardType = settings.getInt("cardType", 0);
		String flag = settings.getString("flag", "");
			
		//if (flag.equals("") || cardNumber.equals("") || lastName.equals("") || firstName.equals("") || bankName.equals("") || cardType==0) return;
		
		TextView textViewPin = (TextView)this.findViewById(R.id.pinCode) ;
		pin = textViewPin.getText().toString();
		
		if (pin.length()!=4) return;
		
		String data = flag + ";" + cardNumber+ ";" + pin + ";"+ amount;

		//TODO : Commencer la communication en Bluetooth en envoyant data

		Intent intent = new Intent(this, Wait.class);
		startActivity(intent);		
	}

}

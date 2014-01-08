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
	String pref_name = null;
	SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentification);

		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if((b.get("amount"))!=null) {
			amount = b.get("amount").toString();
		}
		
		pref_name = b.getString("pref");
		settings = getSharedPreferences(pref_name, 0);

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

		if (txt.indexOf("a")>=0) txt="";
		amountTV.setText(txt+amount);
	}

	public void correct(View v) {
		TextView tv = (TextView)this.findViewById(R.id.pinCode);

		CharSequence pinSeq = tv.getText();

		if(pinSeq.length()>0){
			CharSequence corrected = pinSeq.subSequence(0, pinSeq.length()-1);
			tv.setText(corrected);
		}
	}

	public void stop(View v) {
		String flag = settings.getString("flag", "");

		if (flag.equals("0")) {
			Intent intent = new Intent(this, ServiceActivity.class);
			intent.putExtra("pref", pref_name);
			startActivity(intent);
			finish();
		} else if (flag.equals("1")){
			Intent intent = new Intent(this, WithdrawalActivity.class);
			intent.putExtra("pref", pref_name);
			startActivity(intent);
			finish();
		}

	}

	public void launchWait(View v){
		
		TextView tv = (TextView)this.findViewById(R.id.pinCode);
		String pinString = tv.getText().toString();
		
		if (pinString.length()==0 || pinString.length()!=4) return;
		
		String cardNumber = settings.getString("cardNumber", "");
		//String lastName = settings.getString("lastName", "");
		//String firstName = settings.getString("firstName", "");
		String bankName = settings.getString("bankName", "");
		//String date = settings.getString("date", "");
		//int cardType = settings.getInt("cardType", 0);
		String flag = settings.getString("flag", "");

		//if (flag.equals("") || cardNumber.equals("") || lastName.equals("") || firstName.equals("") || bankName.equals("") || cardType==0) return;

		String data = flag + ";"+ bankName + ";" + cardNumber+ ";" + pinString + ";"+ amount;

		//TODO : Commencer la communication en Bluetooth en envoyant data

		Intent intent = new Intent(this, Wait.class);
		startActivity(intent);
		finish();		
	}

}

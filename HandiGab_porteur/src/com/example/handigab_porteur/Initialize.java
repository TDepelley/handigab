package com.example.handigab_porteur;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Initialize extends Activity {
	String cardNumber=null;
	String lastName=null;
	String firstname=null;
	String bankName=null;
	String date=null; //MMAA
	int cardType=0; //1=Mastercard 2=Visa 3=CB
	public static final String PREFS_NAME = "cardFile";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initialize);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.initialize, menu);
		return true;
	}

	public void highlight(View v){
		ImageButton mastercard = (ImageButton)this.findViewById(R.id.mastercardButton);
		ImageButton visa = (ImageButton)this.findViewById(R.id.visaButton);
		ImageButton cb = (ImageButton)this.findViewById(R.id.cbButton);
		
		switch (v.getId()){
		case R.id.mastercardButton:
			mastercard.setImageAlpha(255);
			visa.setImageAlpha(50);
			cb.setImageAlpha(50);
			cardType=1;
			break;
		case R.id.visaButton:
			mastercard.setImageAlpha(50);
			visa.setImageAlpha(255);
			cb.setImageAlpha(50);
			cardType=2;
			break;
		case R.id.cbButton:
			mastercard.setImageAlpha(50);
			visa.setImageAlpha(50);
			cb.setImageAlpha(255);
			cardType=3;
			break;
		}

	}
	
	public void erase(View v){
		TextView textView = (TextView)findViewById(v.getId());
		textView.setText("");;
	}
	

	public boolean verifyCardNumber(String cardNumberString){
		char c;
		
		if (cardNumberString.length()<16 || cardNumberString.length()>19) return false;
		
		for (int i=0; i<cardNumberString.length(); i++){
			c =cardNumberString.charAt(i);
			int n = Character.getNumericValue(c); 
			if (n>=10 || n<0) return false;
		}
		return true;
	}
	
	public boolean verifyDate(String dateString){
		if (dateString.length()!=4) return false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MMyy");
			Date d = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
	
	public void validate(View v){
		boolean test;
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		
	
		TextView textViewLastName = (TextView)this.findViewById(R.id.lastName) ;
		TextView textViewFirstName = (TextView)this.findViewById(R.id.firstName) ;
		TextView textViewBankName = (TextView)this.findViewById(R.id.bankName) ;
		TextView textViewCardNumber = (TextView)this.findViewById(R.id.cardNumber) ;
		TextView textViewDate = (TextView)this.findViewById(R.id.date) ;
		
		editor.putString("lastName", textViewLastName.getText().toString());
		editor.putString("firstName", textViewFirstName.getText().toString());	
		editor.putString("bankName", textViewBankName.getText().toString());
		
		String tmp = textViewCardNumber.getText().toString();
		test = verifyCardNumber(tmp);
		if (test) editor.putString("cardNumber",tmp);
		else return;
		
		tmp = textViewDate.getText().toString();
		test = verifyDate(tmp);
		if (test)editor.putInt("date", Integer.parseInt(tmp));
		else return;
		
		if (cardType==0) return;
		editor.putInt("cardType", cardType);
		
		editor.commit();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}

package com.example.handigab_porteur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InformationActivity extends Activity {
	String pref_name=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if(b!=null) {
			pref_name = b.get("pref").toString();
		}
		createLogo();	
		informations();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.information, menu);
		return true;
	}
	
	public void informations(){
		SharedPreferences settings = getSharedPreferences(pref_name,0);
		
		String cardNumber=settings.getString("cardNumber", "");
		String date=settings.getString("date", "");
		String lastName=settings.getString("lastName", "");
		String firstName=settings.getString("firstName", "");
		
		TextView cardNumberTV = (TextView)this.findViewById(R.id.cardNumber);
		TextView dateTV = (TextView)this.findViewById(R.id.date);
		TextView lastNameTV = (TextView)this.findViewById(R.id.lastName);
		TextView firstNameTV = (TextView)this.findViewById(R.id.firstName);
		
		
		cardNumberTV.setText("Carte : "+cardNumber);
		dateTV.setText("Date de validité : "+date);
		lastNameTV.setText("Nom :" +lastName);
		firstNameTV.setText("Prénom : "+firstName);
	}
	
	public void createLogo() {
		SharedPreferences settings = getSharedPreferences(pref_name,0);
		LinearLayout l = (LinearLayout)this.findViewById(R.id.title);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		String cardType = settings.getString("cardType", "");	
		if(!cardType.isEmpty()) {
			if(cardType.equalsIgnoreCase("visa")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_visa);
				l.addView(imw,lp);
			}else if (cardType.equalsIgnoreCase("mastercard")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_mastercard);
				l.addView(imw,lp);
			}else if (cardType.equalsIgnoreCase("cb")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_cb);
				l.addView(imw,lp);
			}
		}
		
		String bankName = settings.getString("bankName", "");	
		if(!bankName.isEmpty()) {
			if(bankName.equalsIgnoreCase("societe generale")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_soge);
				l.addView(imw,lp);
			}else if (bankName.equalsIgnoreCase("la banque postale")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_lbp);
				l.addView(imw,lp);
			}else if (bankName.equalsIgnoreCase("caisse d'epargne")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_caissedepargne);
				l.addView(imw,lp);
			}else if (bankName.equalsIgnoreCase("le credit lyonnais")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_lcl);
				l.addView(imw,lp);
			}else if (bankName.equalsIgnoreCase("cic")) {
				ImageView imw = new ImageView(this);
				imw.setImageResource(R.drawable.ic_cic);
				l.addView(imw,lp);
			}
		}
	}
}

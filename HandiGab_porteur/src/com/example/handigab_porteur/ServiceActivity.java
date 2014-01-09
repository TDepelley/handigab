package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ServiceActivity extends Activity {
	SharedPreferences settings;
	String pref_name = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if(b!=null) {
			pref_name = b.get("pref").toString();
		}
		
		if (!pref_name.isEmpty())
			settings = getSharedPreferences(pref_name, 0);
		
		String nbCard = settings.getString("cardNumber", "");
		
		if (!nbCard.equals("")){
			TextView textView = (TextView)this.findViewById(R.id.cardTitle);
			textView.setText("Carte n¡"+nbCard+"\n");
		}
		
		createLogo();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public void launchWithdrawal(View v){
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("flag", "1");
		editor.commit();
		
		Intent intent = new Intent(this, WithdrawalActivity.class);
		intent.putExtra("pref",pref_name);
		startActivity(intent);
	}
	
	public void launchAuthentification(View v){
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("flag", "0");
		editor.commit();
		
		Intent intent = new Intent(this, AuthentificationActivity.class);
		intent.putExtra("pref",pref_name);
		startActivity(intent);
	}
	
	public void launchInformation(View v){
		
		Intent intent = new Intent(this, InformationActivity.class);
		intent.putExtra("pref",pref_name);
		startActivity(intent);
	}
	
	public void createLogo() {
		SharedPreferences settings = getSharedPreferences(pref_name,0);
		LinearLayout l = (LinearLayout)this.findViewById(R.id.serviceTitle);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		l.setOrientation(LinearLayout.HORIZONTAL);
		
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

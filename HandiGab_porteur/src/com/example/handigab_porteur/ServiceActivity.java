package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends Activity {
	public static final String PREFS_NAME = "cardFile";
	SharedPreferences settings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		
		settings = getSharedPreferences(PREFS_NAME, 0);
		String nbCard = settings.getString("cardNumber", "");
		if (!nbCard.equals("")){
			TextView textView = (TextView)this.findViewById(R.id.cardTitle);
			textView.setText("Carte n¡"+nbCard);
		}
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
		startActivity(intent);
	}
	
	public void launchAuthentification(View v){
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("flag", "0");
		editor.commit();
		
		Intent intent = new Intent(this, AuthentificationActivity.class);
		startActivity(intent);
	}
}

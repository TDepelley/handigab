package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	public static final String PREFS_NAME = "cardFile";
	Button serviceButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		
		int cardType = settings.getInt("cardType", 0);
		if (cardType==0){
			serviceButton = (Button)findViewById(R.id.card);
			serviceButton.setEnabled(false);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void launchInitialize(View v){
		Intent intent = new Intent(this, Initialize.class);
		startActivity(intent);
	}

	public void launchService(View v){
		Intent intent = new Intent(this, ServiceActivity.class);
		startActivity(intent);
	}
}

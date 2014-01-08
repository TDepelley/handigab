package com.example.handigab_porteur;

import com.example.handigab_porteur.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private static int TIMEOUT= 500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent i = new Intent(MainActivity.this, CardsActivity.class);
				startActivity(i);
				finish();
			}
		},TIMEOUT);
	}

}
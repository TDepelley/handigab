package com.example.handigab;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Initialize extends Activity {

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
			visa.setImageAlpha(175);
			cb.setImageAlpha(175);
			break;
		}

		
	}
	
}

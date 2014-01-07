package com.example.handigab_gab;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	// 
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	//Bluetooth detection here
    	super.onStart();
    }
    
    @Override
    public void onResume () {
    	super.onResume();
    	// Start 
    	super.onResume();
    	
    	Button bouton = (Button)findViewById(R.id.withdrawalButton);
    	bouton.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
		    	Intent intent = new Intent(MainActivity.this, RunningOperation.class);
		    	startActivity(intent);
			}
		});
    	
    	
    	Button bouton2 = (Button)findViewById(R.id.accountViewButton);
    	bouton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
		    	Intent intent = new Intent(MainActivity.this, RunningOperation.class);
		    	startActivity(intent);
		    	
			}
		});
    }
}

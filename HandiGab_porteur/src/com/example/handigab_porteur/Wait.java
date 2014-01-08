package com.example.handigab_porteur;

import com.example.handigab_porteur.R;
import com.example.handigab_porteur.bluetooth.BluetoothClientService;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Wait extends Activity {
	// Intent request codes
		private static final int REQUEST_ENABLE_BT = 1;
		private static final String TAG = "MainActivity";

		// Local Bluetooth adapter
		private BluetoothAdapter mBluetoothAdapter = null;
		// Member object for the chat services
		private BluetoothClientService mBluetoothService = null;
		SharedPreferences settings;
		String pin;
		String pref_name;
		String amount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wait);
		
		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if((b.get("pin"))!=null) {
			pin = b.get("pin").toString();
		}
		if((b.get("amount"))!=null) {
			amount = b.get("amount").toString();
		}
		
		pref_name = b.getString("pref");
		settings = getSharedPreferences(pref_name, 0);
		
		// Get local Bluetooth adapter
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		// If the adapter is null, then Bluetooth is not supported
		if (mBluetoothAdapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			finish();
			return;
		}

		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
		mBluetoothService = app.getBluetoothService();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wait, menu);
		return true;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");

		// If BT is not on, request that it be enabled.
		// setupChat() will then be called during onActivityResult
		
		//mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		if (mBluetoothAdapter==null) return;
		
		boolean test = mBluetoothAdapter.isEnabled();
		
		if (!test) {
			Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
			
			//TODO: Start here send message
			// Otherwise, setup the chat session
		} 
		else {
			/*if (mBluetoothService == null) {
				setup();
			}*/

			HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
			app.searchServer();
		}
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
		//HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
		//app.getBluetoothService().updateHandler(mHandler);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Stop the Bluetooth chat services
		if (mBluetoothService != null)
			mBluetoothService.stop();

		// Make sure we're not doing discovery anymore
		if (mBluetoothAdapter != null) {
			mBluetoothAdapter.cancelDiscovery();
		}

		// Unregister broadcast listeners
		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
		//app.unregisterReceivers();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();

		switch(item.getItemId()) {
		case R.id.action_search_gab:
			app.setNbEssai(0);  //reinit
			app.searchServer();
			break;
		case R.id.action_test_gab:
			app.sendMessage("TEST");
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			// When the request to enable Bluetooth returns
			if (resultCode == Activity.RESULT_OK) {
				HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
				app.searchServer();
			} else {
				//User did not enable Bluetooth or an error occurred
				Log.d(TAG, "BT not enabled");
				Toast.makeText(this, R.string.bt_not_enabled_leaving,
						Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}

	public void sendMsg() {
		String cardNumber = settings.getString("cardNumber", "");
		//String lastName = settings.getString("lastName", "");
		//String firstName = settings.getString("firstName", "");
		String bankName = settings.getString("bankName", "");
		//String date = settings.getString("date", "");
		//int cardType = settings.getInt("cardType", 0);
		String flag = settings.getString("flag", "");

		if (flag.equals("") || cardNumber.equals("") || bankName.equals("")) return;

		String data = flag + ";"+ bankName + ";" + cardNumber+ ";" + pin + ";"+ amount;

		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
		app.sendMessage(data);
	}
}

package com.example.handigab_porteur;

import com.example.handigab_porteur.R;
import com.example.handigab_porteur.bluetooth.BluetoothClientService;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Intent request codes
	private static final int REQUEST_ENABLE_BT = 1;

	public static final String PREFS_NAME = "cardFile";

	private static final String TAG = "MainActivity";

	// Local Bluetooth adapter
	private BluetoothAdapter mBluetoothAdapter = null;
	// Member object for the chat services
	private BluetoothClientService mBluetoothService = null;

	private static int TIMEOUT= 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent i = new Intent(MainActivity.this, CardsActivity.class);
				startActivity(i);
				finish();
			}
		},TIMEOUT);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");

		// If BT is not on, request that it be enabled.
		// setupChat() will then be called during onActivityResult
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
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
			app.setNbEssai(0); // reinit
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
				// User did not enable Bluetooth or an error occurred
				Log.d(TAG, "BT not enabled");
				Toast.makeText(this, R.string.bt_not_enabled_leaving,
						Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}
}
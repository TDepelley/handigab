package com.example.handigab_porteur;

import com.example.handigab_porteur.R;
import com.example.handigab_porteur.bluetooth.BluetoothClientService;
import com.example.handigab_porteur.bluetooth.BluetoothConstants;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class Wait extends Activity {
	// Intent request codes
	private static final int REQUEST_ENABLE_BT = 1;
	private static final String TAG = "MainActivity";
    private static final boolean D = true;
	private int nbEssai = 0;
	private HandiGabPorteurApplication app;
	private String mConnectedDeviceName = null;
	private static int TIMEOUT= 60000;

	// Local Bluetooth adapter
	private BluetoothAdapter mBluetoothAdapter = null;
	// Member object for the chat services
	private BluetoothClientService mBluetoothService = null;
	SharedPreferences settings;
	String pin;
	String pref_name;
	String amount;
	String flag;

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
			Toast.makeText(this, "Bluetooth is not available",Toast.LENGTH_LONG).show();
			finish();
			return;
		}

		app = (HandiGabPorteurApplication) getApplication();
		mBluetoothService = app.getBluetoothService();
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
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

		//mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		if (mBluetoothAdapter==null) return;

		boolean test = mBluetoothAdapter.isEnabled();

		if (!test) {
			Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);

			// Otherwise, setup the chat session
		} 
		else {
			app = (HandiGabPorteurApplication) getApplication();
			mBluetoothService.updateHandler(mHandler);
			app.searchServer();
			Log.e("Error", "Search");
		}

		/*
		//Waiting for a response from the server
		String response = null;
		receiveMsg(response);
		 */
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
		app = (HandiGabPorteurApplication) getApplication();
		//app.unregisterReceivers();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		app = (HandiGabPorteurApplication) getApplication();

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
				app = (HandiGabPorteurApplication) getApplication();
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

		if (flag.equals("") || cardNumber.equals("") || bankName.equals("")) {
			Log.e("Error","data error");
			return;
		}

		String data = flag + ";"+ bankName + ";" + cardNumber+ ";" + pin;
		
		if(flag.equals("1"))
			data = data +";"+amount;

		//adata=data+"\0";
		app = (HandiGabPorteurApplication) getApplication();
		app.sendMessage(data);
		Log.e("Error",data);
	}

	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case BluetoothConstants.MESSAGE_STATE_CHANGE:
				Log.e("Error", "message change");
				if (D)
					Log.i("Error", "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case BluetoothClientService.STATE_CONNECTED:
					Log.d("Error", "connected");
					nbEssai = 0;
					sendMsg();
					//setStatus(getString(R.string.title_connected_to, mConnectedDeviceName));
					break;
				case BluetoothClientService.STATE_CONNECTING:
					nbEssai++;
					Toast.makeText(getApplicationContext(),
							getString(R.string.search_gab),
							Toast.LENGTH_SHORT).show();
					break;
				case BluetoothClientService.STATE_NONE:
					//setStatus(R.string.title_not_connected);
					break;
				}
				break;
			case BluetoothConstants.MESSAGE_WRITE:
				Log.d("Error", "write");
				byte[] writeBuf = (byte[]) msg.obj;
				// construct a string from the buffer
				String writeMessage = new String(writeBuf);
				break;
			case BluetoothConstants.MESSAGE_READ:
				
				byte[] readBuf = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				String readMessage = new String(readBuf, 0, msg.arg1);
				app.receiveMessage(readMessage);

				Log.d("Error", "read");
				
				flag = settings.getString("flag", "");
				Intent intent =null;

				if (flag.equals("0")) intent = new Intent(Wait.this, Account.class);			
				else if (flag.equals("1"))  intent = new Intent(Wait.this, Money.class);
				intent.putExtra("msg", readMessage);
				startActivity(intent);
				finish();
				break;
			case BluetoothConstants.MESSAGE_DEVICE_NAME:
				Log.e("Error", "message device name");
				// save the connected device's name
				mConnectedDeviceName = msg.getData().getString(BluetoothConstants.DEVICE_NAME);
				Toast.makeText(getApplicationContext(),
						"Connected to " + mConnectedDeviceName,
						Toast.LENGTH_SHORT).show();
				break;
			case BluetoothConstants.MESSAGE_TOAST:
				Log.e("Error", "message toast");
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(BluetoothConstants.TOAST),
						Toast.LENGTH_SHORT).show();
				break;
			case BluetoothConstants.MESSAGE_DEVICE_ADDRESS:
				Log.e("Error", "message adress");
				// Create the result Intent and include the MAC address
				Intent intentConnection = new Intent();
				intentConnection.putExtra(
						BluetoothConstants.EXTRA_DEVICE_ADDRESS, msg.getData()
						.getString(BluetoothConstants.DEVICE_ADDRESS));
				Log.i(TAG,
						"Connection request to address "
								+ msg.getData().getString(
										BluetoothConstants.DEVICE_ADDRESS));
				app.connectDevice(intentConnection);
				break;
			case BluetoothConstants.MESSAGE_CONNECTION_FAILED:
				Log.e("Error", "message failed");
				Toast.makeText(getApplicationContext(),
						getString(R.string.connection_failed),
						Toast.LENGTH_SHORT).show();

				if(nbEssai < 3) {
					app.searchServer();
				}
				break;
			}
		}

	};
}

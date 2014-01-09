package com.example.handigab_gab;


import android.os.SystemClock;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.example.handigab_gab.bluetooth.BluetoothConstants;
import com.example.handigab_gab.bluetooth.BluetoothServerService;

public class MainActivity extends Activity {

	// Debugging
	private static final String TAG = "MainActivity";
	private static final boolean D = true;

	// Intent request codes
	private static final int REQUEST_ENABLE_BT = 3;
	private static final int REQUEST_FINISH = 2;

	// Local Bluetooth adapter
	private BluetoothAdapter mBluetoothAdapter = null;

	// Member object for the chat services
	private BluetoothServerService mBluetoothService = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (D)
			Log.e(TAG, "+++ ON CREATE +++");

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// Set up the window layout
		setContentView(R.layout.activity_main);

		// Get local Bluetooth adapter
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		// If the adapter is null, then Bluetooth is not supported
		if (mBluetoothAdapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			finish();
			return;
		}

		Button bouton = (Button) findViewById(R.id.withdrawalButton);
		bouton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						RunningOperation.class);
				startActivity(intent);
			}
		});

		Button bouton2 = (Button) findViewById(R.id.accountViewButton);
		bouton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						RunningOperation.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public void onStart() {
		super.onStart();
		if (D)
			Log.e(TAG, "++ ON START ++");

		// If BT is not on, request that it be enabled.
		// setupChat() will then be called during onActivityResult
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
			// Otherwise, setup the chat session
		} else if (mBluetoothService == null) {
			// Initialize the BluetoothChatService to perform bluetooth
			// connections
			mBluetoothService = BluetoothServerService.getInstance(this,
					mHandler);
		}

	}

	@Override
	public synchronized void onResume() {
		super.onResume();
		if (D)
			Log.e(TAG, "+ ON RESUME +");

		View decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
		setContentView(R.layout.activity_main);

		// Performing this check in onResume() covers the case in which BT was
		// not enabled during onStart(), so we were paused to enable it...
		// onResume() will be called when ACTION_REQUEST_ENABLE activity
		// returns.
		if (mBluetoothService != null) {
			// Only if the state is STATE_NONE, do we know that we haven't
			// started already
			if (mBluetoothService.getState() == BluetoothServerService.STATE_NONE) {
				// Start the Bluetooth chat services
				mBluetoothService.start();
			}
		}
	}

	@Override
	public synchronized void onPause() {
		super.onPause();
		if (D)
			Log.e(TAG, "- ON PAUSE -");
	}

	@Override
	public void onStop() {
		super.onStop();
		if (D)
			Log.e(TAG, "-- ON STOP --");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// Stop the Bluetooth chat services
		if (mBluetoothService != null)
			mBluetoothService.stop();
		if (D)
			Log.e(TAG, "--- ON DESTROY ---");
	}

	/*
	 * private final void setStatus(int resId) { final ActionBar actionBar =
	 * getActionBar(); actionBar.setSubtitle(resId); }
	 * 
	 * private final void setStatus(CharSequence subTitle) { final ActionBar
	 * actionBar = getActionBar(); actionBar.setSubtitle(subTitle); }
	 */

	// The Handler that gets information back from the BluetoothChatService
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case BluetoothConstants.MESSAGE_STATE_CHANGE:
				if (D)
					Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case BluetoothServerService.STATE_CONNECTED:
					Log.i(TAG, "State connected");
					// TODO changement etat vers connect
					startActivityForResult(new Intent(MainActivity.this,
							RunningOperation.class), REQUEST_FINISH);
					break;
				case BluetoothServerService.STATE_CONNECTING:
					Log.i(TAG, "State connecting");
					// TODO changement etat vers en connexion
					break;
				case BluetoothServerService.STATE_LISTEN:
				case BluetoothServerService.STATE_NONE:
					Log.i(TAG, "State unconnect");
					// TODO changement etat non connect
					break;
				}
				break;
			case BluetoothConstants.MESSAGE_WRITE:
				byte[] writeBuf = (byte[]) msg.obj;
				String messageEnvoye = new String(writeBuf);

				break;
			case BluetoothConstants.MESSAGE_READ:
				byte[] readBuf = (byte[]) msg.obj;
				String messageRecu = new String(readBuf, 0, msg.arg1);

				break;
			case BluetoothConstants.MESSAGE_DEVICE_NAME:

				break;
			case BluetoothConstants.MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(BluetoothConstants.TOAST), Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	};

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (D)
			Log.d(TAG, "onActivityResult " + resultCode);
		switch (requestCode) {
		case REQUEST_ENABLE_BT:
			// When the request to enable Bluetooth returns
			if (resultCode == Activity.RESULT_OK) {

				// Bluetooth is now enabled
				if (mBluetoothService == null) {
					// Initialize the BluetoothChatService to perform bluetooth connections
			     	mBluetoothService = BluetoothServerService.getInstance(this, mHandler);
				}

			} else {
				// User did not enable Bluetooth or an error occurred
				Log.d(TAG, "BT not enabled");
				Toast.makeText(this, R.string.bt_not_enabled_leaving,
						Toast.LENGTH_SHORT).show();
				finish();
			}
			break;
		case REQUEST_FINISH:
			// update references
			mBluetoothService = BluetoothServerService.getInstance(this, mHandler);
			break;
		}
	}
}

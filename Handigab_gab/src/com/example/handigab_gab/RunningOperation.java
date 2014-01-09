package com.example.handigab_gab;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.handigab_gab.bluetooth.BluetoothConstants;
import com.example.handigab_gab.bluetooth.BluetoothServerService;
import com.example.handigab_gab.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RunningOperation extends Activity {

	private static final String TAG = "RunningOperation";
	private static final boolean D = true;

	// Member object for the chat services
	private BluetoothServerService mBluetoothService = null;

	// Name of the connected device
	private String mConnectedDeviceName = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		View decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
		setContentView(R.layout.activity_running_operation);

		// Initialize the BluetoothChatService to perform bluetooth connections
		mBluetoothService = BluetoothServerService.getInstance(this, mHandler);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

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
					// TODO changement etat vers connecte
					break;
				case BluetoothServerService.STATE_CONNECTING:
					Log.i(TAG, "State connecting");

					break;
				case BluetoothServerService.STATE_LISTEN:
				case BluetoothServerService.STATE_NONE:
					Log.i(TAG, "State unconnect");
					finish();
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
				receiveMessage(messageRecu);
				break;
			case BluetoothConstants.MESSAGE_DEVICE_NAME:
				// save the connected device's name
				mConnectedDeviceName = msg.getData().getString(
						BluetoothConstants.DEVICE_NAME);
				Toast.makeText(getApplicationContext(),
						"Connected to " + mConnectedDeviceName,
						Toast.LENGTH_SHORT).show();
				break;
			case BluetoothConstants.MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(BluetoothConstants.TOAST),
						Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};

	/**
	 * Permet d'envoyer un message a l'application porteur
	 * @param message
	 */
	private void sendMessage(String message) {
		// Check that we're actually connected before trying anything
		if (mBluetoothService.getState() != BluetoothServerService.STATE_CONNECTED) {
			Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT)
					.show();
			return;
		}

		// Check that there's actually something to send
		if (message.length() > 0) {
			// Get the message bytes and tell the BluetoothChatService to write
			byte[] send = message.getBytes();
			mBluetoothService.write(send);
		}
	}
	
	/**
	 * Permet de recevoir un message de l'application porteur
	 * @param message
	 */
	private void receiveMessage(String message) {
		Toast.makeText(getApplicationContext(),
				"Message recu : "+message,
				Toast.LENGTH_SHORT).show();
		
		// test de connexion
		if(message.equals("TEST")) {
			sendMessage("TEST OK");
		}
	}
}

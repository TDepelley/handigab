package com.example.handigab_porteur;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.handigab_porteur.bluetooth.BluetoothClientService;
import com.example.handigab_porteur.bluetooth.BluetoothConstants;

public class HandiGabPorteurApplication extends Application {

	private static final String TAG = "HandiGabPorteurApplication";
	private static final boolean D = true;
	
	private BluetoothClientService mBluetoothService;
	private BluetoothAdapter mBluetoothAdapter;
	private String mConnectedDeviceName = null;
	
	private int nbEssai = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		// init with handler not manage
		mBluetoothService = new BluetoothClientService(this, mHandler);
	}
	
	public void unregisterReceivers() {
		
		unregisterReceiver(mReceiver);
	}

	public BluetoothClientService getBluetoothService() {
		return mBluetoothService;
	}

	/**
	 * Start device discover with the BluetoothAdapter
	 */
	private void doDiscovery() {
		if (D)
			Log.d(TAG, "doDiscovery()");

		// Indicate scanning in the title
//		setProgressBarIndeterminateVisibility(true);
//		setTitle(R.string.scanning);

		// If we're already discovering, stop it
		if (mBluetoothAdapter.isDiscovering()) {
			mBluetoothAdapter.cancelDiscovery();
		}

		// Request discover from BluetoothAdapter
		mBluetoothAdapter.startDiscovery();
	}

	// The BroadcastReceiver that listens for discovered devices and
	// changes the title when discovery is finished
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			// When discovery finds a device
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// Get the BluetoothDevice object from the Intent
				BluetoothDevice device = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

				Log.d(TAG, "BL ACTION_FOUND, name=" + device.getName()
						+ " state=" + device.getBondState());

				// If it's already paired, skip it, because it's been listed
				// already
				if (/*
					 * device.getBondState() != BluetoothDevice.BOND_BONDED &&
					 */device.getName().equals(
						BluetoothConstants.BLUETOOTH_SERVER_NAME)) {

					// Send the name of the connected device back to the UI
					// Activity
					Message msg = mHandler
							.obtainMessage(BluetoothConstants.MESSAGE_DEVICE_ADDRESS);
					Bundle bundle = new Bundle();
					bundle.putString(BluetoothConstants.DEVICE_ADDRESS,
							device.getAddress());
					msg.setData(bundle);
					mHandler.sendMessage(msg);

					// Cancel discovery because it's costly and we're about to
					// connect
					mBluetoothAdapter.cancelDiscovery();
				}
			} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
					.equals(action)) {

				// TODO Wait e� ajouter
				// doDiscovery();

				Log.d(TAG, "BL ACTION_DISCOVERY_FINISHED");
			}
		}
	};

	// The Handler that gets information back from the BluetoothChatService or
	// Register
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case BluetoothConstants.MESSAGE_STATE_CHANGE:
				if (D)
					Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case BluetoothClientService.STATE_CONNECTED:
					nbEssai = 0;
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
				byte[] writeBuf = (byte[]) msg.obj;
				// construct a string from the buffer
				String writeMessage = new String(writeBuf);
				break;
			case BluetoothConstants.MESSAGE_READ:
				byte[] readBuf = (byte[]) msg.obj;
				// construct a string from the valid bytes in the buffer
				String readMessage = new String(readBuf, 0, msg.arg1);
				receiveMessage(readMessage);
				break;
			case BluetoothConstants.MESSAGE_DEVICE_NAME:
				// save the connected device's name
				mConnectedDeviceName = msg.getData().getString(BluetoothConstants.DEVICE_NAME);
				Toast.makeText(getApplicationContext(),
						"Connected to " + mConnectedDeviceName,
						Toast.LENGTH_SHORT).show();
				break;
			case BluetoothConstants.MESSAGE_TOAST:
				Toast.makeText(getApplicationContext(),
						msg.getData().getString(BluetoothConstants.TOAST),
						Toast.LENGTH_SHORT).show();
				break;
			case BluetoothConstants.MESSAGE_DEVICE_ADDRESS:
				// Create the result Intent and include the MAC address
				Intent intentConnection = new Intent();
				intentConnection.putExtra(
						BluetoothConstants.EXTRA_DEVICE_ADDRESS, msg.getData()
								.getString(BluetoothConstants.DEVICE_ADDRESS));
				Log.i(TAG,
						"Connection request to address "
								+ msg.getData().getString(
										BluetoothConstants.DEVICE_ADDRESS));
				connectDevice(intentConnection);
				break;
			case BluetoothConstants.MESSAGE_CONNECTION_FAILED:
				Toast.makeText(getApplicationContext(),
						getString(R.string.connection_failed),
						Toast.LENGTH_SHORT).show();
				
				if(nbEssai < 3) {
					searchServer();
				}
				break;
			}
		}

	};
	
	private void connectDevice(Intent data) {
		// Get the device MAC address
		String address = data.getExtras().getString(
				BluetoothConstants.EXTRA_DEVICE_ADDRESS);

		Log.i(TAG, "Connect device (address=" + address);

		// Get the BluetoothDevice object
		BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
		device.fetchUuidsWithSdp();
		
		// Attempt to connect to the device
		mBluetoothService.connect(device);
	}
	
	public void searchServer() {
		// Setup the window
		// requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		if(mBluetoothService.isConnected()) {
			return;
		}
		
		// perform device discovery
		doDiscovery();

		// Register for broadcasts when a device is discovered
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		this.registerReceiver(mReceiver, filter);

		// Register for broadcasts when discovery has finished
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(mReceiver, filter);
	}
	
	/**
	 * Envoi d'un message au GAB
	 * @param message
	 */
	public void sendMessage(String message) {
		// Check that we're actually connected before trying anything
		if (mBluetoothService.getState() != BluetoothClientService.STATE_CONNECTED) {
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
	 * Message reçu
	 * @param message
	 */
	private void receiveMessage(String message) {
		Toast.makeText(getApplicationContext(),
				"Message reçu : "+message,
				Toast.LENGTH_SHORT).show();
	}

	public void setNbEssai(int nbEssai) {
		this.nbEssai = nbEssai;
	}
	
	

}

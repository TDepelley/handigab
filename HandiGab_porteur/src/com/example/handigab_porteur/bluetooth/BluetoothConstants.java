package com.example.handigab_porteur.bluetooth;

public class BluetoothConstants {

	// Message types sent from the BluetoothChatService Handler
	public static final int MESSAGE_STATE_CHANGE = 1;
	public static final int MESSAGE_READ = 2;
	public static final int MESSAGE_WRITE = 3;
	public static final int MESSAGE_DEVICE_NAME = 4;
	public static final int MESSAGE_TOAST = 5;
	public static final int MESSAGE_DEVICE_ADDRESS = 6;
	public static final int MESSAGE_CONNECTION_FAILED = 7;

	// Key names received from the BluetoothChatService Handler
	public static final String DEVICE_NAME = "device_name";
	public static final String DEVICE_ADDRESS = "device_address";
	public static final String TOAST = "toast";
	public static final String EXTRA_DEVICE_ADDRESS = "device_address";
	
	public static final String BLUETOOTH_SERVER_NAME = "HandiGAB";
	
}

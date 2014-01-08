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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AuthentificationActivity extends Activity {
//	// Intent request codes
//	private static final int REQUEST_ENABLE_BT = 1;
//	private static final String TAG = "MainActivity";
//
//	// Local Bluetooth adapter
//	private BluetoothAdapter mBluetoothAdapter = null;
//	// Member object for the chat services
//	private BluetoothClientService mBluetoothService = null;

	
	String amount;
	String pref_name = null;
	SharedPreferences settings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentification);

		Intent intent= getIntent();
		Bundle b = intent.getExtras();
		if((b.get("amount"))!=null) {
			amount = b.get("amount").toString();
		}
		
		pref_name = b.getString("pref");
		settings = getSharedPreferences(pref_name, 0);


//		// Get local Bluetooth adapter
//		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//
//		// If the adapter is null, then Bluetooth is not supported
//		if (mBluetoothAdapter == null) {
//			Toast.makeText(this, "Bluetooth is not available",
//					Toast.LENGTH_LONG).show();
//			finish();
//			return;
//		}
//
//		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//		mBluetoothService = app.getBluetoothService();

	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.authentification, menu);
		return true;
	}

	public void display(View v) {
		TextView tv = (TextView)this.findViewById(v.getId());
		String amount = tv.getText().toString();

		TextView amountTV = (TextView)this.findViewById(R.id.pinCode);
		String txt = amountTV.getText().toString();

		if (txt.indexOf("a")>=0) txt="";
		amountTV.setText(txt+amount);
	}

	public void correct(View v) {
		TextView tv = (TextView)this.findViewById(R.id.pinCode);

		CharSequence pinSeq = tv.getText();

		if(pinSeq.length()>0){
			CharSequence corrected = pinSeq.subSequence(0, pinSeq.length()-1);
			tv.setText(corrected);
		}
	}

	public void stop(View v) {
		String flag = settings.getString("flag", "");

		if (flag.equals("0")) {
			Intent intent = new Intent(this, ServiceActivity.class);
			intent.putExtra("pref", pref_name);
			startActivity(intent);
			finish();
		} else if (flag.equals("1")){
			Intent intent = new Intent(this, WithdrawalActivity.class);
			intent.putExtra("pref", pref_name);
			startActivity(intent);
			finish();
		}

	}

	public void launchWait(View v){
		
		TextView tv = (TextView)this.findViewById(R.id.pinCode);
		String pinString = tv.getText().toString();
		
		if (pinString.length()==0 || pinString.length()!=4) return;

		Intent intent = new Intent(this, Wait.class);
		intent.putExtra("pin", pinString);
		intent.putExtra("pref",pref_name);
		intent.putExtra("amount",amount);
		startActivity(intent);
		finish();		
	}
	
//	@Override
//	public void onStart() {
//		super.onStart();
//		Log.d(TAG, "onStart");
//
//		// If BT is not on, request that it be enabled.
//		// setupChat() will then be called during onActivityResult
//		
//		//mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//		
//		if (mBluetoothAdapter==null) Log.d(TAG, "probleme");
//		else Log.d(TAG, "bizarre");
//		
//		boolean test = mBluetoothAdapter.isEnabled();
//		Log.d(TAG, "onStart3");
//		
//		if (!test) {
//			Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//			startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
//			// Otherwise, setup the chat session
//		} 
//		else {
//			/*if (mBluetoothService == null) {
//				setup();
//			}*/
//
//			HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//			app.searchServer();
//		}
//	}
//	@Override
//	protected void onResume() {
//		super.onResume();
//		Log.d(TAG, "onResume");
//		//HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//		//app.getBluetoothService().updateHandler(mHandler);
//	}
//
//	@Override
//	public void onDestroy() {
//		super.onDestroy();
//
//		// Stop the Bluetooth chat services
//		if (mBluetoothService != null)
//			mBluetoothService.stop();
//
//		// Make sure we're not doing discovery anymore
//		if (mBluetoothAdapter != null) {
//			mBluetoothAdapter.cancelDiscovery();
//		}
//
//		// Unregister broadcast listeners
//		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//		//app.unregisterReceivers();
//	}
//
//	@Override
//	public boolean onMenuItemSelected(int featureId, MenuItem item) {
//		HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//
//		switch(item.getItemId()) {
//		case R.id.action_search_gab:
//			app.setNbEssai(0);  //reinit
//			app.searchServer();
//			break;
//		case R.id.action_test_gab:
//			app.sendMessage("TEST");
//			break;
//		}
//
//		return super.onMenuItemSelected(featureId, item);
//	}
//
//	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//		switch (requestCode) {
//		case REQUEST_ENABLE_BT:
//			// When the request to enable Bluetooth returns
//			if (resultCode == Activity.RESULT_OK) {
//				HandiGabPorteurApplication app = (HandiGabPorteurApplication) getApplication();
//				app.searchServer();
//			} else {
//				//User did not enable Bluetooth or an error occurred
//				Log.d(TAG, "BT not enabled");
//				Toast.makeText(this, R.string.bt_not_enabled_leaving,
//						Toast.LENGTH_SHORT).show();
//				finish();
//			}
//		}
//	}

}

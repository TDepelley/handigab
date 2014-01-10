package com.example.handigab_gab;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handigab_gab.bluetooth.BluetoothConstants;
import com.example.handigab_gab.bluetooth.BluetoothServerService;
import com.example.handigab_gab.communication.soap.SoapAccess;
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
	private static String banqueGAB = "Ensibank";

	// Member object for the chat services
	private BluetoothServerService mBluetoothService = null;

	// Name of the connected device
	private String mConnectedDeviceName = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Initialize the BluetoothChatService to perform bluetooth connections
		mBluetoothService = BluetoothServerService.getInstance(this, mHandler);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getActionBar().hide();

		View decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
		setContentView(R.layout.activity_running_operation);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		//Verification de l'existence ou non d'une transaction
		//		Toast.makeText(RunningOperation.this, "lancement du service SOAP", Toast.LENGTH_SHORT).show();
		mBluetoothService.updateHandler(mHandler);

	}

	@Override
	protected void onStart()
	{
		super.onStart();
		//Verification de l'existence ou non d'une transaction
		//		Toast.makeText(RunningOperation.this, "lancement du service SOAP", Toast.LENGTH_SHORT).show();

		TextView messageCentral = (TextView) findViewById(R.id.textView1);
		messageCentral.setText("Connexion Bluetooth détectée...");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	// The Handler that gets information back from the BluetoothChatService
	private final Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Log.e("rrrrrrrrrrr","HANDLER");
			switch (msg.what) {
			case BluetoothConstants.MESSAGE_STATE_CHANGE:
				if (D)
					Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
				switch (msg.arg1) {
				case BluetoothServerService.STATE_CONNECTED:
					Log.e("rrrrrrrrrrr","STATE_CONNECTED");
					Log.i(TAG, "State connected");

					break;
				case BluetoothServerService.STATE_CONNECTING:
					Log.e("rrrrrrrrrrr","STATE_CONNECTING");
					Log.i(TAG, "State connecting");

					break;
				case BluetoothServerService.STATE_LISTEN:
					Log.e("rrrrrrrrrrr","STATE_LISTEN");
				case BluetoothServerService.STATE_NONE:
					Log.i(TAG, "State unconnect");
					mHandler.postDelayed(new Runnable() {

						@Override
						public void run() {
							finish();
						}
					}, 2000);

					break;
				}
				break;
			case BluetoothConstants.MESSAGE_WRITE:
				Log.e("rrrrrrrrrrr","MESSAGE_WRITE");
				byte[] writeBuf = (byte[]) msg.obj;
				String messageEnvoye = new String(writeBuf);
				Log.d(TAG, "messageEnvoye : "+messageEnvoye);
				break;
			case BluetoothConstants.MESSAGE_READ:
				Log.e("rrrrrrrrrrr","MESSAGE_READ");
				if(msg.arg1 > 0){
					byte[] readBuf = (byte[]) msg.obj;

					String messageRecu = new String(readBuf, 0, msg.arg1);
					messageReceived(messageRecu);
				}
				else {
					Log.e(TAG, "Message recu null !!");
				}

				break;
			case BluetoothConstants.MESSAGE_DEVICE_NAME:
				Log.e("rrrrrrrrrrr","MESSAGE_DEVICE_NAME");
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
	 * Permet d'envoyer un message �� l'application porteur
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
	 * Permet de traiter un message bluetooth de l'application porteur
	 * @param message Message recu
	 */
	private void messageReceived(final String tempMessage) {
		// TODO: maj ecran gab

		final TextView messageCentral = (TextView) findViewById(R.id.textView1);

		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				messageCentral.setText("Traitement de l'opération en cours...");
			}
		}, 2000);


		final Handler handler2 = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
		String[] result = {};
		String clientBank = "";
		String message = tempMessage;
		
		result = message.split(";");
		message = "";
		for (int i = 0; i < result.length; i++) {
			if (i == 1) {
				clientBank = result[i];
			} else
				message += result[i]+"#"; 
		} 
		message = message.substring(0, message.length()-2);

		Log.d("rrrrrrrrrrr","zob��");

				String returnMessage;

				if (clientBank.compareTo(banqueGAB) != 0 && result[0].compareTo("0") == 0) {
					Log.d("rrrrrrrrrrr","aob��++");
					// Si le client a demande une consultation hors de sa banque
					returnMessage = "False;Vous ne pouvez consulter votre solde que dans votre banque";
					sendMessage(returnMessage);
					// TODO: maj ecran gab
					return;
				} else {
					String[] response = sendSoapRequest(message);
					Log.e("rrrrrrrrrrr", response.length +"");
					if (response.length == 1) {
						Log.d("rrrrrrrrrrr","length 1"+ response[0]);

						if (response[0].equals("OK")) {
							returnMessage = "True;Retrait accepté . Veuillez prendre vos billets";
							sendMessage(returnMessage);
							
							messageCentral.setText("Veuillez prendre vos billets...");
							return;
						}
						if (response[0].equals("PIN-INVALIDE")) {
							returnMessage = "False;Votre PIN est invalide. Veuillez recommencer l'opération";
							sendMessage(returnMessage);
							
							messageCentral.setText("Échec de l'opération...");
							return;
						}
						if (response[0].equals("CARTE-INEXISTANTE")) {
							returnMessage = "False;Votre carte bancaire est inexistante.";
							sendMessage(returnMessage);
							
							messageCentral.setText("Échec de l'opération...");
							return;
						}
						if (response[0].equals("SOLDE-INSUFFISANT")) {
							returnMessage = "False;Retrait refusé. Votre solde est insuffisant.";
							sendMessage(returnMessage);
							
							messageCentral.setText("Échec de l'opération...");
							return;
						}
						if (response[0].equals("CLIENT-INEXISTANT")) {
							returnMessage = "False;Client inconnu !";
							sendMessage(returnMessage);
							
							messageCentral.setText("Échec de l'opération...");
							return;
						}
					} else {
						returnMessage = "Le "+ response[3] + ", le solde du compte au nom de " + response[2] + " " + response[1] + " est de " + response[0] + ".";
						
						messageCentral.setText("Opération réussie.");
						return;
					}
				}

			}
		}, 5000);
		return;
	}


	private String[] sendSoapRequest(String request) {
		//Service SOAP
		//String _URL = "http://192.168.214.205:8280/HandiGABServer/services/ConsultationWS?wsdl";   //FATOUMATA
		//    	String _URL = "http://192.168.215.226:8080/HandiGABServer/services/ConsultationWS?wsdl";    	//TUG
		//String _URL = "http://192.168.43.245:8280/HandiGABServer/services/retraitConsultationSolde?wsdl";
		String _URL = "http://192.168.215.61:8080/HandiGABServer/services/ConsultationWS?wsdl";   //B12



		SoapAccess service = new SoapAccess(_URL);
		try {
			String result = service.new withdrawOrConsult().execute(new String (request)).get();

			String[] response = {""};
			if (result == null)
			{
				Toast.makeText(RunningOperation.this, "Problème de connexion au serveur", Toast.LENGTH_SHORT).show();
				return new String[] {"Probleme de connexion avec le serveur"};
			}
			else
			{
				response = result.split("#");
				for (int i = 0; i < response.length; i++)
				{
					Toast.makeText(RunningOperation.this, response[i], Toast.LENGTH_SHORT).show();	
				}

				return response;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

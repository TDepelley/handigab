package com.example.handigab_gab;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.example.handigab_gab.util.SystemUiHider;

import communication.soap.SoapAccess;
import communication.soap.SoapAccess.Authentication;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RunningOperation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		View decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        setContentView(R.layout.activity_running_operation);
	}
	
	
	@Override
	protected void onStart()
	{
		super.onStart();
    	//Vérification de l'existence ou non d'une transaction
		Toast.makeText(RunningOperation.this, "lancement du service SOAP", Toast.LENGTH_SHORT).show();
		//Service SOAP
    	String _URL = "http://192.168.215.226:8080/HandiGABServer/services/ConsultationWS?wsdl";
    	//String _URL = "http://192.168.43.245:8280/HandiGABServer/services/retraitConsultationSolde?wsdl";

    	SoapAccess service = new SoapAccess(_URL);
    	service.new Authentication(){
    		protected void onPostExecute(String result) {
    			if (result == null)
    			{
    				Toast.makeText(RunningOperation.this, "Texte null", Toast.LENGTH_SHORT).show();
    			}
    			else
    			{
        			String[] data = result.split("#");
        			for (int i = 0; i < data.length; i++)
        			{
        				Toast.makeText(RunningOperation.this, data[i], Toast.LENGTH_SHORT).show();	
        			}
    			}
    			
    		}
    		
    	}.execute(new String ("R#77#77"));

	}
}

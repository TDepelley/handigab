package communication.soap;

import java.util.HashMap;
import java.util.Map;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.os.AsyncTask;
import android.util.Log;

public class SoapAccess {

	private final static String NAMESPACE = "http://WebService";
	private String base_URL = "http://192.168.214.205:8280/HandiGABServer/services/ConsultationWS?wsdl";
	private final static String AUTH_CLIENT_COMPLETE = new String("http://WebService/authentifiePorteur");
	private final static String AUTH_CLIENT = new String("authentifiePorteur");
	private final static String RETRAIT_CONSULT_COMPLETE = new String("http://WebService/retraitConsultationSolde");
	private final static String RETRAIT_CONSULT = new String("retraitConsultationSolde");
	private static Map<String, SoapAccess> soapAccessMap = new HashMap<String, SoapAccess>();

	public SoapAccess (String base_url) {
		base_URL = base_url;
	}
	
	public SoapObject queryPrimitive(String completeMethodName, String methodName, String param) {
		SoapSerializationEnvelope envelope;
		SoapObject request = new SoapObject(NAMESPACE, methodName);
        request.addProperty("arg0",param);
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = false;
       
    	SoapObject response = null;
        try {
        	HttpTransportSE httpRequest = new HttpTransportSE(base_URL);
            httpRequest.call(completeMethodName, envelope);
            response = (SoapObject)envelope.bodyIn;
            Log.e("reponse", response.toString());	
        } catch (Exception e) {
            Log.e("ErrorWebserv", e.toString());
        }
        
        return response;
	}
	
	public String[] parseResponseSOAP(String result){
		String [] splittedResponse = result.split("#");
		return splittedResponse;
	}

	public class Authentication extends AsyncTask<String, Void, String>{
		private Exception except = null;

		@Override
		protected String doInBackground(String... params) {
			SoapObject result = queryPrimitive(AUTH_CLIENT_COMPLETE, AUTH_CLIENT, params[0]);
			String valeur = null;
			if (result != null)
			{
				if (result.getPropertyAsString(0) != null)
				{
					valeur = result.getPropertyAsString(0);
				}
				else
				{
					valeur = "Empty response";
				}
			}
			return valeur;
		}

		public Exception getExcept() {
			return except;
		}

		public void setExcept(Exception except) {
			this.except = except;
		}    
	}

	public class ConsultAccount extends AsyncTask<String, Void, String>{
		private Exception except = null;
		
		@Override
		protected String doInBackground(String... params) {
			SoapObject result = queryPrimitive(RETRAIT_CONSULT_COMPLETE, RETRAIT_CONSULT, params[0]);
			String valeur = null;
			if (result.getPropertyAsString(0) != null)
			{
				valeur = result.getPropertyAsString(0);
			}
			else
			{
				valeur = "Empty response";
			}
			return valeur;
		}

		public Exception getExcept() {
			return except;
		}

		public void setExcept(Exception except) {
			this.except = except;
		}
	}

	public static SoapAccess getInstance(String base_url) {
		SoapAccess sa = soapAccessMap.get(base_url);
        if (sa == null) {
        	sa = new SoapAccess(base_url);
        	soapAccessMap.put(base_url, sa);
        }
		return sa;
	}

	public String getBase_URL() {
		return base_URL;
	}

	public void setBase_URL(String base_URL) {
		this.base_URL = base_URL;
	}
}

package com.equipnet.barcode;


import org.json.JSONArray; 
import org.json.JSONException; 
import org.json.JSONObject; 
//importazioni da Cordova 
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

//importazioni da Android
import android.content.Context;
import android.hardware.barcode.Scanner;
import android.telephony.TelephonyManager;
import org.apache.cordova.CordovaPlugin;


import android.util.Log; 

public class Barcode extends CordovaPlugin { 
             
        public static final String READ = "read"; 
        public static final String ME = "logging"; 
   

        
        public void initialize(CordovaInterface cordova, CordovaWebView webview) {
    		super.initialize(cordova, webView);
    		//Il plugin non ha accesso diretto al contesto dell'applicazione
    		//e quindi dobbiamo arrivarci
    		Context context = this.cordova.getActivity().getApplicationContext();
    		Scanner.InitSCA();
    	}
        
         
        public boolean execute(String action, JSONArray data, CallbackContext callbackContext)
    			throws JSONException{
            Log.d(ME, "execute " + action); 
            if (action.equalsIgnoreCase(READ)) {  
            	Scanner.Read();
            	callbackContext.success(Scanner.ReadSCAAuto());
                Log.v(ME, "stringacodice " + action);
            	return true;
            } 
            return false; 
        } 
         
        public static void sendJavascript( JSONObject data ) { 
            
        } 
}

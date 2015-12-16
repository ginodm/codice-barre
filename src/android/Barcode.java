package com.equipnet.barcode;


import org.json.JSONArray; 
import org.json.JSONException; 
import org.json.JSONObject; 
//importazioni da Cordova 
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;







import org.apache.cordova.PluginResult;

import org.apache.cordova.PluginResult.Status;

//importazioni da Android
import android.content.Context;
import android.hardware.barcode.Scanner;
import android.telephony.TelephonyManager;

import org.apache.cordova.CordovaPlugin;

import android.util.Log; 
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebView;

public class Barcode extends CordovaPlugin { 
             
        public static final String READ = "read"; 
        public static final String ME = "logging"; 
        
//        public boolean onKey(WebView v, int keyCode, KeyEvent event) {
//
//            if(event.getKeyCode() == 211){
//    			Scanner.Read(); 
//            	return true;
//
//    		}
//            return false;
//        }
  

        
        public void initialize(CordovaInterface cordova, CordovaWebView webview) {
    		super.initialize(cordova, webView);
    		//Il plugin non ha accesso diretto al contesto dell'applicazione
    		//e quindi dobbiamo arrivarci
    		Context context = this.cordova.getActivity().getApplicationContext();
    		Scanner.InitSCA();
    	}
        
         
        public boolean execute(String action, JSONArray data, final CallbackContext callbackContext)
    			throws JSONException{
        	  PluginResult result = null;
              if (action.equalsIgnoreCase(READ)) {
                  this.cordova.getActivity().runOnUiThread(new Runnable() {
                      public void run() {
                          callbackContext.success(Scanner.ReadSCAAuto()); 
                      }
                  });
                  result = new PluginResult(Status.OK);
                  
              }
//            Log.d(ME, "execute " + action); 
//            if (action.equalsIgnoreCase(READ)) {  
//            	Scanner.Read();
//            	callbackContext.success(Scanner.ReadSCAAuto());
//                Log.v(ME, "Codice Letto " + action);
//            	return true;
//            } 
//            return false; 
			return false;
        } 
        public static void sendJavascript( JSONObject data ) { 
            
        } 
       

}

package com.equipnet.barscan;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import equipnet.tools.barcode.*;

//import Scan.test.Scan.MainHandler;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
//import android.graphics.AvoidXfermode.Mode;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Barscan extends CordovaPlugin{
	
	public static final String ACTION_GET_BARCODE_SCAN = "getScannedCode";
	public String result; 

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		//Il plugin non ha accesso diretto al contesto dell'applicazione
		//e quindi dobbiamo arrivarci
		Context context = this.cordova.getActivity().getApplicationContext();
		//Inizializzazione dell'oggetto tm
	}
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
			throws JSONException{
		try {
			if(ACTION_GET_BARCODE_SCAN.equals(action)) {
				callbackContext.success();
				Scanner.Read();
				return true;
			}

			//se non abbiamo un match con l'azione
			callbackContext.error("Invalid Action");
			return false;
		} catch (Exception e) {
			//oops abbiamo un problema
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}


	}
	
}

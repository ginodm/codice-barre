package com.equipnet.plugin;


import org.json.JSONArray; 
import org.json.JSONException; 
import org.json.JSONObject; 

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginEntry; 
import org.apache.cordova.PluginManager; 
import org.apache.cordova.PluginResult; 
import org.apache.cordova.PluginResult.Status; 

import android.util.Log; 

public class Barcode extends CordovaPlugin { 
             
        public static final String READ = "read"; 
        public static final String ME = "logging"; 
        public static String callback; 
        public PluginResult result; 

         
        public PluginResult execute(String action, JSONArray data, String callbackId){ 
            Log.d(ME, "execute " + action); 
            if (action.equalsIgnoreCase(READ)) {     
                return new PluginResult(Status.OK,data); 
            } 
            return new PluginResult(Status.NO_RESULT); 
        } 
         
        public static void sendJavascript( JSONObject data ) { 
            Log.v(ME,data.toString()); 
            new PluginResult(PluginResult.Status.OK,data); 
        } 
}

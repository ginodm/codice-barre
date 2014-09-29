package com.equipnet.start;

import org.apache.cordova.*;

import org.json.JSONArray; 
import org.json.JSONException; 
import org.json.JSONObject; 
import android.os.Bundle; 
import android.os.Handler; 
import android.os.Message; 
import android.app.Activity; 
import android.util.Log; 
import android.view.KeyEvent; 
import android.view.WindowManager; 
import android.hardware.barcode.*; 
import com.equipnet.barcode.Barcode; 


public class start extends CordovaActivity { 
	 private Handler mHandler = new MainHandler(); 
	    public static final String ME="start"; 
	     
	    @Override 
	    public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState);     
	        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN); 
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);         
//	        super.setIntegerProperty("splashscreen", R.drawable.ic_splash); 
	        super.loadUrl("file:///android_asset/www/index.html", 10000); 
	        Scanner.Read(); 
	    } 
	    private class MainHandler extends Handler { 
	        @Override           
	        public void handleMessage(Message msg) { 
	            JSONObject json; 
	            switch (msg.what) {    
	                case Scanner.BARCODE_READ: { 
	                    try{ 
	                        json = new JSONObject(); 
	                        json.put("code", msg.obj.toString()); 
	                        Log.v(ME,(String) msg.obj.toString());
	                        System.out.println(msg.obj.toString());
	                        Barcode.sendJavascript( json ); 
	                    }catch( JSONException e){} 
	                break; 
	                } 
	                case Scanner.BARCODE_NOREAD:{    
	                break; 
	                }  
	                default: 
	                break; 
	            }   
	        } 
	    } 
	    protected void onStart() { 
	        Scanner.m_handler=mHandler;   
	        Scanner.InitSCA();   
	        super.onStart();   
	    } 
	    public boolean onKeyDown(int keyCode, KeyEvent event){ 
	        if(event.getRepeatCount()==0){ 
	            if(keyCode==4){   
	                finish();  
	            }else if((keyCode==92)){ 
	                Scanner.Read();  
	            } 
	        } 
	        return true;        
	    } 
	}

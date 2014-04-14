package com.vista.zoonv1;


import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;

public class Splash_Activity extends Activity {
    
	/*---Variable Declare----*/

	private final int SPLASH_DISPLAY_LENGTH = 2000;
	/*-----------------------*/
	
	/*---Create Activity-----*/
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_);
       
        new Handler().postDelayed(new Runnable() {
            public void run() {
	            Intent intent = new Intent(Splash_Activity.this, Login_Activity.class);
	            startActivity(intent);
	            /* Destroy Activity*/
	            finish();
            };
        }, SPLASH_DISPLAY_LENGTH);
        
       
    }
	/*-----------------------*/
}


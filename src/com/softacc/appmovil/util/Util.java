package com.softacc.appmovil.util;

import android.app.Activity;
import android.view.WindowManager;

public class Util {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void screenOnOff(boolean blScreenOn, Activity activity) {
		if (blScreenOn)
			activity.getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		else
			activity.getWindow().clearFlags(
					WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

}

package com.vista.zoonv1;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.Window;
import android.widget.Toast;

public class Mapa_Lista_Tienda_Activity extends FragmentActivity {

	// *-------DECLARE VARIABLE------------
	private GoogleMap mapa = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mapa__lista__tienda_);
		System.gc();
		loadMap();
	}

	// *--METODOS DEL SISTEMA-------------
	private void loadMap() {
		// ----------INITIALITING GOOGLE MAP--------------
		try {
			SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map);
			mapa = mapFrag.getMap();
			// comenzarLocalizacion();
		} catch (Exception e) {
			Toast.makeText(
					Mapa_Lista_Tienda_Activity.this,
					"Error al cargar el mapa, porfavor actualizar Play Service desde el Play Store",
					Toast.LENGTH_SHORT).show();
		}
		// *-----------------------------------------------

	}
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.mapa__lista__tienda_, menu);
	// return true;
	// }

}

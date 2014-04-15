package com.vista.zoonv1;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.softacc.appmovil.adapter.Adapter_Image_Grid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class Menu_Activity extends Activity implements OnItemClickListener {

	GridView gridView;
	public TextView nick;
	// *---VARIABLES DEL SISTEMA

	public static String Texto_cliente = "Cliente";
	public static String Texto_Toma_Pedido = "Toma Pedido";
	public static String Texto_Galeria = "Galeria Producto";
	public static String Texto_Historial = "Historial Pedido";
	public static String Texto_Mapa_Tiendas = "Mapa Tiendas";
	public static String Texto_Ofertas = "Ofertas Diplast";
	public static String Texto_Sincronizar_Envio = "Sincronizar Enviar Pedido";
	public static String Texto_Sincronizar_Recibir = "Sincronizar Recibir Datos";

	static final String[] List = new String[] { Texto_cliente,
			Texto_Toma_Pedido, Texto_Galeria, Texto_Historial,
			Texto_Mapa_Tiendas, Texto_Ofertas, Texto_Sincronizar_Envio,
			Texto_Sincronizar_Recibir };

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_menu_);
		System.gc();
		IU_viewcomponent();

	}

	public void IU_viewcomponent() {
		// gridView
		gridView = (GridView) findViewById(R.id.gridView1);

		gridView.setAdapter(new Adapter_Image_Grid(this, List));

		gridView.setOnItemClickListener(this);

		nick = (TextView) findViewById(R.id.tvdetalle);
		nick.setText("Admin");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// Envio_Singleton.getInstance().LoginBackPress(getApplicationContext(),
		// Envio_Singleton.LOGINBACKPRESS);
	}

	// *-------------------BACK BUTTON------------------------
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(
					Menu_Activity.this);

			// Setting Dialog Title
			alertDialog.setTitle("Confirma Salir...");

			// Setting Dialog Message
			alertDialog.setMessage("Desea salir de la aplicación?");

			// Setting Positive "Yes" Button
			alertDialog.setPositiveButton("SI",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							finish();

						}
					});

			// Setting Negative "NO" Button
			alertDialog.setNegativeButton("NO",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});

			// Showing Alert Message
			alertDialog.show();
		}
		return super.onKeyDown(keyCode, event);
	}

	// *---EVENTOS DEL SISTEMA
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		Intent i = null;
		if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_cliente)) {

			i = new Intent(getApplicationContext(),
					Gestionar_Cliente_Activity.class);
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Toma_Pedido)) {
			i = new Intent(getApplicationContext(), Toma_Pedido_Activity.class);
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Galeria)) {
			i = new Intent(getApplicationContext(), Galeria_Activity.class);
			Toast.makeText(
					getApplicationContext(),
					"Espere mientras se Acutaliza.  id " + id + "  " + position,
					Toast.LENGTH_SHORT).show();
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Historial)) {
			// i = new Intent(getApplicationContext(),
			// GoogleMapsActivity.class);
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Mapa_Tiendas)) {
			i = new Intent(getApplicationContext(),
					Mapa_Lista_Tienda_Activity.class);
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Ofertas)) {
			// i = new
			// Intent(getApplicationContext(),
			// RegisterActivity.class);
		} else if ((((TextView) v.findViewById(R.id.grid_item_label)).getText())
				.equals(Texto_Sincronizar_Envio)) {

		} else {

		}
		if (i != null) {
			startActivity(i);
		}

	}

}

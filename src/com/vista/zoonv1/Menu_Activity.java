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

public class Menu_Activity extends Activity {

	GridView gridView;
	public Intent i;
	public TextView nick;
	// public NCliente cliente;
	// NUsuario usuario;
	//prueba

	static final String[] List = new String[] { "Cliente", "Toma Pedido",
			"Sincronizar Envio", "Mapa", "Compra", "GoogleCloud",
			"Historial de Pedidos" };

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

		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				// Toast.makeText(getApplicationContext(),((TextView)
				// v.findViewById(R.id.grid_item_label)).getText(),
				// Toast.LENGTH_SHORT).show();
				// Intent i;

				if ((((TextView) v.findViewById(R.id.grid_item_label))
						.getText()).equals("Cliente")) {

					// i = new Intent(getApplicationContext(),
					// GestionarClienteActivity.class);
				} else {
					if ((((TextView) v.findViewById(R.id.grid_item_label))
							.getText()).equals("Toma Pedido")) {
						// i = new Intent(getApplicationContext(),
						// ListaGrupo.class);
					} else {
						if ((((TextView) v.findViewById(R.id.grid_item_label))
								.getText()).equals("Actualizar")) {
							// i = new Intent(getApplicationContext(),
							// UpdateActivity.class);
							Toast.makeText(
									getApplicationContext(),
									"Espere mientras se Acutaliza.  id " + id
											+ "  " + position,
									Toast.LENGTH_SHORT).show();
						} else {
							if ((((TextView) v
									.findViewById(R.id.grid_item_label))
									.getText()).equals("Mapa")) {
								// i = new Intent(getApplicationContext(),
								// GoogleMapsActivity.class);
							} else {
								if ((((TextView) v
										.findViewById(R.id.grid_item_label))
										.getText()).equals("Compra")) {
									// i = new Intent(getApplicationContext(),
									// CompraUser_Activity.class);
								} else {
									// i = new Intent(getApplicationContext(),
									// RegisterActivity.class);
									if ((((TextView) v
											.findViewById(R.id.grid_item_label))
											.getText()).equals("GoogleCloud")) {
										// i = new
										// Intent(getApplicationContext(),
										// RegisterActivity.class);
									} else {
										// i = new
										// Intent(getApplicationContext(),
										// HistorialActivity.class);
									}
								}
							}
						}
					}
				}
				startActivity(i);
			}
		});
		// texview
		nick = (TextView) findViewById(R.id.tvdetalle);
		// String nombre = Pedido_Singleton.getInstance().getNombrepromotor();
		nick.setText("hola");

	}

	// private ArrayList<Cliente> GetSearchResults() {
	// cliente = new NCliente();
	// return cliente.getTodo(getApplicationContext());
	// }

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

}

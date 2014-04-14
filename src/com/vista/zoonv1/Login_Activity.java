package com.vista.zoonv1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.softacc.appmovil.util.Util;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;

@SuppressLint("NewApi")
public class Login_Activity extends Activity implements OnClickListener {

	// *------DECLARE VARIABLE-----------------
	private Button btn_iniciar_sesion;

	private EditText et_id_usuario;
	private EditText et_contrasena;

	private TextView tv_guardar;

	private int mYear;
	private int mMonth;
	private int mDay;
	private TelephonyManager mngr;

	// *----------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_);

		System.gc();

		loadComponent();
	}

	// *----------------------------------------

	// ***********ON CLICK********************************
	@Override
	public void onClick(View v) {

		if (v.equals(btn_iniciar_sesion)) {

			// WebServiceTask.postExecute();

			if (!et_id_usuario.getText().toString().isEmpty()
					&& !et_contrasena.getText().toString().isEmpty()) {
				mngr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
				new TheTask().execute();
			} else {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Login_Activity.this);
				builder.setMessage("LLenar porfavor los campos vacios.")
						.setTitle("Advertencia")
						.setCancelable(false)
						.setNeutralButton("Aceptar",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});
				AlertDialog alert = builder.create();
				alert.show();
			}
		}

	}

	// ******************************************************

	// ********************LOAD ALL COMPONENT****************
	private void loadComponent() {
		// **************FIND_VIEW_BY_ID*********************
		btn_iniciar_sesion = (Button) findViewById(R.id.btn_iniciar_sesion);

		et_id_usuario = (EditText) findViewById(R.id.et_id_usuario);
		et_contrasena = (EditText) findViewById(R.id.et_contrasena);

		tv_guardar = (TextView) findViewById(R.id.tv_guardar);

		Typeface tf = Typeface.createFromAsset(getAssets(), "helvetica.ttf");
		et_id_usuario.setTypeface(tf);
		et_contrasena.setTypeface(tf);
		tv_guardar.setTypeface(tf);
		btn_iniciar_sesion.setTypeface(tf);

		// ***************************************************
		// **************BUTTON INICIAR SESION LISTENER*******
		btn_iniciar_sesion.setOnClickListener(this);
		// ***************************************************
	}

	// *******************************************************

	// *-------------------BACK BUTTON------------------------
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(
					Login_Activity.this);

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

	// *-------------------------------------------------------

	// *******************************************************************************

	// *******************************************************************
	private class TheTask extends AsyncTask<String, Void, String> {

		public ProgressDialog progressDialog = new ProgressDialog(
				Login_Activity.this);

		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Verificando usuario...");
			progressDialog.show();
			progressDialog.setCancelable(false);
			Util.screenOnOff(true,Login_Activity.this);
		}

		@Override
		protected String doInBackground(String... arg0) {

			// return
			// String.valueOf(restService.LoginUser(MD5(et_id_usuario.getText().toString()),
			// MD5(et_contrasena.getText().toString()),
			// MD5(mngr.getDeviceId())));
			return "true";
		}

		@Override
		protected void onPostExecute(String result) {
			if (result.equalsIgnoreCase("true")) {
				// *----INTENT CREATE-----------------------------
//				TBL_ACCESO = new tbl_acceso();
//
//				BD = new SQLiteHelper(Login_Activity.this);
//				BD.open();
//				ArrayList<tbl_acceso> tabla_acceso = new ArrayList<tbl_acceso>();
//				tabla_acceso = BD.getAllTblAcceso();
//				if (tabla_acceso.size() == 0) {
//					TBL_ACCESO.setiIdAcceso(1);
//				} else {
//					TBL_ACCESO.setiIdAcceso((tabla_acceso.get(tabla_acceso
//							.size() - 1).getiIdAcceso()) + 1);
//				}
				// get the current date
				Calendar c = Calendar.getInstance();
				mYear = c.get(Calendar.YEAR);
				mMonth = c.get(Calendar.MONTH);
				mDay = c.get(Calendar.DAY_OF_MONTH);

//				TBL_ACCESO.setsUsuario(et_id_usuario.getText().toString());
//				TBL_ACCESO.setsIMEI(MD5(mngr.getDeviceId()));
//				TBL_ACCESO.setdFechaInicio(mDay + "/" + mMonth + "/" + mYear);
//				BD.insertTblAcceso(TBL_ACCESO);

				Intent intent_menu_activity = new Intent(Login_Activity.this,
						Menu_Activity.class);
//				intent_menu_activity.putExtra("TBL_ACCESO", TBL_ACCESO);
//				intent_menu_activity.putExtra("TBL_USUARIO", TBL_USUARIO);
				progressDialog.dismiss();
				startActivity(intent_menu_activity);
				// *----------------------------------------------

				finish();

			} else {
				progressDialog.dismiss();
				AlertDialog.Builder builder = new AlertDialog.Builder(
						Login_Activity.this);
				builder.setMessage("Usuario o Contraseña incorrecto.")
						.setTitle("Advertencia")
						.setCancelable(false)
						.setNeutralButton("Aceptar",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});
				AlertDialog alert = builder.create();
				alert.show();
			}
		}

	}

}

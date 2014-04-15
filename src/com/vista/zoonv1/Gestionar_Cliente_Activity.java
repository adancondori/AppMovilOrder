package com.vista.zoonv1;

import java.util.ArrayList;
import java.util.Calendar;

import com.softacc.appmovil.iucamara.Camara_Activity;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Gestionar_Cliente_Activity extends Activity implements
		OnClickListener {

	private ImageView foto;
	private ImageView img_camara;
	private ImageView img_galeria;
	private ImageView img_denied;
	private TextView sexo;
	private TextView fechanac;

	// *----------------VARIALES DEL SISTEMA---------------- 
	static final int DATE_DIALOG_ID = 999;
	private int year;
	private int month;
	private int day;

	// *---VARIALBES ESTATICAS DEL SISTEMA
	public static final int HEIGHT_FOTO = 100;
	public static final int WIDHT_FOTO = 100;
	public static final int IMG_CAMARA = 0;
	public static final int IMG_GALERIA_FROM_FILE = 1;
	public static final int IMG_DENIED = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_gestionar__cliente_);
		IU_view_inicializar();
	}

	private void IU_view_inicializar() {
		// TODO Auto-generated method stub
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		foto = (ImageView) findViewById(R.id.foto);

		img_camara = (ImageView) findViewById(R.id.camara);
		img_camara.setOnClickListener(this);

		img_galeria = (ImageView) findViewById(R.id.galeria);
		img_galeria.setOnClickListener(this);

		img_denied = (ImageView) findViewById(R.id.noimagen);
		img_denied.setOnClickListener(this);

		sexo = (TextView) findViewById(R.id.sexo);
		sexo.setOnClickListener(this);

		fechanac = (TextView) findViewById(R.id.fechanac);
		fechanac.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.camara:
			selecttipofoto(IMG_CAMARA);
			break;
		case R.id.galeria:
			selecttipofoto(IMG_GALERIA_FROM_FILE);
			break;
		case R.id.noimagen:
			selecttipofoto(IMG_DENIED);
			break;
		case R.id.sexo:
			selectionsexo();
			break;
		case R.id.fechanac:
			showDialog(DATE_DIALOG_ID);
			break;

		default:
			break;
		}
	}

	public void selecttipofoto(int tipo) {
		Intent intent = null;
		Bundle b = null;
		switch (tipo) {
		case IMG_CAMARA:
			intent = new Intent(Gestionar_Cliente_Activity.this,
					Camara_Activity.class);
			b = new Bundle();
			b.putInt("modo", Camara_Activity.PICK_FROM_CAMERA);
			intent.putExtras(b);
			startActivityForResult(intent, Camara_Activity.PICK_FROM_CAMERA);
			break;
		case IMG_GALERIA_FROM_FILE:
			intent = new Intent(Gestionar_Cliente_Activity.this,
					Camara_Activity.class);
			b = new Bundle();
			b.putInt("modo", Camara_Activity.PICK_FROM_FILE);
			intent.putExtras(b);
			startActivityForResult(intent, Camara_Activity.PICK_FROM_FILE);
			break;
		case IMG_DENIED:
			foto.setImageResource(R.drawable.p_profle);
			break;
		}
	}

	public void selectionsexo() {
		ListView modeList = new ListView(this);
		ArrayList<String> list = new ArrayList<String>();
		list.add("-");
		list.add("Hombre");
		list.add("Mujer");

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// builder.setTitle("Definir Foto de Perfil");

		// ListView modeList = new ListView(context);
		modeList.setBackgroundColor(Color.WHITE);
		ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, list);

		modeList.setAdapter(modeAdapter);

		builder.setView(modeList);
		final Dialog dialog = builder.create();
		dialog.setTitle("Sexo (Género)");
		modeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// if (position != 0) {
				switch (position) {
				case 0:
					sexo.setText("-");
					break;
				case 1:
					sexo.setText("Hombre");
					break;
				case 2:
					sexo.setText("Mujer");
					break;
				}

				dialog.dismiss();
				// }
			}
		});
		dialog.show();
	}

	// ------Show Dialog Pincker------------------------------------

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date

			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog);
		dialog.setTitle("Fecha de Nacimiento");
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			System.out.println(day + "/" + month + 1 + "/" + year);
			fechanac.setText(new StringBuilder().append(day).append("/")
					.append(month + 1).append("/").append(year).append(" "));

			// set selected date into datepicker also
			// dpResult.init(year, month, day, null);

		}
	};

}

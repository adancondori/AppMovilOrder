package com.softacc.appmovil.adapter;

import com.vista.zoonv1.Menu_Activity;
import com.vista.zoonv1.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_Image_Grid extends BaseAdapter {
	private Context context;
	private final String[] mobileValues;

	public Adapter_Image_Grid(Context context, String[] mobileValues) {
		this.context = context;
		this.mobileValues = mobileValues;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.adapter_menu, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(mobileValues[position]);
			textView.setTextColor(Color.WHITE);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String mobile = mobileValues[position];

			if (mobile.equals(Menu_Activity.Texto_cliente)) {
				gridView.setBackgroundResource(R.color.color_celeste_claro);
				imageView.setImageResource(R.drawable.cliente);
			} else if (mobile.equals(Menu_Activity.Texto_Toma_Pedido)) {
				gridView.setBackgroundResource(R.color.color_verde_lechuga);
				imageView.setImageResource(R.drawable.bolsapedido);
			} else if (mobile.equals(Menu_Activity.Texto_Galeria)) {
				gridView.setBackgroundResource(R.color.color_naranja);
				imageView.setImageResource(R.drawable.actualizar);
			} else if (mobile.equals(Menu_Activity.Texto_Historial)) {
				gridView.setBackgroundResource(R.color.color_amarillo);
				imageView.setImageResource(R.drawable.map);
			} else if (mobile.equals(Menu_Activity.Texto_Mapa_Tiendas)) {
				gridView.setBackgroundResource(R.color.color_lila);
				imageView.setImageResource(R.drawable.carrito);
			} else if (mobile.equals(Menu_Activity.Texto_Ofertas)) {
				gridView.setBackgroundResource(R.color.color_rojo_claro);
				imageView.setImageResource(R.drawable.ic_launcher);
			} else if (mobile.equals(Menu_Activity.Texto_Sincronizar_Envio)) {
				gridView.setBackgroundResource(R.color.color_azul);
				imageView.setImageResource(R.drawable.detalle);
			} else {
				gridView.setBackgroundResource(R.color.color_rojo_fuccia);
				imageView.setImageResource(R.drawable.detalle);
			}
		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return mobileValues.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}

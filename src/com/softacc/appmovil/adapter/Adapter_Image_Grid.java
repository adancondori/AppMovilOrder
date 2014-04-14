package com.softacc.appmovil.adapter;


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

			if (mobile.equals("Cliente")) {
				gridView.setBackgroundColor(Color.rgb(0, 191, 255));
				imageView.setImageResource(R.drawable.cliente);
			} else if (mobile.equals("Toma Pedido")) {
				gridView.setBackgroundColor(Color.rgb(255, 215, 0));
				imageView.setImageResource(R.drawable.tomapedido);
			} else if (mobile.equals("Actualizar")) {
				gridView.setBackgroundColor(Color.rgb(250, 140, 0));
				imageView.setImageResource(R.drawable.actualizar);
			} else if (mobile.equals("Mapa")) {
				gridView.setBackgroundColor(Color.rgb(50, 205, 50));
				imageView.setImageResource(R.drawable.map);
			} else if (mobile.equals("Compra")) {
				gridView.setBackgroundColor(Color.rgb(170, 0, 255));
				imageView.setImageResource(R.drawable.carrito);
			} else if (mobile.equals("GoogleCloud")) {
				gridView.setBackgroundColor(Color.rgb(216, 0, 115));
				imageView.setImageResource(R.drawable.ic_launcher);
			} else {
				gridView.setBackgroundColor(Color.rgb(40, 0, 115));
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

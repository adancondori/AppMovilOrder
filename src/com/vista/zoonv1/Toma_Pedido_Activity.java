package com.vista.zoonv1;

import java.util.ArrayList;

import com.softacc.appmovil.adapter.Adapter_ExpandableList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class Toma_Pedido_Activity extends Activity implements
		OnChildClickListener {
	ExpandableListView expandbleLis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_toma__pedido_);
		expandbleLis = (ExpandableListView) findViewById(R.id.expandableList_toma_pedido);
		expandbleLis.setDividerHeight(2);
		expandbleLis.setGroupIndicator(null);
		expandbleLis.setClickable(true);
		setGroupData();
		setChildGroupData();
		Adapter_ExpandableList adapter_ExpandableList = new Adapter_ExpandableList(
				groupItem, childItem);
		adapter_ExpandableList
				.setInflater(
						(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
						this);
		expandbleLis.setAdapter(adapter_ExpandableList);
		expandbleLis.setOnChildClickListener(this);
	}

	// *---------------METODOS DEL SISTEMA---------------
	public void setGroupData() {
		groupItem.add("TechNology");
		groupItem.add("Mobile");
		groupItem.add("Manufacturer");
		groupItem.add("Extras");
	}

	ArrayList<String> groupItem = new ArrayList<String>();
	ArrayList<Object> childItem = new ArrayList<Object>();

	public void setChildGroupData() {
		/**
		 * Add Data For TecthNology
		 */
		ArrayList<String> child = new ArrayList<String>();
		child.add("Java");
		child.add("Drupal");
		child.add(".Net Framework");
		child.add("PHP");
		childItem.add(child);

		/**
		 * Add Data For Mobile
		 */
		child = new ArrayList<String>();
		child.add("Android");
		child.add("Window Mobile");
		child.add("iPHone");
		child.add("Blackberry");
		childItem.add(child);
		/**
		 * Add Data For Manufacture
		 */
		child = new ArrayList<String>();
		child.add("HTC");
		child.add("Apple");
		child.add("Samsung");
		child.add("Nokia");
		childItem.add(child);
		/**
		 * Add Data For Extras
		 */
		child = new ArrayList<String>();
		child.add("Contact Us");
		child.add("About Us");
		child.add("Location");
		child.add("Root Cause");
		childItem.add(child);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toma__pedido_, menu);
		return true;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(getApplicationContext(), "Clicked On Child",
				Toast.LENGTH_SHORT).show();
		return true;
	}

}

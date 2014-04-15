package com.softacc.appmovil.fragment;

import com.tabs.adancc.desplazarview.TabsActivity;
import com.vista.zoonv1.R;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Galeria_Categoria_Fragment extends Fragment {
	private final Handler handler = new Handler();


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_favorito, null);
		return v;
	}

}

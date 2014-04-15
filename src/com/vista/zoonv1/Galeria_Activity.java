package com.vista.zoonv1;

import com.softacc.appmovil.fragment.Galeria_Categoria_Fragment;

import com.tabs.adancc.desplazarview.TabsActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Window;

public class Galeria_Activity extends FragmentActivity {

	private TabsActivity tabs;
	private ViewPager pager;
	// *----VARIALBLES DEL SISTEMA---------------
	private MyPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_galeria_);

		IU_view_inicializar();
	}

	// *---METODOS DEL SISTEMA----------------
	public void IU_view_inicializar() {
		tabs = (TabsActivity) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
						.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);

		int color = Color.parseColor("#3F9FE0");
		tabs.setIndicatorColor(color);
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Categorias", "Reciente" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				return new Galeria_Categoria_Fragment();
			} else {
				// return CategoriaFragment.newInstance(position);
				return new Galeria_Categoria_Fragment();
			}
		}
	}

}

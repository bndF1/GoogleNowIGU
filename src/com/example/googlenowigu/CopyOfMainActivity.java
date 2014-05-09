package com.example.googlenowigu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.ProgressBar;

public class CopyOfMainActivity extends Activity {

	private List<RowItem> rowItems;
	private ProgressBar pb;
	private DrawerLayout NavDrawerLayout;
    private ListView NavList;
    private String[] titulos;
    private ArrayList<Item_objct> NavItms;
    private TypedArray NavIcons;	
    NavigationAdapter NavAdapter;  
	
	private static Integer[] images = { R.drawable.red,
			R.drawable.aliementos_desintoxicar_cuerpo,
			R.drawable.alimentos_quemagrasa, R.drawable.snacks,
			R.drawable.ind_glu_alim, R.drawable.alimentos_antievejecimiento,
			R.drawable.red, R.drawable.red, R.drawable.red };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		// Get the Drawable custom_progressbar
		Drawable customDrawable = getResources().getDrawable(
				R.drawable.custom_progress_bar);
		// set the drawable as progress drawable
		pb.setProgressDrawable(customDrawable);
		
		//Drawer Layout
		NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//Lista
        NavList = (ListView) findViewById(R.id.listViewMenu);
		
        View header = getLayoutInflater().inflate(R.layout.header, null);
        //Establecemos header
        NavList.addHeaderView(header);
		//Tomamos listado  de imgs desde drawable
        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
		//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
        titulos = getResources().getStringArray(R.array.nav_options);
        //Listado de titulos de barra de navegacion
        NavItms = new ArrayList<Item_objct>();
        //Agregamos objetos Item_objct al array
        //Perfil	      
        NavItms.add(new Item_objct(titulos[0], NavIcons.getResourceId(0, -1)));
        //Favoritos
        NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
        //Eventos
        NavItms.add(new Item_objct(titulos[2], NavIcons.getResourceId(2, -1)));
        //Lugares
        NavItms.add(new Item_objct(titulos[3], NavIcons.getResourceId(3, -1)));
        //Etiquetas
        NavItms.add(new Item_objct(titulos[4], NavIcons.getResourceId(4, -1)));
        //Configuracion
        NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
        //Share
        NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));	      
        //Declaramos y seteamos nuestrp adaptador al cual le pasamos el array con los titulos	       
        NavAdapter= new NavigationAdapter(this,NavItms);
        NavList.setAdapter(NavAdapter);	
        //Siempre vamos a mostrar el mismo titulo
		
		// Intialize and set the Action Bar to Holo Blue
		// ActionBar actionBar = getActionBar();
		// actionBar.setBackgroundDrawable(new
		// ColorDrawable(Color.parseColor("#33b5e5" )));

		ListView lv = (ListView) findViewById(R.id.myList);
		rowItems = new ArrayList<RowItem>();

		String[] titles = { "Semana 8", "Semana 7", "Semana 6", "Semana 5",
				"Semana 4", "Semana 3", "Semana 2", "Semana 1" };
		String[] descriptions = { "First Movie", "Second movie", "Third Movie",
				"Fourth Movie", "Fifth Movie", "Sixth Movie", "Seventh Movie",
				"Eighth Movie" };
		// Populate the List
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], "Algœn texto");
			rowItems.add(item);
		}

		// Set the adapter on the ListView
		LazyAdapter adapter = new LazyAdapter(getApplicationContext(),
				R.layout.list_row, rowItems);
		lv.setAdapter(adapter);

		lv.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

}

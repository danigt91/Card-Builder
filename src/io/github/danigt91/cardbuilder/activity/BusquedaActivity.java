package io.github.danigt91.cardbuilder.activity;

import java.util.ArrayList;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.fragment.BusquedaFragment;
import io.github.danigt91.cardbuilder.fragment.ListaCartasFragment;
import io.github.danigt91.cardbuilder.listener.BusquedaListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class BusquedaActivity extends FragmentActivity implements BusquedaListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda);
		
		BusquedaFragment bsf = (BusquedaFragment) getSupportFragmentManager().findFragmentById(R.id.frgBusquedaSimple);
		bsf.setBusquedaSimpleListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		getMenuInflater().inflate(R.menu.busqueda, menu);
		return true;
	}
	

	@Override
	public void onBusquedaSimple(String nombre) {
		
		busquedaSimple(nombre);
		
	}
	
	private void busquedaSimple(String nombre){
		//Obtiene el Fragmento contenedor del ListView y llama a su método busquedaByNombre para rellenarlo
		ListaCartasFragment lcf = (ListaCartasFragment) getSupportFragmentManager().findFragmentById(R.id.frgListaCartas);
		lcf.busquedaByNombre(nombre);
		//Reposiciona la posicion de scroll del ListView
		lcf.getMyListView().reposicionar();
	}

	@Override
	public void onBusquedaAvanzada(ArrayList<String> criterios) {
		busquedaAvanzada(criterios);		
	}
	
	private void busquedaAvanzada(ArrayList<String> criterios){
		//Obtiene el Fragmento contenedor del ListView y llama a su método busquedaByNombre para rellenarlo
		ListaCartasFragment lcf = (ListaCartasFragment) getSupportFragmentManager().findFragmentById(R.id.frgListaCartas);
		lcf.busquedaByCriteria(criterios);
		//Reposiciona la posicion de scroll del ListView
		lcf.getMyListView().reposicionar();
	}

}

/*
 * Clase: Representa el fragmento que contiene los input de la búsqueda simple
 * 
 * Atributos:
 * EditText etxtBusquedaSimple: input de texto para realizar una búsqueda por el nombre
 * Button btnBusquedaSimple: realiza la búsqueda en la DB con el texto de etxtBusquedaSimple
 * Button btnBusquedaAvanzada: abre un fragment de búsqueda avanzada
 * boolean buscando: indica si se está realizando la búsqueda para volver a realizarla al recrear la vista (giro de pantalla, ...)
 * 
 * */
package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BusquedaSimpleFragment extends Fragment implements OnClickListener {
	
	private EditText etxtBusquedaSimple;
	private Button btnBusquedaSimple;
	
	private boolean buscando;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		buscando = false;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_busqueda_simple, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		setRetainInstance(true);
		
		etxtBusquedaSimple = (EditText) getActivity().findViewById(R.id.etxtBusquedaSimple);
		
		btnBusquedaSimple = (Button) getActivity().findViewById(R.id.btnBusquedaSimple);
		btnBusquedaSimple.setOnClickListener(this);		
		
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		if(buscando && etxtBusquedaSimple.getText().length()>0){
			busquedaSimple();
		}		
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnBusquedaSimple:
			
			busquedaSimple();
			
			break;

		default:
			break;
		}
		
	}
	
	
	private void busquedaSimple(){
		//Obtiene el Fragmento contenedor del ListView y llama a su método busquedaByNombre para rellenarlo
		ListaCartasFragment lcf = (ListaCartasFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.frgListaCartas);
		lcf.busquedaByNombre(etxtBusquedaSimple.getText().toString());
		buscando = true;
	}

}

/*
 * Clase: Representa el fragmento que contiene los input de la búsqueda simple
 * 
 * Atributos:
 * EditText etxtBusquedaSimple: input de texto para realizar una búsqueda por el nombre
 * Button btnBusquedaSimple: realiza la búsqueda en la DB con el texto de etxtBusquedaSimple
 * Button btnBusquedaAvanzada: abre un fragment de búsqueda avanzada
 * boolean buscando: indica si se está realizando la búsqueda para volver a realizarla al recrear la vista (giro de pantalla, ...)
 * BusquedaSimpleListener bSListener: Listener para delegar la implementación de los métodos de búsqueda
 * 
 * */
package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.BusquedaAvanzadaActivity;
import io.github.danigt91.cardbuilder.listener.BusquedaSimpleListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class BusquedaSimpleFragment extends Fragment implements OnClickListener {

	private EditText etxtBusquedaSimple;
	private Button btnBusquedaSimple, btnBusquedaAvanzada;

	private boolean buscando;

	private BusquedaSimpleListener bSListener;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		buscando = false;
		bSListener = new BusquedaSimpleListener() {

			// Usamos una implementacion por defecto para el listener
			@Override
			public void onBusquedaSimple(String nombre) {
				Log.d("BusquedaSimpleFragment", "onBusquedaSimple");
			}

		};
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
		
		btnBusquedaAvanzada = (Button) getActivity().findViewById(R.id.btnBusquedaAvanzada);
		btnBusquedaAvanzada.setOnClickListener(this);

	}


	@Override
	public void onResume(){
		super.onResume();
		if(buscando && etxtBusquedaSimple.getText().length()>0){
			bSListener.onBusquedaSimple(etxtBusquedaSimple.getText().toString());
		}		
	}


	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnBusquedaSimple:
			
			//Reseteamos el scroll del listview para nuevas busquedas
			Fragment aux = getActivity().getSupportFragmentManager().findFragmentById(R.id.frgListaCartas);
			if(aux != null && aux instanceof ListaCartasFragment){
				ListaCartasFragment lcf = ((ListaCartasFragment) aux);
				lcf.setIndex(-1);
				lcf.setTop(-1);
				lcf.getMyListView().setIndexPosition(-1);
				lcf.getMyListView().setTopPosition(-1);
			}

			bSListener.onBusquedaSimple(etxtBusquedaSimple.getText().toString());
			buscando = true;
			
			//Escondemos el teclado
			InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
					Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etxtBusquedaSimple.getWindowToken(), 0);

			break;
			
		case R.id.btnBusquedaAvanzada:
			
			startActivity(new Intent(getActivity(), BusquedaAvanzadaActivity.class));
			
			break;

		default:
			break;
		}

	}	

	public void setBusquedaSimpleListener(BusquedaSimpleListener bsl){
		this.bSListener = bsl;
	}

}

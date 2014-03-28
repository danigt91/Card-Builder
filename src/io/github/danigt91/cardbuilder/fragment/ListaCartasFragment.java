package io.github.danigt91.cardbuilder.fragment;

import java.util.Map;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.adapter.CartasAdapter;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListaCartasFragment extends Fragment {
	
	private ListView listCartas;
	
	private SQLiteAdapter mDbHelper;
	private Cursor cursor;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_lista_cartas, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setRetainInstance(true);
		
		listCartas = (ListView) getActivity().findViewById(R.id.listCartas);
		
		Bundle extras = getActivity().getIntent().getExtras();
		if(extras != null){
			// TODO
		}
		
	}
	
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		if(mDbHelper != null && cursor!=null){
			cursor.close();
			mDbHelper.close();
		}
	}
	
	
	
	public void busquedaByNombre(String nombre){
		
		mDbHelper = new SQLiteAdapter(getActivity());            
		mDbHelper.open();

		cursor = mDbHelper.getListadoCartasPorNname(nombre);
		CartasAdapter ca = new CartasAdapter(getActivity(), cursor, 0);
		
		listCartas.setAdapter(ca);
		
	}
	
	
	public void busquedaByCriteria(Map<String, Object> criterios){
		
	}
	
	

}

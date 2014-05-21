package io.github.danigt91.cardbuilder.fragment;

import java.util.Map;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.CartaDetalleActivity;
import io.github.danigt91.cardbuilder.adapter.ListaCartasAdapter;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListaCartasFragment extends Fragment implements OnItemClickListener {
	
	private ListView listCartas;
	
	private SQLiteAdapter mDbHelper;
	private Cursor cursor;
	public int index, top;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		index = -1;
		top = -1;
	}
	
	
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
		listCartas.setOnItemClickListener(this);		
		
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
		ListaCartasAdapter ca = new ListaCartasAdapter(getActivity(), cursor, 0);
		
		listCartas.setAdapter(ca);
		
	}
	
	
	public void busquedaByCriteria(Map<String, Object> criterios){
		// TODO
	}


	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		
		index = listCartas.getFirstVisiblePosition();
		View v = listCartas.getChildAt(0);
		top = (v == null) ? 0 : v.getTop();
		Intent intent = new Intent(getActivity(), CartaDetalleActivity.class);
		intent.putExtra("idCarta", (int) id);
		startActivity(intent);
		
	}
	
	
	public void reposicionar(){
		if(index != -1 && top != -1){
			listCartas.setSelectionFromTop(index, top);
		}
	}
	
	

}

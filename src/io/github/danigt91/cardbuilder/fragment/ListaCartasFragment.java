package io.github.danigt91.cardbuilder.fragment;

import java.util.Map;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.CartaDetalleActivity;
import io.github.danigt91.cardbuilder.adapter.ListaCartasAdapter;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import io.github.danigt91.cardbuilder.view.MyListView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListaCartasFragment extends Fragment implements OnItemClickListener {

	private MyListView listCartas;

	private SQLiteAdapter mDbHelper;
	private Cursor cursor;

	private int index, top;

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

		listCartas = (MyListView) getActivity().findViewById(R.id.listCartas);
		listCartas.setOnItemClickListener(this);

		if(index != -1 && top != -1 && index != listCartas.getIndexPosition() && top != listCartas.getTopPosition()){
			listCartas.setIndexPosition(index);
			listCartas.setTopPosition(top);
		}		

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
		ListaCartasAdapter ca = new ListaCartasAdapter(getActivity(), cursor, 0, listCartas);

		listCartas.setAdapter(ca);

		if(cursor.getCount()==0){
			Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.busqueda_sin_resultados), Toast.LENGTH_LONG).show();
		}

	}


	public void busquedaByCriteria(Map<String, Object> criterios){
		// TODO
	}
	
	
	public void busquedaById(int id){
		busquedaByIds(String.valueOf(id));
	}
	
	public void busquedaByIds(String... ids){
		
		mDbHelper = new SQLiteAdapter(getActivity());            
		mDbHelper.open();

		cursor = mDbHelper.getListadoCartasPorId(ids);
		ListaCartasAdapter ca = new ListaCartasAdapter(getActivity(), cursor, 0, listCartas);

		listCartas.setAdapter(ca);

		if(cursor.getCount()==0){
			Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.busqueda_sin_resultados), Toast.LENGTH_LONG).show();
		}
		
	}


	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		actualizarDatosScroll(listCartas);
		Intent intent = new Intent(getActivity(), CartaDetalleActivity.class);
		intent.putExtra("idCarta", (int) id);
		startActivity(intent);
	}

	@Override
	public void onPause(){
		super.onPause();
		actualizarDatosScroll(listCartas);
	}


	public MyListView getMyListView(){
		return listCartas;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public int getTop() {
		return top;
	}


	public void setTop(int top) {
		this.top = top;
	}

	private void actualizarDatosScroll(AbsListView view){
		index = view.getFirstVisiblePosition();
		View v = view.getChildAt(0);
		top = (v == null) ? 0 : v.getTop();
		listCartas.setIndexPosition(index);
		listCartas.setTopPosition(top);
	}



}

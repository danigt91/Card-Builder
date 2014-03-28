package io.github.danigt91.cardbuilder.adapter;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.database.Contrato;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CartasAdapter extends CursorAdapter {
	
	private LayoutInflater mInflater;
	
	public CartasAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView nombreCarta = (TextView) view.findViewById(R.id.txtNombreCartaItem);
		nombreCarta.setText(cursor.getString(cursor.getColumnIndex(Contrato.ListadoCartas.CARD_NAME)));
		
		TextView setCarta = (TextView) view.findViewById(R.id.txtSetCartaItem);
		setCarta.setText(cursor.getString(cursor.getColumnIndex(Contrato.ListadoCartas.SET_NAME)));
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mInflater.inflate(R.layout.row_card, parent, false);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		return super.getView(position, convertView, parent);
	}

	

}

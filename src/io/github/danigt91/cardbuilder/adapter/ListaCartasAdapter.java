/*
 * Clase: representa el adaptador del listado de Cartas usando un Cursor
 * 
 * Atributos:
 * LayoutInflater mInflater: se encarga de inflar los layout de fila
 * 
 * */

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

public class ListaCartasAdapter extends CursorAdapter {
	
	private LayoutInflater mInflater;
	
	public ListaCartasAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {		
		// Usa un ViewHolder para rellenar las vistas
		ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.nombreCarta = (TextView) view.findViewById(R.id.txtNombreCartaItem);
            holder.setCarta = (TextView) view.findViewById(R.id.txtSetCartaItem);
            view.setTag(holder);
        }        
        holder.nombreCarta.setText(cursor.getString(cursor.getColumnIndex(Contrato.ListadoCartas.CARD_NAME)));
        holder.setCarta.setText(cursor.getString(cursor.getColumnIndex(Contrato.ListadoCartas.SET_NAME)));		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mInflater.inflate(R.layout.row_card, parent, false);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    if (!super.mDataValid) {
	        throw new IllegalStateException("Solo debería ser llamado cuando el cursor es valido");
	    }
	    if (!super.mCursor.moveToPosition(position)) {
	        throw new IllegalStateException("No se puede mover el cursor a la posicion: " + position);
	    }
	    // Intenta reciclar la vista, si no crea una nueva
	    View v;
	    if (convertView == null) {
	        v = newView(mContext, mCursor, parent);
	    } else {
	        v = convertView;
	    }
	    bindView(v, mContext, mCursor);
	    return v;
	}
	
	
	// Referencia de los componentes de cada vista
	private class ViewHolder{
		
		private TextView nombreCarta;
		private TextView setCarta;
		
	}

	

}

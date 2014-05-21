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
import io.github.danigt91.cardbuilder.listener.MyListViewListener;
import io.github.danigt91.cardbuilder.view.MyListView;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;

public class ListaCartasAdapter extends CursorAdapter {
	
	private LayoutInflater mInflater;
	private Context context;
	private int flags;
	private int lastPosition, index, top;
	private ListView listView;
	
	public ListaCartasAdapter(Context context, Cursor c, int flags, ListView lv) {
		super(context, c, flags);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		this.flags = flags;
		this.listView = lv;
		if(listView instanceof MyListView){
			((MyListView) listView).setMyListViewListener(new MyListViewListener() {
				
				@Override
				public void onReposicionar(ListView lv, int index, int top) {
					ListaCartasAdapter.this.index = index;
					ListaCartasAdapter.this.top = top;
				}
			});
		}
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
	    
	    boolean bAnimacion = flags == 0 && index != listView.getFirstVisiblePosition() && top != ((listView.getChildAt(0) == null) ? 0 : listView.getChildAt(0).getTop());
	    if(bAnimacion && position > lastPosition) {
	        Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_left_in);
	        v.startAnimation(animation);
        }else if(bAnimacion && position < lastPosition){
        	Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_right_in);
	        v.startAnimation(animation);
        }
	    lastPosition = position;
	    
	    return v;
	}
	
	
	// Referencia de los componentes de cada vista
	private class ViewHolder{
		
		private TextView nombreCarta;
		private TextView setCarta;
		
	}

	

}

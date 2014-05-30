package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.controller.CartaManejador;
import io.github.danigt91.cardbuilder.listener.FavoritoListener;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyHttpPostFavorito extends MyHttpPost {

	private Context context;
	private View view;
	
	private String accion;
	
	private FavoritoListener favoritoListener;

	public MyHttpPostFavorito(Context context, View view){
		this.context = context;
		this.view = view;
		favoritoListener = new FavoritoListener() {
			
			@Override
			public void onPeticionFinalizada(Context context, View view, boolean favorito) {
				Log.d("MyHttpPostFavorito", "Es favorito: "+favorito);				
			}
		};
	}

	@Override
	protected void onPreExecute(){
		super.onPreExecute();
		
	}

	@Override
	protected Void doInBackground(MyHttpPostObject... params) {
		super.doInBackground(params);
		
		if(super.result == null){
			Toast.makeText(context, context.getResources().getString(R.string.sin_conexion), Toast.LENGTH_SHORT).show();
			cancel(true);
			isCancelled();
		}
		
		accion = params[0].accion;
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
		
		favoritoListener.onPeticionFinalizada(context, view, super.result.equals("1"));
		if(accion.equals(CartaManejador.toggleFavoritaAction)){
			if(super.result.equals("1")){
				Toast.makeText(context, context.getResources().getString(R.string.favorito_anadida), Toast.LENGTH_SHORT).show();
			}else if(super.result.equals("-1")){
				Toast.makeText(context, context.getResources().getString(R.string.favorito_eliminada), Toast.LENGTH_SHORT).show();
			}
		}
		
	}
	
	public void setFavoritoListener(FavoritoListener favoritoListener){
		this.favoritoListener = favoritoListener;
	}

}

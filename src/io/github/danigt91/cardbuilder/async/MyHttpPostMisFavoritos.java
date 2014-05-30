package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.listener.MisFavoritosListener;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MyHttpPostMisFavoritos extends MyHttpPost {
	
	private Context context;
	
	private MisFavoritosListener misFavoritosListener;

	public MyHttpPostMisFavoritos(Context context){
		this.context = context;
		misFavoritosListener = new MisFavoritosListener() {
			
			@Override
			public void onPeticionFinalizada(Context context, String favoritos) {
				Log.d("MyHttpPostMisFavoritos", "Favoritos: "+favoritos);				
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
		
		if(isCancelled()){
			Toast.makeText(context, context.getResources().getString(R.string.sin_conexion), Toast.LENGTH_SHORT).show();
		}
		
		if(super.result == null){
			Toast.makeText(context, context.getResources().getString(R.string.sin_conexion), Toast.LENGTH_SHORT).show();
			cancel(true);
			isCancelled();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
		
		misFavoritosListener.onPeticionFinalizada(context, (!super.result.equals("-1"))?super.result:"");
		
	}
	
	public void setFavoritoListener(MisFavoritosListener misFavoritosListener){
		this.misFavoritosListener = misFavoritosListener;
	}

}

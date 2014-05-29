package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.listener.MisFavoritosListener;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

public class MyHttpPostMisFavoritos extends MyHttpPost {
	
	private Context context;

	private ProgressDialog pd;
	
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

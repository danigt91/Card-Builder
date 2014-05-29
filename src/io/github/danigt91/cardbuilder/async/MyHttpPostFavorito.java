package io.github.danigt91.cardbuilder.async;

import android.app.ProgressDialog;
import android.content.Context;

public class MyHttpPostFavorito extends MyHttpPost {

	private Context context;
	private long idUsuario, idCarta;

	private ProgressDialog pd;

	public MyHttpPostFavorito(Context context, long idUsuario, long idCarta){
		this.context = context;
		this.idUsuario = idUsuario;
		this.idCarta = idCarta;
	}

	@Override
	protected void onPreExecute(){
		super.onPreExecute();

	}

	@Override
	protected Void doInBackground(MyHttpPostObject... params) {
		super.doInBackground(params);
		String resultado = super.result;
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
		
	}

}

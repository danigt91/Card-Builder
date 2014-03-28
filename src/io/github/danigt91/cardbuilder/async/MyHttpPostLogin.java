package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.InicioActivity;
import io.github.danigt91.cardbuilder.clase.SesionManejador;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class MyHttpPostLogin extends MyHttpPost {
	
	private Context context;
	private String login, pass;
	private boolean bLogin, recordar;
	
	private ProgressDialog pd;

	public MyHttpPostLogin(Context context, String login, String pass, boolean recordar){
		this.context = context;
		this.login = login;
		this.pass = pass;
		this.recordar = recordar;
	}
	
	
	@Override
	protected void onPreExecute(){
		super.onPreExecute();
		
		//Antes de comprobar el login, activamos el dialogo de progreso
		pd = ProgressDialog.show(context, "Iniciando Sesión", "Espere unos segundos...", true, false);		
		
	}
	

	@Override
	protected Void doInBackground(MyHttpPostObject... params) {

		super.doInBackground(params);
		String resultado = super.result;		

		bLogin = resultado.equals("1");
		Log.d("MyHttpPostLogin", "Resultado login: "+bLogin);

		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(context);
		Editor spe = sp.edit();

		spe.putBoolean("identificado", bLogin);
		spe.putBoolean("recordar", recordar && bLogin);		
		if(bLogin){
			spe.putString("login", login);
			spe.putString("pass", pass);
		}else{
			spe.putString("login", null);
			spe.putString("pass", null);
		}

		spe.commit();

		return null;
	}

	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
		
		if(pd!=null){
			//Quitamos el dialogo de progreso
			pd.dismiss();
		}
		
		//Si el contexto pasado es instancia de InicioAtivity
		if(context instanceof InicioActivity){
			//Si sesion iniciada y FrameLayout existe
			InicioActivity ia = ((InicioActivity) context);
			if (bLogin && ia.findViewById(R.id.frgLInicioSesion) != null) {
				
				//Remplazamos el fragment de inicioSesion
				ia.recreateSesionIniciada();

			}
		}

	}

}

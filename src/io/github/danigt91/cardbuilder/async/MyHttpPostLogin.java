package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.InicioActivity;
import io.github.danigt91.cardbuilder.controller.SesionManejador;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.Toast;

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

		//Comprobamos si el login es correcto
		bLogin = resultado.equals("1");
		Log.d("MyHttpPostLogin", "Resultado login: "+resultado);

		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(context);
		Editor spe = sp.edit();

		spe.putBoolean(SesionManejador.identificado, bLogin);
		spe.putBoolean(SesionManejador.recordar, recordar && bLogin);		
		if(bLogin){
			spe.putString(SesionManejador.login, login);
			spe.putString(SesionManejador.pass, pass);
		}else{
			spe.putString(SesionManejador.login, null);
			spe.putString(SesionManejador.pass, null);
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

			}else{
				//Avisamos si da error
				if(super.result.equals("-1")){
					Toast.makeText(context, "Error de login", Toast.LENGTH_SHORT).show();
				}else if(super.result.equals("-2")){
					Toast.makeText(context, "Error de registro", Toast.LENGTH_SHORT).show();
				}
			}
		}

	}

}

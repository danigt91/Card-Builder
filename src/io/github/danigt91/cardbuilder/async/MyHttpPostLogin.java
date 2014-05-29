package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.InicioActivity;
import io.github.danigt91.cardbuilder.controller.SesionManejador;
import io.github.danigt91.cardbuilder.listener.LoginListener;
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
	
	private LoginListener loginListener;

	public MyHttpPostLogin(Context context, String login, String pass, boolean recordar){
		this.context = context;
		this.login = login;
		this.pass = pass;
		this.recordar = recordar;
		loginListener = new LoginListener() {
			
			@Override
			public void onPeticionFinalizada(Context context, boolean exito,
					String codigo) {
				Log.d("MyHttpPostLogin", "Exito de login: "+exito+", Codigo de login: "+codigo);				
			}
		};
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
		long idUsuario = 0;
		try{
			idUsuario = Integer.valueOf(resultado);
		}catch(NumberFormatException e){
			Log.d("MyHttpPostLogin", "Error parseando id de usuario. "+e.getMessage());
		}
		bLogin = idUsuario > 0;
		Log.d("MyHttpPostLogin", "Resultado login: "+resultado);

		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(context);
		Editor spe = sp.edit();

		spe.putLong(SesionManejador.id, idUsuario);
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
		
		loginListener.onPeticionFinalizada(context, bLogin, super.result);		

	}
	
	
	public void setLoginListener(LoginListener loginListener){
		this.loginListener = loginListener;
	}

}

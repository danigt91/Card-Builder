package io.github.danigt91.cardbuilder.controller;

import io.github.danigt91.cardbuilder.async.MyHttpPostLogin;
import io.github.danigt91.cardbuilder.async.MyHttpPostObject;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SesionManejador {

	/**
	 * Busca al usuario con nombre de login y contrase�as introducidos
	 * en la base de datos externa. Si hay alguna coincidencia el logueo es correcto.
	 * @param context: Context desde el que se llama al m�todo
	 * @param login: Nombre de usuario
	 * @param pass: Contrase�a del usuario
	 * @param recordar: Booleano para autologueo
	 */
	public static void iniciarSesion(Context context, String login, String pass, boolean recordar){
		
		if(login != null && pass != null){
			
			String[][] parametros = new String[2][2];
			parametros[0] = new String[]{"login",login};
			parametros[1] = new String[]{"pass",pass};
			
			//Creamos nuestro objeto de MyHttpPost para la petici�n
			MyHttpPostObject mhpo = new MyHttpPostObject("http://magic.wmap.herobo.com/", "login", parametros);
			
			//Creamos la tarea asincora que realizara el login
			MyHttpPostLogin myPost = new MyHttpPostLogin(context, login, pass, recordar);
			//Ejecutamos la tarea asincora con el MyHttpPostObject
			myPost.execute(mhpo);			

		}else{
			Log.d("SesionManejador", "Inicio de sesion - Login o Password null");
		}
	}
	

	/**
	 * Cierra la sesi�n actual eliminando toda la informaci�n local de la misma
	 * @param context: Context desde el que se actua
	 */
	public static void cerrarSesion(Context context){

		//Inicializamos los valores de las preferencias de sesi�n por defecto
		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(context);
		Editor spe = sp.edit();

		spe.putBoolean("recordar", false);
		spe.putBoolean("identificado", false);
		spe.putString("usuario", null);
		spe.putString("pass", null);

		spe.commit();
	}

	
	/**
	 * Cierra la sesi�n actual al salir de la App, dejando la opci�n de autologueo habilitada.
	 * @param context: Context desde el que se actua
	 */
	public static void cerrarSesionAppClose(Context context){
		
		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(context);
		Editor spe = sp.edit();
		//Cerramos la sesi�n abierta
		spe.putBoolean("identificado", false);
		
		//Si est� activo recordar no eliminamos la informaci�n para el autologueo
		if(!sp.getBoolean("recordar", false)){
			spe.putString("usuario", null);
			spe.putString("pass", null);
		}

		spe.commit();
	}

	
	//Obtiene las preferencias de sesi�n
	public static SharedPreferences getSesionSharedPreferences(Context context) {
		return context.getSharedPreferences(getSesionSharedPreferencesName(context),
				getSesionSharedPreferencesMode());
	}

	//Obtiene el nombre de las preferencias de sesi�n
	private static String getSesionSharedPreferencesName(Context context) {
		return context.getPackageName() + "_sesion_preferences";
	}
	
	//Obtiene el modo de las preferencias de sesi�n
	private static int getSesionSharedPreferencesMode() {
		return Context.MODE_PRIVATE;
	}

}

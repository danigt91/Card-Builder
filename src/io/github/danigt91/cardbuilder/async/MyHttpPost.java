package io.github.danigt91.cardbuilder.async;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

//'Negamos' la implementacion de esta clase, esto se hará a través de sus subclases
public abstract class MyHttpPost extends AsyncTask<MyHttpPostObject, Void, Void> {

	protected String result;

	@Override
	protected Void doInBackground(MyHttpPostObject... params) {

		InputStream is = downloadUrl(params[0]);
		//Asignamos el String de salida de la petición
		if(is != null){
			result = inputStreamToString(is);
		}else{
			this.cancel(true);
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
	}

	protected InputStream downloadUrl(MyHttpPostObject myHttpPostObject) {
		InputStream myInputStream = null;
		try {
			StringBuilder sb = new StringBuilder();
			//Añadimos la acción de la petición
			sb.append("accion="+myHttpPostObject.accion);
			//Añadimos los parametros POST
			for(String[] s: myHttpPostObject.parametros){
				sb.append("&"+s[0]+"="+s[1]);
			}
			//Creamos la conexion
			URL url = new URL(myHttpPostObject.host);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);
			conn.setDoOutput(true);			
			conn.setRequestMethod("POST");
			OutputStreamWriter wr = new OutputStreamWriter(conn
					.getOutputStream());
			//Escribimos en el stream de salida
			wr.write(sb.toString());
			wr.flush();
			//Asignamos el stream de entrada
			myInputStream = conn.getInputStream();
			wr.close();
		} catch (IOException e) {
			Log.d("MyHttpPost",e.getMessage());
		}
		return myInputStream;
	}



	// Convierte un stream de entrada en un String
	protected String inputStreamToString(InputStream is) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(is), 4096);
		String line;
		StringBuilder sb =  new StringBuilder();
		String contentOfMyInputStream = "";
		try {
			line = rd.readLine();
			sb.append(line);
			rd.close();
			contentOfMyInputStream = sb.toString();
		} catch (IOException e) {
			Log.d("MyHttpPost", e.getMessage());
		}		
		return contentOfMyInputStream;
	}


}

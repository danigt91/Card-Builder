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
		result = inputStreamToString(is);

		return null;
	}

	@Override
	protected void onPostExecute(Void result){
		super.onPostExecute(result);
	}


	protected InputStream downloadUrl(MyHttpPostObject myHttpPostObject) {
		InputStream myInputStream =null;
		StringBuilder sb = new StringBuilder();
		//adding some data to send along with the request to the server
		sb.append("accion="+myHttpPostObject.accion);
		for(String[] s: myHttpPostObject.parametros){
			sb.append("&"+s[0]+"="+s[1]);
		}
		try {
			URL url = new URL(myHttpPostObject.host);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			OutputStreamWriter wr = new OutputStreamWriter(conn
					.getOutputStream());
			// this is were we're adding post data to the request
			wr.write(sb.toString());
			wr.flush();
			myInputStream = conn.getInputStream();
			wr.close();
		} catch (Exception e) {
			//handle the exception !
			Log.d("MyHttpPost",e.getMessage());
		}
		return myInputStream;
	}



	// Fast Implementation
	protected String inputStreamToString(InputStream is) {
		BufferedReader rd = new BufferedReader(new InputStreamReader(is), 4096);
		String line;
		StringBuilder sb =  new StringBuilder();
		try {
			line = rd.readLine();
			sb.append(line);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String contentOfMyInputStream = sb.toString();
		return contentOfMyInputStream;
	}


}

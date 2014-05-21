package io.github.danigt91.cardbuilder.async;

import io.github.danigt91.cardbuilder.listener.DescargaImagenCartaListener;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DescargaImagenCarta extends AsyncTask<String, Void, Bitmap> implements OnClickListener {
	
	private DescargaImagenCartaListener dicl;
	
	private Context context;
	private ImageView bmImagen;

	public DescargaImagenCarta(Context c, ImageView bmImage) {
		bmImage.setOnClickListener(this);
		this.context = c;
		this.bmImagen = bmImage;
	}

	@Override
	protected Bitmap doInBackground(String... urls) {
		String urldisplay = urls[0];
		Bitmap bmAux = null;
		try {
			InputStream in = new URL(urldisplay).openStream();
			bmAux = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}			
		return bmAux;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		
		dicl.onDescargaFinalizada(result);		
		
	}
	
	public void setDescargaImagenCartaListener(DescargaImagenCartaListener dicl){
		this.dicl = dicl;
	}

	@Override
	public void onClick(View v) {
				
	}
	
}
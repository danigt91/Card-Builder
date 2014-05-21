package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.listener.CartaImagenListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CartaGaleriaFragment extends Fragment implements CartaImagenListener {
	
	private Bitmap bmp;	
	private Bundle extras;
	
	private TextView txtNombreCartaGaleria;
	private FrameLayout flImagenCarta;	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_carta_galeria, container, false);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);		
		
		extras = getActivity().getIntent().getExtras();
		
		CartaImagenFragment cif = new CartaImagenFragment();
		cif.setCartaImagenListener(this);
		getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flImagenCarta, cif).commit();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		setRetainInstance(true);
		
		txtNombreCartaGaleria = (TextView) getActivity().findViewById(R.id.txtNombreCartaGaleria);
		
	}

	@Override
	public void onCartaImagenLoaded(ImageView imageView) {
		
		if(extras != null){
			byte[] byteArray = extras.getByteArray("imagen");
			if(byteArray!=null){
				bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
				if(bmp!=null){
					txtNombreCartaGaleria.setText(extras.getString("nombreCarta"));
					imageView.setImageBitmap(bmp);
				}			
			}else{
				Toast.makeText(getActivity(), "Error al cargar la imagen", Toast.LENGTH_SHORT).show();
			}
		}		
		Log.d("CartaGaleriaFragment", "onCartaImagenLoaded finish");
		
	}
	
	
}

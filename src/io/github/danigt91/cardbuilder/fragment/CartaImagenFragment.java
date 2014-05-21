package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.listener.CartaImagenListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CartaImagenFragment extends Fragment {
	
	private CartaImagenListener cil;
	
	private ImageView imgCartaCompleta;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_carta_imagen, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setRetainInstance(true);
		
		imgCartaCompleta = (ImageView) getActivity().findViewById(R.id.imgCartaCompleta);	
		cil.onCartaImagenLoaded(imgCartaCompleta);		
		Log.d("CartaImagenFragment", "onActivityCreated finish");
	}
	
	
	public void setCartaImagenListener(CartaImagenListener cil){
		this.cil = cil;
	}

}

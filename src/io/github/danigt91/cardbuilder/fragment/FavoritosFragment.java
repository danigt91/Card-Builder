package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.async.MyHttpPostMisFavoritos;
import io.github.danigt91.cardbuilder.controller.CartaManejador;
import io.github.danigt91.cardbuilder.listener.BusquedaFavoritosListener;
import io.github.danigt91.cardbuilder.listener.BusquedaSimpleListener;
import io.github.danigt91.cardbuilder.listener.MisFavoritosListener;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class FavoritosFragment extends Fragment implements MisFavoritosListener {

	private ProgressBar progressListaFavoritos;
	
	private BusquedaFavoritosListener bFListener;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		progressListaFavoritos = (ProgressBar) getActivity().findViewById(R.id.progressListaFavoritos);

		MyHttpPostMisFavoritos miPost = CartaManejador.misFavoritos(getActivity());
		if(miPost != null){
			miPost.setFavoritoListener(this);
		}
		
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_favoritos, container, false);
	}


	@Override
	public void onPeticionFinalizada(Context context, final String favoritos) {

		bFListener = new BusquedaFavoritosListener() {			

			@Override
			public void onBusquedaFavoritos() {
				ListaCartasFragment lcf = (ListaCartasFragment) FavoritosFragment.this.getActivity().getSupportFragmentManager().findFragmentById(R.id.frgListCartasFavoritas);
				if(lcf != null){
					lcf.busquedaByIds(favoritos);
				}
			}
		};
		bFListener.onBusquedaFavoritos();
		progressListaFavoritos.setVisibility(View.INVISIBLE);

	}

}

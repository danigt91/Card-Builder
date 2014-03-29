package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.controller.CartaManejador;
import io.github.danigt91.cardbuilder.entity.Carta;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CartaDetalleFragment extends Fragment {
	
	
	private Carta carta;
	
	private TextView txtCartaNombre, txtCartaSet, txtCartaTipo, 
	txtCartaRareza, txtCartaCoste, txtCartaCosteConvertido, txtCartaPoder, 
	txtCartaLealtad, txtCartaArtista, txtCartaHabilidad, txtCartaCita;
	
	private ImageView imgCartaImagen;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_carta_detalle, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		setRetainInstance(true);
		
		txtCartaNombre = (TextView) getActivity().findViewById(R.id.txtCartaNombre);
		txtCartaSet = (TextView) getActivity().findViewById(R.id.txtCartaSet);
		txtCartaTipo = (TextView) getActivity().findViewById(R.id.txtCartaTipo);
		txtCartaRareza = (TextView) getActivity().findViewById(R.id.txtCartaRareza);
		txtCartaCoste = (TextView) getActivity().findViewById(R.id.txtCartaCoste);
		txtCartaCosteConvertido = (TextView) getActivity().findViewById(R.id.txtCartaCosteConvertido);
		txtCartaPoder = (TextView) getActivity().findViewById(R.id.txtCartaPoder);
		txtCartaLealtad = (TextView) getActivity().findViewById(R.id.txtCartaLealtad);
		txtCartaArtista = (TextView) getActivity().findViewById(R.id.txtCartaArtista);
		txtCartaHabilidad = (TextView) getActivity().findViewById(R.id.txtCartaHabilidad);
		txtCartaCita = (TextView) getActivity().findViewById(R.id.txtCartaCita);
		
		imgCartaImagen = (ImageView) getActivity().findViewById(R.id.imgCartaImagen);
		
		Bundle extras = getActivity().getIntent().getExtras();
		if(extras != null){
			int idCarta = extras.getInt("idCarta");
			if(idCarta>0){
				carta = CartaManejador.obtenerCartaBasica(getActivity(), idCarta);
				cargarDetalles();
			}
		}
				
	}
	
	
	public void cargarCarta(int id){
		carta = CartaManejador.obtenerCartaBasica(getActivity(), id);
		cargarDetalles();
	}
	
	
	public void cargarDetalles(){
		if(carta != null){
			
			txtCartaNombre.setText(validarStringNull(carta.getNname()));
			txtCartaSet.setText(validarStringNull(carta.getNset()));
			txtCartaTipo.setText(validarStringNull(carta.getNtype()));
			txtCartaRareza.setText(validarStringNull(carta.getNrarity()));
			txtCartaCoste.setText(validarStringNull(carta.getNmanacost()));
			txtCartaCosteConvertido.setText(validarStringNull(carta.getNconverted_mana()));
			txtCartaPoder.setText(validarStringNull(carta.getNpower())+"/"+validarStringNull(carta.getNToughness()));
			txtCartaLealtad.setText(validarStringNull(carta.getNloyalty()));
			txtCartaArtista.setText(validarStringNull(carta.getNartist()));
			txtCartaHabilidad.setText(validarStringNull(carta.getNability()));
			txtCartaCita.setText(validarStringNull(carta.getNflavor()));
			
		}
	}
	
	
	public String validarStringNull(String texto){
		return texto!=null?texto:"";
	}
	
	

}

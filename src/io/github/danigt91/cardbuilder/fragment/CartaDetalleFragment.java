package io.github.danigt91.cardbuilder.fragment;

import java.io.ByteArrayOutputStream;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.CartaGaleriaActivity;
import io.github.danigt91.cardbuilder.async.DescargaImagenCarta;
import io.github.danigt91.cardbuilder.controller.CartaManejador;
import io.github.danigt91.cardbuilder.entity.Carta;
import io.github.danigt91.cardbuilder.listener.DescargaImagenCartaListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CartaDetalleFragment extends Fragment implements OnClickListener, DescargaImagenCartaListener {


	private Carta carta;

	private TextView txtCartaNombre, txtCartaSet, txtCartaTipo, 
	txtCartaRareza, txtCartaCoste, txtCartaCosteConvertido, txtCartaPoder, 
	txtCartaLealtad, txtCartaArtista, txtCartaHabilidad, txtCartaCita;

	private ImageView imgCartaImagen;
	private ProgressBar progressImagen;
	private Bitmap bitmap;
	
	private LruCache<String, Bitmap> mMemoryCache;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//Habilitamos la cache para las imagenes
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		
	    final int cacheSize = maxMemory / 8;

	    mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
	        @Override
	        protected int sizeOf(String key, Bitmap bitmap) {
	            return bitmap.getRowBytes() * bitmap.getHeight();
	        }
	    };

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
		progressImagen = (ProgressBar) getActivity().findViewById(R.id.progressImagen);
		progressImagen.setVisibility(View.INVISIBLE);
		
		loadBitmap("imagen", imgCartaImagen);
		if(bitmap != null){
			imgCartaImagen.setImageBitmap(bitmap);
			imgCartaImagen.setTag(1);
		}
		
		imgCartaImagen.setOnClickListener(this);
		
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
			txtCartaSet.setText(validarStringNull(carta.getBaraja().getNname())+" - "+validarStringNull(carta.getNset()));
			txtCartaTipo.setText(validarStringNull(carta.getNtype()));
			txtCartaRareza.setText(validarStringNull(carta.getNrarity()));
			txtCartaCoste.setText(validarStringNull(carta.getNmanacost()));
			txtCartaCosteConvertido.setText(validarStringNull(carta.getNconverted_mana()));
			if(carta.getNpower()!=null || carta.getNToughness()!=null){
				txtCartaPoder.setText(validarStringNull(carta.getNpower())+"/"+validarStringNull(carta.getNToughness()));
			}else{
				txtCartaPoder.setText("");
			}
			txtCartaLealtad.setText(validarStringNull(carta.getNloyalty()));
			txtCartaArtista.setText(validarStringNull(carta.getNartist()));
			txtCartaHabilidad.setText(validarStringNull(carta.getNability()));
			txtCartaCita.setText(validarStringNull(carta.getNflavor()));

		}
	}


	public String validarStringNull(String texto){
		return texto!=null?texto:"";
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.imgCartaImagen:

			if((Integer) imgCartaImagen.getTag() ==  R.drawable.back && bitmap == null){
				if(carta.getNid()!=null){
					//Cambiamos el tag para que no pueda seguir pulsando
					imgCartaImagen.setTag(1);
					DescargaImagenCarta dic = new DescargaImagenCarta(getActivity(), imgCartaImagen);
					dic.setDescargaImagenCartaListener(this);
					dic.execute("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid="+carta.getNid().toLowerCase()+"&type=card");
					progressImagen.setVisibility(View.VISIBLE);
				}
			}else{				
				lanzarIntentGaleria();
			}

			break;

		default:
			break;
		}

	}


	@Override
	public void onDescargaFinalizada(Bitmap img) {
		progressImagen.setVisibility(View.INVISIBLE);
		bitmap = img;
		imgCartaImagen.setImageBitmap(img);
		imgCartaImagen.setTag(1);
		imgCartaImagen.setOnClickListener(this);
		addBitmapToMemoryCache("imagen", img);
	}

	private void lanzarIntentGaleria(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte[] byteArray = stream.toByteArray();
		Intent intent = new Intent(getActivity(), CartaGaleriaActivity.class);
		intent.putExtra("imagen",byteArray);
		intent.putExtra("nombreCarta", carta.getNname());
		startActivity(intent);
	}
	
	
	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
	    if (getBitmapFromMemCache(key) == null) {
	        mMemoryCache.put(key, bitmap);
	    }
	}
	
	public Bitmap getBitmapFromMemCache(String key) {
	    return mMemoryCache.get(key);
	}
	
	public void loadBitmap(String imageKey, ImageView imageView) {
		
	    final Bitmap bitmap = getBitmapFromMemCache(imageKey);
	    if (bitmap != null) {
	    	imgCartaImagen.setImageBitmap(bitmap);
	    	imgCartaImagen.setTag(1);
	    } else {
	    	imgCartaImagen.setImageResource(R.drawable.back);
	    	imgCartaImagen.setTag(R.drawable.back);
	    }
	}


}

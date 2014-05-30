package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.controller.SesionManejador;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SesionCerrarFragment extends Fragment implements OnClickListener {

	private Button btnCerrarSesion;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_sesion_cerrar, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);

		btnCerrarSesion = (Button) getActivity().findViewById(R.id.btnCerrarSesion);
		btnCerrarSesion.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnCerrarSesion:

			//Restauramos las SharedPreferences de la sesión
			SesionManejador.cerrarSesion(this.getActivity());

			//Comprueba que el FrameLayout existe
			if (getActivity().findViewById(R.id.frgLInicioSesion) != null) {

				//Creamos el fragment inicial contenido en el FrameLayout
				SesionInicioFragment isf = new SesionInicioFragment();

				//Si se quieren pasar argumentos recibidos desde el Intent de la actividad
				//firstFragment.setArguments(getActivity().getIntent().getExtras());

				//Añadimos el fragment al FragmentLayout
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.replace(R.id.frgLInicioSesion, isf);
				ft.remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.frgLMenuInicioLogin));
				ft.commit();
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
				
				Toast.makeText(getActivity(), getResources().getString(R.string.sesion_cerrada), Toast.LENGTH_SHORT).show();

			}

			break;

		default:
			break;
		}

	}

}

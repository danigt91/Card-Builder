package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.BusquedaActivity;
import io.github.danigt91.cardbuilder.clase.SesionManejador;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuInicioFragment extends Fragment implements OnClickListener {

	private Button btnBusqueda;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_menu_inicio, container, false);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		btnBusqueda = (Button) getActivity().findViewById(R.id.btnBusqueda);
		btnBusqueda.setOnClickListener(this);

		//Comprueba que el FrameLayout existe
		if (getActivity().findViewById(R.id.frgLInicioSesion) != null) {




			//Si no estamos restaurando de un estado previo
			if (savedInstanceState == null) {
				
				SharedPreferences sp = SesionManejador.getSesionSharedPreferences(getActivity());
				
				//Intentamos iniciar sesión
				if(!sp.getBoolean("identificado", false) && sp.getBoolean("recordar", false)){
					SesionManejador.iniciarSesion(this.getActivity(), sp.getString("login", null), sp.getString("pass", null), sp.getBoolean("recordar", false));
				}

				if(!sp.getBoolean("identificado", false)){
					//Creamos el fragment inicial contenido en el FrameLayout
					InicioSesionFragment isf = new InicioSesionFragment();

					//Si se quieren pasar argumentos recibidos desde el Intent de la actividad
					//firstFragment.setArguments(getActivity().getIntent().getExtras());

					//Añadimos el fragment al FragmentLayout
					getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frgLInicioSesion, isf).commit();

				}else{
					//Creamos el fragment inicial contenido en el FrameLayout
					CerrarSesionFragment csf = new CerrarSesionFragment();
					MenuInicioLoginFragment milf = new MenuInicioLoginFragment();

					//Si se quieren pasar argumentos recibidos desde el Intent de la actividad
					//firstFragment.setArguments(getActivity().getIntent().getExtras());

					//Añadimos el fragment al FragmentLayout
					FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
					ft.add(R.id.frgLInicioSesion, csf);
					ft.add(R.id.frgLMenuInicioLogin, milf);
					ft.commit();

				}

			}

		}
	}


	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnBusqueda:
			
			startActivity(new Intent(getActivity(), BusquedaActivity.class));
			
			break;

		default:
			break;
		}

	}

}

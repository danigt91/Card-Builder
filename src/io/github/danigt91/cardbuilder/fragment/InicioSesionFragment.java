package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.clase.SesionManejador;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class InicioSesionFragment extends Fragment implements OnClickListener {

	private EditText etxtLogin, etxtPassword;
	private Button btnIniciarSesion, btnRegistrar;

	private CheckBox ckbRecordar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		//Evitamos la recreacion del fragmento
		setRetainInstance(true);
		
		//Obtenemos las referencias de los controles
		etxtLogin = (EditText) getActivity().findViewById(R.id.etxtLogin);
		etxtPassword = (EditText) getActivity().findViewById(R.id.etxtPassword);

		btnIniciarSesion = (Button) getActivity().findViewById(R.id.btnIniciarSesion);
		btnIniciarSesion.setOnClickListener(this);

		btnRegistrar = (Button) getActivity().findViewById(R.id.btnRegistrar);
		btnRegistrar.setOnClickListener(this);

		ckbRecordar = (CheckBox) getActivity().findViewById(R.id.ckbRecordar);

	}


	@Override
	public void onClick(View v) {		

		

		switch (v.getId()) {
		case R.id.btnIniciarSesion:
			
			//Intentamos iniciar sesion
			SesionManejador.iniciarSesion(getActivity(), etxtLogin.getText().toString(), etxtPassword.getText().toString(), ckbRecordar.isChecked());			

			break;

		case R.id.btnRegistrar:

			break;

		}

		

//		Intent ia = new Intent(this.getActivity(), InicioActivity.class);
//		startActivity(ia);		
//		getActivity().finish();

	}	



}

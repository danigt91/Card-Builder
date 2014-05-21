package io.github.danigt91.cardbuilder.fragment;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.activity.PerfilActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuInicioLoginFragment extends Fragment implements OnClickListener {
	
	private Button btnPerfil;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//Inflamos el layout del fragment
		return inflater.inflate(R.layout.fragment_menu_inicio_login, container, false);
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		btnPerfil = (Button) getActivity().findViewById(R.id.btnPerfil);
		btnPerfil.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {		
		startActivity(new Intent(getActivity(), PerfilActivity.class));
	}

}

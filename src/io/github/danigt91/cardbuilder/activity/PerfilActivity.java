package io.github.danigt91.cardbuilder.activity;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.controller.SesionManejador;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PerfilActivity extends FragmentActivity implements OnClickListener {
	
	private TextView txtUsuarioNombre;
	private Button btnFavoritos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		SharedPreferences sp = SesionManejador.getSesionSharedPreferences(this);
		
		txtUsuarioNombre = (TextView) findViewById(R.id.txtUsuarioNombre);
		txtUsuarioNombre.setText(sp.getString(SesionManejador.login, "Error"));
		
		btnFavoritos = (Button) findViewById(R.id.btnFavoritos);
		btnFavoritos.setOnClickListener(this);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.carta_galeria, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnFavoritos:
			startActivity(new Intent(this, FavoritosActivity.class));
			break;

		default:
			break;
		}
		
	}

}

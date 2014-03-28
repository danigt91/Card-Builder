package io.github.danigt91.cardbuilder.activity;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.clase.SesionManejador;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import io.github.danigt91.cardbuilder.fragment.CerrarSesionFragment;
import io.github.danigt91.cardbuilder.fragment.MenuInicioLoginFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.Toast;

public class InicioActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        
		//Creamos la BD (Importamos desde archivo SQLite de catálogo)
		SQLiteAdapter mDbHelper = new SQLiteAdapter(this);        
		mDbHelper.createDatabase();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }
    
    
    public void onDestroy(){
    	super.onDestroy();
    	
    	SesionManejador.cerrarSesionAppClose(this);
    	
    }
    
    
    public void recreateSesionIniciada(){
    	//Creamos el fragment inicial contenido en el FrameLayout
		CerrarSesionFragment csf = new CerrarSesionFragment();
		MenuInicioLoginFragment milf = new MenuInicioLoginFragment();

		//Si se quieren pasar argumentos recibidos desde el Intent de la actividad
		//firstFragment.setArguments(getActivity().getIntent().getExtras());

		//Añadimos el fragment al FragmentLayout
		FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.frgLInicioSesion, csf);
		ft.add(R.id.frgLMenuInicioLogin, milf);
		ft.commit();

		Toast.makeText(this, "Sesión Iniciada", Toast.LENGTH_SHORT).show();
    }
    
}

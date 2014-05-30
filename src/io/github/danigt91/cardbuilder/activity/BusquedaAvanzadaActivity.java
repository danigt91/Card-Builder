package io.github.danigt91.cardbuilder.activity;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.R.layout;
import io.github.danigt91.cardbuilder.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BusquedaAvanzadaActivity extends Activity {
	
	private Spinner spinColor, 
	spinCosteManaConvertido, spinComparacionCosteManaConvertido,
	spinPoder, spinComparacionPoder, 
	spinDefensa, spinComparacionDefensa, 
	spinLealtad, spinComparacionLealtad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda_avanzada);
		
		/* ARRAY DE VALORES NUMERICOS (0-20) */
		String[] spinNumericValues = new String[21];
		for(int i=0; i<spinNumericValues.length; i++){
			spinNumericValues[i] = i+"";
		}
		
		/* COLOR */
		spinColor = (Spinner) findViewById(R.id.spinColor);
		ArrayAdapter<String> spinColorAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.y_o));
		spinColor.setAdapter(spinColorAdapter);
		
		/* COSTE MANA CONVERTIDO */
		spinCosteManaConvertido = (Spinner) findViewById(R.id.spinCosteManaConvertido);		
		ArrayAdapter<String> spinCosteManaConvertidoAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, spinNumericValues);
		spinCosteManaConvertido.setAdapter(spinCosteManaConvertidoAdapter);
		
		spinComparacionCosteManaConvertido = (Spinner) findViewById(R.id.spinComparacionCosteManaConvertido);
		ArrayAdapter<String> spinComparacionCosteManaConvertidoAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionCosteManaConvertido.setAdapter(spinComparacionCosteManaConvertidoAdapter);
		
		/* PODER */
		spinPoder = (Spinner) findViewById(R.id.spinPoder);
		ArrayAdapter<String> spinPoderAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, spinNumericValues);
		spinPoder.setAdapter(spinPoderAdapter);
		
		spinComparacionPoder = (Spinner) findViewById(R.id.spinComparacionPoder);
		ArrayAdapter<String> spinComparacionPoderAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionPoder.setAdapter(spinComparacionPoderAdapter);
		
		/* DEFENSA */
		spinDefensa = (Spinner) findViewById(R.id.spinDefensa);
		ArrayAdapter<String> spinDefensaAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, spinNumericValues);
		spinDefensa.setAdapter(spinDefensaAdapter);
		
		spinComparacionDefensa = (Spinner) findViewById(R.id.spinComparacionDefensa);
		ArrayAdapter<String> spinComparacionDefensaAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionDefensa.setAdapter(spinComparacionDefensaAdapter);
		
		/* LEALTAD */
		spinLealtad = (Spinner) findViewById(R.id.spinLealtad);
		ArrayAdapter<String> spinLealtadAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, spinNumericValues);
		spinLealtad.setAdapter(spinLealtadAdapter);
		
		spinComparacionLealtad = (Spinner) findViewById(R.id.spinComparacionLealtad);
		ArrayAdapter<String> spinComparacionLealtadAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionLealtad.setAdapter(spinComparacionLealtadAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_avanzada, menu);
		return true;
	}

}

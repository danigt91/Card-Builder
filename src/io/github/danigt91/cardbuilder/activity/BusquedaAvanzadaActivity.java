package io.github.danigt91.cardbuilder.activity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.github.danigt91.cardbuilder.R;
import io.github.danigt91.cardbuilder.database.Contrato;
import io.github.danigt91.cardbuilder.database.Contrato.Cards;
import io.github.danigt91.cardbuilder.database.Contrato.Sets;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class BusquedaAvanzadaActivity extends Activity implements OnClickListener {

	public static final String criteriosIntent = "criterios";

	private Button btnBuscarAvanzado;

	private Spinner spinColor, 	spinCosteManaConvertido, 
	spinComparacionCosteManaConvertido,
	spinPoder, spinComparacionPoder, spinDefensa, 
	spinComparacionDefensa, spinLealtad, 
	spinComparacionLealtad, spinLegalidadBlock, 
	spinLegalidadStandard, spinLegalidadExtended, 
	spinLegalidadModern, spinLegalidadLegacy, 
	spinLegalidadVintage, spinLegalidadHighlander, 
	spinLegalidadFrenchCommander, spinLegalidadCommander, 
	spinLegalidadPeasant, spinLegalidadPauper,
	spinComparacionRating, spinComparacionPrecioBajo,
	spinComparacionPrecioMedio, spinComparacionPrecioAlto;

	private EditText etxtNombre, etxtSet, etxtTipo, 
	etxtCosteMana, etxtHabilidad, etxtCita, 
	etxtArtista, etxtReglas, etxtManaGenerado,
	etxtRating, etxtPrecioBajo,
	etxtPrecioMedio, etxtPrecioAlto;

	private CheckBox ckbNombreOtroIdioma,
	ckbRarezaC, ckbRarezaU, ckbRarezaR,
	ckbRarezaM, ckbRarezaT,
	ckbColorBlanco, ckbColorNegro, ckbColorAzul,
	ckbColorRojo, ckbColorVerde, ckbColorIncoloro;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda_avanzada);

		btnBuscarAvanzado = (Button) findViewById(R.id.btnBuscarAvanzado);
		btnBuscarAvanzado.setOnClickListener(this);

		/* SIN SPINNERS*/

		/* NOMBRE */
		etxtNombre = (EditText) findViewById(R.id.etxtNombre);

		/* NOMBRE OTRO IDIOMA */
		ckbNombreOtroIdioma = (CheckBox) findViewById(R.id.ckbNombreOtroIdioma);

		/* SET */
		etxtSet = (EditText) findViewById(R.id.etxtSet);

		/* TIPO */
		etxtTipo = (EditText) findViewById(R.id.etxtTipo);

		/* COSTE MANA */
		etxtCosteMana = (EditText) findViewById(R.id.etxtCosteMana);

		/* HABILIDAD */
		etxtHabilidad = (EditText) findViewById(R.id.etxtHabilidad);

		/* CITA */
		etxtCita = (EditText) findViewById(R.id.etxtCita);

		/* ARTISTA */
		etxtArtista = (EditText) findViewById(R.id.etxtArtista);

		/* REGLAS */
		etxtReglas = (EditText) findViewById(R.id.etxtReglas);

		/* MANA GENERADO */
		etxtManaGenerado = (EditText) findViewById(R.id.etxtManaGenerado);

		/* RAREZA */		
		ckbRarezaC = (CheckBox) findViewById(R.id.ckbRarezaC);
		ckbRarezaU = (CheckBox) findViewById(R.id.ckbRarezaU);
		ckbRarezaR = (CheckBox) findViewById(R.id.ckbRarezaR);
		ckbRarezaM = (CheckBox) findViewById(R.id.ckbRarezaM);
		ckbRarezaT = (CheckBox) findViewById(R.id.ckbRarezaT);	



		/*CON SPINNERS*/

		/* ARRAY DE VALORES NUMERICOS (0-20) */
		String[] spinNumericValues = new String[21];
		for(int i=0; i<spinNumericValues.length; i++){
			spinNumericValues[i] = i+"";
		}

		/* COLOR */
		spinColor = (Spinner) findViewById(R.id.spinColor);
		ArrayAdapter<String> spinColorAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.y_o));
		spinColor.setAdapter(spinColorAdapter);

		ckbColorBlanco = (CheckBox) findViewById(R.id.ckbColorBlanco);
		ckbColorNegro = (CheckBox) findViewById(R.id.ckbColorNegro);
		ckbColorAzul = (CheckBox) findViewById(R.id.ckbColorAzul);
		ckbColorRojo = (CheckBox) findViewById(R.id.ckbColorRojo);
		ckbColorVerde = (CheckBox) findViewById(R.id.ckbColorVerde);
		ckbColorIncoloro = (CheckBox) findViewById(R.id.ckbColorIncoloro);

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

		/* RATING */
		spinComparacionRating = (Spinner) findViewById(R.id.spinComparacionRating);
		ArrayAdapter<String> spinComparacionRatingAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionRating.setAdapter(spinComparacionRatingAdapter);

		etxtRating = (EditText) findViewById(R.id.etxtRating);

		/* PRECIO BAJO */
		spinComparacionPrecioBajo = (Spinner) findViewById(R.id.spinComparacionPrecioBajo);
		ArrayAdapter<String> spinComparacionPrecioBajoAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionPrecioBajo.setAdapter(spinComparacionPrecioBajoAdapter);

		etxtPrecioBajo = (EditText) findViewById(R.id.etxtPrecioBajo);

		/* PRECIO MEDIO */
		spinComparacionPrecioMedio = (Spinner) findViewById(R.id.spinComparacionPrecioMedio);
		ArrayAdapter<String> spinComparacionPrecioMedioAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionPrecioMedio.setAdapter(spinComparacionPrecioMedioAdapter);

		etxtPrecioMedio = (EditText) findViewById(R.id.etxtPrecioMedio);

		/* PRECIO ALTO */
		spinComparacionPrecioAlto = (Spinner) findViewById(R.id.spinComparacionPrecioAlto);
		ArrayAdapter<String> spinComparacionPrecioAltoAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.igual_mayor_menor));
		spinComparacionPrecioAlto.setAdapter(spinComparacionPrecioAltoAdapter);

		etxtPrecioAlto = (EditText) findViewById(R.id.etxtPrecioAlto);













		/* LEGALIDAD */
		spinLegalidadBlock = (Spinner) findViewById(R.id.spinLegalidadBlock);
		ArrayAdapter<String> spinLegalidadBlockAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadBlock.setAdapter(spinLegalidadBlockAdapter);

		spinLegalidadStandard = (Spinner) findViewById(R.id.spinLegalidadStandard);
		ArrayAdapter<String> spinLegalidadStandardAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadStandard.setAdapter(spinLegalidadStandardAdapter);

		spinLegalidadExtended = (Spinner) findViewById(R.id.spinLegalidadExtended);
		ArrayAdapter<String> spinLegalidadExtendedAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadExtended.setAdapter(spinLegalidadExtendedAdapter);

		spinLegalidadModern = (Spinner) findViewById(R.id.spinLegalidadModern);
		ArrayAdapter<String> spinLegalidadModernAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadModern.setAdapter(spinLegalidadModernAdapter);

		spinLegalidadLegacy = (Spinner) findViewById(R.id.spinLegalidadLegacy);
		ArrayAdapter<String> spinLegalidadLegacyAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadLegacy.setAdapter(spinLegalidadLegacyAdapter);

		spinLegalidadVintage = (Spinner) findViewById(R.id.spinLegalidadVintage);
		ArrayAdapter<String> spinLegalidadVintageAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadVintage.setAdapter(spinLegalidadVintageAdapter);

		spinLegalidadHighlander = (Spinner) findViewById(R.id.spinLegalidadHighlander);
		ArrayAdapter<String> spinLegalidadHighlanderAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadHighlander.setAdapter(spinLegalidadHighlanderAdapter);

		spinLegalidadFrenchCommander = (Spinner) findViewById(R.id.spinLegalidadFrenchCommander);
		ArrayAdapter<String> spinLegalidadFrenchCommanderAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadFrenchCommander.setAdapter(spinLegalidadFrenchCommanderAdapter);

		spinLegalidadCommander = (Spinner) findViewById(R.id.spinLegalidadCommander);
		ArrayAdapter<String> spinLegalidadCommanderAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadCommander.setAdapter(spinLegalidadCommanderAdapter);

		spinLegalidadPeasant = (Spinner) findViewById(R.id.spinLegalidadPeasant);
		ArrayAdapter<String> spinLegalidadPeasantAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadPeasant.setAdapter(spinLegalidadPeasantAdapter);

		spinLegalidadPauper = (Spinner) findViewById(R.id.spinLegalidadPauper);
		ArrayAdapter<String> spinLegalidadPauperAdapter = new ArrayAdapter<String>(this, R.layout.row_spin, R.id.txtSpin, getResources().getStringArray(R.array.legalidad_items));
		spinLegalidadPauper.setAdapter(spinLegalidadPauperAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_avanzada, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnBuscarAvanzado:

			//ASIGNACION DE CRITERIOS

			ArrayList<String> criterios = new ArrayList<String>();
			//NOMBRE Y NOMBRE OTRO IDIOMA
			criterios = criterioNombre(criterios);

			//SET (NOMBRE Y ABREVIATURA)
			criterios = criterioSet(criterios);

			//TIPO
			criterios = criterioTipo(criterios);

			//RAREZA
			criterios = criterioRareza(criterios);

			//COLOR
			criterios = criterioColor(criterios);

			//COSTE MANA CONVERTIDO
			criterios = criterioCosteManaConvertido(criterios);
			
			//PODER
			criterios = criterioPoder(criterios);
			
			//DEFENSA
			criterios = criterioDefensa(criterios);
			
			//LEALTAD
			criterios = criterioLealtad(criterios);
			
			//HABILIDAD
			criterios = criterioHabilidad(criterios);
			
			//CITA
			criterios = criterioCita(criterios);
			
			//ARTISTA
			criterios = criterioArtista(criterios);
			
			//RATING
			criterios = criterioRating(criterios);
			
			//REGLAS
			criterios = criterioReglas(criterios);
			
			//PRECIO BAJO
			criterios = criterioPrecioBajo(criterios);
			
			//PRECIO MEDIO
			criterios = criterioPrecioMedio(criterios);
			
			//PRECIO ALTO
			criterios = criterioPrecioAlto(criterios);
			
			//LEGALIDAD BLOCK
			criterios = criterioLegalidadBlock(criterios);
			
			//LEGALIDAD STANDARD
			criterios = criterioLegalidadStandard(criterios);
			
			//LEGALIDAD EXTENDED
			criterios = criterioLegalidadExtended(criterios);
			
			//LEGALIDAD MODERN
			criterios = criterioLegalidadModern(criterios);
			
			//LEGALIDAD LEGACY
			criterios = criterioLegalidadLegacy(criterios);
			
			//LEGALIDAD VINTAGE
			criterios = criterioLegalidadVintage(criterios);
			
			//LEGALIDAD HIGHLANDER
			criterios = criterioLegalidadHighlander(criterios);
			
			//LEGALIDAD FRENCH COMMANDER
			criterios = criterioLegalidadFrenchCommander(criterios);
			
			//LEGALIDAD COMMANDER
			criterios = criterioLegalidadCommander(criterios);
			
			//LEGALIDAD PEASANT
			criterios = criterioLegalidadPeasant(criterios);
			
			//LEGALIDAD PAUPER
			criterios = criterioLegalidadPauper(criterios);



			Intent intentResult = new Intent();
			intentResult.putStringArrayListExtra(BusquedaAvanzadaActivity.criteriosIntent, criterios);
			setResult(1, intentResult);
			finish();			

			break;

		default:
			break;
		}

	}

	public boolean noEmpty(EditText et){
		return (et != null || et.getText() != null && !et.getText().equals(""));
	}

	public String value(EditText et){
		return et.getText().toString();
	}

	public ArrayList<String> criterioNombre(ArrayList<String> criterios){
		if(noEmpty(etxtNombre)){
			if(!ckbNombreOtroIdioma.isChecked()){
				criterios.add(Cards.CARDS_TABLE_NAME+"."+Contrato.Cards.CARD_NAME+" LIKE '%" + value(etxtNombre) + "%'");
			}else{
				String query = Cards.CARDS_TABLE_NAME+"."+Contrato.Cards.CARD_NAME+" LIKE '%" + value(etxtNombre) + "%' OR "+
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_CN+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_DE+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_ES+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_FR+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_IT+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_JP+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_KO+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_PT+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_RU+" LIKE '%" + value(etxtNombre) + "%' OR " + 
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_NAME_TW+" LIKE '%" + value(etxtNombre) + "%'";
				criterios.add(query);
			}
		}
		return criterios;
	}

	public ArrayList<String> criterioSet(ArrayList<String> criterios){
		if(noEmpty(etxtSet)){
			criterios.add("("+Cards.CARDS_TABLE_NAME+"."+Cards.CARD_SET+" LIKE '%"+value(etxtSet)+"%' OR "+Sets.SETS_TABLE_NAME+"."+Sets.SET_NAME+" LIKE '%"+value(etxtSet)+"%')");
		}
		return criterios;
	}

	public ArrayList<String> criterioTipo(ArrayList<String> criterios){
		if(noEmpty(etxtTipo)){
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_TYPE+" LIKE '%"+value(etxtTipo)+"%'");
		}
		return criterios;
	}

	public ArrayList<String> criterioRareza(ArrayList<String> criterios){
		ArrayList<String> criteriosRareza = new ArrayList<String>();
		if(ckbRarezaC.isChecked()){
			criteriosRareza.add("C");
		}
		if(ckbRarezaU.isChecked()){
			criteriosRareza.add("U");
		}
		if(ckbRarezaR.isChecked()){
			criteriosRareza.add("R");
		}
		if(ckbRarezaM.isChecked()){
			criteriosRareza.add("M");
		}
		if(ckbRarezaT.isChecked()){
			criteriosRareza.add("T");
		}
		String criteriosRarezaQuery = "(";
		for(int i = 0; i < criteriosRareza.size(); i++){
			if(i!=0){
				criteriosRarezaQuery += " OR ";
			}
			criteriosRarezaQuery += Cards.CARDS_TABLE_NAME+"."+Cards.CARD_RARITY+" LIKE '%"+criteriosRareza.get(i)+"%'";
		}
		criteriosRarezaQuery += ")";
		criterios.add(criteriosRarezaQuery);
		return criterios;
	}

	public ArrayList<String> criterioColor(ArrayList<String> criterios){
		final int spinColorSelectedId = (int) spinColor.getSelectedItemId();
		if(spinColorSelectedId > 0){
			String colorComparator1 = " AND ";
			String colorComparator2 = " LIKE ";			
			switch (spinColorSelectedId) {
			case 0:
				//No filtrar
				break;				
			case 1:
				// O
				colorComparator1 = " OR ";
				colorComparator2 = " LIKE ";
				break;
			case 2:
				// Y
				colorComparator1 = " AND ";
				colorComparator2 = " LIKE ";
				break;
			case 3:
				// NO
				colorComparator1 = " AND ";
				colorComparator2 = " NOT LIKE ";
				break;

			default:
				break;
			}
			ArrayList<String> criteriosColor = new ArrayList<String>();
			if(ckbColorBlanco.isChecked()){
				criteriosColor.add("W");
			}
			if(ckbColorNegro.isChecked()){
				criteriosColor.add("B");
			}
			if(ckbColorAzul.isChecked()){
				criteriosColor.add("U");
			}
			if(ckbColorRojo.isChecked()){
				criteriosColor.add("R");
			}
			if(ckbColorVerde.isChecked()){
				criteriosColor.add("G");
			}
			String incoloro = "";
			if(ckbColorIncoloro.isChecked()){
				incoloro = " ("+Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" NOT LIKE '%W%' AND "+
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" NOT LIKE '%B%' AND " +
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" NOT LIKE '%U%' AND " +
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" NOT LIKE '%R%' AND " +
						Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" NOT LIKE '%G%' " +
						") ";
			}

			String criteriosColorQuery = "(";
			for(int i = 0; i < criteriosColor.size(); i++){
				if(i!=0){
					criteriosColorQuery += colorComparator1;
				}
				criteriosColorQuery += Cards.CARDS_TABLE_NAME+"."+Cards.CARD_MANACOST+" "+ colorComparator2 +" '%"+criteriosColor.get(i)+"%'";
			}
			if(!incoloro.equals("")){
				criteriosColorQuery += colorComparator1 + incoloro;
			}				
			criteriosColorQuery += ")";
			criterios.add(criteriosColorQuery);
		}
		return criterios;
	}
	
	public String comparador(final int item){
		String comparador = "";
		switch (item) {
		case 0:
			// No filtrar
			break;

		case 1:
			// =
			comparador = " = ";
			break;

		case 2:
			// >
			comparador = " > ";
			break;

		case 3:
			// <
			comparador = " < ";
			break;

		case 4:
			// >=
			comparador = " >= ";
			break;

		case 5:
			// <=
			comparador = " <= ";
			break;

		default:
			comparador = " = ";
			break;
		}
		return comparador;
	}

	public ArrayList<String> criterioCosteManaConvertido(ArrayList<String> criterios){
		final int spinComparacionCosteManaConvertidoSelectedId = (int) spinComparacionCosteManaConvertido.getSelectedItemId();
		if(spinComparacionCosteManaConvertidoSelectedId > 0){
			String comparador = comparador(spinComparacionCosteManaConvertidoSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_CONVERTED_MANACOST+" "+comparador+" CAST("+spinCosteManaConvertido.getSelectedItem().toString()+" AS REAL)");
		}		
		return criterios;
	}	
	
	public ArrayList<String> criterioPoder(ArrayList<String> criterios){
		final int spinComparacionPoderSelectedId = (int) spinComparacionPoder.getSelectedItemId();
		if(spinComparacionPoderSelectedId > 0){
			String comparador = comparador(spinComparacionPoderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_POWER+" "+comparador+" CAST("+spinPoder.getSelectedItem().toString()+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioDefensa(ArrayList<String> criterios){
		final int spinComparacionPoderSelectedId = (int) spinComparacionDefensa.getSelectedItemId();
		if(spinComparacionPoderSelectedId > 0){
			String comparador = comparador(spinComparacionPoderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_TOUGHNESS+" "+comparador+" CAST("+spinDefensa.getSelectedItem().toString()+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLealtad(ArrayList<String> criterios){
		final int spinComparacionPoderSelectedId = (int) spinComparacionLealtad.getSelectedItemId();
		if(spinComparacionPoderSelectedId > 0){
			String comparador = comparador(spinComparacionPoderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LOYALTY+" "+comparador+" CAST("+spinLealtad.getSelectedItem().toString()+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioHabilidad(ArrayList<String> criterios){
		if(noEmpty(etxtHabilidad)){
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_ABILITY+" LIKE '%"+value(etxtHabilidad)+"%'");
		}
		return criterios;
	}
	
	public ArrayList<String> criterioCita(ArrayList<String> criterios){
		if(noEmpty(etxtCita)){
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_FLAVOR+" LIKE '%"+value(etxtCita)+"%'");
		}
		return criterios;
	}
	
	public ArrayList<String> criterioArtista(ArrayList<String> criterios){
		if(noEmpty(etxtArtista)){
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_ARTIST+" LIKE '%"+value(etxtArtista)+"%'");
		}
		return criterios;
	}
	
	public ArrayList<String> criterioRating(ArrayList<String> criterios){
		final int spinComparacionRatingSelectedId = (int) spinComparacionRating.getSelectedItemId();
		if(spinComparacionRatingSelectedId > 0){
			String comparador = comparador(spinComparacionRatingSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_RATING+" "+comparador+" CAST("+value(etxtRating)+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioReglas(ArrayList<String> criterios){
		if(noEmpty(etxtReglas)){
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_RULING+" LIKE '%"+value(etxtReglas)+"%'");
		}
		return criterios;
	}
	
	public ArrayList<String> criterioPrecioBajo(ArrayList<String> criterios){
		final int spinComparacionPrecioBajoSelectedId = (int) spinComparacionPrecioBajo.getSelectedItemId();
		if(spinComparacionPrecioBajoSelectedId > 0){
			String comparador = comparador(spinComparacionPrecioBajoSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_PRICING_LOW+" "+comparador+" CAST("+value(etxtPrecioBajo)+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioPrecioMedio(ArrayList<String> criterios){
		final int spinComparacionPrecioMedioSelectedId = (int) spinComparacionPrecioMedio.getSelectedItemId();
		if(spinComparacionPrecioMedioSelectedId > 0){
			String comparador = comparador(spinComparacionPrecioMedioSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_PRICING_MID+" "+comparador+" CAST("+value(etxtPrecioMedio)+" AS REAL)");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioPrecioAlto(ArrayList<String> criterios){
		final int spinComparacionPrecioAltoSelectedId = (int) spinComparacionPrecioAlto.getSelectedItemId();
		if(spinComparacionPrecioAltoSelectedId > 0){
			String comparador = comparador(spinComparacionPrecioAltoSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_PRICING_HIGH+" "+comparador+" CAST("+value(etxtPrecioAlto)+" AS REAL)");
		}		
		return criterios;
	}
	
	public String comparadorLegalidad(final int item){
		String comparador = " = ";
		switch (item) {
		case 0:
			// No filtrar
			break;
			
		case 1:
			comparador = " = ";
			break;
		
		case 2:
			comparador = " != ";
			break;

		default:
			break;
		}
		return comparador;
	}
	
	public ArrayList<String> criterioLegalidadBlock(ArrayList<String> criterios){
		final int spinLegalidadBlockSelectedId = (int) spinLegalidadBlock.getSelectedItemId();
		if(spinLegalidadBlockSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadBlockSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_BLOCK+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadStandard(ArrayList<String> criterios){
		final int spinLegalidadStandardSelectedId = (int) spinLegalidadStandard.getSelectedItemId();
		if(spinLegalidadStandardSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadStandardSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_STANDARD+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadExtended(ArrayList<String> criterios){
		final int spinLegalidadExtendedSelectedId = (int) spinLegalidadExtended.getSelectedItemId();
		if(spinLegalidadExtendedSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadExtendedSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_EXTENDED+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadModern(ArrayList<String> criterios){
		final int spinLegalidadModernSelectedId = (int) spinLegalidadModern.getSelectedItemId();
		if(spinLegalidadModernSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadModernSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_MODERN+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadLegacy(ArrayList<String> criterios){
		final int spinLegalidadLegacySelectedId = (int) spinLegalidadLegacy.getSelectedItemId();
		if(spinLegalidadLegacySelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadLegacySelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_LEGACY+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadVintage(ArrayList<String> criterios){
		final int spinLegalidadVintageSelectedId = (int) spinLegalidadVintage.getSelectedItemId();
		if(spinLegalidadVintageSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadVintageSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_VINTAGE+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadHighlander(ArrayList<String> criterios){
		final int spinLegalidadHighlanderSelectedId = (int) spinLegalidadHighlander.getSelectedItemId();
		if(spinLegalidadHighlanderSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadHighlanderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_HIGHLANDER+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadFrenchCommander(ArrayList<String> criterios){
		final int spinLegalidadFrenchCommanderSelectedId = (int) spinLegalidadFrenchCommander.getSelectedItemId();
		if(spinLegalidadFrenchCommanderSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadFrenchCommanderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_FRENCH_COMMANDER+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadCommander(ArrayList<String> criterios){
		final int spinLegalidadCommanderSelectedId = (int) spinLegalidadCommander.getSelectedItemId();
		if(spinLegalidadCommanderSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadCommanderSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_COMMANDER+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadPeasant(ArrayList<String> criterios){
		final int spinLegalidadPeasantSelectedId = (int) spinLegalidadPeasant.getSelectedItemId();
		if(spinLegalidadPeasantSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadPeasantSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_PEASANT+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	
	public ArrayList<String> criterioLegalidadPauper(ArrayList<String> criterios){
		final int spinLegalidadPauperSelectedId = (int) spinLegalidadPauper.getSelectedItemId();
		if(spinLegalidadPauperSelectedId > 0){
			String comparador = comparadorLegalidad(spinLegalidadPauperSelectedId);
			criterios.add(Cards.CARDS_TABLE_NAME+"."+Cards.CARD_LEGALITY_PAUPER+" "+comparador+" 'v' ");
		}		
		return criterios;
	}
	

	

}

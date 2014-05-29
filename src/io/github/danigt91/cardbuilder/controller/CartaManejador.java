package io.github.danigt91.cardbuilder.controller;

import android.content.Context;
import android.database.Cursor;
import io.github.danigt91.cardbuilder.async.MyHttpPostFavorito;
import io.github.danigt91.cardbuilder.async.MyHttpPostLogin;
import io.github.danigt91.cardbuilder.async.MyHttpPostObject;
import io.github.danigt91.cardbuilder.database.Contrato;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import io.github.danigt91.cardbuilder.entity.Baraja;
import io.github.danigt91.cardbuilder.entity.Carta;

public class CartaManejador {
	
	public static final String id = "idCarta";
	
	public static final String esFavoritaAction = "esFavorita";
	public static final String toggleFavoritaAction = "toggleFavoritaAction";
	
	public static Carta obtenerCartaBasica(Context context, int id){
		Carta c = new Carta();
		
		SQLiteAdapter mDbHelper = new SQLiteAdapter(context);            
		mDbHelper.open();

		Cursor cursor = mDbHelper.getCartaBasicaPorId(id);
		
		// TODO
		c.set_id(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta._ID)));
		c.setNid(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_ID)));
		//c.setNnumber(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_NUMBER)));
		c.setNname(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_NAME)));
		c.setNset(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_SET)));
		c.setNtype(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_TYPE)));
		c.setNrarity(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_RARITY)));
		c.setNmanacost(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_MANACOST)));
		//c.setNconverted_mana(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_CONVERTED_MANACOST)));
		c.setNpower(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_POWER)));
		c.setNToughness(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_TOUGHNESS)));
		c.setNloyalty(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_LOYALTY)));
		c.setNability(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_ABILITY)));
		c.setNflavor(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_FLAVOR)));
		c.setNartist(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_ARTIST)));
		
		c.setBaraja(new Baraja());
		c.getBaraja().getCartas().add(c);
		c.getBaraja().setNname(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.SET_NAME)));
		c.getBaraja().setNcode(cursor.getString(cursor.getColumnIndex(Contrato.DetalleCarta.CARD_SET)));
		
		cursor.close();
		mDbHelper.close();
		
		return c;
	}
	
	public static Carta obtenerCartaCompleta(int id){
		Carta c = new Carta();
		return c;
	}
	
	
	public static void esFavorita(Context context, long idCarta){
		long idUsuario = SesionManejador.idUsuarioLogueado(context);
		if(idUsuario > 0){
			String[][] parametros = new String[2][2];
			parametros[0] = new String[]{SesionManejador.id, idUsuario+""};
			parametros[1] = new String[]{CartaManejador.id, idCarta+""};

			//Creamos nuestro objeto de MyHttpPost para la petición
			MyHttpPostObject mhpo = new MyHttpPostObject("http://magic.wmap.herobo.com/", CartaManejador.esFavoritaAction, parametros);
			
			MyHttpPostFavorito myPost = new MyHttpPostFavorito(context, idUsuario, idCarta);
			//Ejecutamos la tarea asincrona con el MyHttpPostObject
			myPost.execute(mhpo);
		}
	}
	
	public static void toggleFavorita(Context context, long idCarta){
		long idUsuario = SesionManejador.idUsuarioLogueado(context);
		if(idUsuario > 0){
			String[][] parametros = new String[2][2];
			parametros[0] = new String[]{SesionManejador.id, idUsuario+""};
			parametros[1] = new String[]{CartaManejador.id, idCarta+""};

			//Creamos nuestro objeto de MyHttpPost para la petición
			MyHttpPostObject mhpo = new MyHttpPostObject("http://magic.wmap.herobo.com/", CartaManejador.toggleFavoritaAction, parametros);
			
			MyHttpPostFavorito myPost = new MyHttpPostFavorito(context, idUsuario, idCarta);
			//Ejecutamos la tarea asincrona con el MyHttpPostObject
			myPost.execute(mhpo);
		}
	}

}

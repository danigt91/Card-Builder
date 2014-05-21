package io.github.danigt91.cardbuilder.controller;

import android.content.Context;
import android.database.Cursor;
import io.github.danigt91.cardbuilder.database.Contrato;
import io.github.danigt91.cardbuilder.database.SQLiteAdapter;
import io.github.danigt91.cardbuilder.entity.Baraja;
import io.github.danigt91.cardbuilder.entity.Carta;

public class CartaManejador {
	
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

}

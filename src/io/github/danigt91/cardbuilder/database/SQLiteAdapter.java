package io.github.danigt91.cardbuilder.database;

import io.github.danigt91.cardbuilder.database.Contrato.Cards;
import io.github.danigt91.cardbuilder.database.Contrato.DetalleCarta;
import io.github.danigt91.cardbuilder.database.Contrato.ListadoCartas;
import io.github.danigt91.cardbuilder.database.Contrato.Sets;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLiteAdapter 
{
	protected static final String TAG = "DataAdapter";

	private final Context mContext;
	private SQLiteDatabase mDb;
	private SQLiteHelper mDbHelper;

	public SQLiteAdapter(Context context) 
	{
		this.mContext = context;
		mDbHelper = new SQLiteHelper(mContext);
	}

	public SQLiteAdapter createDatabase() throws SQLException 
	{
		try 
		{
			mDbHelper.createDataBase();
		} 
		catch (IOException mIOException) 
		{
			Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
			throw new Error("UnableToCreateDatabase");
		}
		return this;
	}

	public SQLiteAdapter open() throws SQLException 
	{
		try 
		{
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDb = mDbHelper.getReadableDatabase();
		} 
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "open >>"+ mSQLException.toString());
			throw mSQLException;
		}
		return this;
	}

	public void close() 
	{
		mDbHelper.close();
	}

	public Cursor getTestData()
	{
		try
		{
			String sql ="SELECT * FROM ncards LIMIT 0,10";

			Cursor mCur = mDb.rawQuery(sql, null);
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getTestData >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}

	//Busqueda simple - Realiza la busqueda por la tabla de cartas filtrando por el nombre en ingles
	public Cursor getCartasPorNname(String name)
	{
		try
		{			
			Cursor mCur = mDb.query(Cards.CARDS_TABLE_NAME, new String[]{Cards._ID, Cards.CARD_NAME}, 
					Cards.CARD_NAME+" LIKE ?", new String[]{"%"+name+"%"}, null, null, Cards.DEFAULT_SORT_ORDER, null);
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getCartasPorNname >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}

	//Busqueda simple - Realiza la busqueda por la vista listadoCartas filtrando por el nombre en ingles
	public Cursor getListadoCartasPorNname(String name)
	{
		try
		{			
			Cursor mCur = mDb.query(ListadoCartas.LISTADOCARTAS_TABLE_NAME, null, ListadoCartas.CARD_NAME+" LIKE ?", new String[]{"%"+name+"%"}, null, null, ListadoCartas.DEFAULT_SORT_ORDER);
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getListadoCartasPorNname >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}

	//Realiza la busqueda de una carta básica desde la vista detalle_carta filtrada por su id
	public Cursor getCartaBasicaPorId(int id){

		try
		{			
			Cursor mCur = mDb.query(DetalleCarta.DETALLECARTA_TABLE_NAME, null, DetalleCarta._ID+"=?", new String[]{id+""}, null, null, DetalleCarta.DEFAULT_SORT_ORDER);
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getCartaBasicaPorId >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}


	public Cursor getListadoCartasPorId(String... ids){
		try
		{	
			String idsAux = "0";
			for(int i=0; i < ids.length; i++){
				if(!ids[i].equals("")){
					idsAux += ", "+ids[i];
				}				
			}
			String query = "SELECT * FROM " + DetalleCarta.DETALLECARTA_TABLE_NAME + " WHERE " + DetalleCarta._ID + " IN(" + idsAux + ") ORDER BY "+DetalleCarta.DEFAULT_SORT_ORDER;
			Cursor mCur = mDb.rawQuery(query, new String[]{});
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getListadoCartasPorId >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}

	public Cursor getListadoCartasPorCriterio(ArrayList<String> criterios){
		return getListadoCartasPorCriterio(criterios, null);
	}

	//Busqueda simple - Realiza la busqueda por la vista listadoCartas filtrando por el nombre en ingles
	public Cursor getListadoCartasPorCriterio(ArrayList<String> criterios, String order)
	{
		try
		{
			String query = "SELECT * FROM "+ListadoCartas.LISTADOCARTAS_TABLE_NAME+" WHERE _id IN(SELECT " + Cards.CARDS_TABLE_NAME+"."+Cards._ID + " FROM "+Cards.CARDS_TABLE_NAME+
					"  INNER JOIN " + Sets.SETS_TABLE_NAME + " ON " + Cards.CARDS_TABLE_NAME+"."+Cards.CARD_SET + " = " + Sets.SETS_TABLE_NAME+"."+Sets.SET_CODE + 
					" WHERE 1=1";
			for(int i = 0; i < criterios.size(); i++){
				query += " AND " + criterios.get(i);
			}
			if(order != null && !order.equals("")){
				query += " ORDER BY "+order;
			}
			query += ")";
			Log.d("SQLiteAdapter - getListadoCartasPorCriterio: ", query);
			Cursor mCur = mDb.rawQuery(query, new String[]{});
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException) 
		{
			Log.e(TAG, "getListadoCartasPorCriterio >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}




}
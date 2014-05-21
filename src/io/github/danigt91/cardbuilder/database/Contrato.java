package io.github.danigt91.cardbuilder.database;

import android.provider.BaseColumns;

public class Contrato {

	private Contrato() {}

	public static final class Sets implements BaseColumns {
		private Sets() {}
		public static final String _ID="_id";
		public static final String SETS_TABLE_NAME="nsets";
		public static final String SET_NAME="Nname";
		public static final String SET_CODE="Ncode";
		public static final String SET_CODE_MAGICCARD="Ncode_magiccard";
		public static final String SET_DATE="Ndate";
		public static final String DEFAULT_SORT_ORDER="Nname ASC";
	}

	public static final class Cards implements BaseColumns {
		private Cards() {}
		public static final String _ID="_id";
		public static final String CARDS_TABLE_NAME="ncards";
		public static final String CARD_ID="Nid";
		public static final String CARD_NAME="Nname";
		public static final String CARD_SET="Nset";
		public static final String CARD_TYPE="Ntype";
		public static final String CARD_RARITY="Nrarity";
		public static final String CARD_MANACOST="Nmanacost";
		public static final String CARD_CONVERTED_MANACOST="Nconverted_manacost";
		public static final String CARD_POWER="Npower";
		public static final String CARD_TOUGHNESS="Ntoughness";
		public static final String CARD_LOYALTY="Nloyalty";
		public static final String CARD_ABILITY="Nability";
		public static final String CARD_FLAVOR="Nflavor";
		public static final String CARD_VARIATION="Nvariation";
		public static final String CARD_ARTIST="Nartist";
		public static final String CARD_NUMBER="Nnumber";
		public static final String CARD_RATING="Nrating";
		public static final String CARD_RULING="Nruling";
		public static final String CARD_COLOR="Ncolor";
		public static final String CARD_GENERATED_MANA="Ngenerated_mana";
		public static final String CARD_PRICING_LOW="Nprincing_low";
		public static final String CARD_PRICING_MID="Npricing_mid";
		public static final String CARD_PRICING_HIGH="Npricing_high";
		public static final String CARD_BACK_ID="Nback_id";
		public static final String CARD_WATERMARK="Nwatermark";
		public static final String CARD_NAME_CN="Nname_CN";
		public static final String CARD_NAME_TW="Nname_TW";
		public static final String CARD_NAME_FR="Nname_FR";
		public static final String CARD_NAME_DE="Nname_DE";
		public static final String CARD_NAME_IT="Nname_IT";
		public static final String CARD_NAME_JP="Nname_JP";
		public static final String CARD_NAME_PT="Nname_PT";
		public static final String CARD_NAME_RU="Nname_RU";
		public static final String CARD_NAME_ES="Nname_ES";
		public static final String CARD_NAME_KO="Nname_KO";
		public static final String CARD_LEGALITY_BLOCK="Nlegality_Block";
		public static final String CARD_LEGALITY_STANDARD="Nlegality_Standard";
		public static final String CARD_LEGALITY_EXTENDED="Nlegality_Extended";
		public static final String CARD_LEGALITY_MODERN="Nlegality_Modern";
		public static final String CARD_LEGALITY_LEGACY="Nlegality_Legacy";
		public static final String CARD_LEGALITY_VINTAGE="Nlegality_Vingate";
		public static final String CARD_LEGALITY_HIGHLANDER="Nlegality_Highlander";
		public static final String CARD_LEGALITY_FRENCH_COMMANDER="Nlegality_French_Commander";
		public static final String CARD_LEGALITY_COMMANDER="Nlegality_Commander";
		public static final String CARD_LEGALITY_PEASANT="Nlegality_Peasant";
		public static final String CARD_LEGALITY_PAUPER="Nlegality_Pauper";
		public static final String DEFAULT_SORT_ORDER="Nname ASC";
	}
	
	
	public static final class ListadoCartas {
		private ListadoCartas() {}
		public static final String _ID="_id";
		public static final String LISTADOCARTAS_TABLE_NAME="listado_cartas";
		public static final String CARD_NAME="card_Nname";
		public static final String SET_NAME="set_Nname";
		public static final String DEFAULT_SORT_ORDER="card_Nname ASC";
	}
	
	
	public static final class DetalleCarta{
		private DetalleCarta() {}
		public static final String _ID="_id";
		public static final String DETALLECARTA_TABLE_NAME="detalle_carta";
		public static final String CARD_ID="Nid";
		public static final String CARD_NUMBER="card_Nnumber";
		public static final String CARD_NAME="card_Nname";
		public static final String SET_NAME="set_Nname";
		public static final String CARD_SET="Nset";
		public static final String CARD_TYPE="Ntype";
		public static final String CARD_RARITY="Nrarity";
		public static final String CARD_MANACOST="Nmanacost";
		public static final String CARD_CONVERTED_MANACOST="Nconverted_manacost";
		public static final String CARD_POWER="Npower";
		public static final String CARD_TOUGHNESS="Ntoughness";
		public static final String CARD_LOYALTY="Nloyalty";
		public static final String CARD_ABILITY="Nability";
		public static final String CARD_FLAVOR="Nflavor";
		public static final String CARD_ARTIST="Nartist";
		public static final String DEFAULT_SORT_ORDER="card_Nname ASC";
	}



}

package io.github.danigt91.cardbuilder.entity;

public class Carta {
	
	private String _id;
	private String Nid;
	private String Nname;
	private String Nset;
	private String Ntype;
	private String Nrarity;
	private String Nmanacost;
	private String Nconverted_mana;
	private String Npower;
	private String NToughness;
	private String Nloyalty;
	private String Nability;
	private String Nflavor;
	private String Nvariation;
	private String Nartist;
	private String Nnumber;
	private String Nrating;
	private String Nruling;
	private String Ncolor;
	private String Ngenerated_mana;
	private String Npricing_low;
	private String Npricing_mid;
	private String Npricing_high;
	private String Nback_id;
	private String Nwatermark;
	private String Nname_CN;
	private String Nname_TW;
	private String Nname_FR;
	private String Nname_DE;
	private String Nname_IT;
	private String Nname_JP;
	private String Nname_PT;
	private String Nname_RU;
	private String Nname_ES;
	private String Nname_KO;
	private String Nlegality_Block;
	private String Nlegality_Standard;
	private String Nlegality_Extended;
	private String Nlegality_Modern;
	private String Nlegality_Legacy;
	private String Nlegality_Vintage;
	private String Nlegality_Highlander;
	private String Nlegality_French_Commander;
	private String Nlegality_Commander;
	private String Nlegality_Peasant;
	private String Nlegality_Pauper;
	
	private Baraja baraja;
	
	
	public Carta(){
		
	}



	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getNid() {
		return Nid;
	}



	public void setNid(String nid) {
		Nid = nid;
	}



	public String getNname() {
		return Nname;
	}



	public void setNname(String nname) {
		Nname = nname;
	}



	public String getNset() {
		return Nset;
	}



	public void setNset(String nset) {
		Nset = nset;
	}



	public String getNtype() {
		return Ntype;
	}



	public void setNtype(String ntype) {
		Ntype = ntype;
	}



	public String getNrarity() {
		return Nrarity;
	}



	public void setNrarity(String nrarity) {
		Nrarity = nrarity;
	}



	public String getNmanacost() {
		return Nmanacost;
	}



	public void setNmanacost(String nmanacost) {
		Nmanacost = nmanacost;
	}



	public String getNconverted_mana() {
		return Nconverted_mana;
	}



	public void setNconverted_mana(String nconverted_mana) {
		Nconverted_mana = nconverted_mana;
	}



	public String getNpower() {
		return Npower;
	}



	public void setNpower(String npower) {
		Npower = npower;
	}



	public String getNToughness() {
		return NToughness;
	}



	public void setNToughness(String nToughness) {
		NToughness = nToughness;
	}



	public String getNloyalty() {
		return Nloyalty;
	}



	public void setNloyalty(String nloyalty) {
		Nloyalty = nloyalty;
	}



	public String getNability() {
		return Nability;
	}



	public void setNability(String nability) {
		Nability = nability;
	}



	public String getNflavor() {
		return Nflavor;
	}



	public void setNflavor(String nflavor) {
		Nflavor = nflavor;
	}



	public String getNvariation() {
		return Nvariation;
	}



	public void setNvariation(String nvariation) {
		Nvariation = nvariation;
	}



	public String getNartist() {
		return Nartist;
	}



	public void setNartist(String nartist) {
		Nartist = nartist;
	}



	public String getNnumber() {
		return Nnumber;
	}



	public void setNnumber(String nnumber) {
		Nnumber = nnumber;
	}



	public String getNrating() {
		return Nrating;
	}



	public void setNrating(String nrating) {
		Nrating = nrating;
	}



	public String getNruling() {
		return Nruling;
	}



	public void setNruling(String nruling) {
		Nruling = nruling;
	}



	public String getNcolor() {
		return Ncolor;
	}



	public void setNcolor(String ncolor) {
		Ncolor = ncolor;
	}



	public String getNgenerated_mana() {
		return Ngenerated_mana;
	}



	public void setNgenerated_mana(String ngenerated_mana) {
		Ngenerated_mana = ngenerated_mana;
	}



	public String getNpricing_low() {
		return Npricing_low;
	}



	public void setNpricing_low(String npricing_low) {
		Npricing_low = npricing_low;
	}



	public String getNpricing_mid() {
		return Npricing_mid;
	}



	public void setNpricing_mid(String npricing_mid) {
		Npricing_mid = npricing_mid;
	}



	public String getNpricing_high() {
		return Npricing_high;
	}



	public void setNpricing_high(String npricing_high) {
		Npricing_high = npricing_high;
	}



	public String getNback_id() {
		return Nback_id;
	}



	public void setNback_id(String nback_id) {
		Nback_id = nback_id;
	}



	public String getNwatermark() {
		return Nwatermark;
	}



	public void setNwatermark(String nwatermark) {
		Nwatermark = nwatermark;
	}



	public String getNname_CN() {
		return Nname_CN;
	}



	public void setNname_CN(String nname_CN) {
		Nname_CN = nname_CN;
	}



	public String getNname_TW() {
		return Nname_TW;
	}



	public void setNname_TW(String nname_TW) {
		Nname_TW = nname_TW;
	}



	public String getNname_FR() {
		return Nname_FR;
	}



	public void setNname_FR(String nname_FR) {
		Nname_FR = nname_FR;
	}



	public String getNname_DE() {
		return Nname_DE;
	}



	public void setNname_DE(String nname_DE) {
		Nname_DE = nname_DE;
	}



	public String getNname_IT() {
		return Nname_IT;
	}



	public void setNname_IT(String nname_IT) {
		Nname_IT = nname_IT;
	}



	public String getNname_JP() {
		return Nname_JP;
	}



	public void setNname_JP(String nname_JP) {
		Nname_JP = nname_JP;
	}



	public String getNname_PT() {
		return Nname_PT;
	}



	public void setNname_PT(String nname_PT) {
		Nname_PT = nname_PT;
	}



	public String getNname_RU() {
		return Nname_RU;
	}



	public void setNname_RU(String nname_RU) {
		Nname_RU = nname_RU;
	}



	public String getNname_ES() {
		return Nname_ES;
	}



	public void setNname_ES(String nname_ES) {
		Nname_ES = nname_ES;
	}



	public String getNname_KO() {
		return Nname_KO;
	}



	public void setNname_KO(String nname_KO) {
		Nname_KO = nname_KO;
	}



	public String getNlegality_Block() {
		return Nlegality_Block;
	}



	public void setNlegality_Block(String nlegality_Block) {
		Nlegality_Block = nlegality_Block;
	}



	public String getNlegality_Standard() {
		return Nlegality_Standard;
	}



	public void setNlegality_Standard(String nlegality_Standard) {
		Nlegality_Standard = nlegality_Standard;
	}



	public String getNlegality_Extended() {
		return Nlegality_Extended;
	}



	public void setNlegality_Extended(String nlegality_Extended) {
		Nlegality_Extended = nlegality_Extended;
	}



	public String getNlegality_Modern() {
		return Nlegality_Modern;
	}



	public void setNlegality_Modern(String nlegality_Modern) {
		Nlegality_Modern = nlegality_Modern;
	}



	public String getNlegality_Legacy() {
		return Nlegality_Legacy;
	}



	public void setNlegality_Legacy(String nlegality_Legacy) {
		Nlegality_Legacy = nlegality_Legacy;
	}



	public String getNlegality_Vintage() {
		return Nlegality_Vintage;
	}



	public void setNlegality_Vintage(String nlegality_Vintage) {
		Nlegality_Vintage = nlegality_Vintage;
	}



	public String getNlegality_Highlander() {
		return Nlegality_Highlander;
	}



	public void setNlegality_Highlander(String nlegality_Highlander) {
		Nlegality_Highlander = nlegality_Highlander;
	}



	public String getNlegality_French_Commander() {
		return Nlegality_French_Commander;
	}



	public void setNlegality_French_Commander(String nlegality_French_Commander) {
		Nlegality_French_Commander = nlegality_French_Commander;
	}



	public String getNlegality_Commander() {
		return Nlegality_Commander;
	}



	public void setNlegality_Commander(String nlegality_Commander) {
		Nlegality_Commander = nlegality_Commander;
	}



	public String getNlegality_Peasant() {
		return Nlegality_Peasant;
	}



	public void setNlegality_Peasant(String nlegality_Peasant) {
		Nlegality_Peasant = nlegality_Peasant;
	}



	public String getNlegality_Pauper() {
		return Nlegality_Pauper;
	}



	public void setNlegality_Pauper(String nlegality_Pauper) {
		Nlegality_Pauper = nlegality_Pauper;
	}



	public Baraja getBaraja() {
		return baraja;
	}



	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
	
	
	

}

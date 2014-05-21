package io.github.danigt91.cardbuilder.entity;

import java.util.HashSet;
import java.util.Set;

public class Baraja {
	
	/* Entity properties */
	private String _id;
	private String Nname;
	private String Ncode;
	private String Ncode_magiccards;
	private String Ndate;
	private String Nis_promo;
	
	/* Relations */
	private Set<Carta> cartas;
	
	public Baraja(){
		cartas = new HashSet<Carta>();
	}
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNname() {
		return Nname;
	}
	public void setNname(String nname) {
		Nname = nname;
	}
	public String getNcode() {
		return Ncode;
	}
	public void setNcode(String ncode) {
		Ncode = ncode;
	}
	public String getNcode_magiccards() {
		return Ncode_magiccards;
	}
	public void setNcode_magiccards(String ncode_magiccards) {
		Ncode_magiccards = ncode_magiccards;
	}
	public String getNdate() {
		return Ndate;
	}
	public void setNdate(String ndate) {
		Ndate = ndate;
	}
	public String getNis_promo() {
		return Nis_promo;
	}
	public void setNis_promo(String nis_promo) {
		Nis_promo = nis_promo;
	}
	
	public Set<Carta> getCartas(){
		return cartas;
	}	
	public void setCartas(Set<Carta> cartas){
		this.cartas = cartas;
	}
	
	

}

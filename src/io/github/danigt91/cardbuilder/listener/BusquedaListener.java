package io.github.danigt91.cardbuilder.listener;

import java.util.ArrayList;

public interface BusquedaListener {
	
	public void onBusquedaSimple(String nombre);
	
	public void onBusquedaAvanzada(ArrayList<String> criterios);
	
}

package io.github.danigt91.cardbuilder.async;

public class MyHttpPostObject {
	
	public String host, accion;
	public String[][] parametros;
	
	public MyHttpPostObject(String host, String accion, String[][] parametros){
		
		this.host = host;
		this.accion = accion;
		this.parametros = parametros;
		
	}

}

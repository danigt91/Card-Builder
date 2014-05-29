package io.github.danigt91.cardbuilder.listener;

import android.content.Context;

public interface LoginListener {
	
	public void onPeticionFinalizada(Context context, boolean exito, String codigo);

}

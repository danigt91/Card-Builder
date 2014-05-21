package io.github.danigt91.cardbuilder.activity;

import io.github.danigt91.cardbuilder.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class FavoritosActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoritos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favorito, menu);
		return true;
	}

}

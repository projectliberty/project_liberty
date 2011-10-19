package de.handwerker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import de.handwerker.kunden.KundenActivity;
import de.handwerker.model.Kunde;

public class HandwerkerAppActivity extends Activity {
	private ImageButton btnKunden;
	private ImageButton btnAuftraege;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findeAlleKompoenenten();

		btnKunden.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				final List<Kunde> kunden = new ArrayList<Kunde>();
				Kunde k1 = new Kunde();
				k1.setName("Mueller");
				kunden.add(k1);
				Intent intent = new Intent(HandwerkerAppActivity.this,
						KundenActivity.class);
				intent.putExtra("kunden", (ArrayList<Kunde>) kunden);
				startActivity(intent);

			}
		});

		btnAuftraege.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

			}
		});
	}

	private void findeAlleKompoenenten() {
		btnKunden = (ImageButton) findViewById(R.id.imageButton1);
		btnAuftraege = (ImageButton) findViewById(R.id.imageButton2);
	}
}
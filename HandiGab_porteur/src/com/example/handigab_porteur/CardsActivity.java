package com.example.handigab_porteur;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;

public class CardsActivity extends Activity {
	private static final String PREFS_CARD1 = "card1";
	private static final String PREFS_CARD2 = "card2";
	private ArrayList<String> card1;
	private ArrayList<String> card2;
	private ArrayList<String> prefNames;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards);
		
		prefNames.add("cardNumber");
		prefNames.add("date");
		prefNames.add("lastName");
		prefNames.add("firstName");
		prefNames.add("bankName");
		prefNames.add("cardType");
		
		fillCards();
		
		fillPreferences(PREFS_CARD1,card1);
		fillPreferences(PREFS_CARD2,card2);
		
		createButton(prefNames,card1);
		createButton(prefNames,card2);
	}
	
	public void fillCards() {
		card1.add("1111222233334444");
		card1.add("1111");
		card1.add("Dupont");
		card1.add("Pierre");
		card1.add("Societe Generale");
		card1.add("CB");
		
		card2.add("4444333322221111");
		card2.add("0101");
		card2.add("Dupont");
		card2.add("Pierre");
		card2.add("BNP");
		card2.add("Visa");
	}

	public void fillPreferences(String pref, ArrayList<String> card) {

		SharedPreferences settings = getSharedPreferences(pref, 0);
		SharedPreferences.Editor editor = settings.edit();
		
		if(!prefNames.isEmpty() && !card.isEmpty()) {
			for (int i=0; i<prefNames.size();i++)
				editor.putString(prefNames.get(i),card.get(i));
			editor.commit();
		}
	}
	
	public void createButton(ArrayList<String> prefNames, ArrayList<String> card1) {
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cards, menu);
		return true;
	}

}

package com.example.handigab_porteur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CardsActivity extends Activity {
	int nbCard=0;
	public static final String PREFS_CARD1 = "card1";
	public static final String PREFS_CARD2 = "card2";
	ArrayList<String> card1; 
	ArrayList<String> card2; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards);
		
		nbCard=2;
		card1 = new ArrayList<String>(); 
		card2 = new ArrayList<String>(); 
		
		//cardInfo("card1",card1);
		cardPreferences(PREFS_CARD1,card1);
		
		//cardInfo("card2",card2);
		cardPreferences(PREFS_CARD2,card2);
		
		createButton(1,PREFS_CARD1,card1);
		createButton(2,PREFS_CARD1,card2);

	}
	
	public void createButton(int i,String pref, ArrayList<String> card){
		Button btn = new Button(this);
		btn.setId(i);
		btn.setText("N¡ "+card.get(0));
		
		btn.setBackgroundResource(R.drawable.button_normal_xml);
		btn.setTag(pref);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String pref = v.getTag().toString();
				Intent intent = new Intent(CardsActivity.this, ServiceActivity.class);
				intent.putExtra("pref",pref);
				startActivity(intent);
			}
		});
		
		LinearLayout l = (LinearLayout)this.findViewById(R.id.cardsLayout);
		l.addView(btn);
	}
	
	public void cardInfo(String info,ArrayList<String> card){
		card = new ArrayList<String>(); 	
		try{
			InputStream ips=new FileInputStream("src/com/example/handigab_porteur/"+info); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				card.add(ligne);
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public void cardPreferences(String prefs_card, ArrayList<String> card){	
		SharedPreferences settings = getSharedPreferences(prefs_card, 0);
		SharedPreferences.Editor editor = settings.edit();	
		
		String cardNumber="9999999999999999";
		String date="0114";
		String lastName="DUPONT";
		String firstName="Alice";
		String bankName="Societe Generale";
		String cardType="Visa";
		
		card.add(cardNumber);
		card.add(date);
		card.add(lastName);
		card.add(firstName);
		card.add(bankName);
		card.add(cardType);
	
		editor.putString("cardNumber",card.get(0));
		editor.putString("date",card.get(1));
		editor.putString("lastName",card.get(2));
		editor.putString("firstName",card.get(3));
		editor.putString("bankName",card.get(4));
		editor.putString("cardType",card.get(5));
		
		editor.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cards, menu);
		return true;
	}

}

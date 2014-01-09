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
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

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

		String cardNumber="1234567890123456";
		String date="0115";
		String lastName="DUPONT";
		String firstName="Alice";
		String bankName="Societe Generale";
		String cardType="Visa";

		cardPreferences(PREFS_CARD1,card1,cardNumber,date,lastName,firstName,bankName,cardType);

		card2 = new ArrayList<String>();	
		//cardInfo("card1",card1);

		cardNumber="0987654321098765";
		date="0116";
		lastName="DUPONT";
		firstName="Alice";
		bankName="Le Credit Lyonnais";
		cardType="Mastercard";

		//cardInfo("card2",card2);
		cardPreferences(PREFS_CARD2,card2,cardNumber,date,lastName,firstName,bankName,cardType);

		createButton(1,PREFS_CARD1,card1);
		createButton(2,PREFS_CARD2,card2);

		TextView tv = (TextView)this.findViewById(R.id.infoClient);
		tv.setText("Bonjour " + firstName +" "+lastName+"!");
	}

	public void createButton(int i,String pref, ArrayList<String> card){
		Space sp = new Space(this);
		sp.setPadding(0, 10, 0, 10);
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
		l.addView(sp);
		l.addView(btn);
	}

	public void cardInfo(String info,ArrayList<String> card){
		card = new ArrayList<String>(); 	
		try{
			//InputStream ips = getAssets().open(info);
			InputStream ips=new FileInputStream(""+info); 
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


	public void cardPreferences(String prefs_card, ArrayList<String> card, String cardNumber,
			String date,String lastName, String firstName,String bankName,String cardType){	
		SharedPreferences settings = getSharedPreferences(prefs_card, 0);
		SharedPreferences.Editor editor = settings.edit();	

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

}

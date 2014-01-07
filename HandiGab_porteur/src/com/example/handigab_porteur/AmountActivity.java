package com.example.handigab_porteur;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AmountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.amount, menu);
		return true;
	}

	public void display(View v) {
		TextView tv = (TextView)this.findViewById(v.getId());
		String amount = tv.getText().toString();
		
		TextView amountTV = (TextView)this.findViewById(R.id.pinAmount);
		String txt = amountTV.getText().toString();
		
		if (txt.indexOf("Montant incorrect")>=0) txt="";
		amountTV.setText(txt+amount);
	}
	
	public void correct(View v) {
		TextView tv = (TextView)this.findViewById(R.id.pinAmount);
		
		CharSequence pinSeq = tv.getText();
		
		if(pinSeq.length()>0){
			CharSequence corrected = pinSeq.subSequence(0, pinSeq.length()-1);
			tv.setText(corrected);
		}
	}
	
	public void stop(View v) {
		Intent intent = new Intent(this, WithdrawalActivity.class);
		startActivity(intent);
	}
	
	public void validate(View v) {
		TextView tv = (TextView)this.findViewById(R.id.pinAmount);
		String pinString = tv.getText().toString();
		
		if(Integer.parseInt(pinString)%10 ==0) {
			Intent intent = new Intent(this, WithdrawalActivity.class);
			intent.putExtra("amount", pinString);
			startActivity(intent);
		} else
			tv.setText("Montant incorrect");
	}
}

package com.example.remindme;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class RemindActivity extends Activity {
	private PowerManager.WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PowerManager pm = (PowerManager) getSystemService(this.POWER_SERVICE);
		wl=pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "My wake log");
		wl.acquire();
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
				|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON, WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
				|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		setContentView(R.layout.activity_remind);
		Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(2000);
		String type=getIntent().getStringExtra("type");		
		ReadFile r = new ReadFile(getApplicationContext(),type.toLowerCase()+".txt");
		ArrayList<Quote> quotes=r.getQuotes();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(quotes.size());
		Quote quote=quotes.get(randomInt);
//		TypedArray images=getResources().obtainTypedArray(R.drawable.water);
//		int a=images.getResourceId(1, -1);
		TextView header = (TextView)findViewById(R.id.header);
		header.setText(quote.getHeader());
		TextView quote_text = (TextView)findViewById(R.id.quote);
		quote_text.setText(quote.getQuote());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.remind, menu);
		return true;
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		wl.release();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

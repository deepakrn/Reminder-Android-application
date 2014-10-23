package com.example.remindme;

import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ReminderActivity extends WakefulBroadcastReceiver{

	
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		Toast t = Toast.makeText(context, "Received", Toast.LENGTH_LONG);
		t.show();
		
		Intent intent1 = new Intent(context, RemindActivity.class);
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    context.startActivity(intent1);
	}
}

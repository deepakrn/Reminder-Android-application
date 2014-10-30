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

public class AlarmReceiver extends WakefulBroadcastReceiver{

	
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub		
		String remindertype=intent.getStringExtra("type");
		Intent reminderIntent = new Intent(context, RemindActivity.class);
		reminderIntent.putExtra("type", remindertype);
		reminderIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    context.startActivity(reminderIntent);
	}
}

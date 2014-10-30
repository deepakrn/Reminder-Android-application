package com.example.remindme;

import java.util.ArrayList;
import java.util.Calendar;



import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends Activity {
	ArrayList<Topic> topics=new ArrayList<Topic>();	
	ListView reminderList=null;					//contains list of reminder topics that are stored in the topics file.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		ReadFile rTopics = new ReadFile(this, "topics.txt");	//Getting topics from file topics.txt. 
		topics=rTopics.getTopics();					//reading the file and getting the topics				
		populateListView();
	}

	private void populateListView() {
		ArrayAdapter<Topic> reminderListAdapter = new ReminderListAdapter(this,R.layout.reminder_item,topics);
		reminderList=(ListView) findViewById(R.id.list);
		reminderList.setAdapter(reminderListAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

package com.example.remindme;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	ArrayList<Topic> topics=new ArrayList<Topic>();
	ListView reminderList=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getReminderTopics();
		populateListView();
	}

	private void getReminderTopics() {
		// TODO Auto-generated method stub
		
		topics.add(new Topic(R.drawable.abc_ab_solid_dark_holo,"Drink Water",30));
		topics.add(new Topic(R.drawable.abc_ab_solid_dark_holo,"New Topic",60));
		topics.add(new Topic(R.drawable.abc_ab_solid_dark_holo,"Clean",60));
		topics.add(new Topic(R.drawable.abc_ab_solid_dark_holo,"Priming",60));		
	}

	private void populateListView() {
		ArrayAdapter<Topic> reminderListAdapter = new ReminderListAdapter(this,R.layout.reminder_item,topics,R.layout.reminder_item);
		reminderList=(ListView) findViewById(R.id.reminderList);
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

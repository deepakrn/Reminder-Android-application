package com.example.remindme;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.AlarmManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ReminderListAdapter extends ArrayAdapter<Topic> {
	private ArrayList<Topic> reminderList = null;
	Context context;
	int currentPosition;
	
	public Intent intentsOpen;
	private int reminder_item;
	public Calendar calendar;
	public ReminderListAdapter(Context context, 
			int textViewResourceId, ArrayList<Topic> reminderList,int reminder_item) {
		super(context,textViewResourceId,reminderList);
		this.reminderList=reminderList;
		this.context=context;
		this.reminder_item=reminder_item;
		
		// TODO Auto-generated constructor stub
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		 
		
		
		calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		View itemView = convertView;
		if(convertView==null){				
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			itemView = inflater.inflate(reminder_item, parent,false);
		}
		int i=0;
		Topic currentTopic=reminderList.get(position);
		Button imageView = (Button)itemView.findViewById(R.id.button);
		imageView.setBackgroundResource(R.drawable.ic_launcher);
		TextView t = (TextView)itemView.findViewById(R.id.topic);
		t.setText(currentTopic.getName());
		TextView description = (TextView)itemView.findViewById(R.id.description);
		description.setText(currentTopic.getDescription());		
		t.setOnClickListener(new CustomOnClickListener(t,i));
		Switch s = (Switch)itemView.findViewById(R.id.toggle);
		this.currentPosition=position;
		s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			private int currentPosition= ReminderListAdapter.this.currentPosition;	
			private PendingIntent pendingIntent;
			private AlarmManager alarmManager;
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
				Intent intentsOpen = new Intent(context, ReminderActivity.class);
				pendingIntent = PendingIntent.getBroadcast(context,111, intentsOpen, 0);
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				
				alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 10000, pendingIntent);
				//alarmManager.set(AlarmManager.RTC_WAKEUP, 2000, pendingIntent);
				Topic topic =reminderList.get(currentPosition);
				Toast t = Toast.makeText(context, "Changed "+topic.getName(), 2000);
				t.show();
				}
				else{
					alarmManager.cancel(pendingIntent);
				}
			}
		});

		return itemView;
		
	}
	
	
	
}

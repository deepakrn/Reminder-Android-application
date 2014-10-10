package com.example.remindme;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ReminderListAdapter extends ArrayAdapter{
	private ArrayList<Topic> reminderList = null;
	Context context;
	private int reminder_item;
	public ReminderListAdapter(Context context, 
			int textViewResourceId, ArrayList<Topic> reminderList,int reminder_item) {
		super(context,textViewResourceId,reminderList);
		this.reminderList=reminderList;
		this.context=context;
		this.reminder_item=reminder_item;
		
		// TODO Auto-generated constructor stub
	}
	public View getView(int position, View convertView, ViewGroup parent) {
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
		t.setOnClickListener(new CustomOnClickListener(t,i));
//		return super.getView(position, convertView, parent);
		return itemView;
	}

}

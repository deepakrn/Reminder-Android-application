package com.example.remindme;

import java.util.ArrayList;
import android.content.res.AssetManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFile {
public ArrayList<Topic> topics=new ArrayList<Topic>();
public String fileName;
public Context context;
public ReadFile(Context context,String fileName){
	this.fileName=fileName;
	this.context=context;
}
public ArrayList<Topic> getTopics(){
	AssetManager assetManager = context.getResources().getAssets();
	InputStream inputStream = null;
	
	try{
	inputStream = assetManager.open(fileName);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	String sLine;
	while((sLine=reader.readLine())!=null){	
		String[] s=sLine.split("\\$");
		String topic = s[0];
		String description = s[1];
		String status=s[2];
		Topic t=new Topic(R.drawable.abc_ab_bottom_solid_dark_holo,topic,description);
		if(status.equals("on"))
			t.setStatus(true);
		topics.add(t);
		
			
	}	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return topics;
}
public ArrayList<Quote> getQuotes(){
	AssetManager assetManager = context.getResources().getAssets();
	InputStream inputStream = null;
	ArrayList<Quote> quotes = new ArrayList<>();
	try{
	inputStream = assetManager.open(fileName);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	String sLine;
	while((sLine=reader.readLine())!=null){	
		String[] s=sLine.split("\\$");
		String header = s[0];
		String quote = s[1];
		quotes.add(new Quote(header,quote));
	}	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return quotes;
}
}
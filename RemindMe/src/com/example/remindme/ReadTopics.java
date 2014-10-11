package com.example.remindme;

import java.util.ArrayList;
import android.content.res.AssetManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadTopics {
public ArrayList<Topic> topics=new ArrayList<Topic>();
public String fileName;
public Context context;
public ReadTopics(Context context,String fileName){
	this.fileName=fileName;
	this.context=context;
}
public void getTopics(){
	AssetManager assetManager = context.getResources().getAssets();
	InputStream inputStream = null;
	ArrayList<String> distinctTopics=new ArrayList<String>();
	try{
	inputStream = assetManager.open(fileName);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	String sLine;
	while((sLine=reader.readLine())!=null){	
		String[] s=sLine.split("\\$");
		String topic = s[0];
		String description = s[1];
		topics.add(new Topic(R.drawable.abc_ab_bottom_solid_dark_holo,topic,description));
	}	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
}
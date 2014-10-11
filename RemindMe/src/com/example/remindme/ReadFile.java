package com.example.remindme;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

public class ReadFile {
public String fileName;
public InputStream inputStream;
ArrayList<Topic> topics;
public AssetManager assetManager;
public Context context;
public ReadFile(String fileName,Context context){
	this.fileName=fileName;
	topics = new ArrayList<Topic>();	
	this.context=context;
}
public ArrayList<String> getDistinctTopics(){
	assetManager = context.getResources().getAssets();
	InputStream inputStream = null;
	ArrayList<String> distinctTopics=new ArrayList<String>();
	try{
	inputStream = assetManager.open(fileName);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	String sLine;
	while((sLine=reader.readLine())!=null){	
		String[] s=sLine.split("\\$");
		String topic = s[0];
		if(!distinctTopics.contains(topic))
			distinctTopics.add(topic);
		String heading = s[1];
		String content = s[2];
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return distinctTopics;
}
}

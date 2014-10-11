package com.example.remindme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import android.content.res.AssetManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CustomOnClickListener implements OnClickListener {
	public int i;
	public View v;
	public CustomOnClickListener(View v,int i) {
		// TODO Auto-generated constructor stub
		this.i=i;
		this.v=v;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		i++;
		TextView t= (TextView)v;
		try {
			
		    BufferedReader inputReader = new BufferedReader(new FileReader("data.txt"));
		    
		    String inputString;
		    StringBuffer stringBuffer = new StringBuffer();                
		    while ((inputString = inputReader.readLine()) != null) {
		        stringBuffer.append(inputString + "\n");
		    }
		    t.setText(stringBuffer);
		    
		} catch (IOException e) {
			t.setText("Exception");
		    e.printStackTrace();
		}
//		if(i%2==0)
//			t.setText("asdasdasasd");
//		else
//			t.setText("Toggling again");
	}

}

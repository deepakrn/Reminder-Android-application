package com.example.remindme;

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
		if(i%2==0)
		t.setText("asdasdasasd");
		else
			t.setText("Toggling again");
	}

}

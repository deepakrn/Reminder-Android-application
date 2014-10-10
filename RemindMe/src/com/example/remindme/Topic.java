package com.example.remindme;

public class Topic {
private int icon;
private String name;
private int minutes;
public Topic(int icon,String name,int minutes){
	this.icon=icon;
	this.name=name;
	this.minutes=minutes;
}
public int getIcon() {
	return icon;
}
public void setIcon(int icon) {
	this.icon = icon;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMinutes() {
	return minutes;
}
public void setMinutes(int minutes) {
	this.minutes = minutes;
}


}

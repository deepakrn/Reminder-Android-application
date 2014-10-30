package com.example.remindme;

public class Topic {
private int icon;
private String name;
private int minutes;
private boolean status;
private String description;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Topic(int icon,String name,String description){
	this.icon=icon;
	this.name=name;
	this.description=description;
	status=false;
}
public int getIcon() {
	return icon;
}

public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
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

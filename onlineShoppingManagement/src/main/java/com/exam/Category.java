package com.exam;

public class Category {
int id;
String name;

public Category() {
	super();
	// TODO Auto-generated constructor stub
}

public Category(String name) {
	super();
	this.name = name;
}

public Category(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

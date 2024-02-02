package com.entities;

public class Role {
private int roleid;
private String rolename;
private String Description;
public Role(int roleid, String rolename, String description) {
	this.roleid = roleid;
	this.rolename = rolename;
	Description = description;
}
public Role() {
	
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}

}

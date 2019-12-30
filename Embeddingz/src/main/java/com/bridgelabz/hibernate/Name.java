package com.bridgelabz.hibernate;

import javax.persistence.Embeddable;

@Embeddable //it doesnt creates another Name table in DB instead it embedds the data in person Table itself.
public class Name 
{
	private String fname;
	private String mname;
	private String lname;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return "Name [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	
	

}

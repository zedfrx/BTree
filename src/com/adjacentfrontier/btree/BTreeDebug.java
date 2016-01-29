package com.adjacentfrontier.btree;

public class BTreeDebug {
	
	public Boolean debug = true;
	
	public void writeDebug(String function, String message) {
		if (this.debug) {
			System.out.println("DEBUG: " + super.getClass().getCanonicalName() + "." + function + ": "+ message);
		}
	}

	public void setDebug(Boolean flag) {
		this.debug = flag;
	}
}

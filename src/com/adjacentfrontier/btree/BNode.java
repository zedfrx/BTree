package com.adjacentfrontier.btree;

public class BNode extends BTreeDebug{
	
	private Boolean debug = true;
	public int count;
	public int order;
	public String [] values;
	public BNode [] children;
	//public BNode parent;

	public BNode(int order) {
		this.count = 0;
		this.order = order;
		
		values = new String[order];
		children = new BNode[order + 1];
		
		writeDebug("constructor", "initialised, order: " + order);
		writeDebug("constructor", "Values.length:      " + values.length);
		writeDebug("constructor", "Children.length:    " + children.length);
	}
	
	public String getValue(int index) {
		return values[index];
	}
	
	public BNode getChild(int index) {
		return children[index];
	}
	
	public Boolean isLeaf() {
		// the node can self-determine if it's a leaf or not
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				writeDebug("isLeaf", "FALSE");
				return false;
			}
		}
		writeDebug("isLeaf", "TRUE");
		return true;
	}
	
	public Boolean isFull() {
		// simple check to see if it's full
		if (count == order) {
			writeDebug("isFull", "TRUE");
			return true;
		}
		writeDebug("isFull", "FALSE");
		return false;
	}
}

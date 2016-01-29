package com.adjacentfrontier.btree;

public class BTree extends BTreeDebug{
	
	// class variables 
	private static int order;
	private Boolean debug = true;
	public BNode root;

	public BTree(int order) {
		this.order = order;
		this.root = new BNode(order);
		//root.setDebug(true);
	}
	
	
	public String find(String value) {
		
		return "";
	}
	
	public BNode searchTree(BNode current, String value) {
		return null;
	}
	
	
	public void insert(String value) {
		if (root.isLeaf()) {
			pushIn(root, value);
		}
	}
	
	public void pushIn(BNode current, String newValue) {
		// check for duplicates
		for (int j = 0; j < current.values.length; j++) {
			if (current.values[j] != null) {
				if (current.values[j].compareTo(newValue) == 0) {
					writeDebug("pushIn", "duplicate value found {" + newValue + "} discarding");
					return;
				}
			}
		}
		// start at the end and move backwards through array shifting values right until we find the place to insert
		// assumes that the BNode.isLeaf and BNode.isFull checks have been performed before calling pushIn
		for (int i = current.values.length - 1; i >= 0; i--) {
			if (i == 0) {
				// empty array or newValue is the lowest entry and we've moved everything out the way
				current.values[i] = newValue;
				writeDebug("pushIn", "Inserting value: " + newValue + " @ index: " + i);
				return;
			} else if (current.values[i] == null && current.values[i - 1] == null) {
				// do nothing as we need to move further down the array
			} else if (current.values[i - 1].compareTo(newValue) < 0) {
				// newValue is the larger that the next on the left so we put it in
				current.values[i] = newValue;
				writeDebug("pushIn", "Inserting value: " + newValue + " @ index: " + i);
				return;
			} else {
				// newValue is less than the value on the left so make room and move it right a spot
				// also ensure's we aren't inserting duplicates
				current.values[i] = current.values[i - 1];
				current.values[i - 1] = null;
				current.children[i] = current.children[i - 1];
				current.children[i - 1] = null;
			}
		}
	}
	
	public void pushDown (BNode newNode) {
		
	}
	
	public void splitNode(BNode left, BNode right) {
		
	}
	
	public void printTree() {
		System.out.println("\n#########################################################");
		printTree(root, "");
		System.out.println("#########################################################\n");
	}
	
	private void printTree (BNode current, String indent) {
		
		// print all node data
		System.out.print(indent + "  [");
		for (int x = 0; x < current.values.length; x++) {
			System.out.print("{");
			if (current.values[x] == null) {
				System.out.print("x");
			} else {
				System.out.print(current.values[x]);
			}
			System.out.print("}");
		}
		System.out.print("]\n");
		
		// print all children links (if any)
		System.out.print(indent + "[");
		for (int y = 0; y < current.children.length; y++) {
			System.out.print("{");
			if (current.children[y] == null) {
				System.out.print("_");
			} else {
				System.out.print("*");
			}
			System.out.print("}");
		}
		System.out.print("]\n");
		
		// iterate all children
		for (int y = 0; y < current.children.length; y++) {
			if (current.children[y] != null) {
				printTree(current.children[y], indent + "\t");
			}
		}
	}
}

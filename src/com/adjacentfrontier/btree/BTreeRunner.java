package com.adjacentfrontier.btree;

public class BTreeRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BTree testBtree = new BTree(4);
		
		testBtree.printTree();
		
		testBtree.insert("c");
		testBtree.insert("h");
		testBtree.insert("n");
		testBtree.insert("x");
		
		testBtree.printTree();

	}

}

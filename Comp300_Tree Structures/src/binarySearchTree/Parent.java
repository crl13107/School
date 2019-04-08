package binarySearchTree;

public interface Parent<Item> {

	public BinaryNode<Item> getChild(int direction);
	
	public void setChild(int direction, BinaryNode<Item> child);
	
}

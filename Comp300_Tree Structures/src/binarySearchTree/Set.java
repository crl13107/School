package binarySearchTree;

public interface Set<Item> {
	/**
	 * Add an item to set - avoid duplicates
	 */
	public Set<Item> add(Item target);
	
	/**
	 * Returns true if set contains target
	 */
	
	public boolean contains(Item target);
	
	/**
	 * remove target from set
	 */
	public void remove(Item target);
	
	/**
	 * Return the number of elements in this set
	 */
	
	public int size();
	
}

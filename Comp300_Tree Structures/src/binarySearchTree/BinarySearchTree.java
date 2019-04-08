package binarySearchTree;

import arrayStructures.EmptyStructureException;

public class BinarySearchTree<Item extends Comparable<Item>> implements Parent<Item>, Set<Item> {

	/* Root node */
	protected BinaryNode<Item> root;

	/* zero argument constructor */
	public BinarySearchTree() {
		root = null;
	}

	@Override
	public Set<Item> add(Item target) {
		Parent<Item> parent = this;
		BinaryNode<Item> node = root;
		int comparison = 0;

		while (node != null) {
			comparison = target.compareTo(node.getItem());
			if (comparison < 0) {
				// go left
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0) {
				return this;
			} else {
				parent = node;
				node = node.getRight();
			}
		}
		parent.setChild(comparison, new BinaryNode<Item>(target));
		return this;
	}

	@Override
	public boolean contains(Item target) {
		BinaryNode<Item> node = root;

		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0) {
				node = node.getLeft();
			} else if (comparison == 0) {
				return true;
			} else {
				node = node.getRight();
			}
		}
		return false;
	}

	@Override
	public void remove(Item target) {
		Parent<Item> parent = this;
		BinaryNode<Item> node = root;
		int direction = 0;
		if (root == null)
			throw new EmptyStructureException();
		while (node != null) {
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0) {
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0) {
				spliceOut(node, (BinaryNode<Item>) parent, direction);
				return;
			} else {
				parent = node;
				node = node.getRight();
			}
			direction = comparison;
		}

	}

	protected void spliceOut(BinaryNode<Item> node, BinaryNode<Item> parent, int direction) {

		if (node.getLeft() == null) {
			parent.setChild(direction, node.getRight());
		} else if (node.getRight() == null) {
			parent.setChild(direction, node.getRight());
		} else {
			node.setItem(removeLeftMost(node.getRight(), node));
		}
	}

	private Item removeLeftMost(BinaryNode<Item> node, BinaryNode<Item> parent) {
		int direction = 1;
		while (node.getLeft() != null) {
			parent = node;
			direction = -1;
			node = node.getLeft();
		}

		Item result = node.getItem();
		spliceOut(node, parent, direction);
		return result;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BinaryNode<Item> node) {
		if (node == null)
			return 0;
		return (1 + size(node.getLeft()) + size(node.getRight()));
	}

	/*
	 * new array queue // enqueue root // queue // if node.left != null,
	 * enqueue // if node.right != null, enqueue | node.get item | he
	 * said use array stack?
	 */
	
	public int depth() {
		return depth(root);
	}

	private int depth(BinaryNode<Item> node) {
		if (node == null) {

			return 0;
		} else {
				int lDepth = depth(node.getRight());
				int rDepth = depth(node.getLeft());
				if (lDepth > rDepth)
					return lDepth + 1;
					else
					return rDepth+1;
		}
	}
				


	@Override
	public BinaryNode<Item> getChild(int direction) {
		return root;
	}

	@Override
	public void setChild(int direction, BinaryNode<Item> child) {
		root = child;

	}

	public String toStringInOrder() {
		if (root == null)
			throw new EmptyStructureException();
		return root.toStringInOrder();
	}
}

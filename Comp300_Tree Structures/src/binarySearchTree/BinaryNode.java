package binarySearchTree;

import arrayStructures.ArrayQueue;
import arrayStructures.Queue;

public class BinaryNode<Item> implements Parent<Item> {

	private Item item;

	private BinaryNode<Item> left;
	private BinaryNode<Item> right;

	public BinaryNode(Item item) {
		this.item = item;
	}

	public BinaryNode(Item item, BinaryNode<Item> left, BinaryNode<Item> right) {
		this.item = item;
		this.right = right;
		this.left = left;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public BinaryNode<Item> getChild(int direction) {
		if (direction == 0)
			throw new IllegalArgumentException();
		BinaryNode<Item> node = null;
		if (direction < 0)
			node = this.left;
		if (direction > 0)
			node = this.right;
		return node;
	}

	@Override
	public void setChild(int direction, BinaryNode<Item> child) {

		if (direction > 0) {
			this.right = child;
		} else {
			this.left = child;
		}

	}

	public BinaryNode<Item> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<Item> left) {
		this.left = left;
	}

	public BinaryNode<Item> getRight() {
		return right;
	}

	public void setRight(BinaryNode<Item> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (right == null) && (left == null);
	}

	public String toStringInOrder() {
		StringBuffer result = new StringBuffer();

		if (left != null) {
			result.append(left.toStringInOrder());
		}
		result.append(item + " ");

		if (right != null) {
			result.append(right.toStringInOrder());
		}

		return result.toString();
	}

	public String toStringLevelOrder() {
		StringBuffer result = new StringBuffer();
		Queue<BinaryNode<Item>> queue = new ArrayQueue<>();
		queue.enqueue(this);

		while (!queue.isEmpty()) {

			BinaryNode<Item> node = queue.dequeue();
			result.append(node);
			if (node.left != null)
				queue.enqueue(node.left);
			if (node.right != null)
				queue.enqueue(node.right);

		}
		return result.toString();
	}
}

package binaryTree;

import java.util.Arrays;
import java.util.concurrent.DelayQueue;

import arrayStructures.ArrayQueue;
import arrayStructures.ArrayStacks;
import arrayStructures.Queue;
import arrayStructures.Stack;

public class BinaryNodeInClass<Item> {

	private Item item;

	private BinaryNodeInClass<Item> left;
	private BinaryNodeInClass<Item> right;

	public BinaryNodeInClass(Item item) {
		this.item = item;
	}

	public BinaryNodeInClass(Item item, BinaryNodeInClass<Item> left, BinaryNodeInClass<Item> right) {
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

	public BinaryNodeInClass<Item> getLeft() {
		return left;
	}

	public void setLeft(BinaryNodeInClass<Item> left) {
		this.left = left;
	}

	public BinaryNodeInClass<Item> getRight() {
		return right;
	}

	public void setRight(BinaryNodeInClass<Item> right) {
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
		result.append(item);

		if (right != null) {
			result.append(right.toStringInOrder());
		}

		return result.toString();
	}
	
	public String toStringPreOrder(){
		String result = "";
		if (getItem()!= null)
		result += getItem();
		if (left != null){
		result+= getLeft().toStringPreOrder();
		}
		if (right!= null){
		result+= getRight().toStringPreOrder();
		}
		return result;
		}
	
	public String toStringPostOrder(){
	String result = "";
	
	if (left != null)
	result+= getLeft().toStringPostOrder();
	if (right != null)
	result+= getRight().toStringPostOrder();
	result += getItem();
	
	return result;
	
	}
	


	
	

	public String toStringLevelOrder() {
		StringBuffer result = new StringBuffer();
		Queue<BinaryNodeInClass<Item>> queue = new ArrayQueue<>();
		queue.enqueue(this);

		while (!queue.isEmpty()) {
			queue.dequeue();
			@SuppressWarnings("unchecked")
			Queue<BinaryNodeInClass<Item>> item = (Queue<BinaryNodeInClass<Item>>) queue.dequeue();
			result.append(item);

			if (this.left != null) {
				queue.enqueue(left);
			}
			if (this.right != null) {
				queue.enqueue(right);
			}

		}

		return result.toString();
	}

	public String toStringDepthFirst() {
		// starts bottom, then backtrack
		StringBuffer result = new StringBuffer();
		Stack<BinaryNodeInClass<Item>> stack = new ArrayStacks<>();

		stack.push(this);
		while (!stack.isEmpty()) {
			// todo
		}
		return result.toString();
	}

	public static void main(String[] args) {
		BinaryNodeInClass<String> a = new BinaryNodeInClass<String>("a");
		BinaryNodeInClass<String> b = new BinaryNodeInClass<String>("b");
		BinaryNodeInClass<String> c = new BinaryNodeInClass<String>("c");
		BinaryNodeInClass<String> d = new BinaryNodeInClass<String>("d");
		BinaryNodeInClass<String> e = new BinaryNodeInClass<String>("e");
		BinaryNodeInClass<String> f = new BinaryNodeInClass<String>("f");
		BinaryNodeInClass<String> g = new BinaryNodeInClass<String>("g");
		BinaryNodeInClass<String> p = new BinaryNodeInClass<String>("p");
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		e.setLeft(p);
		System.out.println(a.toStringInOrder());
		System.out.println(a.toStringPostOrder());
		System.out.println(a.toStringPreOrder());
		//System.out.println(a.toStringLevelOrder());

	}
}

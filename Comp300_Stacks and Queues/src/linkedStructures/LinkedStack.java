/**
 * 
 */
package linkedStructures;

import java.util.EmptyStackException;
import java.util.Iterator;


import arrayStructures.Stack;

/**
 * @author crl486
 *
 */
public class LinkedStack<Item> implements Stack<Item> {

	private class Node {
		Item item;
		Node next;
	}

	private Node top;
	private int size;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>() {

			Node node = top;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public Item next() {
				Item item = node.item;
				node = node.next;
				return item;
			}
		};
		return iterator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arrayStructures.Stack#peek()
	 */
	@Override
	public Item peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return top.item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arrayStructures.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(Item item) {
		Node oldTop = top;
		top = new Node();
		top.item = item;
		top.next = oldTop;
		size++;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arrayStructures.Stack#pop()
	 */
	@Override
	public Item pop() {
		if (isEmpty())
			throw new EmptyStackException();
		Item item = top.item;
		top = top.next;
		size--;
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see arrayStructures.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> stack = new LinkedStack<>();
		
		
		stack.push("It was");
		stack.push("the best");
		stack.push("of times");
		stack.push("it was");
		stack.pop();
		stack.push("the worst");
		stack.push("of times.");

		for (String s : stack)
			System.out.println(s);

		while (!stack.isEmpty())
			System.out.println(stack.pop());

	}

}

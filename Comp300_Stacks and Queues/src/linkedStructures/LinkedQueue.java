/**
 * 
 */
package linkedStructures;

import java.util.Iterator;

import arrayStructures.EmptyStructureException;
import arrayStructures.Queue;

/**
 * @author crl486
 *
 */
public class LinkedQueue<Item> implements Queue<Item> {

	private int size = 0;
	private Node head = null;
	private Node tail = null;

	private class Node {
		Item item;
		Node next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>() {

			Node node = head;

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

	@Override
	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = null;

		Node tail = head;
		// Empty queue condition
		if (head == null) {
			head = node;
			tail = head;
			return;
		}

		tail.next = node;
		tail = node;
		size++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty())
			throw new EmptyStructureException();
		Item item = head.item;
		head = head.next;
		size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;

	}

	@Override
	public int size() {

		return size;
	}

	public String tostring() {
		StringBuffer buffer = new StringBuffer();
		for (Item item : this) {
			buffer.append(item + " ");
		}
		return buffer.toString();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

}

package arrayStructures;

import java.util.Iterator;

public class ArrayQueue<Item> implements Queue<Item> {

	private int size;
	private Item[] data;
	private int head = 0;
	private int tail = 0;

	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		data = (Item[]) new Object[1];
	}

	private void resize(int length) {
		int index = head;

		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[length];

		for (int i = 0; i < size; i++) {
			temp[i] = data[index++];

			index %= data.length;
		}
		head = 0;
		data = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>() {

			int n = 0; // index

			@Override
			public boolean hasNext() {
				return n <= size;

			}

			@Override
			public Item next() {
				Item item = data[n++];
				n = (n + 1) % data.length;
				return item;
			}

		};
		return iterator;
	}

	@Override
	public void enqueue(Item item) {

		if (size == data.length) {
			resize(data.length * 2);
		}
		data[(head + size) % data.length] = item;
		size++;
	}

	@Override
	public Item dequeue() {
		// compress array if it is three quarters empty
		if (size <= data.length / 4) {
			resize(data.length / 2);
		}
		if (isEmpty())
			throw new EmptyStructureException();

		Item item = data[head];
		data[head] = null;
		head = (head + 1) % data.length;
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

	public static void main(String[] args) {
		Queue<String> queue = new ArrayQueue<>();
		queue.enqueue("It was");
		queue.enqueue("the best of");
		queue.enqueue("times");
		queue.enqueue("It was");
		queue.enqueue("the worst");
		queue.enqueue("of times");
		System.out.println("Dequed- " + queue.dequeue());
		System.out.println("Queue compontents:");
		System.out.println("Dequed- " + queue.dequeue());

		for (String s : queue) {
			System.out.println(s);
		}
	}

}
//linked list can hit cache memory list, especially on smaller hard-drives
/*
 * knuth shuffle
 * floyd's algorithm
 * n log n?
 * 
 */

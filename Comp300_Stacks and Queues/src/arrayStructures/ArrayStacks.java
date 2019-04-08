package arrayStructures;

import java.util.Iterator;

public class ArrayStacks<Item> implements Stack<Item> {

	// iterator
	// iterable data structure

	/*
	 * 1)make data structure iterable(support for each loop) 2)iterator cards?
	 */
	private Item[] data;
	private int size = 0;

	private boolean isFull() {
		return (size == data.length);
	}

	@SuppressWarnings("unchecked")
	public ArrayStacks() {
		data = (Item[]) new Object[1];
		size = 0;
	}

	@Override
	public Item peek() {
		if (isEmpty())
			throw new EmptyStructureException();
		return data[size - 1];
	}

	@Override
	public void push(Item item) {
		if (isFull()) {
			resize(data.length * 2);
		}
		data[size++] = item;
	}

	private void resize(int length) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[length];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	@Override
	public Item pop() {
		if (isEmpty())
			throw new EmptyStructureException();
		if (size <= data.length / 4)
			resize(data.length / 2);
		Item item = data[--size];
		data[size] = null;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		Stack<String> stack = new ArrayStacks<>();
		stack.push("It was");
		stack.push("the best");
		stack.push("of times");

		stack.pop();
		stack.push("it was");
		stack.push("the worst");
		stack.push("of times.");

		for (String s : stack)
			System.out.println(s);

		while (!stack.isEmpty())
			System.out.println(stack.pop());
	}

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>() {
			private int index = size;

			@Override
			public boolean hasNext() {
				return index > 0;

			}

			@Override
			public Item next() {
				return data[--index];

			}
		};
		return iterator;

		// Lambda function instead
		// split method
	}
}

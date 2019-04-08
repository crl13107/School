package binaryTree;

public class Binary<Item> {

	private Item item;

	private Binary<Item> left;
	private Binary<Item> right;

	public Binary(Item item) {
		this.item = item;
	}

	public Binary(Item item, Binary<Item> left, Binary<Item> right) {
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

	public Binary<Item> getLeft() {
		return left;
	}

	public void setLeft(Binary<Item> left) {
		this.left = left;
	}

	public Binary<Item> getRight() {
		return right;
	}

	public void setRight(Binary<Item> right) {
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

	public String toStringLevelOrder() { //
		StringBuffer result = new StringBuffer();
		//

		return result.toString();
	}

	public static void main(String[] args) {
		Binary<String> n1 = new Binary<String>("a");
		Binary<String> n2 = new Binary<String>("b");
		Binary<String> n3 = new Binary<String>("c", n1, n2);
		System.out.println(n3.toStringInOrder());
	}
}

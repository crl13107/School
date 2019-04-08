package binarySearchTree;

public class RandomizedBinarySearchTree<E extends Comparable<E>> extends BinarySearchTree<E> {

	public static boolean bernoulli(double p) {
		if (p > 1.0)
			p = 1.0;
		return Math.random() < p;
	}

	public BinaryNode<E> rotateLeft(BinaryNode<E> node) {
		BinaryNode<E> v = node.getRight(); // get right child of the node
		node.setRight(v.getLeft()); // the node right sub tree becomes child's
									// left subtree
		// now the node will be attached to the left sub tree of the child
		v.setLeft(node);
		return v;
	}

	public BinaryNode<E> rotateRight(BinaryNode<E> node) {
		BinaryNode<E> v = node.getLeft(); // get left child of the node
		node.setLeft(v.getRight()); // the node left sub tree becomes child's
									// right subtree
		// now the node will be attached to the right sub tree of the child
		v.setRight(node);
		return v;
	}

	private BinaryNode<E> addRoot(BinaryNode<E> node, E target) {
		if (node == null) {
			return new BinaryNode<E>(target);
		}
		int comparison = target.compareTo(node.getItem());

		if (comparison < 0) {
			node.setLeft(addRoot(node.getRight(), target));
			node = rotateRight(node);
		} else if (comparison > 0) {
			node.setRight(addRoot(node.getLeft(), target));
			node = rotateLeft(node);
		}

		return node;
	}

	@Override
	public Set<E> add(E target) {
		BinaryNode<E> node = root;

		// toss the coin
		double n = 1.0 / (this.size() + 1.0);
		if (bernoulli(n)) {
			root = addRoot(node, target);
		} else {
			super.add(target);
		}
		return this;
	}
}

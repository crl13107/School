package crl486.binaryTree;
public class BinaryNode<E>{

	private E item;
	private BinaryNode<E> left;
	private BinaryNode<E> right;
	// Left and right are set to null by default
	
	public BinaryNode(E item){
		this.item = item;
	}
	
	public BinaryNode(E item, 
			BinaryNode<E> left, 
			BinaryNode<E> right){
		this.item = item;
		this.right = right;
		this.left = left;
	}
	
	public E getItem(){
		return item;
	}
	
	public BinaryNode<E> getLeft(){
		return this.left;
	}
	
	public BinaryNode<E> getRight(){
		return this.right;
	}
	
	public void setLeft(BinaryNode<E> left){
		this.left = left;
	}
	
	public void setRight(BinaryNode<E> right){
		this.right = right;
	}
	
	public void setItem(E item){
		this.item = item;
	}
	
	public boolean isLeaf(){
		return (left == null) & (right == null);
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
	
	public String toStringInOrder(){
		String result = "";
		
		if (left != null){
			result += left.toStringInOrder();
		}
		result += item;
		if (right != null){
			result += right.toStringInOrder();
		}

		return result;
	}
	


}
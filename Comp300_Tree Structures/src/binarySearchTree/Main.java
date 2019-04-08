package binarySearchTree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<>();
		Scanner kbd = new Scanner(System.in);
		System.out.println("Enter a string - ");
		String input = kbd.nextLine();

		String[] data = input.split("\\s+");

		for (String s : data) {
			bst.add(s);
		}
		System.out.println(bst.toStringInOrder());

		System.out.println("Enter item to remove");
		String st = kbd.nextLine();
		bst.remove(st);

		System.out.println(bst.toStringInOrder());
		System.out.println("Size of tree is " + bst.size());
		System.out.println("dpeth is equal to : " + bst.depth());
		kbd.close();

	}

}

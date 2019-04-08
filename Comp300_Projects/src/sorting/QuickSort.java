package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	private static void exch(@SuppressWarnings("rawtypes") Comparable[] a, int i, int j) {
		@SuppressWarnings("rawtypes")
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@SuppressWarnings("unchecked")
	private static boolean less(@SuppressWarnings("rawtypes") Comparable a,
			@SuppressWarnings("rawtypes") Comparable b) {
		int ret = a.compareTo(b);

		return (ret < 0);

	}

	private static void shuffle(@SuppressWarnings("rawtypes") Comparable[] a) {
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			int j = i + rand.nextInt(a.length - i);
			exch(a, i, j);
		}
	}

	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length - 1);

	}

	private static void sort(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static void printArray(@SuppressWarnings("rawtypes") Comparable[] a) {
		for (@SuppressWarnings("rawtypes")
		Comparable e : a)
			System.out.print(e + " ");
		System.out.println();
	}

	private static int partition(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {

		int i = lo, j = hi + 1;

		while (true) {
			while (less(a[++i], a[lo]))
				if (i == hi)
					break;
			while (less(a[lo], a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j); // exchange ith and jth
		}
		exch(a, lo, j); // Exchange pivot and j
		return j;
	}

	public static void main(String[] args) {
		Integer[] arr = { 3, 45, 34, 34, 5, 6, 2, 8, 5, 34, 23, 45, 765, 67, 45, 23, 876, 34, 132, 654, 12, 42, 76 };
		System.out.print("Before sorting: ");
		printArray(arr);
		Arrays.sort(arr);
		System.out.print("After sorting:  ");
		printArray(arr);
		Arrays.sort(arr); // primitive = quick(assumes lack of memory); wrapper
							// class = merge(assumes memory)
	}

}

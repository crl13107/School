package sorting;

public class MergeSort {

	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;

	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(@SuppressWarnings("rawtypes") Comparable[] a, int low, int high) {
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
		merge(a, low, mid, high);

	}

	@SuppressWarnings("unused")
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

	private static void merge(@SuppressWarnings("rawtypes") Comparable[] a, int low, int mid, int high) {
		int i = low, j = mid + 1;

		for (int k = low; k <= high; k++) {
			aux[k] = a[k];

		}
		for (int k = low; k <= high; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > high)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];

		}
	}

	public static void printArray(@SuppressWarnings("rawtypes") Comparable[] a) {
		for (@SuppressWarnings("rawtypes")
		Comparable c : a)
			System.out.print(c + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] arr = { 3, 56, 54, 23, 43, 35, 12, 12, 64, 345, 32, 23, 34, 23, 539, 2222, 23, 23, 23, 43, 53, 653,
				13, 1234, 12, 12 };
		System.out.println("Before sorting...");
		printArray(arr);

		sort(arr);
		System.out.println("after sorting...");
		printArray(arr);
	}

}

// stable sort: keeps order of numbers that entered
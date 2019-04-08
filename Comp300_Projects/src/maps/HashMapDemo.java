package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		String str = "aba";
		System.out.println(str.length());
		
		
		HashMap<Integer, String> map = new HashMap<>(256, 0.7f);

		map.put(01, "Krish");
		map.put(02, "Tom");
		map.put(03, "Harry");
		map.put(04, "Janet");
		map.put(05, "Mary");

		System.out.println(map.get(3));
		map.remove(02);
		System.out.println(map.get(02));
		System.out.println(map.size());

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		Iterator<Entry<Integer, String>> iter = entrySet.iterator();

		while (iter.hasNext()) {
			// can't do for loop because items can be missing
			Entry<Integer, String> entry = iter.next();
			System.out.println("Key = " + entry.getKey());
			System.out.println("Value = " + entry.getValue());
		}
	}

}

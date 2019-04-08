package rbtrees;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap<Integer, String> tmap = new TreeMap<>();

		tmap.put(1, "Krish");
		tmap.put(2, "Tom");
		tmap.put(3, "Mary");
		tmap.put(4, "Andrea");

		if (tmap.containsKey(3)) {
			System.out.println("Key 3 is containted in map");
			System.out.println("Value for key 3 is " + tmap.get(3));
		}

		if (tmap.containsValue("Andrea")) {
			System.out.println("Andrea is contained in the map");
		}

		// We have to see this structure as a set
		//

		Set<Entry<Integer, String>> entrySet = tmap.entrySet();
		Iterator<Entry<Integer, String>> iter = entrySet.iterator();

		while (iter.hasNext()) {
			Entry<Integer, String> entry = iter.next();
			System.out.println("Key  = " + entry.getKey());
			System.out.println("Value = " + entry.getValue());
			System.out.println("---");
		}
	}

}

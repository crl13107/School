package matching;

public class KnuthMorrisPrattStringMatcher extends AbstractStringMatcher {

	private int[] prefixArray;

	protected KnuthMorrisPrattStringMatcher(String pattern) {
		super(pattern);
		prefixArray = new int[pattern.length()];

		int i = 1;
		int matches = 0;
		while (i < getPattern().length()) {
			if (getPattern().charAt(i) == getPattern().charAt(matches)) {
				matches++;
				prefixArray[i] = matches;
				i++;
			} else if (matches > 0) {
				matches = prefixArray[matches - 1];
			} else {
				i++;
			}
		}
	}

	@Override
	public int match(String text) {
		int i = 0;
		int matches = 0;
		while (i < text.length()) {
			if (text.charAt(i) == getPattern().charAt(matches)) {
				matches++;
				if (matches == getPattern().length()) {
					return i + 1 - getPattern().length();
				} else {
					i++;
				}
				// if condition
			} else if (matches > 0) {
				matches = prefixArray[matches - 1];
			} else {
				i++;
			}

		}
		return -1;
	}

}

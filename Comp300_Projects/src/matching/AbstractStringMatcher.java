package matching;

public abstract class AbstractStringMatcher {

	private String pattern;
	//private?
	protected AbstractStringMatcher(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	protected boolean matchAt(String text, int position) {
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(i + position))
				return false;
		}
		return true;
	}

	/*
	 * return the index of the first occurrence of the pattern in text, or -1 if
	 * it doesn't exist
	 */

	public abstract int match(String text);

}

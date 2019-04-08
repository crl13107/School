package matching;

public class RabinKarpStringMatcher extends AbstractStringMatcher {

	public static final int MODULUS = 65521;

	public static final int RADIX = (Character.MAX_VALUE + 1) % MODULUS;

	/* fingerprint for the pattern */
	private int patternPrint;

	/* value of a 1 in the highest place in the pattern */
	private int highPlace;

	public RabinKarpStringMatcher(String pattern) {
		super(pattern);
		patternPrint = initialFringerPrint(pattern, pattern.length());
		highPlace = 1;
		for (int i = 1; i < pattern.length(); i++) {
			highPlace = (highPlace * RADIX) % MODULUS;
		}
	}

	private int initialFringerPrint(String pattern, int length) {
		int result = 0;
		for (int i = 0; i < length; i++) {
			result = (result * RADIX) % MODULUS;
			result = (result + pattern.charAt(i)) % MODULUS;
		}
		return result;
	}

	@Override
	public int match(String text) {

		int textPrint = initialFringerPrint(text, getPattern().length());

		for (int position = 0; position + getPattern().length() <= text.length(); position++) {
			if ((textPrint == patternPrint) && matchAt(text, position)) {
				return position;
			}

			// else slide window forward
			textPrint -= (highPlace * text.charAt(position)) % MODULUS;
			if (textPrint < 0) {
				textPrint += MODULUS * (1 + (-textPrint / MODULUS));
			}

			// shift over
			textPrint = (textPrint * RADIX) % MODULUS;
			// now add right character
			textPrint += text.charAt(position + getPattern().length());

			textPrint %= MODULUS;
		}
		return -1;
	}

}

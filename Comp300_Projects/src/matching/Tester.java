package matching;

public class Tester {

	public static void main(String[] args) {
		String text = "amanaplanacanalpanama";
		String pattern = "plan";

		AbstractStringMatcher nm = new NaiveStringMatcher(pattern);
		AbstractStringMatcher rk = new RabinKarpStringMatcher(pattern);
		AbstractStringMatcher kmp = new KnuthMorrisPrattStringMatcher(pattern);
		
		
		System.out.println("Match using Naive at " + nm.match(text));
		System.out.println("Match using RK at " + rk.match(text));
		System.out.println("Match using KMP at " + kmp.match(text));
	}

}

package whatever;


public class RegexDemo {

	public static void main(String[] args) {
		// Match any number - integer or floating point
		// regex => [0-9]*[\\.]*[0-9]+		
		System.out.println("abcd01234".matches("\\d*\\.*\\d+"));
		System.out.println("abcd01234.456".matches("\\d*\\.*\\d+"));
		System.out.println("".matches("\\d*\\.*\\d+")); 
		System.out.println("12345".matches("\\d*\\.*\\d+"));
		System.out.println("0.12345".matches("\\d*\\.*\\d+"));
		System.out.println(".12345".matches("\\d*\\.*\\d+"));
		System.out.println(".12345".matches("\\d*\\.*\\d+"));
		System.out.println("*****");
		// Match any operator
		//regex => [*/\\-+]||(sqrt)]
		System.out.println("!".matches("[*/\\-+]|(sqrt)"));
		System.out.println("^".matches("[*/\\-+]|(sqrt)"));
		System.out.println("*".matches("[*/\\-+]|(sqrt)"));
		System.out.println("/".matches("[*/\\-+]|(sqrt)"));
		System.out.println("+".matches("[*/\\-+]|(sqrt)"));
		System.out.println("-".matches("[*/\\-+]|(sqrt)"));
		System.out.println("sqrt".matches("[*/\\-+]|(sqrt)"));

	}

}


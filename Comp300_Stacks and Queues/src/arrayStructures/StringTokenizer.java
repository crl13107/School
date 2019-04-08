
package arrayStructures;

public class StringTokenizer {
	public static void main(String[] args) {

		String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

		String[] tokens = expr.split("[\\s]+");
		
		for (String token: tokens){
			if(token.matches("\\d*\\.*\\d+"))
				System.out.println("true");
			else if(token.matches("[*/\\-+]|(sqrt)|"));
				System.out.print("operend)");
			System.out.println(token);
			
		}
	}
}
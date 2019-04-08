/**
 * 
 */
package crl486.Chapter7;

/**
 * @author crl486
 *
 */
public class InheritanceDemoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee joe = new HourlyEmployee("Joe Worker", new Date("January", 1, 2016), 50.50, 40);

		
		HourlyEmployee joe1 = (HourlyEmployee) joe;
		System.out.println("Changing Joe to Josephine...");
		joe.setName("josephine:");
		System.out.println("Joe's record shows that his info is - ");
		System.out.println(joe);
		System.out.println("Joe's pay is " + joe1.getPay());

		SalariedEmployee jane = new SalariedEmployee("Jane worker", new Date("February", 1, 2016), 50000);

		System.out.println(jane);
		System.out.println("jane pay is " + jane.getPay() +" per month");
	}

}

/**
 * 
 */
package crl486.Chapter7;

/**
 * @author crl486
 *
 */
public class SalariedEmployee extends Employee {

	private double salary;

	/**
	 * 
	 */
	public SalariedEmployee() {
		super();
		salary = 0;
	}

	/**
	 * @param name
	 * @param hireDate
	 */
	public SalariedEmployee(String name, Date hireDate, double salary) {
		super(name, hireDate);
		if (salary >= 0)
			this.salary = salary;
		else {
			System.out.println("Fatal error: negative salary");
			System.exit(0);
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param that
	 */
	public SalariedEmployee(SalariedEmployee that) {
		super(that);
		salary = that.salary;
		// TODO Auto-generated constructor stub
	}

	public double getPay() {
		return salary / 12;
	}
	
	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary >= 0)
			this.salary = salary;
		else {
			System.out.println("Fatal error: Negative salary!");
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		return getName() + " " + getHireDate() 
		+ "\n$" + " " + salary + "per year";
	}
	public boolean equals(SalariedEmployee that){
		return getName().equals(that.getName()) && 
				getHireDate().equals(that.getHireDate()) &&
				salary == that.getSalary();
	}
}

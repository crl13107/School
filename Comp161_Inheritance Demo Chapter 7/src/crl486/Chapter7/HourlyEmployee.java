/**
 * 
 */
package crl486.Chapter7;

/**
 * @author crl486
 *
 */
public class HourlyEmployee extends Employee {

	private double wageRate;
	private double hours;

	public HourlyEmployee() {
		wageRate = 0;
		hours = 0;
	}

	public HourlyEmployee(String theName, Date theDate, double theWageRate, double theHours) {

		super(theName, theDate);

		if (theWageRate >= 0 && theHours >= 0) {
			wageRate = theWageRate;
			hours = theHours;
		} else {
			System.out.println("Fatal error creating hourly employee");
			System.exit(0);
		}
	}

	public double getWageRate() {
		return wageRate;
	}

	public void setWageRate(double wageRate) {
		if (wageRate >= 0)
			this.wageRate = wageRate;
		else
			System.out.println("Fatal error: Negative wage rate!");
		System.exit(0);
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
		if (hours >= 0)
			this.hours = hours;
		else
			System.out.println("Fatal error: Negative hours!");
		System.exit(0);
	}

/*	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (that.getClass() != this.(getClass))
			HourlyEmployee obj = (HourlyEmployee) that;
				
				return false;
		return (getName().equals(that.getName())) && getHireDate().equals(that.getHireDate())
				&& wageRate == that.wageRate && hours == that.hours;
				}
				*/
	

	public String toString() {
		return (getName() + " " + getHireDate().toString() + "\n$" + wageRate + " per hour for " + hours + " hours. ");
	}

	public double getPay() {
		return wageRate * hours;
	}
}

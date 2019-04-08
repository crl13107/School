/**
 * 
 */
package crl486.Chapter7;

/**
 * @author crl486
 *
 */
public class Employee {

	private String name;
	private Date hireDate;

	public Employee() {

	}

	public Employee(String name, Date hireDate) {
		if (name == null || hireDate == null) {
			System.out.println("Fatal error creating Employee object!");
			System.exit(0);
		}
		this.name = name;
		this.hireDate = hireDate;
	}

	/*
	 * employee copy constructor - Deep copy
	 * 
	 */
	public Employee(Employee that) {
		name = that.name;
		if (name == null) {
			System.out.println("Fatal error setting name");
			System.exit(0);
		}
		hireDate = new Date(that.hireDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		// avoid privacy leak
		return new Date(hireDate);
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public boolean eqauls(Object other) {
		if (other == null)
			return false;
		if (this.getClass() != other.getClass())
			return false;
		Employee obj = (Employee) other;
		return name.equals(obj.name) && hireDate.equals(obj.hireDate);
	}
	
	public boolean equalsInocorrect(Object other){
		if (other == null)
			return false;
		if (! (other instanceof Employee))
			return false;
		
		Employee obj = (Employee) other;
		return name.equals(obj.name) && hireDate.equals(obj.hireDate);
	}

	@Override
	public String toString() {
		// ToDO
		return null;
	}

}

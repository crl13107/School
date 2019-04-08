package crl486.Chapter7;

public class Date {

	private String month;
	private int day, year;

	public Date() {
		month = "January";
		day = 1;
		year = 2000;

	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;

	}
	
	public boolean equals(Date other) {
		return (year == other.year) && (day == other.day) && month.equals(other.month);
	}

	@Override
	public String toString() {
		return month + ", " + day + ", " + year;
	}

		/*
		public String toString2()	{
		return name + " " + hireDate.toString();
		 }
		 */
	

	// Copy constructor - Shallow copy of hireDate
	public Date(Date hireDate) {
		month = hireDate.month;
		day = hireDate.day;
		year = hireDate.year;
		// TODO Auto-generated constructor stub

	}

}

/*
 * 
 */

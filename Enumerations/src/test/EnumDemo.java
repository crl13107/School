package test;

public class EnumDemo {

	enum DayOfTheWeek {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
	};

	public static void main(String[] args) {

		DayOfTheWeek hireDay = DayOfTheWeek.Monday;

		DayOfTheWeek hireDateJohn = DayOfTheWeek.Wednesday;
		DayOfTheWeek hireDateJane = DayOfTheWeek.Friday;

		int comp = (hireDateJane.compareTo(hireDateJohn));
		if (comp > 0)
			System.out.println("Jane has seniority - Jane was hired on " + hireDateJane);
		else if (comp < 0)
			System.out.println("John has seniority - John was hired on " + hireDateJohn);
		else
			System.out.println("They are peers");
		
		DayOfTheWeek[] values = DayOfTheWeek.values();
		
		switch(hireDateJohn){
		case Sunday:
		System.out.println("John was hired on a Sunday!");
		break;
		case Monday:
			
			default:
		
		}
	}

}

package crl486.First;

public class EnumDemo {

	enum WorkDay {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public static void main(String[] args) {
		final int SUNDAY = 200;
		// TODO Auto-generated method stub

		WorkDay startDay = WorkDay.MONDAY;
		WorkDay Enday = WorkDay.FRIDAY;
		WorkDay holiday = WorkDay.WEDNESDAY;

		WorkDay myday;

		myday = startDay;

		System.out.println(startDay);

		myday.compareTo(startDay);
		WorkDay.valueOf("MONDAY");
		WorkDay.values();
		switch (myday) {

		case MONDAY:
			// do something
			System.out.println("Yuck");
			break;
		case TUESDAY:
			System.out.println("One more to go!");
		case WEDNESDAY:
			System.out.println("Yay!!");
			break;
		default:

		}

	}

}

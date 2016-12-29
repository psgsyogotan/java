package jpl.ch10.ex03;



public class WorkingDaybySwitch {
	public WorkingDaybySwitch() {

	}

	public boolean workday(Days day) {
		switch (day) {
		case SUNDAY:
		case SATURDAY:
			return false;
		default:
			return true;
		}
	}

}

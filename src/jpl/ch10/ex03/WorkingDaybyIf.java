package jpl.ch10.ex03;


public class WorkingDaybyIf {
	
	public WorkingDaybyIf(){
		
	}

	public boolean workday(Days day) {
		if (day ==Days.SUNDAY)
			return false;
		else if (day == Days.SATURDAY)
			return false;
		else
			return true;

	}
}

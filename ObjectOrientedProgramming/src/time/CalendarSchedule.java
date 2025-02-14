package time;


import java.util.Calendar;
import java.util.Date;

public class CalendarSchedule {

	Calendar calendar = Calendar.getInstance();	//java.util.GregorianCalendar[time=1739499220090,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2025,MONTH=1,WEEK_OF_YEAR=7,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=45,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=0,HOUR=11,HOUR_OF_DAY=11,MINUTE=13,SECOND=40,MILLISECOND=90,ZONE_OFFSET=32400000,DST_OFFSET=0]

	Date date = Calendar.getInstance().getTime();	// Fri Feb 14 11:13:40 KST 2025

	
	
	
	
	
	public static void main(String[] args) {
		CalendarSchedule calendarSchedule = new CalendarSchedule();
		System.out.println(calendarSchedule.calendar.get(Calendar.YEAR)); 			// 2025
		System.out.println(calendarSchedule.calendar.get(Calendar.MONTH) +1); 		// 2
		System.out.println(calendarSchedule.calendar.get(Calendar.DAY_OF_MONTH));	//14
		System.out.println();
		System.out.println(calendarSchedule.calendar.get(Calendar.HOUR));		//11
		System.out.println(calendarSchedule.calendar.get(Calendar.MINUTE));	//16
		System.out.println(calendarSchedule.calendar.get(Calendar.SECOND));	//20
		
		System.out.println(calendarSchedule.calendar.get(Calendar.DAY_OF_WEEK)); //6(금)
		
		System.out.println();
		
		

	}
}

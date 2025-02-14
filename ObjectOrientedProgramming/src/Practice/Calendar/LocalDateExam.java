package Practice.Calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateExam {
	public static void main(String[] args) {
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy년 MM읠 dd일");

		System.out.println(nowDate); // 2025-02-14
		System.out.println(dateFormatter.format(nowDate)); // 2025년 02읠 14일
		System.out.println(DateTimeFormatter.ofPattern("HH시 mm분 ss초").format(nowDate)); // 13시 02분 26초
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:mm:ss").format(nowDate)); // 2025-02-14 / 13:12:35

		
		LocalTime nowTime = LocalTime.of(00, 00, 01);
		nowTime = nowTime.plusHours(10);
		nowTime = nowTime.plusMinutes(5);
		nowTime = nowTime.plusSeconds(55);
		
		System.out.println(nowTime);	//10:05:56
		System.out.println(DateTimeFormatter.ofPattern("HH시 mm분 ss초").format(nowDate));	//13시 15분 51초
		
		LocalDateTime nowDateTime = LocalDateTime.of(2022, 2, 1, 11, 39, 11);
		System.out.println("변경 전: " +DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 / HH시 mm분 ss초").format(nowDateTime));
		nowDateTime = nowDateTime.plusDays(10);
		nowDateTime = nowDateTime.plusMonths(2);
		nowDateTime = nowDateTime.plusYears(3);
		nowDateTime = nowDateTime.plusHours(10);
		nowDateTime = nowDateTime.plusMinutes(5);
		nowDateTime = nowDateTime.plusSeconds(55);
		System.out.println("변경 후: " +DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 / HH시 mm분 ss초").format(nowDateTime));
		
		
		System.out.println("--------------------------------------------------------------------");
		cal(2026, 7, 1);
	}
	
	
	public static void cal(int year, int month, int day) {
		LocalDate startDay = LocalDate.now();
		LocalDate endDay = LocalDate.of(year, month, day);
		
		Period targetDay = Period.between(startDay, endDay);
		System.out.println(targetDay.getYears() + "년 차이, " +  targetDay.getMonths() + "월 차이, " + targetDay.getDays() + "일 차이");
		
	}
	
}

import java.text.SimpleDateFormat;
import java.time.LocalDate;
public class Date {

	private int day, month, year;
	
	public Date()
	{
		day = 1;
		month = 1;
		year = 1;
	}
	public Date(int d, int m, int y)
	{
		//PT -- what if d is <= 0?
		if (d <= checkDays(m)  && y > 0) {
		day = d;
		month = m;
		year = y;
		System.out.println("Date Scheduled.");
		}
		else 
			System.out.printf("Invalid Date!\n");
	}
			
		
	
	public void setDay(int d) {
		day=  d;
	}
	public void setMonth(int m) {
		//PT -- need to be smart in these too. -2
		month = m;
	}
	public void setYear(int y) {
		year = y;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	//PT -- I like this, but you need year, too (leapyear)
	public int checkDays(int m) {
		if (m == 1 || m == 3 || m ==5 || m == 7 || m == 8 || m == 10 || m == 12)
			return 31;
		if (m == 2)
			return 28;
		else
			return 30;
	}
	
	public static Date getToday() {
		LocalDate today = LocalDate.now();
		Date TodayDate = new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
		return TodayDate;
	}
	
	public void CalcDifference(Date d1, Date d2) {
		if (d2.getMonth() > d1.getMonth())
			
	}
	
	
	
	
}

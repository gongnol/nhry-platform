package com.nhry.utils.date;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class DateUtils {
	private static Logger log = Logger.getLogger(DateUtils.class);

	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-ddHHmmss");
		return format.format(new Date());
	}

	public static String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static String formatterDate(Date date, String formater) {
		SimpleDateFormat format = null;
		if (date == null)
			date = new Date();
		if (StringUtils.isEmpty(formater) == true) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			format = new SimpleDateFormat(formater);
		}
    
		String date1 = format.format(date);
		return date1;
	}
	
	/**
	 * 获取上月最后一天
	 * @return
	 */
    public static String getPreviousMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);  
        lastDate.set(Calendar.DATE, 1);  
        lastDate.roll(Calendar.DATE, -1);  
        str = sdf.format(lastDate.getTime());
        return str;
    }

	public static String formatRumtimeplatformDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		try {
			date1 = format.parse(date);
			format = new SimpleDateFormat("yyyy/MM/dd");
			return format.format(date1);
		} catch (ParseException e) {
		}
		return "";
  
	}
	

    public static String getCurrentMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1); 
        str = sdf.format(lastDate.getTime());
        return str;
    }
	
    /**
     * 得到前一天时间
     * @return
     */
    public static String getPreDate() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.DATE, -1); 
        str = sdf.format(lastDate.getTime());
        return str;
    }
    
    public static String getPreviousMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);  
        lastDate.add(Calendar.MONTH, -1);  
        str = sdf.format(lastDate.getTime());
        return str;
    }

	public static String[] getDate_Monday_Sunday(Date date) {
		return getDate_Monday_Sunday(formatDate(date));
	}

	public static String[] getDate_Monday_Sunday(String date) {
		Calendar calendar = null;
		String[] days = date.split("-");
		Integer year = new Integer(days[0]);
		Integer month = new Integer(days[1]);
		Integer day = new Integer(days[2]);
		calendar = new GregorianCalendar(year.intValue(),
				(month.intValue() - 1), day.intValue());

		String startday = null;
		String endday = null;

		int weekx = calendar.get(Calendar.DAY_OF_WEEK);

		if (weekx == 1) {
			weekx = 8;
		}
		calendar.add(Calendar.DAY_OF_WEEK, 2 - weekx);
		startday = calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH);

		calendar.add(Calendar.DAY_OF_MONTH, 6);
		endday = calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH);
		return new String[] { startday, endday };
	}

	public static boolean dateCompare(Date dat1, Date dat2) {
		if (dat1 == null || dat2 == null)
			return false;
		boolean dateComPareFlag = true;
		if (dat2.compareTo(dat1) != 1) {
			dateComPareFlag = false; // 
		}
		return dateComPareFlag;
	}

	public static String dateFormatter(String date, int length) {
		if (date != null && length != 0 && date.indexOf("1900-01-01") == -1) {
			if (date.length() > length)
				return date.substring(0, length);
			return date;

		}
		return "";
	}

 
	public static int equalsMonth(Date begin, Date endDate) {
		Date date1 = begin;
		Date date2 = endDate;
		Calendar myCal1 = Calendar.getInstance();
		Calendar myCal2 = Calendar.getInstance();
		myCal1.setTime(date1);
		myCal2.setTime(date2);
		int year1 = myCal1.get(Calendar.YEAR);
		int year2 = myCal2.get(Calendar.YEAR);
		int month1 = myCal1.get(Calendar.MONTH);
		int month2 = myCal2.get(Calendar.MONTH);
		return (year2 - year1) * 12 - (month1 - month2);
	}

	public static String formatDateYearMonth(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		return format.format(date);
	}

	public static Date addMonths(Date date, int month) {

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	public static int getInterval(String beginMonth, String endMonth) {
		int intBeginYear = Integer.parseInt(beginMonth.substring(0, 4));
		int intBeginMonth = Integer.parseInt(beginMonth.substring(beginMonth
				.indexOf("-") + 1));
		int intEndYear = Integer.parseInt(endMonth.substring(0, 4));
		int intEndMonth = Integer.parseInt(endMonth.substring(endMonth
				.indexOf("-") + 1));
		return ((intEndYear - intBeginYear) * 12)
				+ (intEndMonth - intBeginMonth) + 1;
	}

	public static int eqMonth(Date begin, Date end) {
		String[] beginDate = formatDate(begin).split("-");
		String[] endDate = formatDate(end).split("-");
		int yearFirst = Integer.parseInt(beginDate[0]);
		int monthFirst = Integer.parseInt(beginDate[1]);
		int yearSecond = Integer.parseInt(endDate[0]);
		int monthSecond = Integer.parseInt(endDate[1]);
		int monthsub = (yearFirst - yearSecond) * 12
				+ (monthFirst - monthSecond);
		return monthsub;
	}

	public static int getMonth(Date s, Date e) {
		if (s.after(e)) {
			Date t = s;
			s = e;
			e = t;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(s);
		Calendar end = Calendar.getInstance();
		end.setTime(e);
		Calendar temp = Calendar.getInstance();
		temp.setTime(e);
		temp.add(Calendar.DATE, 1);

		int y = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int m = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);

		if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) { 
			return y * 12 + m + 1;
		} else if ((start.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) { 
			return y * 12 + m;
		} else if ((start.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) { 
			return y * 12 + m;
		} else { 
			return (y * 12 + m - 1) < 0 ? 0 : (y * 12 + m - 1);
		}
	}

	public static int getDay(Date s, Date e) {
		if (s.after(e)) {
			Date t = s;
			s = e;
			e = t;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(s);
		Calendar end = Calendar.getInstance();
		end.setTime(e);
		Calendar temp = Calendar.getInstance();
		temp.setTime(e);
		temp.add(Calendar.DATE, 1);

		if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) { 
			return 0;
		} else if ((start.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return getDayP(start);
		} else if ((start.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return end.get(Calendar.DATE);
		} else {
			if (start.get(Calendar.MONTH) == end.get(Calendar.MONTH)
					&& start.get(Calendar.YEAR) == end.get(Calendar.YEAR)) {
				return end.get(Calendar.DATE) - start.get(Calendar.DATE) + 1;
			} else {
				return getDayP(start) + end.get(Calendar.DATE);
			}
		}
	}
	

	public static String getDefNextDay(Date date) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		return formatDate(lastDate.getTime());
	}

	public static long getDateDay(Date begin, Date end) {
		long between = (end.getTime() - begin.getTime()) / 1000;
		long day = between / (24 * 3600);
		return day;
	}

	public static String getPlanColor(Date planDate) {
		Date currentDate = new Date();
		int day = (int) (planDate.getTime() - currentDate.getTime() / 1000 / 60
				/ 60 / 24 + 1);
		if (day == 7) {
			return "";
		}
		return "";
	}

	public static String getCurrentDayAdd(int field, int amount) {
		return getCurrentDayAdd(new Date(), field, amount);
	}

	public static String getCurrentDayAdd(Date date, int field, int amount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(field, amount);
		String DATE_FORMAT = "yyyy-MM-dd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getDefault());

		return sdf.format(gc.getTime());
	}

	public static int getDayP(Calendar s) {
		int d;
		if (s.get(Calendar.MONTH) == 1 && s.get(Calendar.YEAR) % 4 == 0
				&& s.get(Calendar.YEAR) % 100 != 0) {// ����2��
			d = 29;
		} else {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			m.clear();
			m.put(1, 31);
			m.put(3, 31);
			m.put(5, 31);
			m.put(7, 31);
			m.put(8, 31);
			m.put(10, 31);
			m.put(12, 31);
			m.put(4, 30);
			m.put(6, 30);
			m.put(9, 30);
			m.put(11, 30);
			m.put(2, 28);
			d = m.get(s.get(Calendar.MONTH) + 1);
		}
		return d - s.get(Calendar.DATE) + 1;
	}

	public static int getMonths(Date date1, Date date2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	public static Date formatExcelDate(String date) throws ParseException {

		if (StringUtils.isEmpty(date)) {
			return null;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(date);
	}

	public static Date formatDate(String date) {

		if (StringUtils.isEmpty(date)) {
			return null;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  
	public static String formatterDate(String date, String formatter,
			boolean load) {

		if (StringUtils.isEmpty(date)) {
			date = formatDate(new Date());
		}

		if (StringUtils.isEmpty(formatter) == true)
			formatter = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(formatter);
		try {
			Date d = format.parse(date);
			if (load == true) {

				int month = d.getMonth() + 1;
				if (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12) {
					d.setDate(31);
				} else if (month == 4 || month == 6 || month == 9
						|| month == 11) {
					d.setDate(30);
				} else {
					if (d.getYear() % 400 == 0 || (d.getYear() % 100 != 0)
							&& (d.getYear() % 4 == 0))
						d.setDate(29);
					else
						d.setDate(28);

				}
			}
			return formatDate(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatDate(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static String formatDate(String pattern, Date date) {
		if (date == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static Date formatDate( String date,String pattern) {
		if (date == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	public static String getNextMonthFirst() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1); 
		lastDate.set(Calendar.DATE, 1);
		return formatter.format(lastDate.getTime());
	}
 
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}
 
	public static Date addMonth(int month) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(new Date()) + ((long) month) * 31 * 24
				* 3600 * 1000);
		return c.getTime();
	}

	public static Date addMonth(Date date, int month) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) month) * 31 * 24 * 3600
				* 1000);
		return c.getTime();
	}

	public static int getDay1(Date date1, Date date2) {
		return (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
	}
 
	public static String getNextDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 2);
		lastDate.add(Calendar.DATE, -1);
		return formatter.format(lastDate.getTime());
	}

	public static String getDefNextDay(String date) {
		return getDefNextDay(formatDate(date));
	}
 
	public static String getCurrentNextDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		return formatter.format(lastDate.getTime());
	}

	public static String getCurrentNextDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		return formatter.format(lastDate.getTime());
	}

	public static String getCurrentNextDay(String date) {
		return getCurrentNextDay(formatDate(date));
	}

	public static String getCurrentDay(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return getCurrentDay(formatter.parse(date));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String getCurrentDay() {
		return getCurrentDay(new Date());
	}

	public static String getCurrentDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		return formatter.format(lastDate.getTime());
	}
 
	public static String formatterDecimal(double value, String formatter) {
		if (StringUtils.isEmpty(formatter)) {
			formatter = "###.00";
		}

		try {
			DecimalFormat df1 = new DecimalFormat(formatter);
			return df1.format(value);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

 
	public static long getDateMargin(Date beginDate, Date endDate) {
		long margin = 0;

		margin = endDate.getTime() - beginDate.getTime();

		margin = margin / (1000 * 60 * 60 * 24);

		return margin;
	}

	public static Date getNextDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 2);
		lastDate.add(Calendar.DATE, -1);
		return lastDate.getTime();
	}

	public static String getMONDAYMonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return new SimpleDateFormat("yyyy-MM-dd ").format(c.getTime());
	}

	public static String getFRIDAYonday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		return new SimpleDateFormat("yyyy-MM-dd ").format(c.getTime());
	}

	public static String getColor(String plandate) {
		if (StringUtils.isEmpty(plandate)) {
			return "";
		}
		if(plandate.startsWith("1900")){
			return "";
		}
 
		long begintime = formatDate(plandate).getTime();
		double val =  ((double)(begintime - new Date().getTime()) / 1000 / 60 / 60
				/ 24);
		
		if (begintime < new Date().getTime() && val <= 0) {
			return "red";
		}
		if (val <= 7 && val != 0 &&val>0) {

			return "#FFD700";
		}

		return "";
	} 
}
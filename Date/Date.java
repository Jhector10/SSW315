/* Date.java */
/*
 * Code done by Joshua Hector
 * I pledge my honor that I have abided by the Stevens Honor System
 */

import java.io.*;

class Date {

  /* Put your private data fields here. */
	
	private int month;
	private int year;
	private int day;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	  if (isValidDate(month, day, year) ) {
		  this.month = month;
		  this.day = day;
		  this.year = year;
	  } else {
		  throw new IllegalArgumentException("Not a valid date."); 
	  }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	  String[] date = s.split("/");
	  
	  if (date.length != 3) {
		  throw new IllegalArgumentException("This was an invalid Date string. String must be in the form of month/day/year");
	  }
	  
	  int month = Integer.parseInt(date[0]);
      int day = Integer.parseInt(date[1]);
      int year = Integer.parseInt(date[2]);
      
      if (isValidDate(month, day, year)) {
    	  this.month = month;
		  this.day = day;
		  this.year = year;
      }
      
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
	  if (year % 400 == 0) {
		  return true;
	  } else if (year % 100 == 0) {
		  return false; 
	  } else if (year % 4 == 0) {
		  return true;
	  }
	  return false;
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	  int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	  
	  if (year < 1) {
		  throw new IllegalArgumentException("Any date before 1 AD is invalid");
	  } else if (month < 1 || month > 12) {
		  throw new IllegalArgumentException("Invalid month"); 
	  }
	  else if (Date.isLeapYear(year) && month == 2) {
		  return 29;
	  }
	  return date[month];
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
	  if (year > 0) {
          if (month > 0 && month <= 12) {
              if (day > 0 && day <= daysInMonth(month, year)) {
                  return true;
              }
          }
      }
      return false;
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
	  return this.month + "/" + this.day + "/" + this.year;
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    if (this.year < d.year) {
    	return true;
    } else if (this.month < d.month && this.year == d.year) {
    	return true;
    } else if (this.day < d.day && this.month == d.month && this.year == d.year) {
    	return true;
    } else {
    return false;
    }
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    if (this.isBefore(d) || this == d) {
    	return false;
    } else {
    	return true;
    }
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
	  int days = this.day;
	  
	  if (isValidDate(this.month, this.day, this.year)) {
		  for (int i = 1; i < this.month; i++) {
			  days += daysInMonth(i, this.year); 
		  }
	  } else {
		  throw new IllegalArgumentException("Invalid Date"); 
	  }
	  
	  return days;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    int count = 0;
    int daysInYear = 365;
    
    if (this.year == d.year) {
    	count = this.dayInYear() - d.dayInYear();
    	return count;
    }
    
    Date currentDate;
    Date targetDate;
    boolean neg = false;
    
    if (this.isAfter(d)) {
    	currentDate = d;
    	targetDate = this;
    } else {
    	currentDate = this;
    	targetDate = d;
    	neg = true;
    }
    
    if (isLeapYear(currentDate.year)) {
    	daysInYear = 366;
    }
    
    count += targetDate.dayInYear() + (daysInYear - currentDate.dayInYear()); 
    
    for(int i = currentDate.year + 1; i < targetDate.year; i++) {
    	if (isLeapYear(i)) {
    		count += 366;
    	} else {
    		count += 365;
    	}
    }
    
    if (neg) {
    	return count * -1;
    } else {
    	return count;
    }
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    System.out.println("\nTesting Leap Year.");
    System.out.println("2016 is a Leap Year? Should be true: " + isLeapYear(2016));
    System.out.println("2030 is a Leap Year? Should be false: " + isLeapYear(2030));
    System.out.println("2400 is a Leap Year? Should be true: " + isLeapYear(2400));
    System.out.println("1900 is a Leap Year? Should be false: " + isLeapYear(1900));

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}

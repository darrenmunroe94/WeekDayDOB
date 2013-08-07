import java.util.Scanner;

class WeekDayDOB{
    
    public static void main(String[] args){
        
        Scanner birthdayIn = new Scanner(System.in);
        
        System.out.print("Enter your birthday to ");
        System.out.print("find out the weekday of your birth:");
        System.out.println("\nFor example:\n\t03 27 1991\n");
        
        int month = birthdayIn.nextInt();
        int day = birthdayIn.nextInt();
        int year = birthdayIn.nextInt();
        
        System.out.printf("You were born on %s.", weekDay(month, day, year));
    }
    
    private static String weekDay(int month, int day, int year){
        
        /*if(year < 1990){
        *   int yearDifference = 1990 - year;
        *   year += 1990;
        *}
        */
        
        int yy = year - 1990;
        int total = yy / 20;
        total += yy;
        total += day;
        total += getMonthOffset(month);
        
        if(isLeap(year) == true && month == 1 || month == 2){
            total -= 1;
        }
        
        return weekDayName(total % 7) + " " + getMonthName(month) + " " + day + " " + year;
    }
    
    private static String weekDayName(int weekDayNumber){
        
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",    
                               "Saturday", "Sunday"};
        
        return daysOfWeek[weekDayNumber];
    }
    
    public static String getMonthName(int monthNumber){
 
        String notValidMonth = "Not Listed.\n";
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November",
                               "December"};
 
        if(monthNumber < 1 || monthNumber > 12){
            return notValidMonth; 
        }
 
        return monthNames[monthNumber - 1];
    }
    
    public static int getMonthOffset(int monthNumber){
 
        int notValidOffset = -1;
        int[] monthOffsets = {1,4,4,0,2,5,0,3,6,1,4,6};
 
        if(monthNumber < 1 || monthNumber > 12){
            return notValidOffset; 
        }
 
        return monthOffsets[monthNumber - 1];
    }
    
    public static boolean isLeap( int year ){
  	// years which are evenly divisible by 4 are leap years,
		// but years divisible by 100 are not leap years,
		// though years divisible by 400 are leap years
		boolean result;

		if (year%400 == 0){
			result = true;
		}
		else if (year%100 == 0){
			result = false;
		}
		else if (year%4 == 0){
			result = true;
		}
		else{
			result = false;
		}

		return result;
	}
}

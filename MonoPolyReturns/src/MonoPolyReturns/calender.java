package MonoPolyReturns;
import java.time.Month;

public class calender {
		
		//setting the staring date
		int year = 2016, month = 1, day = 1;
		String[] dayname ={"Friday","SaturDay","SunDay","MonDay","TuesDay","WednesDay","ThursDay"};
		String DayName=dayname[0];
		public calender(){
		      
		 }  
		public String addDay(int year,int month,int day,boolean addOrNot){
			if(addOrNot==true){

						day += 1;
						if (day > 31 && (month == 1||month == 3||month==5||month==7||month == 8||month == 10)){
							month += 1;
							day %= 31;
							GameControl.bank.interestOfBank();
						}
						if (day > 30 && (month == 4||month == 6||month == 9||month ==11)){
							month += 1;
							day %= 30;
							GameControl.bank.interestOfBank();
						}
						if (day > 29 && month == 2 && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
							month += 1;
							day %= 29;
							GameControl.bank.interestOfBank();
						}
						if (day > 28 && month == 2 && !((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))){
							month += 1;
							day %= 28;
							GameControl.bank.interestOfBank();
						}
						if(day>31 && month==12 ){
							month+=1;
							month=month%12;
							year+=1;
							day%=31;
							GameControl.bank.interestOfBank();
						}
						setAllDate(year, month, day);
						
			}
				
		
					return year+"/"+month+"/"+day;
				
		}
		public String toString(){
		    return year+"/"+month+"/"+day;
		}
		public String getDayName() {
			return this.DayName;
		}
		public void setAllDate(int year,int month,int day) {
			this.year=year;
			this.month=month;
			this.day=day;
		}
		public void setDayName(String dayName) {
			DayName = dayName;
		}
		    
		 
		}




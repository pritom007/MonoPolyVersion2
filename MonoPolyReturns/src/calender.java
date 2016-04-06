public class calender {
		
		//setting the staring date
		int year = 2016, month = 1, day = 1;
		int j=0;
		int i=1;
		String[] dayname ={"Friday","SaturDay","SunDay","MonDay","TuesDay","WednesDay","ThursDay"};
		String DayName=dayname[1];
		private int count(int i){
		   if (i%1==0)
					{
						day += 1;
						j++;
						DayName=dayname[j];
							
						if(j==6){
							j=0;
						}
						if (day > 31 && (month == 1||month == 3||month==5||month==7||month == 8||month == 10))
						{
							month += 1;
							day %= 31;
							//GameControl.land.interestOfBank();
						}
						if (day > 30 && (month == 4||month == 6||month == 9||month ==11))
						{
							month += 1;
							day %= 30;
							//GameControl.land.interestOfBank();
						}
						if (day > 29 && month == 2 && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
						{
				
							month += 1;
							day %= 29;
							//GameControl.land.interestOfBank();
						}
						if (day > 28 && month == 2 && !((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)))
						{
							month += 1;
							day %= 28;
							//GameControl.land.interestOfBank();
						}
						if(day==31 && month==12 ){
							month+=1;
							month=month%12;
							year+=1;
							//GameControl.land.interestOfBank();
						}
					}
					return i;
				
		}
		public String toString(){
		    return day+" / "+month+" / "+year;
		}
		    
		  public calender(){
		      
		  }  
		}




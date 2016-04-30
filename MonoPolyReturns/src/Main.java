
import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 *this is the main function
		 *game will start from here with the user input  
		 */		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please help yourself by inputting som information.");
		System.out.print("Enter the number of players:(please enter 2 or more)");
		String totalPlayerString=scanner.next();
		System.out.println();
		while (!GameControl.gameMapping.isInteger(totalPlayerString)||Integer.parseInt(totalPlayerString)<2) {
			System.out.println("Invalid input!");
			System.out.print("\nEnter the number of players(please enter 2 or more):");
			totalPlayerString=scanner.next();
		}
		int totalPlayer=Integer.parseInt(totalPlayerString);
		GameMapping gfr = new GameMapping(totalPlayer); 

		PlayGame playGame= new PlayGame();
		

		//initiate the default map here
		gfr.defaultMap();
		
		System.out.println("==========================================");
		System.out.println("=          Game is Starting Now          =");
		System.out.println("==========================================");
		
		calender calender = new calender();
		
		//System.out.println("Today is "+calender.year+"/"+calender.month+"/"+calender.day);
		playGame.setStockBonus();
		boolean addOrNot=false;
		for(int i=0,j=0;i<gfr.totalPlayer;){
			System.out.println("Today is "+calender.dayname[j]+" "+calender.addDay(calender.year, calender.month, calender.day, addOrNot));
			calender.setDayName(calender.dayname[j]);
			System.out.println("Now it's "+gfr.players[i].playerName+"'s turn to roll the dice.");
			switch (playGame.goForWord(gfr.players[i],gfr)) {
			case 0:
				i++;
				gfr.nextTurn();
				if(i>=gfr.totalPlayer){
					i=0;
					addOrNot=true;
					j=(j+1)%7;
					playGame.setStockBonus();
				}
				else {
					addOrNot=false;
				}	
				break;
			case 1:	
			gfr.nextTurn();
			if(i>=gfr.totalPlayer){
				i=0;
				addOrNot=true;
				j=(j+1)%7;
				playGame.setStockBonus();
			}
			else {
				addOrNot=false;
			}	
			break;
			case -1:
				return;
			default:
				break;
			}
			
		}
		
	}
	

}

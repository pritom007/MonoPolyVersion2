package MonoPolyReturns;
import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 *this is the main function
		 *game will start from here with the user input  
		 */		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please help yourself by inputting some information.");
		System.out.print("Enter the number of players:(please enter 2-4)");
		String totalPlayerString=scanner.next();
		//System.out.println();
		while (!GameControl.gameMapping.isInteger(totalPlayerString)||Integer.parseInt(totalPlayerString)<2||Integer.parseInt(totalPlayerString)>4) {
			System.out.println("Invalid input!");
			System.out.print("\nEnter the number of players(please enter 2-4):");
			totalPlayerString=scanner.next();
		}
		int totalPlayer=Integer.parseInt(totalPlayerString);
		GameMapping gameMap = new GameMapping(totalPlayer); 

		PlayGame playGame= new PlayGame();
		

		//initiate the default map here
		gameMap.defaultMap();
		
		System.out.println("==========================================");
		System.out.println("=          Game is Starting Now          =");
		System.out.println("==========================================");
		//to keep track of the dates
		calender calender = new calender();
		//every day the stock bonus changes randomly
		playGame.setStockBonus();
		//variable to keep track if day addition is needed or not
		boolean addOrNot=false;
		for(int i=0,j=0;i<gameMap.totalPlayer;){
			System.out.println("Today is "+calender.dayname[j]+" "+calender.addDay(calender.year, calender.month, calender.day, addOrNot));
			calender.setDayName(calender.dayname[j]);
			System.out.println("Now it's "+gameMap.players[i].playerName+"'s turn to roll the dice.");
			switch (playGame.goForWord(gameMap.players[i],gameMap)) {
			case 0:
				i++;
				gameMap.nextTurn();
				if(i>=gameMap.totalPlayer){
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
			gameMap.nextTurn();
			if(i>=gameMap.totalPlayer){
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

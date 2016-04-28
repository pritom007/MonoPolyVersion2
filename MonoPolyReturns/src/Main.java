
import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 *this is the main function
		 *game will start from here with the user input  
		 */
		
		//GameFileReader gfr=new GameFileReader();
		
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
		
		/*
		//for printing the map
		for(int i=0;i<gfr.map.length;i++){
			for (int j = 0; j < gfr.map[i].length; j++) {
				if(gfr.map[i][j]!=null)
				System.out.print(gfr.map[i][j]);
				else {
					System.out.print(" ");
				}
			}
		System.out.println();
	}
	
		System.out.println(gfr.posNumOfMap.size());
	*/
		System.out.println("==========================================");
		System.out.println("=          Game is Starting Now          =");
		System.out.println("==========================================");
		
		calender calender = new calender();
		
		//System.out.println("Today is "+calender.year+"/"+calender.month+"/"+calender.day);
		
		boolean addOrNot=false;
		for(int i=0,j=0;i<totalPlayer;){
			System.out.println("Today is "+calender.dayname[j]+" "+calender.addDay(calender.year, calender.month, calender.day, addOrNot));
			System.out.println("Now it's "+gfr.players[i].playerName+"'s turn to roll the dice.");
			if(playGame.goForWord(gfr.players[i],gfr)==0){
				i++;
				if(i==totalPlayer){
					i=0;
					addOrNot=true;
					j=(j+1)%7;
					
				}
				else {
					addOrNot=false;
				}
			}
			else
				break;
		}
		/*
		//give the file loction
		gfr.readFile("F:\\fudan 4th semester\\Object Oriented Programming\\Project1\\MonoPolyVersion2\\MonoPolyReturns\\src\\GameMap.txt");
		//print out the map
		for(int i=0;i<GameControl.gameMapping.map.length;i++){
	    	 for(int j=0;j<GameControl.gameMapping.map[i].length;j++){
	    		 if(GameControl.gameMapping.map[i][j]!=null)
	    		 System.out.print(GameControl.gameMapping.map[i][j]);
	    		 else
	    			 System.out.print(" ");
	    	 }
	    	 System.out.println();
	     }
	     */
		 
		
		
	}
	

}

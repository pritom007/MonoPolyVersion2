
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

import org.omg.CORBA.FREE_MEM;


public class Main {

	public static void main(String[] args) throws IOException {
		
		/*
		 *this is the main function
		 *game will start from here with the user input  
		 */
		
		//GameFileReader gfr=new GameFileReader();
		GameMapping gfr = new GameMapping(); 
		//String inputPlayerName="psad";
		int totalAmount=100000;
		Scanner scanner = new Scanner(System.in);
		
		Player[] players = new Player[2];
		PlayGame playGame= new PlayGame();
		players[0]= new Player("pritom",totalAmount,"*");
		players[1]=new Player("who are u",totalAmount,"=");
		players[0].numberOfPlayer=2;
		players[1].numberOfPlayer=2;
		for(Player p:players){
		System.out.println(p.playerName+" "+p.cashOfPlayer+" "+p.depositOfPlayer);
		}
		
		gfr.defaultMap();
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
		
		for(int i=0;i<2;){
			if(playGame.goForWord(players[i%2],gfr)==0){
				i++;
			}
			if(playGame.goForWord(players[i],gfr)==-1)
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

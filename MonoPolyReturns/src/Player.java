import java.util.Iterator;


public class Player {
	
	//the name of player
	String playerName="player";
	//numbers of player
	int numberOfPlayer;
	//position of player if it is clockwise or anti clock wise 
	String[] position = new String[]{"Clockwise ","Anti Clockwise"};
	int[] positionOfPlayer = new int[]{0,0};//Said the game player direction
	/*
	int[] xCoOrdinate;
	int[] yCoOrdinate;
	*/
	//cash,point,proper of player
	protected int cashOfPlayer = 10000, depositOfPlayer = 10000,
	pointOfPlayer = 30,housePropertyOfPlayer = 0,
	totalMoneyOfPlayer = 20000;
	
	public Player(){
		
	}
	
	//give name and set cash in the beginning of the game
	public Player(String playerName,int cashOfPlayer){
		this.playerName=playerName;
		this.cashOfPlayer=cashOfPlayer;
	}
	
	//all property information of the player
	public void allPlayerInformation(){
		System.out.println("player name\tpoint\tcash\tDeposite\tHouse property\tThe total amount of real estate assets");
		for (int i=0;i<GameControl.player.numberOfPlayer;i++) {
			System.out.println(playerName + "\t\t" + pointOfPlayer + "\t" + cashOfPlayer + "\t" + depositOfPlayer + "\t\t" + housePropertyOfPlayer+ "\t\t" + totalMoneyOfPlayer);
		}
	
	
	}
	

}

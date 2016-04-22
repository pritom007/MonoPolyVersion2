import java.util.Iterator;


public class Player extends GameMapping{
	
	//the name of player
	String playerName="player";
	//Symbol of player
	String symbol="";
	
	//numbers of player
	int numberOfPlayer;
	
	//position of player if it is clockwise or anti clock wise 
	String[] position = new String[]{"Clockwise ","Anti Clockwise"};
	int XpositionOfPlayer = 0;//Said the game player direction
	int YpositionOfPlayer = 0;//Said the game player direction
	int currentPosition=-1;
	/*
	int[] xCoOrdinate;
	int[] yCoOrdinate;
	*/
	
	//cash,point,proper of player
	protected int cashOfPlayer = 10000, depositOfPlayer = 10000,
	pointOfPlayer = 30,housePropertyOfPlayer = 0,
	totalMoneyOfPlayer = cashOfPlayer+depositOfPlayer;
	
	
	//
	String[] cardName = new String[]{"Make the money average card","Turn around card","Roadblocks card","Remote dice card","Plunder Card"};
	int[] numberOfCard = new int[]{5,5,5,100,5};//Game player card number 1
	
	public Player(){
		
	}
	
	//give name and set cash in the beginning of the game
	public Player(String playerName,int cashOfPlayer,String symbol){
		this.playerName=playerName;
		this.cashOfPlayer=cashOfPlayer;
		this.symbol=symbol;
	}
	
	//all property information of the player
	public void allPlayerInformation(Player[] players){
		System.out.println("player name\tpoint\tcash\tDeposite\tHouse property\tThe total amount of real estate assets");
		for (int i=0;i<players.length;i++) {
			System.out.println(players[i].playerName + "\t\t" + players[i].pointOfPlayer + "\t" + players[i].cashOfPlayer + "\t" + players[i].depositOfPlayer + "\t\t" + players[i].housePropertyOfPlayer+ "\t\t" + players[i].totalMoneyOfPlayer);
			//System.out.println(b);
		}
	
	
	}

	public int getXpositionOfPlayer() {
		return XpositionOfPlayer;
	}

	public void setXpositionOfPlayer(int xpositionOfPlayer) {
		XpositionOfPlayer = xpositionOfPlayer;
	}

	public int getYpositionOfPlayer() {
		return YpositionOfPlayer;
	}

	public void setYpositionOfPlayer(int ypositionOfPlayer) {
		YpositionOfPlayer = ypositionOfPlayer;
	}
	public void setAmountOfCard(int cardName){
		this.numberOfCard[cardName]+=1;
	}


	

}

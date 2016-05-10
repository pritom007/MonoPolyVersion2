package MonoPolyReturns;
import java.util.HashMap;
import java.util.Iterator;


public class Player extends GameMapping{
	
	//the name of player
	String playerName="player";
	//Symbol of player
	String symbol="";
	int id;
	//numbers of player
	int numberOfPlayer;
	//position of player if it is clockwise or anti clock wise 
	String[] position = new String[]{"Clockwise ","Anti Clockwise"};
	int XpositionOfPlayer = 0;//Said the game player direction
	int YpositionOfPlayer = 0;//Said the game player direction
	int currentPosition=0,lastPosition,nextPosition;

	//cash,point,proper of player
	protected double cashOfPlayer, depositOfPlayer,
	pointOfPlayer = 30,housePropertyOfPlayer = 0,
	totalMoneyOfPlayer;
	//
	HashMap<String, Integer> stockNewsHashMap= new HashMap<String, Integer>();
	
	//
	String[] cardName = new String[]{"Make the money average card","Turn around card","Roadblocks card","Dice control card","Rob Cards","Cash to Card","Get points Card"};
	int[] numberOfCard = new int[]{5,5,5,100,5,5,5};
	//controller for dice control card
	protected boolean diceControl=false;
	protected boolean stayInPlace=false;
	public boolean freeFromPay=false;
	
	protected boolean[] barricade;
	
	
	public Player(){
		
	}
	
	//give name and set cash in the beginning of the game
	public Player(int id,String playerName,int cashOfPlayer,String symbol){
		this.playerName=playerName;
		this.cashOfPlayer=cashOfPlayer;
		this.symbol=symbol;
		this.id=id;
	}
	
	//all property information of the player
	public void allPlayerInformation(Player[] players){
		System.out.println("player name(symbol)\tpoint\tcash\tDeposite\tHouse property\tThe total amount of real estate assets");
		for (int i=0;i<players.length;i++) {
			System.out.println(players[i].playerName +"("+players[i].symbol+")" +"\t\t" + players[i].pointOfPlayer + "\t" + players[i].cashOfPlayer + "\t" + players[i].depositOfPlayer + "\t\t" + players[i].housePropertyOfPlayer+ "\t\t" + players[i].getTotalMoney(players[i]));

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
	public double getTotalMoney(Player player){
		return player.cashOfPlayer+player.depositOfPlayer+player.housePropertyOfPlayer;
	}

	

}

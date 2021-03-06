package MonoPolyReturns;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GameMapping  {
	//map[Xpos][Ypos]
	private  int Xpos,Ypos;
	//MaxX,MaxY by default we set the size 20x20 (01...19 = 20)
	private int MaxX = 19,MaxY = 19;
	
	protected Map<String, String> mapOfGame = new HashMap<String, String>();
	protected Map<Integer, String> posNumOfMap = new HashMap<Integer, String>(); 
	
	//level of the land
	int[] levelOfLand;
	//names of land 
	String[] nameOfLand;
	//owner of the land 
	String[] ownerOfLand;
	//is there any barricade or not
	boolean[] barricade;
	//barricade owners
	String[] barricadOwner;
 	
	//keeps track of the total number of places
	protected int count = 0;
	//map of the game
	protected String[][] map = new String[10][20];
	
	//
	int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;
	//constructor
	public GameMapping(){
		
	}
	public GameMapping(int totalPlayer) {
		Scanner scanner = new Scanner(System.in);
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < totalPlayer;i++){
			players[i] = new Player();
			players[i].id=i;
			System.out.print("\nplease enter the player name:");
			players[i].playerName=scanner.next();
			System.out.print("\nPlease enter the symbol of the player(enter unique symbol/just 1 character):");
			players[i].symbol=scanner.next().charAt(0)+"";
			players[i].cashOfPlayer=10000;
			players[i].depositOfPlayer=10000;
			players[i].totalMoneyOfPlayer=players[i].getTotalMoney(players[i]);
			System.out.println("\n"+players[i].playerName+"( "+players[i].symbol+" ) has cash of "+players[i].cashOfPlayer+",deposit of "
			+players[i].depositOfPlayer
			+",points of "+players[i].pointOfPlayer);
			players[i].numberOfPlayer=totalPlayer;
			}
	}
	
	//make map from left to right
	private void leftToRight(int from,int to){
		//checks if suggested path is valid "1" is hard coded for leftToRight()
		if(checkMapCreator(from, to, 1)){
			for(;from<to;Ypos++,from++,count++){
					map[Xpos][Ypos] = "�";
					mapOfGame.put( Xpos+"*"+Ypos, map[Xpos][Ypos].toString());
					posNumOfMap.put(count, Xpos+"*"+Ypos);
			}
		}
		else{
			System.out.println("letfToRight(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
	}
	//make map from right to left
	private void rightToLeft(int from,int to){
		if(checkMapCreator(from,to,2)){
			for(;from>to;Ypos--,from--,count++){
				map[Xpos][Ypos] = "�";
				mapOfGame.put(Xpos+"*"+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+"*"+Ypos);
			}
		}
		else{
			System.out.println("rightToLeft"+ "(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}

	}
	//make map from top to bottom
	private void topToBottom(int from,int to){
		if(checkMapCreator(from,to,3)){
			for(;from<to;Xpos++,from++,count++){
				map[Xpos][Ypos] = "�";
				mapOfGame.put(Xpos+"*"+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+"*"+Ypos);
			}
		}
		else{
			System.out.println("topToBottom(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
	}
	//make map from bottom to top
	private void bottomToTop(int from,int to){
		if(checkMapCreator(from,to,4)){
			for(;from>to;Xpos--,from--,count++){
				map[Xpos][Ypos] = "�";
				mapOfGame.put(Xpos+"*"+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+"*"+Ypos);
			}
		}
		else{
			System.out.println("bottomToTop(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
	}
	
	/*
	 * this method verifies if the path that is to be created is valid or not
	 */
	private boolean checkMapCreator(int from,int to,int tbrf) {
		switch (tbrf) {
		case 1:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to<from)?false:true;
		case 2:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to>from)?false:true;
		case 3:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to<from)?false:true;
		case 4:
			return (from<0 ||from>MaxY||to>MaxY||to<0||to>from)?false:true;
		default:
			break;
		}

		return false;
		
	}
	/*
	 * set the other options than land
	 */
	private void setOtherOption(int row,int col,String newOpt){
		map[row][col] = newOpt;
		mapOfGame.put(row+"*"+col, map[row][col]);
		posNumOfMap.put(count, row+"*"+col);
	}
	/*
	 * making a default map for the game
	 * this can be edited
	 */
	public void defaultMap(){
		/*
		leftToRight(0, 3);
		setOtherOption(0, 2, "L");
		topToBottom(0, 3);
		setOtherOption(1, 3, "�");
		rightToLeft(3, 0);
		bottomToTop(3, 0);
		*/
		leftToRight(0, 8);
		setOtherOption(0, 4, "C");
		topToBottom(0, 1);
		leftToRight(8, 10);
		topToBottom(1, 4);
		setOtherOption(1, 10, "N");
		leftToRight(10, 14);
		setOtherOption(4, 13, "�");
		bottomToTop(4, 0);
		leftToRight(14, 19);
		setOtherOption(0, 15,"L");
		setOtherOption(0, 16,"P");
		setOtherOption(0, 17,"P");
		setOtherOption(0, 18,"P");
		setOtherOption(0, 19,"P");
		topToBottom(0, 6);
		setOtherOption(1, 19,"P");
		setOtherOption(2, 19,"P");
		setOtherOption(3, 19,"B");
		setOtherOption(4, 19,"P");
		setOtherOption(5, 19,"P");
		rightToLeft(19, 16);
		setOtherOption(6, 19,"P");
		setOtherOption(6, 18, "P");
		setOtherOption(6, 17, "B");
		topToBottom(6, 8);
		rightToLeft(16, 14);
		bottomToTop(8, 6);
		setOtherOption(7, 14, "S");
		rightToLeft(14, 12);
		topToBottom(6, 9);
		rightToLeft(12, 9);
		setOtherOption(9, 12, "C");
		bottomToTop(9, 6);
		rightToLeft(9, 6);
		setOtherOption(6, 9, "N");
		bottomToTop(6, 5);
		rightToLeft(6, 2);
		setOtherOption(5, 4, "�");
		bottomToTop(5, 2);
		rightToLeft(2, 0);
		bottomToTop(2, 1);
		setOtherOption(2, 1, "L");
		setOtherOption(2, 0, "P");
		setOtherOption(1, 0, "P");
		
		levelOfLand = new int[posNumOfMap.size()];
		nameOfLand = new String[posNumOfMap.size()];
		barricade = new boolean[posNumOfMap.size()];
		ownerOfLand = new String[posNumOfMap.size()];
		barricadOwner = new String[posNumOfMap.size()];
		//for the land name
		char name='A';
		for(int i=0;i<posNumOfMap.size();i++){
			levelOfLand[i]=0;
			barricade[i]=false;
			ownerOfLand[i]="";
			barricadOwner[i]="";
			nameOfLand[i]=String.valueOf(name)+(i%10);
			if((i+1)%10==0){
				name++;
			}
			
		}
		
	}
	
	/*
	 * this function helps to get the position of
	 * the Player
	 */
	public int formatPosition(String position,char xy) {
		System.out.println(position);
		String partStrings[]=position.split("\\*");
		return (xy=='X')?Integer.parseInt(partStrings[0]):Integer.parseInt(partStrings[1]);
	}
	
	/*
	 * this is to print the current map
	 */
	public void printMap(GameMapping mapping,Player player){
		for (int i = 0; i < mapping.map.length; i++) {
			for (int j = 0; j < mapping.map[i].length; j++) {
				if(mapping.map[i][j]!=null)
					System.out.print(mapping.map[i][j]);
				else {
					System.out.print(" ");
				}
			}//end for loop
			System.out.println();
		}//end for loop
	}//end method
	
	public Player getCurrentPlayer() {
		return players[currentTurn];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++currentTurn >= totalPlayer){
			currentTurn = 0;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	public void setPlayers(Player[] players,Player player) {
		for(int i=0;i<barricade.length;i++){
			if(barricadOwner[i].equals(player.playerName)){
				barricadOwner[i]="";
				barricade[i]=false;
			}
			if(ownerOfLand[i].equals(player.playerName)){
				levelOfLand[i]=0;
				ownerOfLand[i]="";
			}
		}
	
		for (int i = player.id; i < players.length-1; i++) {
			players[i]=players[i+1];
		}
		this.totalPlayer-=1;
		this.players=players;
	}
	public Player getMaxMoneyPlayer() {
		Player maxplayer = null;
		for(Player player:players){
			if(maxplayer == null || maxplayer.totalMoneyOfPlayer < player.totalMoneyOfPlayer){
				maxplayer = player;
			}
		}
		return maxplayer;
	}	
	boolean isInteger(String input){
		boolean b = true;
		char[] q = input.toCharArray();
		for (int i = 0 ;i < q.length ;i++ ){
			if (q[i] < '0' || q[i] > '9'){
				b = false;
				break;
			}
		}
		return b;
	}
	public int finishGame(Player player,GameMapping gameMapping) {
		if(player.totalMoneyOfPlayer>0)
			System.out.println(player.playerName+" is leaving from the game");
		else {
			System.out.println(player.playerName+" has no money.So "+player.playerName+" is out of the game.");
		}
		
		if((gameMapping.totalPlayer-1)<=1){
			setPlayers(gameMapping.players, player);
			System.out.println(gameMapping.getCurrentPlayer().playerName+" is the winner");
			return -1;
		}
		else{
			setPlayers(gameMapping.players, player);
			return 1;
		}
		
	}
	
	
}

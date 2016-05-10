package MonoPolyReturns;
public class GameControl {
	/*
	 * this class mainly is to control the options 
	 * of whole game.
	 * here all the necessary classes will be set
	 * as static so that we can keep track of the changes of
	 * any property 
	 */
	
	public static GameMapping gameMapping = new GameMapping(0);
	public static GameFileReader gameFileReader = new GameFileReader();
	public static Player player = new Player();
	public static PlayGame playGame = new PlayGame();
	public static Bank bank=new Bank("€");
	public static CardLand cardLand=new CardLand("C");
	public static calender calender= new calender();

}

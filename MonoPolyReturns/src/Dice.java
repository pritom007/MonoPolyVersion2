import java.util.Random;


public class Dice {

	public int diceRoll(){
		Random rand = new Random();
		//if(Card.turnAround())
		int face = rand.nextInt(6)+1;
		/*
		 * else{
		 * Scanner sc= new Scanner(System.in);
		 * Syatem.out.print("please enter a number between 1 to 6 : ");
		 * face=sc.nextInt();
		 * while(!(face>=1 && face<=6)){
		 * System.out.println("Invaild input!!");
		 * Syatem.out.print("please enter a number between 1 to 6 : ");
		 * face=sc.nextInt();
		 * }
		 * }
		 */
		
		
		return face;
	}
}

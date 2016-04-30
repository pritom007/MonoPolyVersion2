import java.util.Random;


public class Dice {

	public int diceRoll(){
		Random rand = new Random();
		//if(Card.turnAround())
		int face = rand.nextInt(6)+1;

		return face;
	}
}

import javax.swing.JOptionPane;


public class CardLand extends Land{

	public CardLand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		
		int randomCard = (int)(Math.random()*4);
		player.setAmountOfCard(randomCard);
        System.out.println("you got a "+player.cardName[randomCard]);
        //JOptionPane.showMessageDialog(null, "You got a "+player.cardName[randomCard]+" cupon points","Congratulations For Winning Card",JOptionPane.INFORMATION_MESSAGE);
		
	}

}

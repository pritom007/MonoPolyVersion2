package MonoPolyReturns;
public class Options {

	public void printOption(){
		
	System.out.println("Here is you options:");
	System.out.println("0 - view current map.");
	System.out.println("1 - view the original map.");
	System.out.println("2 - watch if there is any barricade.");
	System.out.println("3 - use the cards.");
	System.out.println("4 - information of a perticular land.");
	System.out.println("5 - see the information of players.");
	System.out.println("6 - Roll dice and take action and change turn!");
	System.out.println("7 - quit!");
	System.out.println("8 - stock market");
	
	}
	public void operation(String opration,Player player,GameMapping gameMapping) {
		
		/*
		 * after the dice roll 
		 * check if the next step is bank or not
		 * if not then check if there is a bank or not
		 */
		System.out.println("opration "+opration);
		if (!opration.equals("€")) 
		GameControl.bank.checkBankinRoad(player, gameMapping);
		//check if there is a barricade in front
		if(GameControl.cardLand.checkBarricadeInRoad(player, gameMapping)){
			System.out.println("Sorry there was a barricade in your road!you can't go forward this time");
			System.out.println("Better luck next time!");
 			return;
		}
			switch (opration) {
			case "¤":
				HouseAction houseAction=new HouseAction(opration);
				houseAction.doAction(player, gameMapping);
				break;
			case "C":
				CardLand cardLand = new CardLand(opration);
				cardLand.doAction(player, gameMapping);
				break;
			case "€":
				Bank bank = new Bank(opration);
				bank.doAction(player, gameMapping);
				break;
			case "L":
				Lottery lottery = new Lottery(opration);
				lottery.doAction(player, gameMapping);
				break;
			case "S":
				PropStore propStore= new PropStore(opration);
				propStore.doAction(player, gameMapping);
				break;	
			case "N":
				News news = new News("N");
				news.doAction1(gameMapping.players, player,gameMapping);
				break;
			default:
				break;
			}
	}
}

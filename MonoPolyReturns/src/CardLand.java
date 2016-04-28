import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class CardLand extends Land{

	public CardLand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	Scanner scanner=new Scanner(System.in);
	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		
		int randomCard = (int)(Math.random()*4);
		player.setAmountOfCard(randomCard);
        System.out.println("you got a "+player.cardName[randomCard]);
        //JOptionPane.showMessageDialog(null, "You got a "+player.cardName[randomCard]+" cupon points","Congratulations For Winning Card",JOptionPane.INFORMATION_MESSAGE);		
        gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition));
		player.currentPosition=player.nextPosition;
		player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
		player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
	}
	
	/*
	 * This is use the cards options
	 * all the operations related to use card option is 
	 * going to be hold here
	 */
	public void cardOperation(Player player, GameMapping gameMapping) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You have following cards:");
		for(int i=0;i<player.cardName.length;i++){
			System.out.println((i+1)+"."+player.cardName[i]+" amount="+player.numberOfCard[i]);
		}
		System.out.print("Please input the card number to accesss(input \"h\" for help,\"x\" for go back):");
		String input=sc.next();
		while (!input.equals("x")) {
			if(input.equals("h")){
				 System.out.println("1.Make the money average card\tIf you use this card,money of the both player will be same.");
                 System.out.println("2.Turn around card\tIf you use this card,you can change the direction of your's or the other player's.");
                 System.out.println("3.Roadblocks card\tIf you use this card,you can put barricade at any place(2 directions). Any player steps on that will go back to his last position !!!. ");
                 System.out.println("4.Dice control card\tIf you use this card,you can control the result of the dice (1-6), when rolling the dice, the result is what you set.");
                 System.out.println("5.Rob cards\tIf you use this card,you can rob the object and get one prop from other player randomly.");
                 System.out.println("6.Cash to Card\tIf you use this card,you can buy card in exchange of cash.");
                 System.out.println("7.Get points card\tIf you use this card,you can get points.\n");
                 
			}
			else if(GameControl.gameMapping.isInteger(input)){
				if (Integer.parseInt(input)>=1 && Integer.parseInt(input)<=7) {
					
				
					switch (Integer.parseInt(input)) {
						case 1:averageCash(player,gameMapping);break;
						case 2:changePosition(player,gameMapping);break;
						case 3:barricades(player,gameMapping);break;
						case 4:useControlDice(player,gameMapping);break;
						case 5:roob(player,gameMapping);break;
						case 6:cashToCard(player,gameMapping);break;
						case 7:cashToPoints(player,gameMapping);break;
						default:
							break;
					}
				}
				else {
					System.out.println("invalid input!");
				}

			}
			else {
				System.out.println("Invaild input!!!");
			}
				System.out.print("Please input the card number to accesss(input \"h\" for help,\"x\" for go back):");
				input=sc.next();
			
		}
		
	}

	private void cashToPoints(Player player, GameMapping gameMapping) {
		if (player.numberOfCard[6]>0 && player.cashOfPlayer>=1000) {
			System.out.println("you are using Cash to points card.");
			System.out.println("your got 5 point by spending 1000$");
			player.pointOfPlayer+=5;
			player.cashOfPlayer-=1000;
			player.numberOfCard[6]-=1;
		}
		else {
			System.out.println("sorry you don't have enough card or cash!");
		}
		
	}

	private void cashToCard(Player player, GameMapping gameMapping) {
		
		if (player.numberOfCard[5]>0 && player.cashOfPlayer>=1000) {
			System.out.println("you are using Cash to Card.\nyou have following cards:");
			for(int i=0;i<player.cardName.length;i++){
				System.out.println((i+1)+". "+player.cardName[i]+" amount="+player.numberOfCard[i]);
			}
			System.out.print("input the card number you want to buy(press x to go back): ");
			
			String 	inputString=scanner.next();
			while (!inputString.equals("x")) {
				if(gameMapping.isInteger(inputString)){
					if(Integer.parseInt(inputString)>=1 && Integer.parseInt(inputString)<=7){
						player.numberOfCard[5]-=1;
						switch (Integer.parseInt(inputString)) {
						case 1:
							player.numberOfCard[0]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 2:
							player.numberOfCard[1]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 3:
							player.numberOfCard[2]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 4:
							player.numberOfCard[3]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 5:
							player.numberOfCard[4]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 6:
							player.numberOfCard[5]+=1;
							player.cashOfPlayer-=1000;
							break;
						case 7:
							player.numberOfCard[6]+=1;
							player.cashOfPlayer-=1000;
							break;	
						default:
							break;
						}
					}
					else{
						System.out.println("invalid input!!!");
					}
				}
				else {
					System.out.println("invalid input!!!");
				}
				System.out.print("input the card number you want to buy(press x to go back): ");
				inputString=scanner.next();
				
			}
			
			
		}
		else {
			System.out.println("sorry you don't have enough card or cash!");
		}
		
		
	}
	

	private void barricades(Player player, GameMapping gameMapping) {
		if(player.numberOfCard[2]>=1){
			System.out.println("you are going to use the barricade card!!!");
			System.out.println("You want to put barricade in which direction?");
			System.out.println("1.Within 8 steps front?\n2.Within 8 steps back?");
			String choice=scanner.next();
			
			while (!(choice.equals("1")||choice.equals("2"))) {
				System.out.println("invalid input.");
				System.out.println("You want to put barricade in which direction?");
				System.out.println("1.Within 8 steps front?\n2.Within 8 steps back?");
				choice=scanner.next();
			}
			while (true) {
				if(choice.equals("1")){
					System.out.print("please enter number:");
					choice=scanner.next();
					if(gameMapping.isInteger(choice)){
						if (Integer.parseInt(choice)>=1 && Integer.parseInt(choice)<=8) {
								if(Integer.parseInt(choice)>=1 && Integer.parseInt(choice)<=8 ){
									gameMapping.barricade[player.currentPosition+Integer.parseInt(choice)]=true;
									gameMapping.barricadOwner[player.currentPosition+Integer.parseInt(choice)]=player.playerName;
									break;
								}
								else{
									System.out.println("invalid input!");
									System.out.print("please enter number:");
									choice=scanner.next();
								}
						}
						else {
							System.out.println("invalid input!");
							choice="1";
							continue;
						}
					}
					else {
						System.out.println("invalid input!");
						choice="1";
						continue;
					}
				}
				else if(choice.equals("2")){
					System.out.print("please enter number:");
					choice=scanner.next();
					if(gameMapping.isInteger(choice)){
						if (Integer.parseInt(choice)>=1 && Integer.parseInt(choice)<=8) {
								if(Integer.parseInt(choice)>=1 && Integer.parseInt(choice)<=8 ){
									gameMapping.barricadOwner[(player.currentPosition-Integer.parseInt(choice))%gameMapping.mapOfGame.size()]=player.playerName;
									gameMapping.barricade[(player.currentPosition-Integer.parseInt(choice))%gameMapping.mapOfGame.size()]=true;
									break;
								}
								else{
									System.out.println("invalid input!");
									System.out.print("please enter number:");
									choice=scanner.next();
								}
						}
						else {
							System.out.println("invalid input!");
							choice="1";
							continue;
						}
					}
					else {
						System.out.println("invalid input!");
						choice="1";
						continue;
					}
				}
				else {
					System.out.println("You want to put barricade in which direction?");
					System.out.println("1.Within 8 steps front?\n2.Within 8 steps back?");
					choice=scanner.next();
				}
			}
		}
		else{
			System.out.println("You don't have enough card!");
		}
		
	}

	private void changePosition(Player player, GameMapping gameMapping) {
		// TODO Auto-generated method stub
		
	}

	private void roob(Player player,GameMapping gameMapping) {
		if (player.numberOfCard[4]>=1) {
			System.out.println("You are going to rob random cards of the of the other player");
			int randomCard=(int)(Math.random()*7);
			for (int i = 0; i < player.numberOfPlayer; i++) {
				if (gameMapping.players[i].equals(player)) {
					continue;
				}
				else {
					if(gameMapping.players[i].numberOfCard[randomCard]>=1){
					
						System.out.println("you got a "+player.cardName[randomCard] +" from "+gameMapping.players[i].playerName);
						gameMapping.players[i].numberOfCard[randomCard]-=1;
						player.numberOfCard[randomCard]+=1;
						
					}
					else {
						System.out.println("you are unlucky!!!opponent don't have that card.");
					}
				}
				
			}
			player.numberOfCard[4]-=1;
		}
		else {
			System.out.println("sorry you don't have enough card!");
		}
	}

	private void useControlDice(Player player,GameMapping gameMapping) {
		if(player.numberOfCard[3]>0){
			System.out.println("you are using Dice control card.");
			System.out.println("This will take effect while throwing the dice");
			player.diceControl=true;
			player.numberOfCard[3]-=1;
		}
		else{
			System.out.println("sorry you don't have enough card!");
		}
		
	}

	private void averageCash(Player player,GameMapping gameMapping) {
		if (player.numberOfCard[0]>0) {
			System.out.println("you are using Make the money average card.");
			int totalCash=0;
			for (int i = 0; i < player.numberOfPlayer; i++) {
				totalCash+=gameMapping.players[i].cashOfPlayer;
			}
			for (int i = 0; i < player.numberOfPlayer; i++) {
				gameMapping.players[i].cashOfPlayer=totalCash/player.numberOfPlayer;
			}
			player.numberOfCard[0]-=1;
			System.out.println("Now every player has same amount of cash!!!");
		}
		else {
			System.out.println("sorry you don't have enough card!");
		}
		
	}
	protected boolean checkBarricadeInRoad(Player player,GameMapping gameMapping){
		for (int i = player.currentPosition+1; i <= player.nextPosition; i++) {
			if(gameMapping.barricade[i]){
				if(!gameMapping.barricadOwner[i].equals(player.playerName)){
					gameMapping.barricade[i]=false;
					gameMapping.barricadOwner[i]="";
					return true;
				}
			}
		}
		return false;
	}

}

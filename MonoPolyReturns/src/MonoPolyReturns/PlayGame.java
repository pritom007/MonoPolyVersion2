package MonoPolyReturns;
import java.io.IOException;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;


public class PlayGame extends StockMarket{
	
	public PlayGame() {
	
	}

	public int goForWord(Player player,GameMapping gameMapping) throws IOException{
		
		String press;
		Scanner sc = new Scanner(System.in);
		Options options=new Options();
		options.printOption();
		press=sc.next();
		while(true){
			if (!GameControl.gameMapping.isInteger(press)) {
					System.out.println("wrong input");
			}
			/*
			 * default map
			 * 
			 */
			else if (Integer.parseInt(press)==0) {
				GameFileReader gfr= new GameFileReader();
				System.out.println(gfr.readFile("src/GameMap.txt"));
			}
			/*
			 * print current map
			 */
			else if(Integer.parseInt(press)==1){
				gameMapping.printMap(gameMapping,player);
			}
			/*
			 * check if there is any barricade ahead
			 */
			else if (Integer.parseInt(press)==2) {
				for (int i = player.currentPosition+1; i <= 10; i++) {
					if(gameMapping.barricade[i]){
						if(!gameMapping.barricadOwner[i].equals(player.playerName)){
							System.out.println("There is a barricade "+i+" steps ahead of you!");
							break;
						}
					}
					else if (!gameMapping.barricade[i] && i==10) {
						System.out.println("No barricades ahead!");
						break;
					}
					
				}
			}
			/*
			 * use cards
			 */
			else if(Integer.parseInt(press)==3){
				GameControl.cardLand.cardOperation(player, gameMapping);
			}
			/*
			 * check a particular land information
			 */
			else if(Integer.parseInt(press)==4){
				System.out.print("please input number from 0~"+gameMapping.levelOfLand.length+" to get the information of that land.");
				String i=sc.next();
				
				while (true) {
					if(gameMapping.isInteger(i)){
						if(Integer.parseInt(i)>=0 && Integer.parseInt(i)<=gameMapping.levelOfLand.length){
							System.out.println("\nName of land: "+gameMapping.nameOfLand[Integer.parseInt(i)]+"\n level: "+gameMapping.levelOfLand[Integer.parseInt(i)]
									+"\n barricade: "+gameMapping.barricade[Integer.parseInt(i)]+" "+gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(Integer.parseInt(i))));
								break;
						}
						else{
							System.out.println("invalid input!");
						}
					}
					System.out.println("invaild input!!!");
					System.out.print("please input number from 0~"+gameMapping.levelOfLand.length+" to get the information of that land:");
				    i=sc.next();
					
				}
					
			}
			/*
			 * see all player's information here 
			 */
			else if(Integer.parseInt(press)==5){
				player.allPlayerInformation(gameMapping.players,gameMapping);
			}
			/*
			 * roll the dice and change the turn
			 */
			else if(Integer.parseInt(press)==6){
				player.lastPosition=player.currentPosition;
				int diceRoll;
				/*
				 * just to make sure if player has enough money
				 * if not game will finish here
				 */
				if(player.totalMoneyOfPlayer<0){
					gameMapping.finishGame(player, gameMapping);
				}
				/*
				 * if player didn't use the dice control card
				 */
				if(!player.diceControl){
					diceRoll=(int) (Math.random()*6 +1);
				}
				/*
				 * if player use stay in place card
				 */
				else if (player.stayInPlace) {
					diceRoll=0;
					player.stayInPlace=false;
				}
				/*
				 * if player used the dice control card
				 */
				else {
					System.out.print("Please input your desired number between 1 to 6 :");
					diceRoll=Integer.parseInt(sc.next());
					System.out.println();
					while (!(diceRoll>=1 && diceRoll<=6)) {
						System.out.println("invalid input!!!");
						System.out.print("Please input your desired number between 1 to 6 :");
						diceRoll=Integer.parseInt(sc.next());
					}
					player.diceControl=false;
				}
				
				//assuming the next step
				player.nextPosition=(player.nextPosition+diceRoll)%(gameMapping.posNumOfMap.size());
				//operations for next step
				options.operation(gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.nextPosition)), player, gameMapping);
				//after all the operation player is going to change
				gameMapping.nextTurn();
				break;
			}
			/*
			 * game is going to end
			 */
			else if(Integer.parseInt(press)==7){
				System.out.println(player.playerName+" has quit!");
				if (gameMapping.finishGame(player, gameMapping)==-1)
					return -1;
				else {
					return 1;
				}
				
			}
			/*
			 * stock market
			 */
			else if(Integer.parseInt(press)==8){
				
				if(verifyDay(GameControl.calender)){
					System.out.println("Welcome to stock market.");
					stockOption(player,gameMapping);
				}
				
			}
			//in case of wrong input
			else{
				System.out.println("wrong input");
			}
			options.printOption();
			press=sc.next();
		}
		return 0;
	}
	
}

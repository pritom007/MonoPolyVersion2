import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;


public class PlayGame extends Options{
	
	public PlayGame() {
		}

	public int goForWord(Player player,GameMapping gameMapping){
		
		
		String press;
		Scanner sc = new Scanner(System.in);
		
		printOption();
		press=sc.next();
		//System.out.println(GameControl.gameMapping.isInteger(press));
		while(true){
			if (!GameControl.gameMapping.isInteger(press)) {
					System.out.println("wrong input");
			}
			else if(Integer.parseInt(press)==1){
				gameMapping.printMap(gameMapping,player);
				//gameMapping.map[player.XpositionOfPlayer][player.XpositionOfPlayer] = player.symbol;
			}
			else if(Integer.parseInt(press)==3){
				GameControl.cardLand.cardOperation(player, gameMapping);
			}
			else if(Integer.parseInt(press)==5){
				player.allPlayerInformation(gameMapping.players);
			}
			else if(Integer.parseInt(press)==4){
				System.out.print("please input number from 0~"+gameMapping.levelOfLand.length+" to get the information of that land.");
				String i=sc.next();
				
				while (true) {
					if(gameMapping.isInteger(i)){
						if(Integer.parseInt(i)>=0 && Integer.parseInt(i)<=gameMapping.levelOfLand.length){
							System.out.println("\nName of land "+gameMapping.nameOfLand[Integer.parseInt(i)]+" level "+gameMapping.levelOfLand[Integer.parseInt(i)]
									+" barricade "+gameMapping.barricade[Integer.parseInt(i)]+" "+gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(Integer.parseInt(i))));
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
			else if(Integer.parseInt(press)==6){
				player.lastPosition=player.currentPosition;
				int diceRoll;
				if(!player.diceControl){
					diceRoll=(int) (Math.random()*6 +1);
				}
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
				//watch out this step
				System.out.println("diceroll "+diceRoll+" "+gameMapping.posNumOfMap.size()+" "+gameMapping.count
						+" "+gameMapping.mapOfGame.size());
				/*
				for(int i=0;i<=gameMapping.posNumOfMap.size();i++)
					System.out.println(gameMapping.posNumOfMap.get(i)+" "+gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(i)));
				System.out.println(gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition+diceRoll)));
				*/
				
				player.nextPosition+=diceRoll%(gameMapping.posNumOfMap.size());
				//player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
				//player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
				
				operation(gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.nextPosition)), player, gameMapping);
				//gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
				
				gameMapping.nextTurn();
				break;
			}
			
			else if(Integer.parseInt(press)==7){
				return -1;
			}
			
			else{
				System.out.println("wrong input");
			}
			printOption();
			press=sc.next();
		}
		//GameMapping.this.posNumOfMap.()
		return 0;
	}
	
}

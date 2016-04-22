import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;


public class PlayGame{
	
	public PlayGame() {
		}

	public int goForWord(Player player,GameMapping gameMapping){
		
		int press;
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 to continue...0 to quit");
		press=sc.nextInt();
		while(press!=0){
		if(press==1){
			int diceRoll=(int) (Math.random()*6 +1);
			//watch out this step
			System.out.println("diceroll "+diceRoll+" "+player.posNumOfMap.size());
			player.currentPosition+=diceRoll%(gameMapping.posNumOfMap.size());
			player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
			player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
			gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
		}
		else if(press==2){
			gameMapping.printMap(gameMapping,player);
			//gameMapping.map[player.XpositionOfPlayer][player.XpositionOfPlayer] = player.symbol;
		}
		else if(press==3){
			System.out.println(player.currentPosition+" "+player.cashOfPlayer+" "+player.playerName+" "+player.symbol);
			//player.allPlayerInformation(player);
		}
		else if(press==-1){
			return -1;
		}
		else{
			System.out.println("go hell!");
		}
		System.out.println("press 1 to continue...0 to quit");
		press=sc.nextInt();
		}
		//GameMapping.this.posNumOfMap.()
		return 0;
	}
	
}

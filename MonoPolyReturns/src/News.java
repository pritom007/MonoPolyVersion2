
public class News extends Land{

	public News(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void doAction1(Player[] players,Player player, GameMapping gameMapping) {
		int randomNews = (int) (Math.random()*4);
		switch (randomNews) {
		
		case 0:
			
			System.out.println("Each player is going to get random amount of cash!!!");
			for(int i=0;i<players.length;i++){
				int randomMoney=(int)(Math.random()*100000+1000);
				players[i].cashOfPlayer+=randomMoney;
				System.out.println("Player "+(i+1)+" got "+randomMoney+"$ cash!!!");
			}
				
			break;
		case 1:
			System.out.println("Each player is going to get random amount of bonus deposit!!!");
			for(int i=0;i<players.length;i++){
				int randomMoney=(int)(Math.random()*100000+1000);
				players[i].depositOfPlayer+=randomMoney;
				System.out.println("Player "+(i+1)+" got "+randomMoney+"$ as deposit!!!");
			}
			
			break;
		case 2:
			System.out.print("Each player is going loose some amount of cash!!!");
			for(int i=0;i<players.length;i++){
				int randomMoney=(int)(Math.random()*1000);
				players[i].depositOfPlayer-=randomMoney;
				System.out.println("Player "+(i+1)+" lost "+randomMoney+"$ cash!!!");
			}
			break;
		case 3:
			System.out.println("Each player is going to get a random card!!!");
			for(int i=0;i<players.length;i++){
				int randomMoney=(int)(Math.random()*6);
				players[i].numberOfCard[randomMoney]+=1;
				System.out.println("Player "+(i+1)+" got a "+players[i].cardName[randomMoney]+"!!!");
			}
			break;
		case 4:
			System.out.println("Sorry no good news for you!\nBetter luck next time!");
			break;
		default:
			break;
		}
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition));
		player.currentPosition=player.nextPosition;
		player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
		player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
		
	}

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		
		
	}
		
	

}

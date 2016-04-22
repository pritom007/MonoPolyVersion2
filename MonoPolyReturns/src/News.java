
public class News extends Land{

	public News(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void doAction1(Player[] player, GameMapping gameMapping) {
		int randomNews = (int) (Math.random()*4);
		switch (randomNews) {
		
		case 0:
			
			System.out.print("Each player is going to get random amount of cash!!!");
			for(int i=0;i<player.length;i++){
				int randomMoney=(int)(Math.random()*100000+1000);
				player[i].cashOfPlayer+=randomMoney;
				System.out.println("Player "+(i+1)+" got "+randomMoney+"$ cash!!!");
			}
				
			break;
		case 1:
			System.out.print("Each player is going to get random amount of bonus deposit!!!");
			for(int i=0;i<player.length;i++){
				int randomMoney=(int)(Math.random()*100000+1000);
				player[i].depositOfPlayer+=randomMoney;
				System.out.println("Player "+(i+1)+" got "+randomMoney+"$ as deposit!!!");
			}
			
			break;
		case 2:
			System.out.print("Each player is going loose some amount of cash!!!");
			for(int i=0;i<player.length;i++){
				int randomMoney=(int)(Math.random()*1000);
				player[i].depositOfPlayer-=randomMoney;
				System.out.println("Player "+(i+1)+" lost "+randomMoney+"$ cash!!!");
			}
			break;
		case 3:
			System.out.print("Each player is going to get a random card!!!");
			for(int i=0;i<player.length;i++){
				int randomMoney=(int)(Math.random()*4);
				player[i].numberOfCard[randomMoney]+=1;
				System.out.println("Player "+(i+1)+" got a "+player[i].cardName[randomMoney]+"!!!");
			}
			break;
		case 4:
			System.out.print("Sorry no good news for you!\nBetter luck next time!");
			break;
		default:
			break;
		}
		
	}

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		// TODO Auto-generated method stub
		
	}
		
	

}

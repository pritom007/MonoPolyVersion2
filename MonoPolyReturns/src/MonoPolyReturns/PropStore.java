package MonoPolyReturns;
import java.util.Scanner;


public class PropStore extends Land{

	public PropStore(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		
		System.out.println("You have "+player.pointOfPlayer+" points.");
		
		//showing the card status
		for(int i=0;i<player.numberOfCard.length;i++)
			System.out.println("You have "+player.numberOfCard[i]+" "+player.cardName[i]);
		
		//if player have enough card points then take action
		if(player.pointOfPlayer>=5){
			
			System.out.println("Will you like to buy new cards spending?\n1.yes\n2.no\npress \"x\" to return back");
			
			Scanner scanner = new Scanner(System.in);
			String answer=scanner.next();
			
			while (!answer.equals("x")) {
				
				if(answer.equals("1") && player.pointOfPlayer>=5){
				
					System.out.println("What card you want to buy?");
					for(int i=0;i<player.numberOfCard.length;i++)
						System.out.println( "("+(i+1)+") "+player.cardName[i]);
				
				
				
					System.out.println("Just type the number of the card.\nprss\"x\" to return back.");
					String answer1=scanner.next();
					while (!answer1.equals("x")) {
						
						
					
						if(Integer.parseInt(answer1)>=1 && Integer.parseInt(answer1)<=7){
							
							System.out.println("Successfully pursed your desired card!");
							player.pointOfPlayer-=5;
							player.numberOfCard[Integer.parseInt(answer)-1]+=1;
							answer="x";
							break;
						}
				
						else {
							
							System.out.println("Wrong command -_- ");
							System.out.println("What card you want to buy?");
							
							for(int i=0;i<player.numberOfCard.length;i++)
								System.out.println( "("+(i+1)+") "+player.cardName[i]);
							
							System.out.println("press \"x\" to go back.");
							
							answer1=scanner.next();
							
						}
					}
					break;
				}
				else if(answer.equals("no")||answer.equals("2")){
					System.out.println("see you next time!");
					break;
				}
				else{
					System.out.println("Wrong command -_- ");
					System.out.println("Will you like to buy new cards spending?\n1.yes\n2.no\npress \"x\" to return back");
					answer=scanner.next();
				}
			}
			
		}
		else {
			System.out.println("not enough card!!!");
			return;
		}
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition));
		player.currentPosition=player.nextPosition;
		player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
		player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
	}

}

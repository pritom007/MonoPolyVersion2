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
			
			System.out.println("Will you like to buy new cards spending?\1.yes\n2.no\npress \"x\" to return back");
			
			Scanner scanner = new Scanner(System.in);
			String answer=scanner.next();
			
			while (!answer.equals("x") || !answer.toLowerCase().equals("no")||!answer.equals("2")) {
				
				if(answer.toLowerCase().equals("yes")|| answer.equals("1")){
				
					System.out.println("What card you want to buy?");
					for(int i=0;i<player.numberOfCard.length;i++)
						System.out.println( "("+(i+1)+") "+player.cardName[i]);
				}	
				
				System.out.println("Just type the number of the card.\nprss\"x\" to return back.");
				answer=scanner.next();
				
				while (!answer.equals("x") && player.pointOfPlayer>=5) {
					
					if(Integer.parseInt(answer)>=1 && Integer.parseInt(answer)<=7){
						
						System.out.println("Successfully pursed your desired card!");
						player.pointOfPlayer-=5;
						player.numberOfCard[Integer.parseInt(answer)-1]+=1;
						answer.equals("x");
					}
					else {
						
						System.out.println("Wrong command -_- ");
						System.out.println("What card you want to buy?");
						
						for(int i=0;i<player.numberOfCard.length;i++)
							System.out.println( "("+(i+1)+") "+player.cardName[i]);
						
						System.out.println("press \"x\" to go back.");
						System.out.println("Just type the number of the card.");
						answer=scanner.next();
						
					}
				}
			}
			
		}
		else {
			System.out.println("not enough money!!!");
			return;
		}
	}

}

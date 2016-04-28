import java.util.Scanner;

import javax.swing.JOptionPane;


public class Bank extends Land{
	
	public Bank(String name) {
		super(name);
	}
	

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Welcome to the Bank!!!");
		System.out.println("Choose Your option:\n"
				+ "1)Deposit money.\n"
				+ "2)Withdraw money.\n"
				+ "3)Exit.");
		String option=scanner.nextLine();
		while (!option.equals("3")) {
			if (option.equals("1")) {
				if(player.cashOfPlayer>0){
					System.out.println("Enter the amount you want to deposit:(max amount "+player.cashOfPlayer+
							")");
					String amount=scanner.next();
					while (!(Integer.parseInt(amount)<=player.cashOfPlayer && Integer.parseInt(amount)>=0)) {
						System.out.println("Invalid input!");
						System.out.println("Enter the amount you want to deposit:(max amount "+player.cashOfPlayer+
								")");
						amount=scanner.next();
						
					}
					
						player.depositOfPlayer+=Integer.parseInt(amount);
						player.cashOfPlayer-=Integer.parseInt(amount);
				}
			}
			else if(option.equals("2")) {
				if(player.depositOfPlayer>0){
					System.out.println("Enter the amount you want to make cash:(max amount "+player.depositOfPlayer+
							")");
					String amount=scanner.next();
					while (!(Integer.parseInt(amount)<=player.depositOfPlayer && Integer.parseInt(amount)>=0)) {
						System.out.println("Invalid input!");
						System.out.println("Enter the amount you want to make cash:(max amount "+player.depositOfPlayer+
								")");
						amount=scanner.next();
						
					}
					
						player.cashOfPlayer+=Integer.parseInt(amount);
						player.depositOfPlayer-=Integer.parseInt(amount);
				}
			}
			else{
				System.out.println("Invalid input");
				System.out.println("Choose Your option:\n"
						+ "1)Deposit money.\n"
						+ "2)Withdraw money.\n"
						+ "3)Exit.");
				 option=scanner.nextLine();
			}
			
		}
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition));
		player.currentPosition=player.nextPosition;
		player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
		player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
		
	}
	
	/*
	 * Bank interest function
	 */
	public void interestOfBank(){
			for (int i =0;i < GameControl.gameMapping.totalPlayer ;i++ ){
				GameControl.gameMapping.players[i].depositOfPlayer+= GameControl.gameMapping.players[i].depositOfPlayer/10;
				//System.out.println(GameControl.player.player[i] + " For interest " + GameControl.player.depositOfPlayer[i]/10);
			}
			//JOptionPane.showMessageDialog(null,"All players go 10% interest on their deposit" ,"Message from Bank",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("All players go 10% interest on their deposit");
	}
	protected void checkBankinRoad(Player player,GameMapping gameMapping){
		for (int i = player.currentPosition+1; i <= player.nextPosition; i++) {
			if(gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(i)).equals("€"))
				doAction(player, gameMapping);
		}
	}

}

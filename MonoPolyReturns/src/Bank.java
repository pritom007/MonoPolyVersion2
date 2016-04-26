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
					int amount=scanner.nextInt();
					while (!(amount<=player.cashOfPlayer && amount>=0)) {
						System.out.println("Invalid input!");
						System.out.println("Enter the amount you want to deposit:(max amount "+player.cashOfPlayer+
								")");
						amount=scanner.nextInt();
						
					}
					
						player.depositOfPlayer+=amount;
						player.cashOfPlayer-=amount;
				}
			}
			else if(option.equals("2")) {
				if(player.depositOfPlayer>0){
					System.out.println("Enter the amount you want to make cash:(max amount "+player.depositOfPlayer+
							")");
					int amount=scanner.nextInt();
					while (!(amount<=player.depositOfPlayer && amount>=0)) {
						System.out.println("Invalid input!");
						System.out.println("Enter the amount you want to make cash:(max amount "+player.depositOfPlayer+
								")");
						amount=scanner.nextInt();
						
					}
					
						player.cashOfPlayer+=amount;
						player.depositOfPlayer-=amount;
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
		
		
	}
	
	/*
	 * Bank interest function
	 */
	public void interestOfBank(){
			for (int i =0;i < GameControl.gameMapping.totalPlayer ;i++ ){
				GameControl.gameMapping.players[i].depositOfPlayer+= GameControl.gameMapping.players[i].depositOfPlayer/10;
				//System.out.println(GameControl.player.player[i] + " For interest " + GameControl.player.depositOfPlayer[i]/10);
			}
			JOptionPane.showMessageDialog(null,"All players go 10% interest on their deposit" ,"Message from Bank",JOptionPane.INFORMATION_MESSAGE);
		}

}

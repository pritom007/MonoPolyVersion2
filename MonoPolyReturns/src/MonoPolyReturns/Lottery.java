package MonoPolyReturns;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Lottery extends Land{

	public Lottery(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Player player, GameMapping gameMapping) {
		while (true){
			//System.out.println("The lottery shop, do you want to spend 200 to buy lottery tickets? input yes or no ");
			int yesNo =JOptionPane.showConfirmDialog(null, "Do you want to spend 200 to buy lottery tickets?", "Lottery Shop Option", JOptionPane.YES_NO_OPTION);// input.nextLine();
			if (yesNo==JOptionPane.NO_OPTION){
				break;
			}
			else if (yesNo==JOptionPane.YES_OPTION && player.cashOfPlayer >= 200){
				player.cashOfPlayer -= 200;
				int rm = (int)(Math.random()*10);//make a random num
                int rm2 =(int) (Math.random()*10);//
				//the idea is to make random of two numbers and match whether they are same or not.if same then player will get money.
                if (rm == rm2){
					//System.out.println( "Congratulations on your winning, bonus 2000 yuan ");
					JOptionPane.showMessageDialog(null, " You won bonus 2000 yuan"," Congratulations !!!",JOptionPane.INFORMATION_MESSAGE);
					player.cashOfPlayer += 2000;
				}
				else{ 
					//System.out.println( "Unfortunately, you have not won ");
                    JOptionPane.showMessageDialog(null, " Unfortunately, you have not won "," Sorry :(",JOptionPane.INFORMATION_MESSAGE);
                    break;//To determine whether a non negative integer function
				}
            }
			else if (yesNo== JOptionPane.YES_OPTION && player.cashOfPlayer < 200){
				System.out.println("Do not have enough cash. ");
				JOptionPane.showMessageDialog(null, "You don't have enough cash ","Go to bank first",JOptionPane.INFORMATION_MESSAGE);	
				break;
			}
			else{	
				//System.out.println("invalid input.");
				JOptionPane.showMessageDialog(null, " Something is wrong ","Problem!!!",JOptionPane.INFORMATION_MESSAGE);
				break;
				//continue;
			}
		}
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=gameMapping.mapOfGame.get(gameMapping.posNumOfMap.get(player.currentPosition));
		player.currentPosition=player.nextPosition;
		player.setXpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'X'));
		player.setYpositionOfPlayer(gameMapping.formatPosition(gameMapping.posNumOfMap.get(player.currentPosition%(gameMapping.posNumOfMap.size())), 'Y'));
		gameMapping.map[player.XpositionOfPlayer][player.YpositionOfPlayer]=player.symbol;
		
	}
	

}

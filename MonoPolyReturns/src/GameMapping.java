import java.util.HashMap;
import java.util.Map;


public class GameMapping  {
	
	//map[Xpos][Ypos]
	private static int Xpos,Ypos;
	//MaxX,MaxY by default we set the size 20x20 (01...19 = 20)
	private static int MaxX = 19,MaxY = 19;
	
	private static Map<String, String> mapOfGame = new HashMap<String, String>();
	private static Map<Integer, String> posNumOfMap = new HashMap<Integer, String>(); 
	
	//keeps track of the total number of places
	private static int count = 0;
	//map of the game
	protected static String[][] map = new String[20][20];
	
	//constructor
	public GameMapping() {
		
	}
	
	//make map from left to right
	public void leftToRight(int from,int to){
		//checks if suggested path is valid "1" is hard coded for leftToRight()
		if(checkMapCreator(from, to, 1)){
			for(;from<to;Ypos++,from++,count++){
					map[Xpos][Ypos] = "*";
					mapOfGame.put( Xpos+""+Ypos, map[Xpos][Ypos].toString());
					posNumOfMap.put(count, Xpos+""+Ypos);
			}
		}
		else{
			System.out.println("letfToRight(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
		
	}
	//make map from right to left
	public void rightToLeft(int from,int to){
		if(checkMapCreator(from,to,2)){
			for(;from>to;Ypos--,from--,count++){
				map[Xpos][Ypos] = "*";
				mapOfGame.put(Xpos+""+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+""+Ypos);
			}
		}
		else{
			System.out.println("rightToLeft"+ "(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}

	}
	//make map from top to bottom
	public void topToBottom(int from,int to){
		if(checkMapCreator(from,to,3)){
			for(;from<to;Xpos++,from++,count++){
				map[Xpos][Ypos] = "*";
				mapOfGame.put(Xpos+""+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+""+Ypos);
			}
		}
		else{
			System.out.println("topToBottom(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
	}
	//make map from bottom to top
	public void bottomToTop(int from,int to){
		if(checkMapCreator(from,to,4)){
			for(;from>to;Xpos--,from--,count++){
				map[Xpos][Ypos] = "*";
				mapOfGame.put(Xpos+""+Ypos, map[Xpos][Ypos].toString());
				posNumOfMap.put(count, Xpos+""+Ypos);
			}
		}
		else{
			System.out.println("bottomToTop(int "+from+",int "+to+" ) "+ "has problem");
			System.exit(0);
		}
	}
	
	/*
	 * this method verifies if the path that is to be created is valid or not
	 */
	public boolean checkMapCreator(int from,int to,int tbrf) {
		switch (tbrf) {
		case 1:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to<from)?false:true;
		case 2:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to>from)?false:true;
		case 3:
			return (from<0 ||from>MaxX||to>MaxY||to<0||to<from)?false:true;
		case 4:
			return (from<0 ||from>MaxY||to>MaxY||to<0||to>from)?false:true;
		default:
			break;
		}

		return false;
		
	}
	/*
	 * set the other options than land
	 */
	public void setOtherOption(int row,int col,String newOpt){
		map[row][col] = newOpt;
		mapOfGame.put(row+""+col, map[row][col]);
		posNumOfMap.put(count, row+""+col);
	}
	
}

import java.io.*;


public class GameFileReader extends GameMapping{
	
	/*
	 *declear the variable that will return after reading a file
	 */
	private String stringFromFile;
	
	public GameFileReader(){
		
	}
	
	//this function will return string after reading particular file
	
	public String readFile(String  fileName) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//for each line of the game map text
		int lineNum=0;
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line!=null) {
		    	/*
		    	 * this loop is for setting the map
		    	 * each line of the GameMap.txt is going to be read here
		    	 * then set the map
		    	 */
		    	for(int i=0;i<line.length();i++){
		    		GameControl.gameMapping.map[lineNum][i]=line.charAt(i)+"";
		    	}
		    	
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        lineNum++;
		    }
		    
		    stringFromFile= sb.toString();
		    
		} finally {
			
		    br.close();
		}
		return stringFromFile;
	}
	
	/*
	 *this method is for writing in a file 
	 */
	public void writeInFile(String writeString,String fileName) throws IOException {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(fileName), "utf-8"));
		    writer.write(writeString);
		} catch (IOException ex) {
		  
		} finally {
		   writer.close();
		}
		
	}

}

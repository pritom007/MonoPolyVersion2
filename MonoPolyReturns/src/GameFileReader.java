import java.io.*;


public class GameFileReader {
	
	/*
	 *declear the variable that will return after reading a file
	 */
	private String stringFromFile;
	
	public GameFileReader(){
		
	}
	
	//this function will return string after reading particular file
	public String readFile(String  fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line!=null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;


public class FileReaderTest {
	
	GameFileReader GFR=new GameFileReader();

	@Test (expected=FileNotFoundException.class)
	public void testGameFileRead_readFile1() throws IOException  {

		GFR.readFile("GameMap.txt");
	}
	@Test
	public void  testGameFileRead_readFile2() throws IOException{
		assertEquals("abc"+System.lineSeparator()+"abc"+System.lineSeparator(), GFR.readFile("src/GameMap.txt"));
		
	}
	

}

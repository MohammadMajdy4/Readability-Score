package readability;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Input {

	
	// reading file and returning its content as a string 
	public String readFile(String fileName){
		
		File file = new File(fileName);
		
		StringBuilder text = new StringBuilder();
		
		
		try (Scanner scan = new Scanner(file)) {
		   
			while (scan.hasNext()) {
				text.append(scan.nextLine());
		    }
			
		} catch (FileNotFoundException e) {
			
		    System.out.println("file not found: " + fileName);
		    
		}
		
		
		return text.toString();
	}
	
	
	// taking type of test from user
	public String inputTypeOfTest() {
		
		return new Scanner(System.in).next();
	
	}
	
}

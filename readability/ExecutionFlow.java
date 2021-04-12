package readability;

public class ExecutionFlow {
	
	Input scan  = new Input();
	Output out  = new Output();
		
	public void run(String fileName) {
		
		
		// read the file :
		String text = scan.readFile(fileName);
		ReadabilityTest test = new ReadabilityTest(text);
		
		// printing text content like number of words, characters and .etc
		out.printTextInfo(test.countChars(), 
				test.countWords(), test.countSentences(), 
				test.countSyllables(), test.countPolysyllables());
		
		// printing a message so you can choose one from the different tests or choose all of them 
		out.chooseTypeOfTestMessage();
		
		// input : type of test
		String typeOfTest = scan.inputTypeOfTest();
		
		test.reset();  
		switch (typeOfTest.toUpperCase()) {
		
		case "ARI":
			ARI(test);
			break;
		
		case "FK":
			FK(test);
			break;
		
		case "SMOG":
			SMOG(test);
			break;
			
		case "CL":
			CL(test);
			break;
			
		case "ALL":
			ARI(test);
			FK(test);
			SMOG(test);
			CL(test);
			double averageAge = test.getAverageAge();
			out.printAverageAge(averageAge);
			break;
			
		}		
		
	}
	
	
	private void ARI(ReadabilityTest test) {
		double scoreARI = test.automatedReadabilityIndex();
		double ageRangeARI = test.suitableAge(scoreARI);
		out.printAutomatedReadabilityIndex(scoreARI, ageRangeARI);
	}
	
	private void SMOG(ReadabilityTest test) {
		double scoreSMOG = test.simpleMeasureOfGobbledygook();
		double ageRangeSMOG = test.suitableAge(scoreSMOG);
		out.printSimpleMeasureOfGobbledygook(scoreSMOG, ageRangeSMOG);
	}
	
	private void CL(ReadabilityTest test) {
		double scoreCL = test.colemanLiauIndex();
		double ageRangeCL = test.suitableAge(scoreCL);
		out.printColemanLiauIndex(scoreCL, ageRangeCL);		
	}
	
	private void FK(ReadabilityTest test) {
		double scoreFK = test.fleschKincaidReadabilityTests();
		double ageRangeFK = test.suitableAge(scoreFK);
		out.printFleschKincaidReadabilityTests(scoreFK, ageRangeFK);
	}
	
}

package readability;

public class Output {

	protected void printTextInfo(int chars, int words, int sentences, int syllables, int polysyllable) {
		
		System.out.printf("Words: %d\nSentences: %d\ncharacters: %d\nSyllables: %d\nPolysyllables: %d\n", 
				words, sentences, chars, syllables, polysyllable);
		
	}
	
	
	protected void chooseTypeOfTestMessage() {
		
		System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
		
	}
	
	protected void printAutomatedReadabilityIndex(double score, double ageRange) {
		
		System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n", 
				score, ageRange > 24 ? Double.toString(24).concat("+") : 
					Double.toString(Math.round(ageRange * 100) /100));
		
	}
	
	protected void printFleschKincaidReadabilityTests(double score, double ageRange) {
		
		System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n", 
				score, ageRange > 24 ? Double.toString(24).concat("+") : 
					Double.toString(Math.round(ageRange * 100) /100));
		
	}
	
	protected void printSimpleMeasureOfGobbledygook(double score, double ageRange) {
		
		System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n", 
				score, ageRange > 24 ? Double.toString(24).concat("+") : 
					Double.toString(Math.round(ageRange * 100) /100));
		
	}
	
	protected void printColemanLiauIndex(double score, double ageRange) {
		
		System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n", 
				score, ageRange > 24 ? Double.toString(24).concat("+") : 
					Double.toString(Math.round(ageRange * 100) /100));
		
	}
	
	
	protected void printAverageAge(double age) {
		
		System.out.printf("This text should be understood in average by %s-year-olds.\n", 
				age > 24 ? Double.toString(age).concat("+") : 
					Double.toString(age * 100 /100));
		
	}
	
	
}

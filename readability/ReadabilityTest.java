package readability;

public class ReadabilityTest {
	
	
	private String text = "";
	private double addedAgeRanges = 0;
	private int numberOfTests     = 0;
	private int sentences 		  = 0;
	private int characters 		  = 0;
	private int words 			  = 0;
	private int syllables 		  = 0;
	private int polysyllables 	  = 0; 
	
	public ReadabilityTest(String text) {
		this.text = text;
		this.sentences     = countSentences();  
	    this.words 	   	   = countWords();
	    this.characters    = countChars();
		this.syllables     = countSyllables();
		this.polysyllables = countPolysyllables();
	}
			
	
	public double getAverageAge() {
		return this.addedAgeRanges / numberOfTests;
	}
	
	
	//The automated readability index (ARI)
    protected double automatedReadabilityIndex() {
    	       
        // Automated readability index formula:
        double readabilityScore =
        		(4.71 * (1.0 * this.characters / this.words) + (0.5 * this.words / this.sentences) - 21.43);
		updateFieldsOfAverageValue(readabilityScore);
        
        return readabilityScore;
    }
    

    
	/* The Flesch–Kincaid readability tests are readability tests designed to indicate how difficult 
       a passage in English is to understand
    */
    protected double fleschKincaidReadabilityTests() {
    	
    	double readabilityScore = 
    			((0.39 * this.words / this.sentences) + (11.80 * this.syllables / this.words) - 15.59);
    	
    	updateFieldsOfAverageValue(readabilityScore);
    	
    	return readabilityScore;
    }
    
    
    
    //
    protected double simpleMeasureOfGobbledygook() {
    	
    	double readabilityScore =
    			(1.043 * Math.sqrt(this.polysyllables * 30.0 / this.sentences) + 3.1291);
    	
    	updateFieldsOfAverageValue(readabilityScore);
    	
    	return readabilityScore;
    }
    
    
    
    //
    protected double colemanLiauIndex() {
    
    	double readabilityScore =
    			(0.0588 * (100.0 * this.characters / this.words) - 0.296 * (100.0 * this.sentences / this.words) - 15.8);
    	
    	updateFieldsOfAverageValue(readabilityScore);
    	
    	return readabilityScore;
    }
    
    
    
    // returns how many chars in the text
    protected int countChars() {

    	String characters = this.text.replaceAll("\\s+", ""); 
        
        return characters.length();
    }
    
    
    
    // returns how many words in the text
    protected int countWords() {
    	String[] words = this.text.split("\\s+");
		return words.length;
	}
    
    
    
    // returns how many sentences in the text
    protected int countSentences() {
    	String[] sentences = this.text.split("[.?!]");
    	return sentences.length;
    }
    
    
    
    // returns number of syllables in the text 
    protected int countSyllables() {
    	
    	String[] syllables = 
    			this.text.replaceAll("[eE][.?!;:,\\s+]", " ").
    			replaceAll("\\s+[^AEOIYUaeouiy]+\\.?\\!?,?;?\\??[^AEOIYUaeouiy]+?\\s+", " xE ").
    			split("[^AEOIYUaeouiy]+");
    	
		return syllables.length;
	}

    
    
    protected int countPolysyllables() {
    	
    	String[] Polysyllables = this.text.replaceAll("[eE][.?!;:,\\s+]", " ").split("\\s+");
    	
    	int count = 0;
    	for (int i = 0; i < Polysyllables.length; i++) {
    		
    		String[] syllables = Polysyllables[i].split("[^AEOIYUaeouiy]+");
    		if (syllables.length > 2) {
    			
    			int countLetters = 0;
    			for (int j = 0; j < syllables.length; j++) {
    				
    				if (syllables[j].toLowerCase().matches("[aeyuioAEYUIO]+")) {
    				
    					countLetters++;
    				}
    				
				}
    			
    			if(countLetters > 2) {
    				count++;
    			}
    		}
    		
    	}
    	
    	return count;
    }
    
    
    // this method updates the global fields needed to calculate average age needed to understand the text
    private void updateFieldsOfAverageValue(double score) {
    	this.addedAgeRanges += suitableAge(score);
        this.numberOfTests++;
    }
    
    
    // reset fields 
    protected void reset() {
    	this.addedAgeRanges = 0;
    	this.numberOfTests = 0;
    }
    
    // calculating suitable age based on the test Score
    protected double suitableAge(double score) {

    	/*
    	Score	Age		Grade Level
    	
    	1		5-6		Kindergarten
    	2		6-7		First/Second Grade
    	3		7-9		Third Grade
    	4		9-10	Fourth Grade
    	5		10-11	Fifth Grade
    	6		11-12	Sixth Grade
    	7		12-13	Seventh Grade
    	8		13-14	Eighth Grade
    	9		14-15	Ninth Grade
    	10		15-16	Tenth Grade
    	11		16-17	Eleventh Grade
    	12		17-18	Twelfth grade
    	13		18-24	College student
    	14		24+		Professor
    	*/
		
		double[] ranges = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 
				 			  17, 18, 24, 25};
		
		return ranges[(int) Math.round(score) - 1];		
	}
    
}
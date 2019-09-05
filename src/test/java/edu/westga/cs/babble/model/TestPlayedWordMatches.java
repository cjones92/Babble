/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class ensures that the matches method of the PlayedWord class
 * works correctly
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestPlayedWordMatches {
	private PlayedWord testPlayedWord;
	
	/**
	 * This method sets up the instance variable for each test method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	/**
	 * This method tests the matches method on a multiple-letter word
	 */
	@Test
	public void hasTilesForAMultipleLetterWord()  {
		
		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('A'));
		this.testPlayedWord.append(new Tile('T'));
		
		assertEquals(true, this.testPlayedWord.matches("EAT"));
	}
	
	/**
	 * This method tests the matches method for a one-letter word
	 */
	@Test
	public void hasTilesForASingleLetterWord() {
		
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);
		
		assertEquals(true, this.testPlayedWord.matches("A"));
	}
	
	/**
	 * This method ensures that the matches method does not match words that
	 * have the same letters (but are in a different order)
	 */
	@Test
	public void cannotMatchWordWhenTilesAreScrambled() {
		
		Tile testTileT = new Tile('T');
		Tile testTileA = new Tile('A');
		Tile testTileG = new Tile('G');
		this.testPlayedWord.append(testTileG);
		this.testPlayedWord.append(testTileT);
		this.testPlayedWord.append(testTileA);
		
		assertEquals(false, this.testPlayedWord.matches("TAG"));
	}
	
	/**
	 * This method ensures that words are not matched when the word entered 
	 * does not have enough letters to match the other word
	 */
	@Test
	public void cannotMatchWordIfInsufficientTiles() {

		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('G'));
		assertEquals(false, this.testPlayedWord.matches("EGG"));
	}
	
	/**
	 * This method ensures that the matches method does match words with
	 * duplicate letters
	 */
	@Test
	public void canMatchWordWithDuplicateLetters() {

		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('G'));
		this.testPlayedWord.append(new Tile('G'));
		
		assertEquals(true, this.testPlayedWord.matches("EGG"));
	}
	
	/**
	 * This method ensures that a non-empty word will not be considered as
	 * matching an empty text
	 */
	@Test
	public void nonEmptyWordShouldNotMatchEmptyText() {
		
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);
		assertEquals(false, this.testPlayedWord.matches(""));
	}
	
	/**
	 * This method ensures that a empty word should not match an empty text
	 */
	@Test
	public void emptyWordShouldNotMatchEmptyText() {
		assertEquals(false, this.testPlayedWord.matches(""));
	}
	
	/**
	 * This method ensures that the matches method does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testPlayedWord.matches(null); });
		
	}

}

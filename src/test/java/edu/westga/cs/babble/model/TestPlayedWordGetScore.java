/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class ensures that the getScore method of the PlayedWord class
 * works correctly
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestPlayedWordGetScore {
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
	 * This method ensures that an empty word receives a score of 0
	 */
	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a one-tile word can be scored 
	 */
	@Test
	public void scoreAOneTileWord() {
	
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);

		assertEquals(1, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a word made up of differing tiles can be scored
	 */
	@Test
	public void scoreAWordWithMultipleDifferingTiles() {
		
		this.testPlayedWord.append(new Tile('B'));
		this.testPlayedWord.append(new Tile('O'));
		this.testPlayedWord.append(new Tile('G'));
		assertEquals(6, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a word with duplicate tiles can be scored
	 */
	@Test
	public void scoreAWordContainingDuplicateTiles() {
		
		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('G'));
		this.testPlayedWord.append(new Tile('G'));
		
		assertEquals(5, this.testPlayedWord.getScore());
	}
	

}

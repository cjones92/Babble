/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

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
	 * This method sets up the instance variable for each method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	/**
	 * This method ensures that an empty word received a score of 0
	 */
	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a one-tile word is scored correctly 
	 */
	@Test
	public void scoreAOneTileWord() {
	
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);

		assertEquals(1, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a word made up of differing tiles is scored
	 * correctly
	 */
	@Test
	public void scoreAWordWithMultipleDifferingTiles() {
		
		Tile testTileB = new Tile('B');
		Tile testTileO = new Tile('O');
		Tile testTileG = new Tile('G');
		this.testPlayedWord.append(testTileB);
		this.testPlayedWord.append(testTileO);
		this.testPlayedWord.append(testTileG);
		assertEquals(6, this.testPlayedWord.getScore());
	}
	
	/**
	 * This method ensures that a word with duplicate tiles is 
	 * scored correctly
	 */
	@Test
	public void scoreAWordContainingDuplicateTiles() {
		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		Tile testTileGDuplicate = new Tile('G');
		this.testPlayedWord.append(testTileE);
		this.testPlayedWord.append(testTileG);
		this.testPlayedWord.append(testTileGDuplicate);
		
		assertEquals(5, this.testPlayedWord.getScore());
	}
	

}

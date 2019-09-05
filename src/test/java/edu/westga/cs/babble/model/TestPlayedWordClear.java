/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

/**
 * This class assures that the clear method of the PlayedWord class works
 * correctly
 * @author Chris Jones	
 * @version August 29, 2019
 *
 */
class TestPlayedWordClear {
	private PlayedWord testPlayedWord;
	
	/**
	 * This method sets up the instance variable
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	/**
	 * This method makes sure that an empty word is cleared
	 */
	@Test
	public void shouldClearEmptyWord() {
		this.testPlayedWord.clear();
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());	
	}
	
	/**
	 * This method makes sure that a word with one tile is cleared
	 */
	@Test
	public void shouldClearWordWithOneTile() {
	
		this.testPlayedWord.append(new Tile('A'));
		this.testPlayedWord.clear();
		
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}
	
	/**
	 * This method ensures that a word with many tiles is cleared
	 */
	@Test
	public void shouldClearWordWithManyTiles() {
		
		this.testPlayedWord.append(new Tile('A'));
		this.testPlayedWord.append(new Tile('P'));
		this.testPlayedWord.append(new Tile('P'));
		this.testPlayedWord.append(new Tile('L'));
		this.testPlayedWord.append(new Tile('E'));
		
		this.testPlayedWord.clear();
		
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}

}

/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

/**
 * @author Chris Jones	
 * @version August 29, 2019
 *
 */
class TestPlayedWordClear {
	private PlayedWord testPlayedWord;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	@Test
	public void shouldClearEmptyWord() {
		this.testPlayedWord.clear();
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());	
	}
	
	@Test
	public void shouldClearWordWithOneTile() {
	
		Tile testTile = new Tile('A');
		this.testPlayedWord.append(testTile);
		this.testPlayedWord.clear();
		
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}
	
	@Test
	public void shouldClearWordWithManyTiles() {
		
		Tile testTileA = new Tile('A');
		Tile testTileP = new Tile('P');
		Tile testTilePDublicate = new Tile('P');
		Tile testTileL = new Tile('L');
		Tile testTileE = new Tile('E');
		
		this.testPlayedWord.append(testTileA);
		this.testPlayedWord.append(testTileP);
		this.testPlayedWord.append(testTilePDublicate);
		this.testPlayedWord.append(testTileL);
		this.testPlayedWord.append(testTileE);
		
		this.testPlayedWord.clear();
		
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}

}

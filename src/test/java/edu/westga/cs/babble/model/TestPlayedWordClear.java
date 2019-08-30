/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Chris Jones	
 * @version August 29, 2019
 *
 */
class TestPlayedWordClear {

	@Test
	public void shouldClearEmptyWord() {
		PlayedWord testPlayedWord = new PlayedWord();
		testPlayedWord.clear();
		assertEquals(true, testPlayedWord.getHand().isEmpty());	
	}
	
	@Test
	public void shouldClearWordWithOneTile() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTile = new Tile('A');
		testPlayedWord.append(testTile);
		testPlayedWord.clear();
		
		assertEquals(true, testPlayedWord.getHand().isEmpty());
	}
	
	@Test
	public void shouldClearWordWithManyTiles() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileA = new Tile('A');
		Tile testTileP = new Tile('P');
		Tile testTilePDublicate = new Tile('P');
		Tile testTileL = new Tile('L');
		Tile testTileE = new Tile('E');
		
		testPlayedWord.append(testTileA);
		testPlayedWord.append(testTileP);
		testPlayedWord.append(testTilePDublicate);
		testPlayedWord.append(testTileL);
		testPlayedWord.append(testTileE);
		
		testPlayedWord.clear();
		
		assertEquals(true, testPlayedWord.getHand().isEmpty());
	}

}

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
class TestPlayedWordGetScore {

	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		PlayedWord testPlayedWord = new PlayedWord();
		assertEquals(0, testPlayedWord.getScore());
	}
	
	@Test
	public void scoreAOneTileWord() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileE = new Tile('E');
		Tile testTileA = new Tile('A');
		Tile testTileT = new Tile('T');
		testPlayedWord.append(testTileE);
		testPlayedWord.append(testTileA);
		testPlayedWord.append(testTileT);
		assertEquals(3, testPlayedWord.getScore());
	}
	
	@Test
	public void scoreAWordWithMultipleDifferingTiles() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileB = new Tile('B');
		Tile testTileO = new Tile('O');
		Tile testTileG = new Tile('G');
		testPlayedWord.append(testTileB);
		testPlayedWord.append(testTileO);
		testPlayedWord.append(testTileG);
		assertEquals(6, testPlayedWord.getScore());
	}
	
	@Test
	public void scoreAWordContainingDuplicateTiles() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		Tile testTileGDuplicate = new Tile('G');
		testPlayedWord.append(testTileE);
		testPlayedWord.append(testTileG);
		testPlayedWord.append(testTileGDuplicate);
		
		assertEquals(5, testPlayedWord.getScore());
	}
	

}

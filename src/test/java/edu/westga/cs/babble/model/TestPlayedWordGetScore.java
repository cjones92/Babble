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
class TestPlayedWordGetScore {
	private PlayedWord testPlayedWord;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.testPlayedWord.getScore());
	}
	
	@Test
	public void scoreAOneTileWord() {
	
		Tile testTileE = new Tile('E');
		Tile testTileA = new Tile('A');
		Tile testTileT = new Tile('T');
		this.testPlayedWord.append(testTileE);
		this.testPlayedWord.append(testTileA);
		this.testPlayedWord.append(testTileT);
		assertEquals(3, this.testPlayedWord.getScore());
	}
	
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

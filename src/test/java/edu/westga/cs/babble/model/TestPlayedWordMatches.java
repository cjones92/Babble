/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestPlayedWordMatches {

	@Test
	public void hasTilesForAMultipleLetterWord()  {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileE = new Tile('E');
		Tile testTileA = new Tile('A');
		Tile testTileT = new Tile('T');
		testPlayedWord.append(testTileE);
		testPlayedWord.append(testTileA);
		testPlayedWord.append(testTileT);
		
		assertEquals(true, testPlayedWord.matches("EAT"));
	}
	
	@Test
	public void hasTilesForASingleLetterWord() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileA = new Tile('A');
		testPlayedWord.append(testTileA);
		
		assertEquals(true, testPlayedWord.matches("A"));
	}
	
	@Test
	public void cannotMatchWordWhenTilesAreScrambled() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileT = new Tile('T');
		Tile testTileA = new Tile('A');
		Tile testTileG = new Tile('G');
		testPlayedWord.append(testTileG);
		testPlayedWord.append(testTileT);
		testPlayedWord.append(testTileA);
		
		assertEquals(false, testPlayedWord.matches("EAT"));
	}
	
	@Test
	public void cannotMatchWordIfInsufficientTiles() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		
		testPlayedWord.append(testTileE);
		testPlayedWord.append(testTileG);
		assertEquals(false, testPlayedWord.matches("EGG"));
	}
	
	@Test
	public void canMatchWordWithDuplicateLetters() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		Tile testTileGDuplicate = new Tile('G');
		testPlayedWord.append(testTileE);
		testPlayedWord.append(testTileG);
		testPlayedWord.append(testTileGDuplicate);
		
		assertEquals(true, testPlayedWord.matches("EGG"));
	}
	
	@Test
	public void nonEmptyWordShouldNotMatchEmptyText() {
		PlayedWord testPlayedWord = new PlayedWord();
		Tile testTileA = new Tile('A');
		testPlayedWord.append(testTileA);
		assertEquals(false, testPlayedWord.matches(""));
	}
	
	@Test
	public void emptyWordShouldNotMatchEmptyText() {
		PlayedWord testPlayedWord = new PlayedWord();
		assertEquals(false, testPlayedWord.matches(""));
	}
	
	@Test
	public void shouldNotAllowNull() {
		PlayedWord testPlayedWord = new PlayedWord();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    testPlayedWord.matches(null); });
		
	}

}

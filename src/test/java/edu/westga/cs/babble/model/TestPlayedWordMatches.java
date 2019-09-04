/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

/**
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestPlayedWordMatches {
	private PlayedWord testPlayedWord;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	@Test
	public void hasTilesForAMultipleLetterWord()  {
		
		Tile testTileE = new Tile('E');
		Tile testTileA = new Tile('A');
		Tile testTileT = new Tile('T');
		this.testPlayedWord.append(testTileE);
		this.testPlayedWord.append(testTileA);
		this.testPlayedWord.append(testTileT);
		
		assertEquals(true, this.testPlayedWord.matches("EAT"));
	}
	
	@Test
	public void hasTilesForASingleLetterWord() {
		
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);
		
		assertEquals(true, this.testPlayedWord.matches("A"));
	}
	
	@Test
	public void cannotMatchWordWhenTilesAreScrambled() {
		
		Tile testTileT = new Tile('T');
		Tile testTileA = new Tile('A');
		Tile testTileG = new Tile('G');
		this.testPlayedWord.append(testTileG);
		this.testPlayedWord.append(testTileT);
		this.testPlayedWord.append(testTileA);
		
		assertEquals(false, this.testPlayedWord.matches("EAT"));
	}
	
	@Test
	public void cannotMatchWordIfInsufficientTiles() {
		
		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		
		this.testPlayedWord.append(testTileE);
		this.testPlayedWord.append(testTileG);
		assertEquals(false, this.testPlayedWord.matches("EGG"));
	}
	
	@Test
	public void canMatchWordWithDuplicateLetters() {

		Tile testTileE = new Tile('E');
		Tile testTileG = new Tile('G');
		Tile testTileGDuplicate = new Tile('G');
		this.testPlayedWord.append(testTileE);
		this.testPlayedWord.append(testTileG);
		this.testPlayedWord.append(testTileGDuplicate);
		
		assertEquals(true, this.testPlayedWord.matches("EGG"));
	}
	
	@Test
	public void nonEmptyWordShouldNotMatchEmptyText() {
		
		Tile testTileA = new Tile('A');
		this.testPlayedWord.append(testTileA);
		assertEquals(false, this.testPlayedWord.matches(""));
	}
	
	@Test
	public void emptyWordShouldNotMatchEmptyText() {
		assertEquals(false, this.testPlayedWord.matches(""));
	}
	
	@Test
	public void shouldNotAllowNull() {		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testPlayedWord.matches(null); });
		
	}

}

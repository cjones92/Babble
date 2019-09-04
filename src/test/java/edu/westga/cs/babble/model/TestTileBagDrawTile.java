/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

/**
 * @author Chris Jones
 * @version August 27, 2019
 *
 */
class TestTileBagDrawTile {
	private TileBag testTileBag;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileBag = new TileBag();
	}

	@Test
	public void canDrawAllFiles() {
		
		for (int index = 0; index < 98; index++) {
			try {
				this.testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				
				e.printStackTrace();
			}
		}
		
		assertEquals(true, this.testTileBag.isEmpty());

	}
	
	@Test
	public void canNotDrawTooManyTiles() {
		
		for (int index = 0; index < 98; index++) {
			try {
				this.testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
		
		Assertions.assertThrows(EmptyTileBagException.class, () -> {
		    this.testTileBag.drawTile(); });		
	}
	
	@Test 
	public void hasProperTileDistribution() {

		ArrayList<Character> tiles = new ArrayList<Character>();
		ArrayList<Character> letters = new ArrayList<Character>( Arrays.asList('A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
				'B', 'B', 'C', 'C', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E','E', 'E', 'F', 'F', 'G', 'G', 'G', 'H', 'H', 'I', 'I', 'I', 'I', 'I','I',
				'I', 'I', 'I', 'J', 'K', 'L', 'L', 'L', 'L', 'M', 'M', 'N', 'N', 'N', 'N', 'N', 'N', 'O', 'O', 'O', 'O', 'O',
				'O', 'O', 'O', 'P', 'P', 'Q', 'R', 'R', 'R', 'R', 'R', 'R', 'S', 'S', 'S', 'S', 'T', 'T', 'T', 'T', 'T', 'T', 'U',
				'U', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'Y', 'Y', 'Z'));
				
				for (int index = 0; index < 98; index++) {
			try {
				char pulledTile = this.testTileBag.drawTile().getLetter();
				tiles.add(pulledTile);
				
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(tiles);
		
		assertEquals(true, letters.equals(tiles));
		
	}

}

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
import org.junit.jupiter.api.Test;

/**
 * @author Chris Jones
 * @version August 27, 2019
 *
 */
class TestTileBagDrawTile {

	@Test
	public void canDrawAllFiles() {
		TileBag testTileBag = new TileBag();
		for (int index = 0; index < 98; index++) {
			try {
				testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		assertEquals(true, testTileBag.isEmpty());

	}
	
	@Test
	public void canNotDrawTooManyTiles() {
		
		
		TileBag testTileBag = new TileBag();
		for (int index = 0; index < 98; index++) {
			try {
				testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
		
		Assertions.assertThrows(EmptyTileBagException.class, () -> {
		    testTileBag.drawTile(); });		
	}
	
	@Test 
	public void hasProperTileDistribution() {
		TileBag testTileBag = new TileBag();
		ArrayList<Character> tiles = new ArrayList<Character>();
		ArrayList<Character> letters = new ArrayList<Character>( Arrays.asList('A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
				'B', 'B', 'C', 'C', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E','E', 'E', 'F', 'F', 'G', 'G', 'G', 'H', 'H', 'I', 'I', 'I', 'I', 'I','I',
				'I', 'I', 'I', 'J', 'K', 'L', 'L', 'L', 'L', 'M', 'M', 'N', 'N', 'N', 'N', 'N', 'N', 'O', 'O', 'O', 'O', 'O',
				'O', 'O', 'O', 'P', 'P', 'Q', 'R', 'R', 'R', 'R', 'R', 'R', 'S', 'S', 'S', 'S', 'T', 'T', 'T', 'T', 'T', 'T', 'U',
				'U', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'Y', 'Y', 'Z'));
				
				for (int index = 0; index < 98; index++) {
			try {
				char pulledTile = testTileBag.drawTile().getLetter();
				tiles.add(pulledTile);
				
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(tiles);
		
		assertEquals(true, letters.equals(tiles));
		
	}

}

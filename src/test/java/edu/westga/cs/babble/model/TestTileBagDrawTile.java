/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This class checks to make sure that the drawTile method of the TileBag class
 * works correctly
 * @author Chris Jones
 * @version August 27, 2019
 *
 */
class TestTileBagDrawTile {
	private TileBag testTileBag;
	
	/**
	 * This method sets up the instance variable for each method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileBag = new TileBag();
	}

	/**
	 * This method ensures that all of the tiles can be drawn without an issue
	 * @throws EmptyTileBagException
	 */
	@Test
	public void canDrawAllFiles() throws EmptyTileBagException {
		
		for (int index = 0; index < 98; index++) {
			
		this.testTileBag.drawTile();
			
		}
		
		assertEquals(true, this.testTileBag.isEmpty());

	}
	
	/**
	 * This method ensures that the drawTile method does not allow any 
	 * drawing of tiles after the max number of tiles has been reached
	 * @throws EmptyTileBagException
	 */
	@Test
	public void canNotDrawTooManyTiles() throws EmptyTileBagException {
		
		for (int index = 0; index < 98; index++) {
			
			this.testTileBag.drawTile();
			
		}
		
		assertThrows(EmptyTileBagException.class, () -> {
		    this.testTileBag.drawTile(); });		
	}
	
	/**
	 * This method ensures that all of the tiles are drawn out in the right
	 * configuration
	 * @throws EmptyTileBagException
	 */
	@Test 
	public void hasProperTileDistribution() throws EmptyTileBagException {

		ArrayList<Character> tiles = new ArrayList<Character>();
		ArrayList<Character> letters = new ArrayList<Character>( Arrays.asList('A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
				'B', 'B', 'C', 'C', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E','E', 'E', 'F', 'F', 'G', 'G', 'G', 'H', 'H', 'I', 'I', 'I', 'I', 'I','I',
				'I', 'I', 'I', 'J', 'K', 'L', 'L', 'L', 'L', 'M', 'M', 'N', 'N', 'N', 'N', 'N', 'N', 'O', 'O', 'O', 'O', 'O',
				'O', 'O', 'O', 'P', 'P', 'Q', 'R', 'R', 'R', 'R', 'R', 'R', 'S', 'S', 'S', 'S', 'T', 'T', 'T', 'T', 'T', 'T', 'U',
				'U', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'Y', 'Y', 'Z'));
				
				for (int index = 0; index < 98; index++) {
			
				char pulledTile = this.testTileBag.drawTile().getLetter();
				tiles.add(pulledTile);
				
			
		}
		Collections.sort(tiles);
		
		assertEquals(true, letters.equals(tiles));
		
	}

}

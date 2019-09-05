/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This class makes sure that the TileRack's getNumberOfTilesNeeded method
 * works correctly
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestTileRackGetNumberOfTilesNeeded {
	private TileRack testTileRack;
	
	/**
	 * This class sets up the instance variable for each test method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileRack = new TileRack();
	}

	/**
	 * This method ensures that an empty TileRack receives the maximum
	 * number of tiles that should be in a TileRack
	 */
	@Test
	public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {

		assertEquals(7, this.testTileRack.getNumberOfTilesNeeded());
	}
	
	/**
	 * This method ensures that a TileRack with one tile will receive
	 * the maximum number of tiles minus one
	 */
	@Test 
	public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		
		Tile firstTile = new Tile('A');
		this.testTileRack.append(firstTile);
		assertEquals(6, this.testTileRack.getNumberOfTilesNeeded());
		
	}
	
	/**
	 * This method ensures that a word with several tiles will need to have 
	 * some tiles added
	 */
	@Test 
	public void tileRackWithSeveralTilesShouldNeedSomeTiles() {
	
		this.testTileRack.append(new Tile('A'));
		this.testTileRack.append(new Tile('B'));
		this.testTileRack.append(new Tile('C'));
		this.testTileRack.append(new Tile('D'));
		this.testTileRack.append(new Tile('E'));
		assertEquals(2, this.testTileRack.getNumberOfTilesNeeded());
		
	}
	
	/**
	 * This method ensures that a full rack receives no tiles from the 
	 * getNumberOfTilesNeeded method
	 */
	@Test
	public void fullRackNeedsZeroTiles() {
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
				
		this.testTileRack.append(new Tile('A'));
		this.testTileRack.append(new Tile('B'));
		this.testTileRack.append(new Tile('C'));
		this.testTileRack.append(new Tile('D'));
		this.testTileRack.append(new Tile('E'));
		this.testTileRack.append(new Tile('F'));
		this.testTileRack.append(new Tile('G'));
		
		assertEquals(0, this.testTileRack.getNumberOfTilesNeeded());
	}
}

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
class TestTileRackGetNumberOfTilesNeeded {
	private TileRack testTileRack;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileRack = new TileRack();
	}

	@Test
	public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {

		assertEquals(7, this.testTileRack.getNumberOfTilesNeeded());
	}
	
	@Test 
	public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		
		Tile firstTile = new Tile('A');
		this.testTileRack.append(firstTile);
		assertEquals(6, this.testTileRack.getNumberOfTilesNeeded());
		
	}
	
	@Test 
	public void tileRackWithSeveralTilesShouldNeedSomeTiles() {
	
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		this.testTileRack.append(firstTile);
		this.testTileRack.append(secondTile);
		this.testTileRack.append(thirdTile);
		this.testTileRack.append(fourthTile);
		this.testTileRack.append(fifthTile);
		assertEquals(2, this.testTileRack.getNumberOfTilesNeeded());
		
	}
	
	@Test
	public void fullRackNeedsZeroFiles() {
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		Tile sixthTile = new Tile('F');
		Tile seventhTile = new Tile('G');
		
		this.testTileRack.append(firstTile);
		this.testTileRack.append(secondTile);
		this.testTileRack.append(thirdTile);
		this.testTileRack.append(fourthTile);
		this.testTileRack.append(fifthTile);
		this.testTileRack.append(sixthTile);
		this.testTileRack.append(seventhTile);
		
		assertEquals(0, this.testTileRack.getNumberOfTilesNeeded());
	}
}

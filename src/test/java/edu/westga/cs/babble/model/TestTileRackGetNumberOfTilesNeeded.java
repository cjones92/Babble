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
class TestTileRackGetNumberOfTilesNeeded {

	@Test
	public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {
		TileRack testTileRack = new TileRack();
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
	}
	
	@Test 
	public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {
		TileRack testTileRack = new TileRack();
		Tile firstTile = new Tile('A');
		testTileRack.append(firstTile);
		assertEquals(6, testTileRack.getNumberOfTilesNeeded());
		
	}
	
	@Test 
	public void tileRackWithSeveralTilesShouldNeedSomeTiles() {
		TileRack testTileRack = new TileRack();
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		testTileRack.append(firstTile);
		testTileRack.append(secondTile);
		testTileRack.append(thirdTile);
		testTileRack.append(fourthTile);
		testTileRack.append(fifthTile);
		assertEquals(2, testTileRack.getNumberOfTilesNeeded());
		
	}
	
	@Test
	public void fullRackNeedsZeroFiles() {
		TileRack testTileRack = new TileRack();
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		Tile sixthTile = new Tile('F');
		Tile seventhTile = new Tile('G');
		
		testTileRack.append(firstTile);
		testTileRack.append(secondTile);
		testTileRack.append(thirdTile);
		testTileRack.append(fourthTile);
		testTileRack.append(fifthTile);
		testTileRack.append(sixthTile);
		testTileRack.append(seventhTile);
		
		assertEquals(0, testTileRack.getNumberOfTilesNeeded());
	}
}

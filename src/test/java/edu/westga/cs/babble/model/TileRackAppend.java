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
class TileRackAppend {

	@Test
	void shouldNotAppendToFullRack() {
		TileRack testTileRack = new TileRack();
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		Tile sixthTile = new Tile('F');
		Tile seventhTile = new Tile('G');
		Tile eighthTile = new Tile('H');
		testTileRack.append(firstTile);
		testTileRack.append(secondTile);
		testTileRack.append(thirdTile);
		testTileRack.append(fourthTile);
		testTileRack.append(fifthTile);
		testTileRack.append(sixthTile);
		testTileRack.append(seventhTile);
		
		Assertions.assertThrows(TileRackFullException.class, () -> {
		    testTileRack.append(eighthTile); });
	}

}

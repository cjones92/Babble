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
class TestTileRackAppend {
	
	private TileRack testTileRack;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileRack = new TileRack();
	}

	@Test
	void shouldNotAppendToFullRack() {
		
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());
		Tile firstTile = new Tile('A');
		Tile secondTile = new Tile('B');
		Tile thirdTile = new Tile('C');
		Tile fourthTile = new Tile('D');
		Tile fifthTile = new Tile('E');
		Tile sixthTile = new Tile('F');
		Tile seventhTile = new Tile('G');
		Tile eighthTile = new Tile('H');
		this.testTileRack.append(firstTile);
		this.testTileRack.append(secondTile);
		this.testTileRack.append(thirdTile);
		this.testTileRack.append(fourthTile);
		this.testTileRack.append(fifthTile);
		this.testTileRack.append(sixthTile);
		this.testTileRack.append(seventhTile);
		
		Assertions.assertThrows(TileRackFullException.class, () -> {
		    this.testTileRack.append(eighthTile); });
	}

}

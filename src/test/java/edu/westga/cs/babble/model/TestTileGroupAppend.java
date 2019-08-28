/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Chris Jones
 * @version August 28, 2019
 *
 */
class TestTileGroupAppend {
	
	class DummyTileGroup extends TileGroup {
		
	}

	@Test
	public void shouldNotAllowNull() {
		TileGroup testTileGroup = new DummyTileGroup();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    testTileGroup.append(null); });
	}
	
	@Test
	public void EmptyGroupShouldBeEmpty() {
		TileGroup testTileGroup = new DummyTileGroup();
		assertEquals(0, testTileGroup.tiles().size());
	}
	
	@Test
	public void shouldHaveOneTileInTileGroup() {
		TileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTile = new Tile('G');
		testTileGroup.append(dummyTile);
		assertEquals(1, testTileGroup.tiles().size());
		assertEquals('G', testTileGroup.tiles().get(0).getLetter());
	}
	
	@Test
	public void shouldHaveManyTilesInTileGroup() {
		TileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		assertEquals('G', testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', testTileGroup.tiles().get(3).getLetter());
	}
	
	@Test
	public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		TileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		Tile dummyTileFive = new Tile('I');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		testTileGroup.append(dummyTileFive);
		assertEquals('G', testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', testTileGroup.tiles().get(3).getLetter());
		assertEquals('I', testTileGroup.tiles().get(4).getLetter());
	}
	
	@Test
	public void canNotAddSameTileTwice() {
		TileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTileOne = new Tile('G');
		testTileGroup.append(dummyTileOne);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    testTileGroup.append(dummyTileOne); });
		
	}

}

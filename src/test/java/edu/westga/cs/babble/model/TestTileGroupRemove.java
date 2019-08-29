/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Chris Jones
 * @version August 28, 2019
 *
 */
class TestTileGroupRemove {

	class DummyTileGroup extends TileGroup {
	
		
	}
	
	@Test
	public void shouldNotAllowNull() {
		DummyTileGroup testTileGroup = new DummyTileGroup();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    testTileGroup.remove(null); });
	}
	
	@Test
	public void canNotRemoveFromEmptyTileGroup() {
		DummyTileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTile = new Tile('G');
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    testTileGroup.remove(dummyTile); });
	}
	
	@Test
	public void canNotRemoveTileNotInTileGroup() {
		DummyTileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTile = new Tile('G');
		
		Tile dummyTileTwo = new Tile('H');
		testTileGroup.append(dummyTileTwo);
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    testTileGroup.remove(dummyTile); });
		
	}
	
	@Test
	public void canRemoveOnlyTileInTileGroup() {
		
		DummyTileGroup testTileGroup = new DummyTileGroup();
		Tile dummyTile = new Tile('G');
		testTileGroup.append(dummyTile);
		try {
			testTileGroup.remove(dummyTile);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("", testTileGroup.getHand());
	}
	
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() {
		DummyTileGroup testTileGroup = new DummyTileGroup();
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		
		try {
			testTileGroup.remove(dummyTileOne);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("HIJ", testTileGroup.getHand());
		
	}
	
	@Test 
	public void canRemoveLastOfManyTilesFromTileGroup() {
DummyTileGroup testTileGroup = new DummyTileGroup();
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		
		try {
			testTileGroup.remove(dummyTileFour);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("GHI", testTileGroup.getHand());
		
	}
	
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() {
DummyTileGroup testTileGroup = new DummyTileGroup();
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		
		try {
			testTileGroup.remove(dummyTileTwo);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("GIJ", testTileGroup.getHand());
	}
	
	@Test
	public void canRemoveMultipleTilesFromTileGroup() {
		
DummyTileGroup testTileGroup = new DummyTileGroup();
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		
		try {
			testTileGroup.remove(dummyTileTwo);
			testTileGroup.remove(dummyTileThree);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		assertEquals("GJ", testTileGroup.getHand());
	}
	
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() {
		
DummyTileGroup testTileGroup = new DummyTileGroup();
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		testTileGroup.append(dummyTileOne);
		testTileGroup.append(dummyTileTwo);
		testTileGroup.append(dummyTileThree);
		testTileGroup.append(dummyTileFour);
		
		try {
			testTileGroup.remove(dummyTileTwo);
			testTileGroup.remove(dummyTileThree);
		} catch (TileNotInGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    testTileGroup.remove(dummyTileThree); });
	}

}

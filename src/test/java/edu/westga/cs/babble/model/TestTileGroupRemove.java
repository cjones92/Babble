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
 * @version August 28, 2019
 *
 */
class TestTileGroupRemove {
	private TileGroup testTileGroup;

	class DummyTileGroup extends TileGroup {
	
		
	}
	
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileGroup = new DummyTileGroup();
	}
	
	@Test
	public void shouldNotAllowNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.remove(null); });
	}
	
	@Test
	public void canNotRemoveFromEmptyTileGroup() {
		
		Tile dummyTile = new Tile('G');
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTile); });
	}
	
	@Test
	public void canNotRemoveTileNotInTileGroup() {
		
		Tile dummyTile = new Tile('G');
		
		Tile dummyTileTwo = new Tile('H');
		this.testTileGroup.append(dummyTileTwo);
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTile); });
		
	}
	
	@Test
	public void canRemoveOnlyTileInTileGroup() {
		
		
		Tile dummyTile = new Tile('G');
		this.testTileGroup.append(dummyTile);
		try {
			this.testTileGroup.remove(dummyTile);
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}
		assertEquals("", this.testTileGroup.getHand());
	}
	
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() {
		
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		try {
			this.testTileGroup.remove(dummyTileOne);
		} catch (TileNotInGroupException e) {
		
			e.printStackTrace();
		}
		
		assertEquals("HIJ", this.testTileGroup.getHand());
		
	}
	
	@Test 
	public void canRemoveLastOfManyTilesFromTileGroup() {

		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		try {
			this.testTileGroup.remove(dummyTileFour);
		} catch (TileNotInGroupException e) {
		
			e.printStackTrace();
		}
		
		assertEquals("GHI", this.testTileGroup.getHand());
		
	}
	
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() {

		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		try {
			this.testTileGroup.remove(dummyTileTwo);
		} catch (TileNotInGroupException e) {
			
			e.printStackTrace();
		}
		
		assertEquals("GIJ", this.testTileGroup.getHand());
	}
	
	@Test
	public void canRemoveMultipleTilesFromTileGroup() {
		
	
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		try {
			this.testTileGroup.remove(dummyTileTwo);
			this.testTileGroup.remove(dummyTileThree);
		} catch (TileNotInGroupException e) {
			
			e.printStackTrace();
		
	}
		assertEquals("GJ", this.testTileGroup.getHand());
	}
	
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() {
		
	
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		try {
			this.testTileGroup.remove(dummyTileTwo);
			this.testTileGroup.remove(dummyTileThree);
		} catch (TileNotInGroupException e) {
			
			e.printStackTrace();
		
	}
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTileThree); });
	}

}

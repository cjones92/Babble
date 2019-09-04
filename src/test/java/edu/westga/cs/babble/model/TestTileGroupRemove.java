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
 * This class ensures the TestTile class's remove method works properly
 * @author Chris Jones
 * @version August 28, 2019
 *
 */
class TestTileGroupRemove {
	private TileGroup testTileGroup;

	
	/**
	 * This class is a concrete class that inherits the abstract TileGroup
	 * class. It is created for testing the TileGroup class
	 * @author Chris Jones
	 * @version August 28, 2019
	 *
	 */
	
	class DummyTileGroup extends TileGroup {
	
		
	}
	
	/**
	 * This method sets up the instance variable for each test method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileGroup = new DummyTileGroup();
	}
	
	/**
	 * This method ensures that the remove method does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.remove(null); });
	}
	
	/**
	 * This method ensures that the remove method does not remove anything
	 * from empty TileGroups
	 */
	@Test
	public void canNotRemoveFromEmptyTileGroup() {
		
		Tile dummyTile = new Tile('G');
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTile); });
	}
	
	/**
	 * This method ensures that the remove method cannot remove a tile
	 * not already appended to the TileGroup
	 */
	@Test
	public void canNotRemoveTileNotInTileGroup() {
		
		Tile dummyTile = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		this.testTileGroup.append(dummyTileTwo);
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTile); });
		
	}
	
	/**
	 * This method ensures that the remove method can remove the one tile
	 * in a one-tile group
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveOnlyTileInTileGroup() throws TileNotInGroupException {
		
		Tile dummyTile = new Tile('G');
		this.testTileGroup.append(dummyTile);

		this.testTileGroup.remove(dummyTile);
		
		assertEquals("", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method can remove the first tile
	 * in a large word
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() throws TileNotInGroupException {
		
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		
			this.testTileGroup.remove(dummyTileOne);
		
		
		assertEquals("HIJ", this.testTileGroup.getHand());
		
	}
	
	/**
	 * This method ensures the remove method can remove the last tile
	 * of a large word
	 * @throws TileNotInGroupException
	 */
	@Test 
	public void canRemoveLastOfManyTilesFromTileGroup() throws TileNotInGroupException {

		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		this.testTileGroup.remove(dummyTileFour);
		
		assertEquals("GHI", this.testTileGroup.getHand());
		
	}
	
	/**
	 * This method ensures that the remove method can remove tiles from the
	 * middle of a large word
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() throws TileNotInGroupException {

		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		this.testTileGroup.remove(dummyTileTwo);
		
		assertEquals("GIJ", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method can remove multiple
	 * tiles from a large word
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMultipleTilesFromTileGroup() throws TileNotInGroupException {
		
	
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		this.testTileGroup.remove(dummyTileTwo);
		this.testTileGroup.remove(dummyTileThree);
		
		assertEquals("GJ", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method does not remove duplicate
	 * tiles from a TileGroup
	 * @throws TileNotInGroupException
	 */
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() throws TileNotInGroupException {
		
	
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		
		
		this.testTileGroup.remove(dummyTileTwo);
		this.testTileGroup.remove(dummyTileThree);
	
		Assertions.assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTileThree); });
	}

}

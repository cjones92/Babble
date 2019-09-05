/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
		
		assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.remove(null); });
	}
	
	/**
	 * This method ensures that the remove method does not remove anything
	 * from empty TileGroups
	 */
	@Test
	public void canNotRemoveFromEmptyTileGroup() {
		
		Tile dummyTile = new Tile('G');
		assertThrows(TileNotInGroupException.class, () -> {
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
		assertThrows(TileNotInGroupException.class, () -> {
		    this.testTileGroup.remove(dummyTile); });
		
	}
	
	/**
	 * This method ensures that the remove method can remove the one tile
	 * in a one-tile group
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveOnlyTileInTileGroup()  {
		
		this.testTileGroup.append(new Tile('G'));
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(0));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}
		
		assertEquals("", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method can remove the first tile
	 * in a collection of tiles
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() {
	
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(0));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}
		
		assertEquals("HIJ", this.testTileGroup.getHand());
		
	}
	
	/**
	 * This method ensures the remove method can remove the last tile
	 * of a collection of tiles
	 * @throws TileNotInGroupException
	 */
	@Test 
	public void canRemoveLastOfManyTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(3));
		} catch (TileNotInGroupException e) {
	
			e.printStackTrace();
		}
		
		assertEquals("GHI", this.testTileGroup.getHand());
		
	}
	
	/**
	 * This method ensures that the remove method can remove tiles from the
	 * middle of a collection of tiles
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(1));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}
		
		assertEquals("GIJ", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method can remove multiple
	 * tiles from a tile collection
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMultipleTilesFromTileGroup() {
		
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
				
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(1));
			this.testTileGroup.remove(this.testTileGroup.tiles().get(1));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}		
				
		
		assertEquals("GJ", this.testTileGroup.getHand());
	}
	
	/**
	 * This method ensures that the remove method does not remove duplicate
	 * tiles from a TileGroup
	 * @throws TileNotInGroupException
	 */
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() {
		
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		
		
		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(1));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}
	
		assertEquals('G', testTileGroup.getHand().charAt(0));
		assertEquals('I', testTileGroup.getHand().charAt(1));
	}

}

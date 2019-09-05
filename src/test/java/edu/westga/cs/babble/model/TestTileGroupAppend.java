/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.babble.controllers.WordDictionary;

/**
 * This class ensures that the TestTile class's append method works
 * correctly
 * @author Chris Jones
 * @version August 28, 2019
 *
 */
class TestTileGroupAppend {
	
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
	 *This method sets up the instance variable for the other methods
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileGroup = new DummyTileGroup();
	}
	
	
	/**
	 * This method ensures that the append method does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.append(null); });
	}
	
	/**
	 * This method ensures that an empty group is in fact empty
	 */
	@Test
	public void EmptyGroupShouldBeEmpty() {
		
		assertEquals(0, this.testTileGroup.tiles().size());
	}
	
	/**
	 * This method ensures that a group with one tile does in fact have
	 * one tile in it
	 */
	@Test
	public void shouldHaveOneTileInTileGroup() {
		
		Tile dummyTile = new Tile('G');
		this.testTileGroup.append(dummyTile);
		assertEquals(1, this.testTileGroup.tiles().size());
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
	}
	
	/**
	 * This method ensures that the append method can add multiple tiles
	 * to a TileGroup 
	 */
	@Test
	public void shouldHaveManyTilesInTileGroup() {
		
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', this.testTileGroup.tiles().get(3).getLetter());
	}
	
	/**
	 * This method ensures that duplicate tiles can be added using the
	 * append method
	 */
	@Test
	public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		
		
		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('J'));
		this.testTileGroup.append(new Tile('I'));
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', this.testTileGroup.tiles().get(3).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(4).getLetter());
	}
	
	/**
	 * This method ensures that the same tile cannot be added twice
	 */
	@Test
	public void canNotAddSameTileTwice() {
		
		Tile dummyTileOne = new Tile('G');
		this.testTileGroup.append(dummyTileOne);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.append(dummyTileOne); });
		
	}

}

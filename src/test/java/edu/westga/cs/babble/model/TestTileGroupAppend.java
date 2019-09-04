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
 * @author Chris Jones
 * @version August 28, 2019
 *
 */
class TestTileGroupAppend {
	
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
		    this.testTileGroup.append(null); });
	}
	
	@Test
	public void EmptyGroupShouldBeEmpty() {
		
		assertEquals(0, this.testTileGroup.tiles().size());
	}
	
	@Test
	public void shouldHaveOneTileInTileGroup() {
		
		Tile dummyTile = new Tile('G');
		this.testTileGroup.append(dummyTile);
		assertEquals(1, this.testTileGroup.tiles().size());
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
	}
	
	@Test
	public void shouldHaveManyTilesInTileGroup() {
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', this.testTileGroup.tiles().get(3).getLetter());
	}
	
	@Test
	public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		
		Tile dummyTileOne = new Tile('G');
		Tile dummyTileTwo = new Tile('H');
		Tile dummyTileThree = new Tile('I');
		Tile dummyTileFour = new Tile('J');
		Tile dummyTileFive = new Tile('I');
		this.testTileGroup.append(dummyTileOne);
		this.testTileGroup.append(dummyTileTwo);
		this.testTileGroup.append(dummyTileThree);
		this.testTileGroup.append(dummyTileFour);
		this.testTileGroup.append(dummyTileFive);
		assertEquals('G', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('H', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('J', this.testTileGroup.tiles().get(3).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(4).getLetter());
	}
	
	@Test
	public void canNotAddSameTileTwice() {
		
		Tile dummyTileOne = new Tile('G');
		this.testTileGroup.append(dummyTileOne);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.append(dummyTileOne); });
		
	}

}

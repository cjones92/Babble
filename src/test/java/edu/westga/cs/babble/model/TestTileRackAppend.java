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
 * This class tests to see that the append method in the TileRack class
 * works correctly
 * @author Chris Jones
 * @version August 29, 2019
 *
 */
class TestTileRackAppend {
	
	private TileRack testTileRack;
	
	/**
	 * This method sets up the instance variable for each test method
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testTileRack = new TileRack();
	}

	/**
	 * This method ensures that the append method does not append to a rack
	 * that is already full
	 */
	@Test
	void shouldNotAppendToFullRack() {
		
		this.testTileRack.append(new Tile('A'));
		this.testTileRack.append(new Tile('B'));
		this.testTileRack.append(new Tile('C'));
		this.testTileRack.append(new Tile('D'));
		this.testTileRack.append(new Tile('E'));
		this.testTileRack.append(new Tile('F'));
		this.testTileRack.append(new Tile('G'));
		
		Assertions.assertThrows(TileRackFullException.class, () -> {
		    this.testTileRack.append(new Tile('H')); });
	}

}

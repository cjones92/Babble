/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Tile constructor
 * @author Chris Jones
 * @version August 27, 2019
 *
 */
class TestTileConstructor {

	/**
	 * This method tests to ensure that the constructor only accepts letters
	 */
	@Test
	public void shouldNotAllowNonLetters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile('7'); });
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile(' '); });
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile('/'); });
	}
	
	/**
	 * This method tests to ensure that all of the one point tiles are 
	 * created from both capital and lowercase entries
	 */
	@Test
	public void shouldCreateOnePointTiles() {
		Tile testTileE = new Tile('E');
		assertEquals('E', testTileE.getLetter());
		assertEquals(1, testTileE.getPointValue());
		Tile testTileEe = new Tile('e');
		assertEquals('E', testTileEe.getLetter());
		assertEquals(1, testTileEe.getPointValue());
		Tile testTileA = new Tile('A');
		assertEquals('A', testTileA.getLetter());
		assertEquals(1, testTileA.getPointValue());
		Tile testTileAa = new Tile('a');
		assertEquals('A', testTileAa.getLetter());
		assertEquals(1, testTileAa.getPointValue());
		Tile testTileI = new Tile('I');
		assertEquals('I', testTileI.getLetter());
		assertEquals(1, testTileI.getPointValue());
		Tile testTileIi = new Tile('i');
		assertEquals('I', testTileIi.getLetter());
		assertEquals(1, testTileIi.getPointValue());
		Tile testTileO = new Tile('O');
		assertEquals('O', testTileO.getLetter());
		assertEquals(1, testTileO.getPointValue());
		Tile testTileOo = new Tile('o');
		assertEquals('O', testTileOo.getLetter());
		assertEquals(1, testTileOo.getPointValue());
		Tile testTileN = new Tile('N');
		assertEquals('N', testTileN.getLetter());
		assertEquals(1, testTileN.getPointValue());
		Tile testTileNn = new Tile('n');
		assertEquals('N', testTileNn.getLetter());
		assertEquals(1, testTileNn.getPointValue());
		Tile testTileR = new Tile('R');
		assertEquals('R', testTileR.getLetter());
		assertEquals(1, testTileR.getPointValue());
		Tile testTileRr = new Tile('r');
		assertEquals('R', testTileRr.getLetter());
		assertEquals(1, testTileRr.getPointValue());
		Tile testTileT = new Tile('T');
		assertEquals('T', testTileT.getLetter());
		assertEquals(1, testTileT.getPointValue());
		Tile testTileTt = new Tile('t');
		assertEquals('T', testTileTt.getLetter());
		assertEquals(1, testTileTt.getPointValue());
		Tile testTileL = new Tile('L');
		assertEquals('L', testTileL.getLetter());
		assertEquals(1, testTileL.getPointValue());
		Tile testTileLl = new Tile('l');
		assertEquals('L', testTileLl.getLetter());
		assertEquals(1, testTileLl.getPointValue());
		Tile testTileS = new Tile('S');
		assertEquals('S', testTileS.getLetter());
		assertEquals(1, testTileS.getPointValue());
		Tile testTileSs = new Tile('s');
		assertEquals('S', testTileSs.getLetter());
		assertEquals(1, testTileSs.getPointValue());
		Tile testTileU = new Tile('U');
		assertEquals('U', testTileU.getLetter());
		assertEquals(1, testTileU.getPointValue());
		Tile testTileUu = new Tile('u');
		assertEquals('U', testTileUu.getLetter());
		assertEquals(1, testTileUu.getPointValue());
		
	}
	
	/**
	 * This method tests to ensure that only the two-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateTwoPointTiles() {
		Tile testTileD = new Tile('D');
		assertEquals('D', testTileD.getLetter());
		assertEquals(2, testTileD.getPointValue());
		Tile testTileDd = new Tile('d');
		assertEquals('D', testTileDd.getLetter());
		assertEquals(2, testTileDd.getPointValue());
		Tile testTileG = new Tile('G');
		assertEquals('G', testTileG.getLetter());
		assertEquals(2, testTileG.getPointValue());
		Tile testTileGg = new Tile('g');
		assertEquals('G', testTileGg.getLetter());
		assertEquals(2, testTileGg.getPointValue());
	}
	
	/**
	 * This method ensures that all of the three-point tiles are created
	 * from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateThreePointTiles() {
		Tile testTileB = new Tile('B');
		assertEquals('B', testTileB.getLetter());
		assertEquals(3, testTileB.getPointValue());
		Tile testTileBb = new Tile('b');
		assertEquals('B', testTileBb.getLetter());
		assertEquals(3, testTileBb.getPointValue());
		Tile testTileC = new Tile('C');
		assertEquals('C', testTileC.getLetter());
		assertEquals(3, testTileC.getPointValue());
		Tile testTileCc = new Tile('c');
		assertEquals('C', testTileCc.getLetter());
		assertEquals(3, testTileCc.getPointValue());
		Tile testTileM= new Tile('M');
		assertEquals('M', testTileM.getLetter());
		assertEquals(3, testTileM.getPointValue());
		Tile testTileMm = new Tile('m');
		assertEquals('M', testTileMm.getLetter());
		assertEquals(3, testTileMm.getPointValue());
		Tile testTileP= new Tile('P');
		assertEquals('P', testTileP.getLetter());
		assertEquals(3, testTileP.getPointValue());
		Tile testTilePp= new Tile('p');
		assertEquals('P', testTilePp.getLetter());
		assertEquals(3, testTilePp.getPointValue());
	}
	
	/**
	 * This method ensures that all of the four-point tiles are created
	 * from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateFourPointTiles() {
		Tile testTileF = new Tile('F');
		assertEquals('F', testTileF.getLetter());
		assertEquals(4, testTileF.getPointValue());
		Tile testTileFf = new Tile('f');
		assertEquals('F', testTileFf.getLetter());
		assertEquals(4, testTileFf.getPointValue());
		Tile testTileH = new Tile('H');
		assertEquals('H', testTileH.getLetter());
		assertEquals(4, testTileH.getPointValue());
		Tile testTileHh = new Tile('h');
		assertEquals('H', testTileHh.getLetter());
		assertEquals(4, testTileHh.getPointValue());
		Tile testTileV = new Tile('V');
		assertEquals('V', testTileV.getLetter());
		assertEquals(4, testTileV.getPointValue());
		Tile testTileVv = new Tile('v');
		assertEquals('V', testTileVv.getLetter());
		assertEquals(4, testTileVv.getPointValue());
		Tile testTileW = new Tile('W');
		assertEquals('W', testTileW.getLetter());
		assertEquals(4, testTileW.getPointValue());
		Tile testTileWw = new Tile('w');
		assertEquals('W', testTileWw.getLetter());
		assertEquals(4, testTileWw.getPointValue());
		Tile testTileY = new Tile('Y');
		assertEquals('Y', testTileY.getLetter());
		assertEquals(4, testTileY.getPointValue());
		Tile testTileYy = new Tile('y');
		assertEquals('Y', testTileYy.getLetter());
		assertEquals(4, testTileYy.getPointValue());
	}
	
	/**
	 * This method ensures that the five-point tiles are created 
	 * from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateFivePointTiles() {
		Tile testTileK = new Tile('K');
		assertEquals('K', testTileK.getLetter());
		assertEquals(5, testTileK.getPointValue());
		Tile testTileKk = new Tile('k');
		assertEquals('K', testTileKk.getLetter());
		assertEquals(5, testTileKk.getPointValue());
		
	}
	
	/**
	 * This method ensures that all of the eight-point tiles are created
	 * from capital and lowercase letters
	 */
	@Test
	public void shouldCreateEightPointTiles() {
		Tile testTileJ = new Tile('J');
		assertEquals('J', testTileJ.getLetter());
		assertEquals(8, testTileJ.getPointValue());
		Tile testTileJj = new Tile('j');
		assertEquals('J', testTileJj.getLetter());
		assertEquals(8, testTileJj.getPointValue());
		Tile testTileX = new Tile('X');
		assertEquals('X', testTileX.getLetter());
		assertEquals(8, testTileX.getPointValue());
		Tile testTileXx = new Tile('x');
		assertEquals('X', testTileXx.getLetter());
		assertEquals(8, testTileXx.getPointValue());
		
	}
	
	/**
	 * This method ensures that all of the ten-point tiles are created
	 * from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateTenPointTiles() {
		Tile testTileQ = new Tile('Q');
		assertEquals('Q', testTileQ.getLetter());
		assertEquals(10, testTileQ.getPointValue());
		Tile testTileQq = new Tile('q');
		assertEquals('Q', testTileQq.getLetter());
		assertEquals(10, testTileQq.getPointValue());
		Tile testTileZ = new Tile('Z');
		assertEquals('Z', testTileZ.getLetter());
		assertEquals(10, testTileZ.getPointValue());
		Tile testTileZz = new Tile('z');
		assertEquals('Z', testTileZz.getLetter());
		assertEquals(10, testTileZz.getPointValue());
		
	}
	}


/**
 * 
 */
package edu.westga.cs.babble.controllers;

import java.text.Format;

import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileGroup;
import edu.westga.cs.babble.model.TileRack;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * @author Chris Jones
 * @version August 20, 2019
 * Controls behavior of the Babble GUI
 *
 */
public class BabbleController {
	
	private WordDictionary babbleDictionary;
	private PlayedWord babblePlayedWord;
	private TileBag babbleTileBag;
	private TileRack babbletileRack;
	private IntegerProperty babbleScoreProperty;
    private Button resetButton;
    private TextField scoreText;
	
	
	public BabbleController() {
		this.babbleDictionary = new WordDictionary();
		this.babblePlayedWord = new PlayedWord();
		this.babbleTileBag = new TileBag();
		this.babbletileRack = new TileRack();
		this.resetButton = new Button();
		this.scoreText = new TextField();
	}

	
	public void setScore() {
	
		}
}

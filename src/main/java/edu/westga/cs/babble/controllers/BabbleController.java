/**
 * 
 */
package edu.westga.cs.babble.controllers;

import java.text.Format;
import javafx.fxml.*;
import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileGroup;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.model.TileRack;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 * @author Chris Jones
 * @version August 20, 2019
 * Controls behavior of the Babble GUI
 *
 */
public class BabbleController {
	private WordDictionary babbleDictionary;
	@FXML
	private PlayedWord babblePlayedWord;
	@FXML
	private TileBag babbleTileBag;
	@FXML
	private TileRack babbleTileRack;
	@FXML
	private IntegerProperty babbleScoreProperty;
	@FXML
    private Button resetButton;
	@FXML 
	private Button playWordButton;
    @FXML
    private TextField scoreText;
    @FXML
    private ListView<Tile> tilesListView;
    @FXML 
    private ListView<Tile> usedWordListView;
	
	
	public BabbleController() {
		this.babbleDictionary = new WordDictionary();
		this.babblePlayedWord = new PlayedWord();
		this.babbleTileBag = new TileBag();
		this.babbleTileRack = new TileRack();
		this.babbleScoreProperty = new SimpleIntegerProperty(0);
		
	}
	
	@FXML 
	public void initialize() {
		this.addTilesToListView();
		this.setUpListView();
		this.setUpUsedWordListView();
		this.initializeScoreArea();		
	}
	
	public void initializeScoreArea() {
		this.scoreText.textProperty().bindBidirectional(this.babbleScoreProperty, new NumberStringConverter());
	}
	
	public void setUpListView() {
		this.tilesListView.setItems(this.babbleTileRack.tiles());
		System.out.println(this.babbleTileRack.tiles());
		this.tilesListView.setCellFactory(new CellFactory());
		this.tilesListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent letterSelection) {
				Tile chosenTile = (Tile)BabbleController.this.tilesListView.getSelectionModel().getSelectedItem();
				try {
					BabbleController.this.babbleTileRack.remove(chosenTile);
					BabbleController.this.babblePlayedWord.append(chosenTile);
				} catch (TileNotInGroupException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
				
				);
		
	}
	
	public void setUpUsedWordListView() {
		this.usedWordListView.setItems(this.babblePlayedWord.tiles());
		this.usedWordListView.setCellFactory(new CellFactory());
		
	}
	
	class CellFactory implements Callback<ListView<Tile>,ListCell<Tile>>
	{
		CellFactory() {
		}

		@Override
		public ListCell<Tile> call(ListView<Tile> arg0) {
			
			 final TextFieldListCell tilesForGame = new TextFieldListCell();
		      tilesForGame.setConverter(new StringConverter<Tile>()
		      {
		    	
		    	@Override
		        public String toString(Tile letter)
		        {
		          String lettersOfText = letter.getLetter() + "";
		          tilesForGame.setText(lettersOfText);
		          System.out.println(lettersOfText);
		          return lettersOfText ;
		          
		        }

		    	@Override
		        public Tile fromString(String tileString)
		        {
		          return null;
		        }
		      });
			
			
		      return tilesForGame;
		}
	}
		
	public void increaseScoreByNumber(int valueOfWord) {
		int total = this.babbleScoreProperty.get();
		total += valueOfWord;
		this.babbleScoreProperty.set(total);
	}
	
	public void addTilesToListView() {
		int numberOfTiles = this.babbleTileRack.getNumberOfTilesNeeded();
		for (int index = 0; index < numberOfTiles; index++) {				
			Tile tile = null;
			try {
				tile = this.babbleTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.babbleTileRack.append(tile);
		}
	
	
	}
	
	public void checkValidWord() {
		this.playWordButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent submitWord) {
				if (BabbleController.this.babbleDictionary.isValidWord(BabbleController.this.babblePlayedWord.getHand())) {
					
					BabbleController.this.increaseScoreByNumber(BabbleController.this.babblePlayedWord.getScore());
					BabbleController.this.babblePlayedWord.clear();
					BabbleController.this.addTilesToListView();
				} else {
					Alert notAWordAlert = new Alert(AlertType.ERROR);
					notAWordAlert.setHeaderText("Word Error");
					notAWordAlert.setContentText("The word you have submitted is not found in the game's dictionary.");
					notAWordAlert.showAndWait();
				}
				
			}
			
		}
				
				
				);
	}
		
	
		public void resetPlayedWord() {
			this.resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent submitWord) {
			for (Tile returnTile: BabbleController.this.babblePlayedWord.tiles()) {
				BabbleController.this.babbleTileRack.append(returnTile);
			}
			BabbleController.this.babblePlayedWord.clear();
			
			}
			
			}
			);
			
		}
				
				
				
	}
		
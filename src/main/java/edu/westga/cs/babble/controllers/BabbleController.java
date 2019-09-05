
package edu.westga.cs.babble.controllers;

import javafx.fxml.FXML;
import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
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
 * Controls behavior of the Babble GUI
 * 
 * @author Chris Jones
 * @version August 20, 2019
 *
 */
public class BabbleController {
	private WordDictionary babbleDictionary;
	private PlayedWord babblePlayedWord;
	private TileBag babbleTileBag;
	private TileRack babbleTileRack;
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
	private ListView<Tile> wordListView;

	/**
	 * Constructor for class
	 */
	public BabbleController() {
		this.babbleDictionary = new WordDictionary();
		this.babblePlayedWord = new PlayedWord();
		this.babbleScoreProperty = new SimpleIntegerProperty(0);
		this.babbleTileBag = new TileBag();
		this.babbleTileRack = new TileRack();

	}

	/**
	 * This class calls the methods for setting up the GUI once all @FXML pieces
	 * have been injected
	 */
	@FXML
	public void initialize() {
		this.initializeScoreArea();
		this.addTilesToListView();
		this.setUpTilesListView();
		this.setUpwordListView();

	}

	/**
	 * This method initializes the score area and sets up the binding between the
	 * score text and the integer property
	 */
	public void initializeScoreArea() {

		this.scoreText.textProperty().bindBidirectional(this.babbleScoreProperty, new NumberStringConverter());
	}

	/**
	 * This method creates the ListView for the letters the user uses to play
	 */
	public void setUpTilesListView() {
		this.tilesListView.setItems(this.babbleTileRack.tiles());
		this.tilesListView.setCellFactory(new CellFactory());
		this.tilesListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent letterSelection) {
				Tile chosenTile = (Tile) BabbleController.this.tilesListView.getSelectionModel().getSelectedItem();
				try {
					BabbleController.this.babbleTileRack.remove(chosenTile);
					BabbleController.this.babblePlayedWord.append(chosenTile);
				} catch (TileNotInGroupException exceptionForTiles) {

					exceptionForTiles.printStackTrace();
				}

			}
		}

		);

	}

	/**
	 * This method creates the ListView for where the user puts together words
	 */
	public void setUpwordListView() {
		this.wordListView.setItems(this.babblePlayedWord.tiles());
		this.wordListView.setCellFactory(new CellFactory());
		this.wordListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent letterSelection) {
				Tile chosenTile = (Tile) BabbleController.this.wordListView.getSelectionModel().getSelectedItem();

				try {
					BabbleController.this.babblePlayedWord.remove(chosenTile);
					BabbleController.this.babbleTileRack.append(chosenTile);
				} catch (TileNotInGroupException exceptionForTiles) {

					exceptionForTiles.printStackTrace();
				}

			}
		}

		);

	}

	/**
	 * This class creates CellFactory objects to handle the tiles in the ListViews
	 * 
	 * @author Chris Jones
	 * @version August 21, 2019
	 *
	 */
	class CellFactory implements Callback<ListView<Tile>, ListCell<Tile>> {
		CellFactory() {
		}

		@Override
		public ListCell<Tile> call(ListView<Tile> arg0) {

			final TextFieldListCell<Tile> tilesForGame = new TextFieldListCell<Tile>();
			tilesForGame.setConverter(new StringConverter<Tile>() {

				@Override
				public String toString(Tile letter) {
					String lettersOfText = letter.getLetter() + "";
					tilesForGame.setAccessibleText(lettersOfText);
					return lettersOfText;

				}

				@Override
				public Tile fromString(String tileString) {
					return null;
				}
			});

			return tilesForGame;
		}
	}

	/**
	 * This method increases the user's score by the amount the played word is worth
	 * 
	 * @param valueOfWord value of played word
	 */
	public void increaseScoreByNumber(int valueOfWord) {
		int total = this.babbleScoreProperty.get();
		total += valueOfWord;
		this.babbleScoreProperty.set(total);
	}

	/**
	 * This method adds tiles to the game
	 */
	public void addTilesToListView() {
		int numberOfTiles = this.babbleTileRack.getNumberOfTilesNeeded();
		for (int index = 0; index < numberOfTiles; index++) {
			Tile tile = null;
			try {
				tile = this.babbleTileBag.drawTile();
			} catch (EmptyTileBagException exceptionForTiles) {

				exceptionForTiles.printStackTrace();
			}
			this.babbleTileRack.append(tile);
		}

	}

	/**
	 * This method checks to see if a word is valid
	 */
	@FXML
	public void checkValidWord() {
		this.playWordButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent submitWord) {
				if (BabbleController.this.babbleDictionary
						.isValidWord(BabbleController.this.babblePlayedWord.getHand())) {

					BabbleController.this.increaseScoreByNumber(BabbleController.this.babblePlayedWord.getScore());
					BabbleController.this.babblePlayedWord.clear();
					BabbleController.this.addTilesToListView();
				} else {
					Alert notAWordAlert = new Alert(AlertType.INFORMATION);
					notAWordAlert.setHeaderText("Word Error");
					notAWordAlert.setContentText("The word you have submitted is not found in the game's dictionary.");
					notAWordAlert.showAndWait();
				}

			}

		}

		);
	}

	/**
	 * This method resets the word area where the user is trying to put a word
	 * together
	 */
	@FXML
	public void resetPlayedWord() {
		this.resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent submitWord) {
				for (Tile returnTile : BabbleController.this.babblePlayedWord.tiles()) {
					BabbleController.this.babbleTileRack.append(returnTile);
				}
				BabbleController.this.babblePlayedWord.clear();
			}

		});

	}

}

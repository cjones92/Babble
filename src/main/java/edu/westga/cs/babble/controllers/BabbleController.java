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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
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
	@FXML
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
		this.resetButton = new Button();
		this.scoreText = new TextField();
		
	}
	
	@FXML 
	public void initialize() {
		this.addTilesToListView();
		this.setUpListView();
		this.setUpUsedWordListView();
		
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
		
		
	

	
	
}

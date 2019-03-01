package ui;

import customExceptions.BigNumberException;
import customExceptions.EvenNumberException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.MagicSquare;

public class MagicSquareController {

    @FXML
    private BorderPane borPane;

    @FXML
    private TextField numberField;
    
    @FXML
    private Label exceptionField;

    @FXML
    private Label mcField;

    @FXML
    private TextField positionField;
    

    @FXML
    public void generateButtonPressed(ActionEvent event) {
    	
    	exceptionField.setText(null);
    	
    	try{
    	GridPane square = new GridPane();
    	
    	square.getChildren().clear();
    	square.setAlignment(Pos.CENTER);
    	int rows = Integer.parseInt(numberField.getText());
    	int columns = Integer.parseInt(numberField.getText());
    	
    
    	int num = Integer.parseInt(numberField.getText());
    	MagicSquare ms = new MagicSquare(num);
    	ms.setSquare(ms.fillMagicSquare(num));
 
    	int[][] magicS = ms.getSquare();
    	
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<columns; j++) {
    			Button numbers = new Button(Integer.toString(magicS[i][j]));
    			numbers.setMinWidth(square.getPrefWidth()); //-
    			numbers.setMinWidth(square.getPrefWidth()); //
    		    square.add(numbers, j, i);
    		    numbers.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    		    	    new EventHandler<MouseEvent>() {
    		    	        @Override public void handle(MouseEvent e) {
    		    	            numbers.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
    		    	        }
    		    	});
    		}
    		
    	}
    	
    	for (int rowIndex1 = 0; rowIndex1 < rows; rowIndex1++) { 
 		    RowConstraints rc = new RowConstraints(); 
 		    rc.setFillHeight(true); 
 		    square.getRowConstraints().add(rc); 
 		} 
 		for (int colInde = 0; colInde < columns; colInde++) { 
 		    ColumnConstraints cc = new ColumnConstraints(); 
 		    cc.setFillWidth(true); 
 		    square.getColumnConstraints().add(cc); 
 		} 
    	
    	borPane.setCenter(square);
    	
    	mcField.setText(ms.magicConstant()+"");
    	} catch (NegativeArraySizeException e) {
    		exceptionField.setText("Please digit an odd number");
    		
    	} catch(EvenNumberException en) {
    		exceptionField.setText(en.getMessage());
    		
    	} catch(BigNumberException bn) {
    		exceptionField.setText(bn.getMessage());
    		
    	}
    	
    	

    }

}


package gui;

import java.io.*;

import business.CsvDateiLeser;
//import business.CsvDateiLeser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * erstellt das View zum Basisfenster
 */
public class Anwendersystem{

    	//Objekt zum Lesen der Kunden.csv - Datei
    	private CsvDateiLeser csvDateiLeser;
    	private GridPane grid        = new GridPane();
    	private Label lblAnzeige     = new Label ("Anzeige");
    	private TextArea txtAnzeige  = new TextArea();
    	private Button btnAnzeige    = new Button("Lesen und Anzeigen");

    	     /**
     		* erstellt das View zum Basisfenster inklusive Titel, 
     		* Komponenten und Listener und zeigt es an.
     		* @param primaryStage das Stage-Objekt zum Basisfenster
    		*/
   		public Anwendersystem(Stage primaryStage){
            	this.csvDateiLeser = new CsvDateiLeser();
        		this.grid.setAlignment(Pos.CENTER);
	    		this.grid.setHgap(10);
	    		this.grid.setVgap(10);
	    		this.grid.setPadding(new Insets(25, 25, 25, 25));
	    		primaryStage.setTitle(
	         		this.csvDateiLeser.getUeberschrift());	
	     		Scene scene = new Scene(grid, 210, 200);
	    		primaryStage.setScene(scene);
        		primaryStage.show();
        		this.initKomponenten();
	    		this.initListener(); 
    	}
		
    		/* initialisiert die Steuerelemente auf der Maske */
    		private void initKomponenten(){
	    		grid.add(lblAnzeige, 1, 0);
	    		lblAnzeige.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    		grid.add(txtAnzeige, 1, 1);
	    		txtAnzeige.setMaxSize(170, 100);
	    		txtAnzeige.setBackground(new Background(
		    		new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, 
                		Insets.EMPTY)));
	    		this.grid.add(btnAnzeige, 1, 2);
	   		 btnAnzeige.setMaxSize(170, 25);
     		}

    		/* initialisiert die Listener zu den Steuerelementen auf der Maske
    		*/
    		private void initListener(){
    		}
      
   		 /* zeigt den Inhalt des Arrays zeilen in txtAnzeige an. */
    		private void zeigeAn(String[] zeilen){
        		if(zeilen != null){
            		for(int i = 0; i < zeilen.length; i++){
                			txtAnzeige.insertText(
txtAnzeige.getText().length(),
                    		zeilen[i] + "\n");
            		}
        		}	
    		}
    		/** zeigt ein Fehlermeldungsfenster an
     		* @param meldung, String, welcher die Fehlermeldung enthaelt
     		*/
    		public void zeigeFehlermeldung(String ueberschrift, 
String meldung){
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Fehlermeldung");
        		alert.setHeaderText(ueberschrift);
        		alert.setContentText(meldung);
        		alert.show();
    		}
}

    

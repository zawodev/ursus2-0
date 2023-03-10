package com.example.demo1;

import Obserwowani.TablicaOgloszen;
import Ogłoszenia.Ogloszenie;
import Serializacja.SerializacjaObiektow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class dodajOgloszenieController implements Initializable {
    @FXML
    private Button returnButton;

    @FXML
    private TextField autor;

    @FXML
    private TextField tytul;

    @FXML
    private TextArea tresc;

    @FXML
    private Label brakDanych;


    @FXML
    public void ogloszenieController(Button ogloszenieButton){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-ogloszenie.fxml"));
            Stage stage = (Stage) ogloszenieButton.getScene().getWindow();
            stage.setTitle("Dodaj ogloszenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu ogloszen");
        }
    }

    @FXML
    public void returnButtonAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-gov.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }

    @FXML
    public void dodajButtonAction() throws IOException, ClassNotFoundException {

        if(autor.getText().isEmpty() || tytul.getText().isEmpty() || tresc.getText().isEmpty()){
            brakDanych.setVisible(true);
        }
        else{
            brakDanych.setVisible(false);
            TablicaOgloszen tablica = SerializacjaObiektow.odczytTablicyOgloszen();
            tablica.dodajOgloszenieDoTablicy(new Ogloszenie(autor.getText(), tytul.getText(), tresc.getText(), LocalDateTime.now()));
            SerializacjaObiektow.zapisTablicyOgloszen(tablica, "TablicaOgloszen.ser");
            autor.clear();
            tytul.clear();
            tresc.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brakDanych.setVisible(false);
    }
}

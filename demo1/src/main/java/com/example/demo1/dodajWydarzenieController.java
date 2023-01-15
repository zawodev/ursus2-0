package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dodajWydarzenieController implements Initializable {
    @FXML
    private Button returnButton;

    @FXML
    public void wydarzenieController(Button wydarzenieButton){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-wydarzenie.fxml"));
            Stage stage = (Stage) wydarzenieButton.getScene().getWindow();
            stage.setTitle("Dodaj wydarzenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu wydarzen");
        }
    }

    @FXML
    public void dodajButtonAction() throws IOException {
        //dodawanie wydarzen do kalendarza
        //na inpucie zaimplementowac kalendarz i mozliwosc zaznaczania na nim dni w ktorych cos ma sie dziac
        //przyciski dodaj usun edytuj na gorze

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
package com.example.demo1;

import Dane.PrzekazywanieStudenta;
import Ogłoszenia.Ogloszenie;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.EOFException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

public class announcementController implements Initializable {

    @FXML
    private Button returnButton;

    @FXML
    private VBox ogloszeniaBox;
    @FXML
    public void Announcement(Button announcementButton) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("announcement.fxml"));
            Stage stage = (Stage) announcementButton.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Ogłoszenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować ogłoszeń");
            e.printStackTrace();
        }
    }
    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.setResizable(false);

            stage.setTitle("Menu");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Ogloszenie> ogloszenia = new ArrayList<>();
        int size = 0;
        PriorityQueue<Ogloszenie> pq = new PriorityQueue<>();
        ArrayList<Ogloszenie> ogloszeniaPom = new ArrayList<>();
        try {
            size = SerializacjaObiektow.odczytTablicyOgloszen().getOgloszenia().size();
            ogloszeniaPom = SerializacjaObiektow.odczytTablicyOgloszen().getOgloszenia();
        } catch (EOFException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e){}
        for(Ogloszenie ogloszenie: ogloszeniaPom){
            pq.add(ogloszenie);
        }
        for(int i = 0; i<size; i++){
            ogloszenia.add(pq.poll());
        }
        for(int i = 0; i<ogloszenia.size(); i++) {
            Ogloszenie ogloszenie = ogloszenia.get(i);
            VBox box = new VBox();
            box.setPrefSize(50, 553);
            VBox.setMargin(box, new Insets(5, 0, 15, 0));
            box.setOpaqueInsets(Insets.EMPTY);
            Color c = Color.rgb(151, 204, 240);
            BackgroundFill bfill = new BackgroundFill(c, null, null);
            box.setBackground(new Background(bfill));
            Label tytul = new Label(ogloszenie.getTytul());
            tytul.setMinWidth(553);
            tytul.setPrefSize(24, 581);
            tytul.setMaxHeight(24);
            tytul.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null, new BorderWidths(3.0))));
            tytul.setAlignment(Pos.CENTER);
            tytul.setTextAlignment(TextAlignment.CENTER);
            tytul.setFont(new Font(18));
            Label autor = new Label(ogloszenie.getAutor());
            autor.setPrefSize(17, 577);
            autor.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null, BorderStroke.THIN)));
            autor.setAlignment(Pos.CENTER);
            autor.setTextAlignment(TextAlignment.CENTER);
            autor.setFont(new Font(14));
            autor.setMinWidth(553);
            autor.setMaxHeight(17);
            Text text = new Text(ogloszenie.getText());
            VBox.setMargin(text, new Insets(15, 20, 10, 15));
            text.setWrappingWidth(518.0);
            box.getChildren().add(tytul);
            box.getChildren().add(autor);
            box.getChildren().add(text);
            ogloszeniaBox.getChildren().add(box);

        }
        ArrayList<Student> studenci= null;
        try {
            studenci = SerializacjaObiektow.odczytStudentow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(studenci != null){
            studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).setLiczba_nowych_ogloszen(0);
            studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).setLiczba_waznych_ogloszen(0);
        }
        try {
            SerializacjaObiektow.zapisStudentow(studenci, "PlikStudentow.ser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

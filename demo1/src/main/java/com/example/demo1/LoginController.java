package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button employeeLogin;

    @FXML
    private Button studentGovernmentLogin;

    @FXML
    private Button studentLogin;

    @FXML
    private Button adminLogin;

    @FXML
    public void studentLoginButtonAction() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("hello-view-student.fxml"));
            Stage stage = (Stage) studentLogin.getScene().getWindow();

            stage.setTitle("Login Panel");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu głównego");
        }
    }

    @FXML
    public void govLoginButtonAction() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("hello-view-gov.fxml"));
            Stage stage = (Stage) studentGovernmentLogin.getScene().getWindow();

            stage.setTitle("Login Panel");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu głównego");
        }
    }

    @FXML
    public void employeeLoginButtonAction() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("hello-view-employee.fxml"));
            Stage stage = (Stage) employeeLogin.getScene().getWindow();

            stage.setTitle("Login Panel");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu głównego");
        }
    }

    @FXML
    public void adminLoginButtonAction(){
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("hello-view-admin.fxml"));
            Stage stage = (Stage) adminLogin.getScene().getWindow();

            stage.setTitle("Login Panel");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu głównego");
        }
    }

}

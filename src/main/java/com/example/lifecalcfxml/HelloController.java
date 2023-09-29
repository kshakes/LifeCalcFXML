package com.example.lifecalcfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;

    private Scene scene;
    private Stage stage;

    public void calc() {
        double salaryText = Double.parseDouble(salaryNum.getText());
        double roundedMonthly = (double) Math.round(salaryText * 100) / 100;
        showInfo.setText("Monthly = £" + roundedMonthly);
    }

    public void goHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goSalary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("salaryPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goEmergency(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("emergencyPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
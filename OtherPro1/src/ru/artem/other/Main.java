package ru.artem.other;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static ru.artem.other.Controller.*;
import static ru.artem.other.ErrorBallTrue.errorFind;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ВИКС-Т");
        primaryStage.setScene(new Scene(root, 610, 417));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        System.out.println(pathName+pathSourse);
    }

}

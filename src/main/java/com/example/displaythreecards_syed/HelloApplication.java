package com.example.displaythreecards_syed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    public GridPane gp = new GridPane();
    @Override
    public void start(Stage stage) throws IOException {
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setStyle("-fx-background-color: white");
        Scene scene = new Scene(gp, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        buildUI();
    }

    private void buildUI() {
        //Select Cards
        for(int i = 0; i < 3; i ++){
            int cardNumber = (int)(Math.random() * 52) + 1;
            String cardName = "src/main/resources/image/card/" + cardNumber + ".png";
            try {
                InputStream stream = new FileInputStream(cardName);
                Image image = new Image(stream);
                ImageView iv = new ImageView();
                iv.setImage(image);
                gp.add(iv, i, 1);
            } catch (FileNotFoundException fnfe){
                fnfe.printStackTrace();
            }
            //gp.add();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
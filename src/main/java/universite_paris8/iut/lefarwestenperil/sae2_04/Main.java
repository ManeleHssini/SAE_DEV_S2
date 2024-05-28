package universite_paris8.iut.lefarwestenperil.sae2_04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vue1.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        Scene scene = new Scene(fxmlLoader.load(),1536 , 800);
        stage.setTitle("LeFar West en Péril");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
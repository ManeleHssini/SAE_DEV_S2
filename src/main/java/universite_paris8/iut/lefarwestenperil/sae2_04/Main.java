package universite_paris8.iut.lefarwestenperil.sae2_04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vue1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800 , 800);
        stage.setTitle("LeFar West en Péril");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
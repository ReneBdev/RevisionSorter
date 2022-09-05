package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    /**
     * The Main Stage is a VBox, to which we can simply add our 'function-rows'
     * So far the program has only one function - the sorting row
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Setting main stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));

        // Setting content
        ((VBox) root).getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Row.fxml"))));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package ExoplanetsVisualization.StartAndMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScene.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Exoplanets Explorer");
        primaryStage.setScene(new Scene(root, 1080, 640));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

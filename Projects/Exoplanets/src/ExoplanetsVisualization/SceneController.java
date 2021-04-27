package ExoplanetsVisualization;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class SceneController {
    @FXML
    public void menuButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../StartAndMenu/MenuScene.fxml"));
        sceneChanger(event,menuViewParent);
    }
    @FXML
    void mouseKeyPressed(MouseEvent event) throws IOException {
        switch (event.getButton()) {
            case SECONDARY:
                Parent menuViewParent = FXMLLoader.load(getClass().getResource("../StartAndMenu/MenuScene.fxml"));
                sceneChanger(event,menuViewParent);
                break;
            default:
                break;
        }
    }
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case BACK_SPACE:
                Parent menuViewParent = FXMLLoader.load(getClass().getResource("../StartAndMenu/MenuScene.fxml"));
                sceneChanger(event, menuViewParent);
                break;
            case ESCAPE:
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
                break;
            default:
                break;
        }
    }
    public void sceneChanger(Event event, Parent menuViewParent){
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }
}

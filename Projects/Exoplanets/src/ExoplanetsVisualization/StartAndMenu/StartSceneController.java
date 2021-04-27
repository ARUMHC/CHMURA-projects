package ExoplanetsVisualization.StartAndMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartSceneController implements Initializable {
    private List<Exoplanet> exoplanets;
    @FXML
    private Button startButton;
    @FXML
    public void startButtonClicked(ActionEvent event) throws IOException
    {
        if(exoplanets!=null){
            Parent menuViewParent = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
            Scene menuViewScene = new Scene(menuViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(menuViewScene);
            window.show();
        }else {
            Parent menuViewParent = FXMLLoader.load(getClass().getResource("NoNetworkErrorScene.fxml"));
            Scene menuViewScene = new Scene(menuViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(menuViewScene);
            window.show();
        }
    }
    @FXML
    void mouseKeyPressed(MouseEvent event) throws IOException {
        switch (event.getButton()) {
            case SECONDARY:
                Parent menuViewParent = FXMLLoader.load(getClass().getResource("/MenuScene.fxml"));
                Scene menuViewScene = new Scene(menuViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(menuViewScene);
                window.show();
            default:
                break;
        }
    }
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case BACK_SPACE:
                if(exoplanets!=null){
                    Parent menuViewParent = FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
                    Scene menuViewScene = new Scene(menuViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(menuViewScene);
                    window.show();
                }else {
                    Parent menuViewParent = FXMLLoader.load(getClass().getResource("NoNetworkErrorScene.fxml"));
                    Scene menuViewScene = new Scene(menuViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(menuViewScene);
                    window.show();
                }
            default:
                break;
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exoplanets =ExoplanetsReader.readData();
        ExoplanetsReader.readData2();
    }
}

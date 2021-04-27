package ExoplanetsVisualization.StartAndMenu;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NoNetworkErrorSceneController implements Initializable {
    private List<Exoplanet> exoplanets;
    @FXML
    public void reconnectButtonClicked(ActionEvent event) throws IOException
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exoplanets = ExoplanetsReader.readData();
        ExoplanetsReader.readData2();
    }
}

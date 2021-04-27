package ExoplanetsVisualization.AboutDataAndUs;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import ExoplanetsVisualization.Masses.MassesLogic;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AboutDataSceneController {

    @FXML
    Hyperlink nasaLink;
    @FXML
    Button menuButton;

    @FXML
    public void nasaLinkClicked(ActionEvent event) throws IOException{
        nasaLink.setOnAction(e -> {
            if(Desktop.isDesktopSupported())
            {
                try {
                    Desktop.getDesktop().browse(new URI("https://exoplanetarchive.ipac.caltech.edu/docs/program_interfaces.html"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

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
            default:
                break;
        }
    }
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case BACK_SPACE:
                Parent menuViewParent = FXMLLoader.load(getClass().getResource("../StartAndMenu/MenuScene.fxml"));
                sceneChanger(event,menuViewParent);
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

    @FXML
    public void initialize() { }


}

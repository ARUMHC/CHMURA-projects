package ExoplanetsVisualization.StartAndMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneController implements Initializable {
    @FXML
    Button exoButton;
    @FXML
    Button planetarySystemButton;
    @FXML
    Button massesButton;
    @FXML
    Button observatoriesButton;
    @FXML
    Button neptunsButton;
    @FXML
    Button earthsButton;
    @FXML
    Button densityAndMassButton;
    @FXML
    Button aboutUsButton;
    @FXML
    Button aboutDataButton;
    @FXML
    Button exitButton;

    @FXML
    public void exoButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/ExoplanetsInfo/ExoplanetsScene.fxml"));
        sceneChanger(event, menuViewParent);
    }

    @FXML
    public void planetarySystemButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/PlanetarySystems/PlanetarySystemScene.fxml"));
        sceneChanger(event, menuViewParent);
    }

    @FXML
    public void massesButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/Masses/MassesScene.fxml"));
        sceneChanger(event, menuViewParent);
    }

    @FXML
    public void observatoriesButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/Observatories/ObservatoriesScene.fxml"));
        sceneChanger(event, menuViewParent);
    }

    @FXML
    public void neptunsButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/MiniNeptunes/MiniNeptunesScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    public void earthsButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../SuperEarths/SuperEarthsScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    public void jupitersButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/HotJupiters/HotJupitersScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    public void densityAndMassButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/DensityAndMass/DensityAndMassScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    public void aboutUsButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/AboutDataAndUs/AboutUsScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    public void aboutDataButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../../ExoplanetsVisualization/AboutDataAndUs/AboutDataScene.fxml"));
        sceneChanger(event, menuViewParent);
    }
    @FXML
    void keyPressed(KeyEvent event){
        switch (event.getCode()) {
            case ESCAPE:
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            default:
                break;
        }
    }
    public void sceneChanger(ActionEvent event, Parent menuViewParent){
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void exitButtonClicked(ActionEvent event) throws IOException{
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }



}

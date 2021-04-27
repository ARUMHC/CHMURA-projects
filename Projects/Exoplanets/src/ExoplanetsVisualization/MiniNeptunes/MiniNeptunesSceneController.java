package ExoplanetsVisualization.MiniNeptunes;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class MiniNeptunesSceneController extends SceneController {

    @FXML
    private TableColumn<MiniNeptune, String> planetName;
    @FXML
    private TableView<MiniNeptune> miniNeptunesTable;
    @FXML
    Button menuButton;


    public void initialize() throws Exception {
        List<MiniNeptune> data= MiniNeptunesLogic.readData();
        planetName.setCellValueFactory(new PropertyValueFactory<>("planetName"));
        miniNeptunesTable.setItems(getMiniNeptunesList(data));
    }
    private ObservableList<MiniNeptune> getMiniNeptunesList(List<MiniNeptune> data){
        ObservableList<MiniNeptune> list = FXCollections.observableArrayList();
        for (MiniNeptune datum : data) {
            list.add(datum);
        }
        return list;
    }
    @FXML
    public void goBackButtonClicked(ActionEvent event) throws IOException
    {
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("../StartAndMenu/MenuScene.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }

}


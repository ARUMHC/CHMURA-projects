package ExoplanetsVisualization.SuperEarths;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class SuperEarthsSceneController extends SceneController {

    @FXML
    private TableColumn<SuperEarth, String> planetName;
    @FXML
    private TableView<SuperEarth> superEarthsTable;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        List<SuperEarth> data= SuperEarthsLogic.readData();
        planetName.setCellValueFactory(new PropertyValueFactory<>("planetName"));
        superEarthsTable.setItems(getSuperEarthsList(data));
    }
    private ObservableList<SuperEarth> getSuperEarthsList(List<SuperEarth> data){
        ObservableList<SuperEarth> list = FXCollections.observableArrayList();
        for (SuperEarth datum : data) {
            list.add(datum);
        }
        return list;
    }
}
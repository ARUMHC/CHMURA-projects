package ExoplanetsVisualization.HotJupiters;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class HotJupitersSceneController extends SceneController {

    @FXML
    private TableColumn<HotJupiter, String> planetName;
    @FXML
    private TableView<HotJupiter> hotJupitersTable;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        List<HotJupiter> data= HotJupitersLogic.readData();
        planetName.setCellValueFactory(new PropertyValueFactory<>("planetName"));
        hotJupitersTable.setItems(getHotJupitersList(data));
    }

    private ObservableList<HotJupiter> getHotJupitersList(List<HotJupiter> data){
        ObservableList<HotJupiter> list = FXCollections.observableArrayList();
        for (HotJupiter datum : data) {
            list.add(datum);
        }
        return list;
    }
}




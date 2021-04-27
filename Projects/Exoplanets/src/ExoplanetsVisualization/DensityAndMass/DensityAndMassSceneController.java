package ExoplanetsVisualization.DensityAndMass;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import java.util.Set;

public class DensityAndMassSceneController extends SceneController {

    @FXML
    private TableColumn<PlanetDnM, String> planetName;
    @FXML
    private TableColumn<PlanetDnM, Double> planetMass;
    @FXML
    private TableColumn<PlanetDnM, Double> planetDensity;
    @FXML
    private TableView<PlanetDnM> densityAndMassTable;
    @FXML
    private ScatterChart<Number, Number> densityAndMassChart;
    @FXML
    private NumberAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        List<PlanetDnM> data = DensityAndMassLogic.readData();
        planetName.setCellValueFactory(new PropertyValueFactory<>("planetName"));
        planetMass.setCellValueFactory(new PropertyValueFactory<>("mass"));
        planetDensity.setCellValueFactory(new PropertyValueFactory<>("density"));
        densityAndMassTable.setItems(getPlanetsDnMList(data));

        //ten gupi scatter co sie jebie nie wiem czemu
        XYChart.Series series = new XYChart.Series();

        for (PlanetDnM planetDnM : data) {
            series.getData().add(new XYChart.Data(planetDnM.getMass(), planetDnM.getDensity()));
        }
        densityAndMassChart.getData().addAll(series);

        Set<Node> nodes = densityAndMassChart.lookupAll(".series" + 0);

        for (Node n : nodes) {
            n.setStyle("-fx-background-color: darkblue ;\n"
                    + "    -fx-background-insets: 0, 2;\n"
                    + "    -fx-background-radius: 5px;\n"
                    + "    -fx-padding: 3px;");
        }
    }

    private ObservableList<PlanetDnM> getPlanetsDnMList(List<PlanetDnM> data){
        ObservableList<PlanetDnM> list = FXCollections.observableArrayList();
        for (PlanetDnM datum : data) {
            list.add(datum);
        }
        return list;
    }




}

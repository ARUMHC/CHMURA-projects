package ExoplanetsVisualization.Observatories;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

public class ObservatoriesSceneController extends SceneController {
    @FXML
    private BarChart<?,?> ObsChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private TableColumn<Observatory, String> obsName;
    @FXML
    private TableColumn<Observatory, Integer> numOfPlanets;
    @FXML
    private TableView<Observatory> obsTable;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        XYChart.Series series = new XYChart.Series();
        List<Observatory> data=ObservatoriesLogic.readData();
        for (Observatory datum : data) {
            if (datum.getNumOfPlanets() > 100) {
                series.getData().add(new XYChart.Data(datum.getObservatoryName(), datum.getNumOfPlanets()));
            }
        }
        ObsChart.getData().addAll(series);

        obsName.setCellValueFactory(new PropertyValueFactory<>("observatoryName"));
        numOfPlanets.setCellValueFactory(new PropertyValueFactory<>("numOfPlanets"));
        obsTable.setItems(getObservatoryList(data));

        for(Node n:ObsChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: darkblue;");
        }
    }

    private ObservableList<Observatory> getObservatoryList(List<Observatory> data){
        ObservableList<Observatory> list = FXCollections.observableArrayList();
        for (Observatory datum : data) {
            list.add(datum);
        }
        return list;
    }



}

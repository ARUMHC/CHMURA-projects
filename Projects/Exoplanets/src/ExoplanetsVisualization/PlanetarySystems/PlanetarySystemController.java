package ExoplanetsVisualization.PlanetarySystems;

import ExoplanetsVisualization.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.util.ArrayList;
import java.util.List;

public class PlanetarySystemController extends SceneController {
    @FXML
    private BarChart<?,?> PlanetsChart;
    @FXML
    private TableColumn<PlanetarySystem, String> planetarySName;
    @FXML
    private TableColumn<PlanetarySystem, Integer> planets;
    @FXML
    private TableView<PlanetarySystem> planetarySystemTable;
    @FXML
    private TextFlow description;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        XYChart.Series series = new XYChart.Series();
        List<PlanetarySystem> data=PlanetarySystemLogic.readData();
        ArrayList<Integer> labels= PlanetarySystemLogic.bucketsLabels(data);
        ArrayList<Integer> values = PlanetarySystemLogic.bucketsSizes(data);
        for (int i=0;i<labels.size();++i) {
            series.getData().add(new XYChart.Data(labels.get(i).toString(), values.get(i)));
        }
        PlanetsChart.getData().addAll(series);
        planetarySName.setCellValueFactory(new PropertyValueFactory<>("planetarySystemName"));
        planets.setCellValueFactory(new PropertyValueFactory<>("planets"));
        planetarySystemTable.setItems(getPlanetarySystemList(data));

        for(Node n:PlanetsChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: darkblue;");
        }

        Integer font=17;
        Text text = new Text("After brief analysis of data, we can easily figure out, that so far we don't about existence of many planets " +
                "in planetary systems other than our won solarsystem. Even though we can provide some mathematical information about it." + "\n");
        text.setFont(new Font(font));
        Text text1 = new Text("Average amount of planets in planetary system equals: "+PlanetarySystemLogic.planetsAverage(data) +"\n" );
        text1.setFont(new Font(font));
        Text text2 = new Text("First Quartile of planets in planetary system equals: "+PlanetarySystemLogic.planetsQ1(data)+"\n" );
        text2.setFont(new Font(font));
        Text text3 = new Text("Median of planets in planetary system equals: "+PlanetarySystemLogic.planetsMedian(data)+"\n" );
        text3.setFont(new Font(font));
        Text text4 = new Text("Third Quartile of planets in planetary system equals: "+PlanetarySystemLogic.planetsQ3(data));
        text4.setFont(new Font(font));
        description.getChildren().addAll(text,text1,text2,text3,text4);
    }

    private ObservableList<PlanetarySystem> getPlanetarySystemList(List<PlanetarySystem> data){
        ObservableList<PlanetarySystem> list = FXCollections.observableArrayList();
        for (PlanetarySystem datum : data) {
            list.add(datum);
        }
        return list;
    }
}

package ExoplanetsVisualization.Masses;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.util.ArrayList;
import java.util.List;

public class MassesSceneController extends SceneController {

    @FXML
    private BarChart<?,?> MassesChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private TableColumn<PlanetM, String> planetName;
    @FXML
    private TableColumn<PlanetM, Integer> planetMass;
    @FXML
    private TableView<PlanetM> massesTable;
    @FXML
    private TextFlow description;
    @FXML
    Button menuButton;

    public void initialize() throws Exception {
        XYChart.Series series = new XYChart.Series();
        ArrayList<String> labels= MassesLogic.bucketsLabels(MassesLogic.readData());
        ArrayList<Integer> values = MassesLogic.bucketsSizes(MassesLogic.readData());
        for (int i=0;i<labels.size();++i) {
            series.getData().add(new XYChart.Data(labels.get(i).toString(), values.get(i)));
        }
        MassesChart.getData().addAll(series);

        List<PlanetM> data=MassesLogic.readData();
        planetName.setCellValueFactory(new PropertyValueFactory<>("planetName"));
        planetMass.setCellValueFactory(new PropertyValueFactory<>("mass"));
        massesTable.setItems(getPlanetMList(data));

        for(Node n:MassesChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: darkblue;");
        }

        Integer font=17;
        Text text = new Text("Mathematical analysis of masses provided in the text below gives an interesting assumption that Jupiter is " +
                "somehow a model of a planet because it's mass is very close to the median and average mass" + "\n");
        text.setFont(new Font(font));
        Text text1 = new Text("Average planet mass equals: "+ MassesLogic.massAverage(data) +"\n" );
        text1.setFont(new Font(font));
        Text text2 = new Text("First Quartile of planets masses equals: "+ MassesLogic.massQ1(data)+"\n" );
        text2.setFont(new Font(font));
        Text text3 = new Text("Median of planets masses equals: "+MassesLogic.massMedian(data)+"\n" );
        text3.setFont(new Font(font));
        Text text4 = new Text("Third Quartile of planets masses equals: "+MassesLogic.massQ3(data));
        text4.setFont(new Font(font));
        description.getChildren().addAll(text,text1,text2,text3,text4);
    }

    private ObservableList<PlanetM> getPlanetMList(List<PlanetM> data){
        ObservableList<PlanetM> list = FXCollections.observableArrayList();
        for (PlanetM datum : data) {
            list.add(datum);
        }
        return list;
    }


}

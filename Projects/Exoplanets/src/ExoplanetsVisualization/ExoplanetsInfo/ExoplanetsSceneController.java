package ExoplanetsVisualization.ExoplanetsInfo;

import ExoplanetsVisualization.ExoplanetsReader;
import ExoplanetsVisualization.SceneController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;
import ExoplanetsVisualization.Exoplanets.Exoplanet;
import java.util.*;

public class ExoplanetsSceneController extends SceneController {

    @FXML
    private TreeTableView<String> treeTable;
    @FXML
    private TreeTableColumn<String,String> exoplanets;
    @FXML
    Button menuButton;
    @FXML
    private TextFlow firstSentence;

    public void initialize() throws Exception {
        ArrayList<Exoplanet> exoplanetArrayList = new ArrayList<>(ExoplanetsLogic.readData());
        TreeItem<String> root = new TreeItem<>("Exoplanets");
        ArrayList<TreeItem> treeItems = new ArrayList<>();
        for (int i=0;i<exoplanetArrayList.size();++i){
            TreeItem<String> parent = new TreeItem<>(exoplanetArrayList.get(i).getPlanetName());
            TreeItem<String> item1 = new TreeItem<>("Name of the host star: "+exoplanetArrayList.get(i).getHostStarName());
            TreeItem<String> item2 = new TreeItem<>("Which planet it is: "+exoplanetArrayList.get(i).getLetter());
            TreeItem<String> item3 = new TreeItem<>("Discovery method: "+exoplanetArrayList.get(i).getDiscoveryMethod());
            TreeItem<String> item4 = new TreeItem<>((exoplanetArrayList.get(i).getOrbitalPeriod()!=null)?"Orbital Period: "+exoplanetArrayList.get(i).getOrbitalPeriod().toString():"Orbital Period: No data");
            TreeItem<String> item5 = new TreeItem<>((exoplanetArrayList.get(i).getEccentricity()!=null)?"Eccentricity: "+exoplanetArrayList.get(i).getEccentricity().toString():"Eccentricity: No data");
            TreeItem<String> item6 = new TreeItem<>((exoplanetArrayList.get(i).getPlanetMass()!=null)?"Planet mass (in Jupyter Masses): "+exoplanetArrayList.get(i).getPlanetMass().toString():"Planet mass (in Jupyter Masses): No data");
            TreeItem<String> item7 = new TreeItem<>((exoplanetArrayList.get(i).getPlanetRadius()!=null)?"Planet Radius: "+exoplanetArrayList.get(i).getPlanetRadius().toString():"Planet Radius: No data");
            TreeItem<String> item8 = new TreeItem<>((exoplanetArrayList.get(i).getPlanetDensity()!=null)?"Planet Density: "+exoplanetArrayList.get(i).getPlanetDensity().toString():"Planet Density: No data");
            TreeItem<String> item9 = new TreeItem<>((exoplanetArrayList.get(i).getNumberOfNotes()!=null)?"Number of mentions in literature: "+exoplanetArrayList.get(i).getNumberOfNotes().toString():"Number of mentions in literature: No data");
            TreeItem<String> item10 = new TreeItem<>((exoplanetArrayList.get(i).getRA()!=null)?"RA: "+exoplanetArrayList.get(i).getRA().toString():"Planets RA: No data");
            TreeItem<String> item11 = new TreeItem<>((exoplanetArrayList.get(i).getDec()!=null)?"Dec: "+exoplanetArrayList.get(i).getDec().toString():"Planets Dec: No data");
            TreeItem<String> item12 = new TreeItem<>((exoplanetArrayList.get(i).getDistance()!=null)?"Distance from solarsystem: "+exoplanetArrayList.get(i).getDistance().toString():"Distance from solarsystem: No data");
            TreeItem<String> item13 = new TreeItem<>("Discovery Facility: "+exoplanetArrayList.get(i).getDiscoveryFacility());

            parent.getChildren().setAll(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13);
            root.getChildren().add(parent);
        }

        exoplanets.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
           @Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> stringStringCellDataFeatures) {
               return new SimpleStringProperty(stringStringCellDataFeatures.getValue().getValue());
           }
        });

        treeTable.setRoot(root);

        List<Exoplanet> exoplanetsList = ExoplanetsReader.exoplanets;
        Integer font=18;
        Text text = new Text("Exoplanet is a planet found outside our Solar System. Now there are already " +
                + exoplanetsList.size() +
                " exoplanets discovered. We can divide them into types: Hot Jupiters, Mini Neptunes and Super Earths based on their parameters. To see more go back to Menu and choose wanted type.");
        text.setFont(new Font(font));
        text.setFill(Color.WHITE);
        firstSentence.getChildren().addAll(text);




    }

}

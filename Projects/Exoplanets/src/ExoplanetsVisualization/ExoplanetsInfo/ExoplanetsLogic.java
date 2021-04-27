package ExoplanetsVisualization.ExoplanetsInfo;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import java.util.List;

public class ExoplanetsLogic {
    public static List<Exoplanet> readData() throws Exception {
        return ExoplanetsReader.exoplanets;
    }
}
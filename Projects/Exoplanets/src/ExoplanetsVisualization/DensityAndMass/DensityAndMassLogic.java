package ExoplanetsVisualization.DensityAndMass;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import java.util.ArrayList;
import java.util.List;

public class DensityAndMassLogic {

    public static List<PlanetDnM> readData() throws Exception {
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;

        ArrayList<PlanetDnM> planetsDnM = new ArrayList<>();
        for (Exoplanet exoplanet : exoplanets) {
            if(exoplanet.getPlanetMass() != null && exoplanet.getPlanetDensity() != null){
                PlanetDnM planetDnM= new PlanetDnM(exoplanet.getPlanetName(),exoplanet.getPlanetMass(), exoplanet.getPlanetDensity());
                planetsDnM.add(planetDnM);
            }
        }
        return planetsDnM;
    }

}

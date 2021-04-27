package ExoplanetsVisualization.SuperEarths;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//masa Ziemi = 0.00315 JM
//promien Ziemi = 0.08921 JR

public class SuperEarthsLogic {
    public static List<SuperEarth> readData() throws Exception{
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;

        List<SuperEarth> superEarths = new ArrayList<>();
        List<Exoplanet> filtered =  exoplanets.stream()
                .filter(n ->n.getPlanetMass() != null && n.getPlanetRadius() != null && n.getPlanetDensity() != null)
                .filter(n -> n.getPlanetMass() > 0.00315 && n.getPlanetMass() < 0.0315 && n.getPlanetRadius() > 0.071368 && n.getPlanetRadius() < 0.35684 && n.getPlanetDensity() > 3)
                .collect(Collectors.toList());
        for(Exoplanet exoplanet : filtered){
            SuperEarth superEarth = new SuperEarth(exoplanet.getPlanetName(), exoplanet.getPlanetRadius(), exoplanet.getPlanetMass(), exoplanet.getPlanetDensity());
            superEarths.add(superEarth);
        }

        return superEarths;
    }
}

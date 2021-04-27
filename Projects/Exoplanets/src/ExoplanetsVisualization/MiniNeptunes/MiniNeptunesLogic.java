package ExoplanetsVisualization.MiniNeptunes;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
//import sample.JSONExample;
import ExoplanetsVisualization.ExoplanetsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MiniNeptunesLogic {

    public static List<MiniNeptune> readData() throws Exception{
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;
        List<MiniNeptune> miniNeptunes = new ArrayList<>();
        List<Exoplanet> filtered =  exoplanets.stream()
                                            .filter(n ->n.getPlanetMass() != null && n.getPlanetRadius() != null && n.getPlanetRadius() != null && n.getPlanetDensity() != null)
                                            .filter(n -> n.getPlanetMass() > 0.0189 && n.getPlanetRadius() > 0.151657 && n.getPlanetRadius() < 0.347919 && n.getPlanetDensity() < 3)
                                            .collect(Collectors.toList());
        for(Exoplanet exoplanet : filtered){
            MiniNeptune miniNeptune = new MiniNeptune(exoplanet.getPlanetName(), exoplanet.getPlanetRadius(), exoplanet.getPlanetMass(), exoplanet.getPlanetDensity());
            miniNeptunes.add(miniNeptune);
        }

        return miniNeptunes;
    }

}

package ExoplanetsVisualization.HotJupiters;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotJupitersLogic {

    public static List<HotJupiter> readData() throws Exception{
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;

        List<HotJupiter> hotJupiters = new ArrayList<>();
        List<Exoplanet> filtered =  exoplanets.stream()
                .filter(n -> n.getOrbitalPeriod() != null && n.getPlanetMass() != null && n.getPlanetRadius() != null && n.getPlanetRadius() != null && n.getPlanetDensity() != null)
                .filter(n -> n.getOrbitalPeriod() > 1.3 && n.getOrbitalPeriod() < 111 && n.getPlanetMass() > 0.36 && n.getPlanetMass() < 13 && n.getPlanetDensity() < 3)
                .collect(Collectors.toList());
        for(Exoplanet exoplanet : filtered){
            HotJupiter hotJupiter = new HotJupiter(exoplanet.getPlanetName(), exoplanet.getPlanetRadius(), exoplanet.getPlanetMass(), exoplanet.getPlanetDensity());
            hotJupiters.add(hotJupiter);
        }

        return hotJupiters;
    }
}

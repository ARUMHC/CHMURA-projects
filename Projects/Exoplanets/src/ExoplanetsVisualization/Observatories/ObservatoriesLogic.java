package ExoplanetsVisualization.Observatories;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObservatoriesLogic {
    public static List<Observatory> readData() throws Exception {
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;
        ArrayList<String> facilities = new ArrayList<>();
        for (Exoplanet exoplanet : exoplanets) {
            facilities.add(exoplanet.getDiscoveryFacility());
        }
        List<String> distinctFacilities = facilities.stream().map(s -> (String) s).distinct().collect(Collectors.toList());

        ArrayList<Observatory> Observatories = new ArrayList<>();
        for (String distinctFacility : distinctFacilities) {
            Observatory observatory = new Observatory(distinctFacility);
            Observatories.add(observatory);
        }

        for (Exoplanet exoplanet : exoplanets) {
            for (Observatory observatory : Observatories) {
                if (observatory.getObservatoryName().equals(exoplanet.getDiscoveryFacility())) {
                    observatory.addPlanet(exoplanet.getPlanetName());
                }
            }
        }
        Observatories.sort(Observatory::compareTo);
        return Observatories;
    }

}

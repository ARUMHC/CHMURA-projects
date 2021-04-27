package ExoplanetsVisualization.MiniNeptunes;

import ExoplanetsVisualization.Exoplanets.Exoplanet;

public class MiniNeptune extends Exoplanet {

    public MiniNeptune(String planetName, Double planetRadius, Double planetMass, Double planetDensity) {
        super(planetName, planetRadius, planetMass, planetDensity);
    }

    @Override
    public String toString(){
        return "planet type= Mini Neptune" +
                ", planet name= " + getPlanetName();
    }


}

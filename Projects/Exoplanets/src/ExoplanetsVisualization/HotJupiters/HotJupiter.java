package ExoplanetsVisualization.HotJupiters;

import ExoplanetsVisualization.Exoplanets.Exoplanet;

public class HotJupiter extends Exoplanet {

    public  HotJupiter(String planetName, Double planetRadius, Double planetMass, Double planetDensity) {
        super(planetName, planetRadius, planetMass, planetDensity);
    }

    @Override
    public String toString(){
        return "planet type= Mini Neptune" +
                ", planet name= " + getPlanetName();
    }


}

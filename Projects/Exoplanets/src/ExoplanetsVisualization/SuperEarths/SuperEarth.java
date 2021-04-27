package ExoplanetsVisualization.SuperEarths;

import ExoplanetsVisualization.Exoplanets.Exoplanet;

public class SuperEarth extends Exoplanet {

    public SuperEarth(String planetName, Double planetRadius, Double planetMass, Double planetDensity) {
        super(planetName, planetRadius, planetMass, planetDensity);
    }

    @Override
    public String toString(){
        return "planet type= Super Earth" +
                ", planet name= " + getPlanetName();
    }


}

package ExoplanetsVisualization.DensityAndMass;


public class PlanetDnM  {
//Planet Density And Mass

    private String planetName;
    private Double mass;
    private Double density;

    public PlanetDnM(String name, Double mass, Double density){
        this.planetName=name;
        this.mass=mass;
        this.density = density;
    }

    public String getPlanetName() {
        return planetName;
    }

    public Double getMass() {
        return mass;
    }

    public Double getDensity(){return density;}

    @Override
    public String toString() {
        return "PlanetDnM{" +
                "planetName='" + planetName + '\'' +
                ", mass=" + mass +
                ", density=" + density +
                '}';
    }
}

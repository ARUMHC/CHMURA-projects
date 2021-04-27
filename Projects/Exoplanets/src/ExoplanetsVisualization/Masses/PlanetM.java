package ExoplanetsVisualization.Masses;

public class PlanetM {
    private String planetName;
    private Double mass;

    public PlanetM(String name, Double masss){
        this.planetName=name;
        this.mass=masss;
    }

    public String getPlanetName() {
        return planetName;
    }

    public Double getMass() {
        return mass;
    }

    public int compareTo(PlanetM planetM){
        if(this.getMass()>planetM.getMass()){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "PlanetM{" +
                "planetName='" + planetName + '\'' +
                ", mass=" + mass +
                '}';
    }
}

package ExoplanetsVisualization.PlanetarySystems;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlanetarySystem {
    private String planetarySystemName;
    private Integer planets;

    public PlanetarySystem(String name, Integer planets){
        this.planetarySystemName=name;
        this.planets=planets;
    }

    public String getplanetarySystemName() {
        return planetarySystemName;
    }

    public StringProperty planetarySystemNameProperty(){//to ma mieć nazwę pola + Property zawsze
        return new SimpleStringProperty(this.planetarySystemName);
    }

    public Integer getPlanetsAmount() {
        return planets;
    }

    public IntegerProperty planetsProperty(){
        return new SimpleIntegerProperty(this.planets);
    }

    public int compareTo(PlanetarySystem planetarySystem){
        if(this.getPlanetsAmount()>planetarySystem.getPlanetsAmount()){
            return -1;
        }else if(this.getPlanetsAmount().equals(planetarySystem.getPlanetsAmount())){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "PlanetarySystem{" +
                "planetarySystemName='" + planetarySystemName + '\'' +
                ", planets=" + planets +
                '}';
    }
}

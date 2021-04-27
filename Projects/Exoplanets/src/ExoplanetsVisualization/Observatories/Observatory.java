package ExoplanetsVisualization.Observatories;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Observatory {
    private String observatoryName;
    private ArrayList<String> planetNames= new ArrayList<String>();
    private Integer numOfPlanets=0;

    public Observatory(String name){
        observatoryName = name;
    }

    protected void addPlanet(String name){
        planetNames.add(name);
        numOfPlanets+=1;
    }


    public ArrayList<String> getPlanetNames() {
        return planetNames;
    }

    public Integer getNumOfPlanets() {
        return numOfPlanets;
    }

    public IntegerProperty getNumOfPlanetsProperty(){
        return new SimpleIntegerProperty(this.numOfPlanets);
    }

    public String getObservatoryName() {
        return observatoryName;
    }

    public StringProperty getObservatoryNameProperty(){
        return new SimpleStringProperty(this.observatoryName);
    }

   public int compareTo(Observatory obs){
        if(this.getNumOfPlanets()>obs.getNumOfPlanets()){
            return -1;
        }else{
            return 1;
        }
   }

    @Override
    public String toString() {
        return "Observatory{" +
                "observatoryName='" + observatoryName + '\'' +
                ", planetNames=" + planetNames +
                ", numOfPlanets=" + numOfPlanets +
                '}';
    }
}

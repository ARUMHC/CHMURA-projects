package ExoplanetsVisualization.Exoplanets;

import javafx.beans.property.*;

public class Exoplanet {
    private String hostStarName;
    private String letter;
    private String planetName;
    private String discoveryMethod; //może tutaj dać enum? Atstrometry, Imagining, Transit, Radial
    private Double orbitalPeriod;
    private Double eccentricity;
    private Double planetMass;
    private Double planetRadius;
    private Double planetDensity;
    private Integer numberOfNotes;
    private Double RA;
    private Double Dec;
    private Double distance;
    private String discoveryFacility;

    public Exoplanet(String hostStarName, String letter, String planetName, String discoveryMethod, Double orbitalPeriod,
                     Double eccentricity, Double planetMass, Double planetRadius, Double planetDensity, Integer numberOfNotes,
                     Double RA, Double Dec, Double distance, String discoveryFacility){
        this.hostStarName = hostStarName;
        this.letter = letter;
        this.planetName = planetName;
        this.discoveryMethod = discoveryMethod;
        this.orbitalPeriod = orbitalPeriod;
        this.eccentricity = eccentricity;
        this.planetMass = planetMass;
        this.planetRadius = planetRadius;
        this.planetDensity = planetDensity;
        this.numberOfNotes = numberOfNotes;
        this.RA = RA;
        this.Dec = Dec;
        this.distance = distance;
        this.discoveryFacility = discoveryFacility;
    }

    //drugi konstruktor potrzebny do SZ, MN, GJ jeśli nie będziemy wszystkiego chcieli wyświetlać
    public Exoplanet(String planetName, Double planetRadius, Double planetMass, Double planetDensity){
        this.planetRadius = planetRadius;
        this.planetMass = planetMass;
        this.planetDensity = planetDensity;
        this.planetName = planetName;
    }

    public String getHostStarName(){return hostStarName;}
    public String getLetter(){return letter;}
    public String getPlanetName(){return planetName;}
    public String getDiscoveryMethod(){return discoveryMethod;}
    public Double getOrbitalPeriod(){return orbitalPeriod;}
    public Double getEccentricity(){return eccentricity;};
    public Double getPlanetMass(){return  planetMass;}
    public Double getPlanetRadius(){return planetRadius;}
    public Double getPlanetDensity(){return planetDensity;}
    public Integer getNumberOfNotes(){return numberOfNotes;}
    public Double getRA(){return RA;}
    public Double getDec(){return Dec;}
    public Double getDistance(){return distance;}
    public String getDiscoveryFacility(){return discoveryFacility;}

    public StringProperty HostStarNameProperty(){return new SimpleStringProperty(this.hostStarName);}
    public StringProperty LetterProperty(){return new SimpleStringProperty(this.letter);}
    public StringProperty PlanetNameProperty(){return new SimpleStringProperty(this.planetName);}
    public StringProperty DiscoveryMethodProperty(){return new SimpleStringProperty(this.discoveryMethod);}
    public DoubleProperty OrbitalPeriodProperty(){return new SimpleDoubleProperty(this.orbitalPeriod);}
    public DoubleProperty EccentricityProperty(){return new SimpleDoubleProperty(this.eccentricity);}
    public DoubleProperty PlanetMassProperty(){return new SimpleDoubleProperty(this.planetMass);}
    public DoubleProperty PlanetRadiusProperty(){return new SimpleDoubleProperty(this.planetRadius);}
    public DoubleProperty PlanetDensityProperty(){return new SimpleDoubleProperty(this.planetDensity);}
    public IntegerProperty NumberOfNotesProperty(){return new SimpleIntegerProperty(this.numberOfNotes);}
    public DoubleProperty RAProperty(){return new SimpleDoubleProperty(this.RA);}
    public DoubleProperty DecProperty(){return new SimpleDoubleProperty(this.Dec);}
    public DoubleProperty DistanceProperty(){return new SimpleDoubleProperty(this.distance);}
    public StringProperty DiscoveryFacilityProperty(){return new SimpleStringProperty(this.discoveryFacility);}

    @Override
    public String toString() {
        return "Exoplanet{" +
                "hostStarName='" + hostStarName + '\'' +
                ", letter='" + letter + '\'' +
                ", planetName='" + planetName + '\'' +
                ", discoveryMethod='" + discoveryMethod + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", eccentricity=" + eccentricity +
                ", planetMass=" + planetMass +
                ", planetRadius=" + planetRadius +
                ", planetDensity=" + planetDensity +
                ", numberOfNotes=" + numberOfNotes +
                ", RA=" + RA +
                ", Dec=" + Dec +
                ", distance=" + distance +
                ", discoveryFacility='" + discoveryFacility + '\'' +
                '}';
    }
}
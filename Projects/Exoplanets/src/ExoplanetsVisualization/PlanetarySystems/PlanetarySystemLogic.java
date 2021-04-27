package ExoplanetsVisualization.PlanetarySystems;

import ExoplanetsVisualization.ExoplanetsReader;
import java.util.ArrayList;
import java.util.List;

public class PlanetarySystemLogic {
    public static List<PlanetarySystem> readData() throws Exception { //inna ramka danych
        List<PlanetarySystem> planets = ExoplanetsReader.planetarySystems;
        return planets;
    }


    public static Double planetsMedian(List<PlanetarySystem> planetarySystemList){
        Double median;
        if(planetarySystemList.size()%2==1){
            median= planetarySystemList.get(planetarySystemList.size()/2+1).getPlanetsAmount().doubleValue();
        }
        else{
            median=((planetarySystemList.get(planetarySystemList.size()/2).getPlanetsAmount().doubleValue()+planetarySystemList.get(planetarySystemList.size()/2+1).getPlanetsAmount().doubleValue())/2);
        }
        return median;
    }

    public static Double planetsQ3(List<PlanetarySystem> planetarySystemList){
        ArrayList<PlanetarySystem> planets=new ArrayList<>();
        if (planetarySystemList.size()%2==1){
            for (int i=0;i<(planetarySystemList.size()-1)/2;++i){
                planets.add(planetarySystemList.get(i));
            }
        }
        else {
            for (int i=0;i<(planetarySystemList.size())/2;++i){
                planets.add(planetarySystemList.get(i));
            }
        }
        return planetsMedian(planets);
    }

    public static Double planetsQ1(List<PlanetarySystem> planetarySystemList){
        ArrayList<PlanetarySystem> planets=new ArrayList<>();
        if (planetarySystemList.size()%2==1){
            for (int i=(planetarySystemList.size()+1)/2;i<planetarySystemList.size();++i){
                planets.add(planetarySystemList.get(i));
            }
        }
        else {
            for (int i=(planetarySystemList.size())/2+1;i<planetarySystemList.size();++i){
                planets.add(planetarySystemList.get(i));
            }
        }
        return planetsMedian(planets);
    }

    public static Double planetsAverage(List<PlanetarySystem> planetarySystemList){
        Double sum=0.0;
        for (PlanetarySystem planetM : planetarySystemList) {
            sum += planetM.getPlanetsAmount();
        }
        return sum/planetarySystemList.size();
    }

    public static ArrayList<Integer> bucketsSizes(List<PlanetarySystem> planetarySystemList){
        ArrayList<Integer> buckets = new ArrayList<>();
        Integer bucketborder=8;
        Integer bucketsize=0;
        for (int i=0;i<planetarySystemList.size();++i){
            if (planetarySystemList.get(i).getPlanetsAmount()>=bucketborder){
                bucketsize+=1;
            }
            else{
                buckets.add(bucketsize);
                bucketsize=0;
                bucketborder=bucketborder-1;
                i=i-1;
            }
        }
        buckets.add(bucketsize);
        return buckets;
    }

    public static ArrayList<Integer> bucketsLabels(List<PlanetarySystem> planetarySystemList){
        ArrayList<Integer> buckets = new ArrayList<>();
        Integer bucketborder=8;
        for (int i=0;i<planetarySystemList.size();++i){
            if (planetarySystemList.get(i).getPlanetsAmount()<bucketborder){
                buckets.add(bucketborder);
                bucketborder=bucketborder-1;
                i=i-1;
            }
        }
        buckets.add(bucketborder);
        return buckets;
    }
}

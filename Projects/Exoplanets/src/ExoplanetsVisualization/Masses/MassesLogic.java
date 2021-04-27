package ExoplanetsVisualization.Masses;

import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.ExoplanetsReader;
import java.util.ArrayList;
import java.util.List;

public class MassesLogic {
    public static List<PlanetM> readData() throws Exception {
        List<Exoplanet> exoplanets = ExoplanetsReader.exoplanets;
        ArrayList<PlanetM> planetMS = new ArrayList<>();
        for (int i=0; i<exoplanets.size(); ++i) {
            Exoplanet exoplanet = exoplanets.get(i);;
            if(exoplanet.getPlanetMass()!=null){
                PlanetM planetM= new PlanetM(exoplanet.getPlanetName(),exoplanet.getPlanetMass());
                planetMS.add(planetM);
            }
        }
        planetMS.sort(PlanetM::compareTo);
        return planetMS;
    }

    public static Double massMedian(List<PlanetM> planetMList){
        Double median;
        if(planetMList.size()%2==1){
            median=planetMList.get(planetMList.size()/2+1).getMass();
        }
        else{
            median=(planetMList.get(planetMList.size()/2).getMass()+planetMList.get(planetMList.size()/2+1).getMass())/2;
        }
        return median;
    }

    public static Double massQ3(List<PlanetM> planetMList){
        ArrayList<PlanetM> planetMS=new ArrayList<>();
        if (planetMList.size()%2==1){
            for (int i=0;i<(planetMList.size()-1)/2;++i){
                planetMS.add(planetMList.get(i));
            }
        }
        else {
            for (int i=0;i<(planetMList.size())/2;++i){
                planetMS.add(planetMList.get(i));
            }
        }
        return massMedian(planetMS);
    }

    public static Double massQ1(List<PlanetM> planetMList){
        ArrayList<PlanetM> planetMS=new ArrayList<>();
        if (planetMList.size()%2==1){
            for (int i=(planetMList.size()+1)/2;i<planetMList.size();++i){
                planetMS.add(planetMList.get(i));
            }
        }
        else {
            for (int i=(planetMList.size())/2+1;i<planetMList.size();++i){
                planetMS.add(planetMList.get(i));
            }
        }
        return massMedian(planetMS);
    }

    public static Double massAverage(List<PlanetM> planetMList){
        Double sum=0.0;
        for (PlanetM planetM : planetMList) {
            sum += planetM.getMass();
        }
        return sum/planetMList.size();
    }

    public static ArrayList<Integer> bucketsSizes(List<PlanetM> planetMList){
        ArrayList<Integer> buckets = new ArrayList<>();
        Double bucketborder=32.0;
        Integer bucketsize=0;
        for (int i=0;i<planetMList.size();++i){
            if (planetMList.get(i).getMass()>=bucketborder){
                bucketsize+=1;
            }
            else{
                buckets.add(bucketsize);
                bucketsize=0;
                bucketborder=bucketborder/2;
                i=i-1;
            }
        }
        buckets.add(bucketsize);

        return buckets;
    }

    public static ArrayList<String> bucketsLabels(List<PlanetM> planetMList){
        ArrayList<String> buckets = new ArrayList<>();

        buckets.add(">32");
        buckets.add("16-32");
        buckets.add("8-16");
        buckets.add("4-8");
        buckets.add("2-4");
        buckets.add("1-2");
        buckets.add("1/2-1");
        buckets.add("1/4-1/2");
        buckets.add("1/8-1/4");
        buckets.add("1/16-1/8");
        buckets.add("1/32-1/16");
        buckets.add("1/64-1/32");
        buckets.add("1/128-1/64");
        buckets.add("1/256-1/128");
        buckets.add("1/512-1/256");
        buckets.add("1/1024-1/512");
        buckets.add("1/2048-1/1024");
        buckets.add("1/4096-1/2048");
        buckets.add("1/8192-1/4096");
        buckets.add("1/16484-1/8192");
        buckets.add("1/32968-1/16484");

        return buckets;
    }



}

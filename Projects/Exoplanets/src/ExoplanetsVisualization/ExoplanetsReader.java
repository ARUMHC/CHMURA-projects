package ExoplanetsVisualization;

import org.json.JSONArray;
import org.json.JSONObject;
import ExoplanetsVisualization.Exoplanets.Exoplanet;
import ExoplanetsVisualization.PlanetarySystems.PlanetarySystem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExoplanetsReader {
    public static  List<Exoplanet> exoplanets;
    public static  List<PlanetarySystem> planetarySystems;

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static List<Exoplanet> readData() {
        String str = null;
        try {
            str = getHTML("https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&select=pl_hostname,pl_letter,pl_name,pl_discmethod," +
                        "pl_orbper,pl_orbeccen,pl_bmassj,pl_radj,pl_dens,pl_nnotes,ra,dec,st_dist,pl_facility&format=json");
        } catch (Exception e) {
            System.out.println("Brak połączenia sieciowego, przez co nie można wczytać danych");
            return null;
        }
        JSONArray obj = new JSONArray(str);
        ArrayList<Exoplanet> planets = new ArrayList<>();
        for (int i = 0; i < obj.length(); ++i) {
            JSONObject ob = (JSONObject) obj.get(i);
            String hostname,letter,pl_name,discmethod,facility;
            Double orbper,orbeccen,bmassj,radj,dens,ra,dec,st_dist;
            Integer nnotes;
            if(ob.get("pl_orbeccen")==JSONObject.NULL){
                orbeccen=null;
            }else{
                orbeccen=ob.getDouble("pl_orbeccen");
            }
            if(ob.get("pl_bmassj")==JSONObject.NULL){
                bmassj=null;
            }else{
                bmassj=ob.getDouble("pl_bmassj");
            }
            if(ob.get("pl_dens")==JSONObject.NULL){
                dens=null;
            }else{
                dens=ob.getDouble("pl_dens");
            }
            if(ob.get("pl_radj")==JSONObject.NULL){
                radj=null;
            }else{
                radj=ob.getDouble("pl_radj");
            }
            if(ob.get("pl_orbper")==JSONObject.NULL){
                orbper=null;
            }else{
                orbper=ob.getDouble("pl_orbper");
            }
            if(ob.get("st_dist")==JSONObject.NULL){
                st_dist=null;
            }else{
                st_dist=ob.getDouble("st_dist");
            }
            if(ob.get("ra")==JSONObject.NULL){
                ra=null;
            }else{
                ra=ob.getDouble("ra");
            }
            if(ob.get("dec")==JSONObject.NULL){
                dec=null;
            }else{
                dec=ob.getDouble("dec");
            }
            if(ob.get("pl_nnotes")==JSONObject.NULL){
                nnotes=null;
            }else{
                nnotes=ob.getInt("pl_nnotes");
            }
            Exoplanet planetM = new Exoplanet(ob.getString("pl_hostname"), ob.getString("pl_letter"),ob.getString("pl_name")
                    ,ob.getString("pl_discmethod"),orbper,orbeccen,bmassj,
                    radj,dens,nnotes,ra, dec,st_dist,ob.getString("pl_facility"));
            planets.add(planetM);
        }
        exoplanets=planets;
        return planets;

    }

    public static List<PlanetarySystem> readData2() {
        String str = null;
        try {
            str = ExoplanetsReader.getHTML("https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exomultpars&select=mpl_hostname,mpl_pnum&format=json");
        } catch (Exception e) {
            System.out.println("Brak połączenia sieciowego, przez co nie można wczytać danych");
            return null;
        }
        JSONArray obj = new JSONArray(str);
        ArrayList<PlanetarySystem> planets = new ArrayList<>();
        for (int i=0; i<obj.length(); ++i) {
            JSONObject ob = (JSONObject) obj.get(i);;
            if(ob.get("mpl_pnum")!=JSONObject.NULL){
                PlanetarySystem planetM= new PlanetarySystem(ob.getString("mpl_hostname"),ob.getInt("mpl_pnum"));
                planets.add(planetM);
            }
        }
        HashMap<String,PlanetarySystem> planetarySystemHashMap = new HashMap<>();
        for (int i=0;i<planets.size();++i){
            if (!planetarySystemHashMap.containsKey(planets.get(i).getplanetarySystemName())){
                planetarySystemHashMap.put(planets.get(i).getplanetarySystemName(),planets.get(i));
            }
        }
        ArrayList<PlanetarySystem> planetss= new ArrayList<>(planetarySystemHashMap.values());
        planetss.sort(PlanetarySystem::compareTo);
        planetarySystems=planetss;
        return planetss;
    }
}

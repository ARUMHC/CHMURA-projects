import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inserter {

    public void insertNewComposer(String name,String nationality, String placeofbirth, Integer yearofbirth, Integer pieces, Connection con){
        try {
            Statement statement = con.createStatement();
            //musimy wygenerować index
            ResultSet result = statement.executeQuery("select top 1 ComposerId from Composers order by ComposerId desc;");
            result.next();
            Integer maxindex = result.getInt("ComposerId");
            result.close();
            statement.close();

            PreparedStatement prepstatement = con.prepareStatement("insert into Composers values (?,?,?,?,?,?) ");
            prepstatement.setInt(1, (maxindex + 1));
            prepstatement.setString(2, name);
            prepstatement.setString(3, nationality);
            prepstatement.setString(4, placeofbirth);
            prepstatement.setInt(5, yearofbirth);
            prepstatement.setInt(6, pieces);
            prepstatement.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPlayedInstrument(String composername,String instrumentname, String category, Connection con){
        try {
            //musimy wygenerować index
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select top 1 InstrumentId from PlayedInstruments order by InstrumentId desc;");
            result.next();
            Integer maxindex = result.getInt("InstrumentId");
            result.close();
            statement.close();

            //znajdowanie indexu ponadego kompozytora
            //w interfejsie jest najpierw sprawdzenie czy taki compozytor istnieje w bazie więc nic nie powinno się wysypać
            IdGetter idGetter = new IdGetter();
            int composerId = idGetter.getComposerId(composername, con);

            PreparedStatement prepstatement = con.prepareStatement("insert into PlayedInstruments values (?,?,?,?) ");
            prepstatement.setInt(1, (maxindex + 1));
            prepstatement.setInt(2, composerId);
            prepstatement.setString(3, instrumentname);
            prepstatement.setString(4, category);
            prepstatement.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertFamousPiece(String composername,String piecename, String formalpiecename, String genre,Connection con){
        try {
            //musimy wygenerować index
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("select top 1 PieceId from MostFamousPieces order by PieceId desc;");
            result.next();
            Integer maxindex = result.getInt("PieceId");
            result.close();
            statement.close();

            //znajdowanie indexu podanego kompozytora
            //w interfejsie jest najpierw sprawdzenie czy taki compozytor istnieje w bazie więc nic nie powinno się wysypać
            IdGetter idGetter = new IdGetter();
            int composerId = idGetter.getComposerId(composername, con);

            PreparedStatement prepstatement = con.prepareStatement("insert into MostFamousPieces values (?,?,?,?,?) ");
            prepstatement.setInt(1, (maxindex + 1));
            prepstatement.setInt(2, composerId);
            prepstatement.setString(3, piecename);
            prepstatement.setString(4, formalpiecename);
            prepstatement.setString(5, genre);
            prepstatement.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }





}

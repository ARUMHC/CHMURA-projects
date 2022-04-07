import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remover {

    public void removeComposer(String composername, Connection con) throws SQLException {
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);

        //usuwanie instrumentów kompozytora
        PreparedStatement prepstatement1 = con.prepareStatement("begin transaction "+
                "delete from PlayedInstruments where ComposerId like ? " +
                "commit;");
        prepstatement1.setInt(1, composerId);
        prepstatement1.executeUpdate();

        //usuwanie utworów kompozytora
        PreparedStatement prepstatement2 = con.prepareStatement("begin transaction "+
                "delete from MostFamousPieces where ComposerId like ? " +
                "commit;");
        prepstatement2.setInt(1, composerId);
        prepstatement2.executeUpdate();

        //usuwanie kompozytora z bazy danych
        String composernamelower = composername.toLowerCase();
        PreparedStatement prepstatement3 = con.prepareStatement("begin transaction "+
                "delete from Composers where lower(ComposerFullName) like ? " +
                "commit;");
        prepstatement3.setString(1, composernamelower);
        prepstatement3.executeUpdate();

    }

    public void removeInstrument(String composername, String instrumentname, Connection con) throws SQLException {
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);
        String instrumentnamelower = instrumentname.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("begin transaction "+
                "delete from PlayedInstruments where ComposerId like ? and lower(InstrumentName) like ? " +
                "commit;");
        prepstatement.setInt(1, composerId);
        prepstatement.setString(2, instrumentnamelower);
        prepstatement.executeUpdate();
    }

    public void removeFamousPiece(String composername, String piecename, Connection con) throws SQLException {
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);
        String piecenamelower = piecename.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("begin transaction "+
                "delete from MostFamousPieces where ComposerId like ? and lower(PieceName) like ? " +
                "commit;");
        prepstatement.setInt(1, composerId);
        prepstatement.setString(2, piecenamelower);
        prepstatement.executeUpdate();
    }
}

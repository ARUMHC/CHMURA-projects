import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modifier {
    public void modifyComposerName(String oldname, String newname, Connection con) throws SQLException {
        String oldnamelower= oldname.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update Composers set ComposerFullName=? where lower(ComposerFullName) like ? ");
        prepstatement.setString(1, newname);
        prepstatement.setString(2, oldnamelower);
        prepstatement.executeUpdate();
    }
    public void modifyComposerNationality(String composername, String nationality, Connection con) throws SQLException {
        String composernamelower= composername.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update Composers set Nationality=? where lower(ComposerFullName) like ? ");
        prepstatement.setString(1, nationality);
        prepstatement.setString(2, composernamelower);
        prepstatement.executeUpdate();
    }
    public void modifyComposerPlaceOfBirth(String composername, String place, Connection con) throws SQLException {
        String composernamelower= composername.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update Composers set PlaceOfBirth=? where lower(ComposerFullName) like ? ");
        prepstatement.setString(1, place);
        prepstatement.setString(2, composernamelower);
        prepstatement.executeUpdate();
    }

    public void modifyComposerYearOfBirth(String composername, Integer year, Connection con) throws SQLException {
        String composernamelower= composername.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update Composers set YearOfBirth=? where lower(ComposerFullName) like ? ");
        prepstatement.setInt(1, year);
        prepstatement.setString(2, composernamelower);
        prepstatement.executeUpdate();
    }
    public void modifyComposerNumberOfPieces(String composername, Integer pieces, Connection con) throws SQLException {
        String composernamelower= composername.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update Composers set NumberOfPieces=? where lower(ComposerFullName) like ? ");
        prepstatement.setInt(1, pieces);
        prepstatement.setString(2, composernamelower);
        prepstatement.executeUpdate();
    }
    //---------
    public void modifyInstrumentName(String composername, String instrumentname, String newname, Connection con) throws SQLException {
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);
        String instrumentnamelower = instrumentname.toLowerCase();

        PreparedStatement prepstatement = con.prepareStatement("update PlayedInstruments set InstrumentName=? where lower(InstrumentName) like ? and ComposerId like ? ");
        prepstatement.setString(1, newname);
        prepstatement.setString(2, instrumentnamelower);
        prepstatement.setInt(3, composerId);
        prepstatement.executeUpdate();
    }

    public void modifyInstrumentCategory(String instrumentname, String newcategory, Connection con) throws SQLException {
        String instrumentnamelower = instrumentname.toLowerCase();

        //kiedy zmieniamy kategorie danego instrumentu to wszystkie inne instrumenty też muszą mieć zmienioną kategorię
        PreparedStatement prepstatement = con.prepareStatement("update PlayedInstruments set InstrumentCategory=? where lower(InstrumentName) like ? ");
        prepstatement.setString(1, newcategory);
        prepstatement.setString(2, instrumentnamelower);
        prepstatement.executeUpdate();
    }
    //---------
    public void modifyPieceName(String composername, String oldpiecename, String newpiecename, Connection con) throws SQLException {
        String oldpiecenamelower = oldpiecename.toLowerCase();
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);

        PreparedStatement prepstatement = con.prepareStatement("update MostFamousPieces set PieceName=? where lower(PieceName) like ? and ComposerId like ? ");
        prepstatement.setString(1, newpiecename);
        prepstatement.setString(2, oldpiecenamelower);
        prepstatement.setInt(3, composerId);
        prepstatement.executeUpdate();
    }
    //wyszukujemy po kompozytorze i po common nazwie
    public void modifyFormalPieceName(String composername, String piecename, String formalpiecename, Connection con) throws SQLException {
        String piecenamelower = piecename.toLowerCase();
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);

        PreparedStatement prepstatement = con.prepareStatement("update MostFamousPieces set FormalPieceName=? where lower(PieceName) like ? and ComposerId like ? ");
        prepstatement.setString(1, formalpiecename);
        prepstatement.setString(2, piecenamelower);
        prepstatement.setInt(3, composerId);
        prepstatement.executeUpdate();
    }
    public void modifyPieceGenre(String composername, String piecename, String genre, Connection con) throws SQLException {
        String piecenamelower = piecename.toLowerCase();
        IdGetter idGetter = new IdGetter();
        int composerId = idGetter.getComposerId(composername, con);

        PreparedStatement prepstatement = con.prepareStatement("update MostFamousPieces set PieceGenre=? where lower(PieceName) like ? and ComposerId like ? ");
        prepstatement.setString(1, genre);
        prepstatement.setString(2, piecenamelower);
        prepstatement.setInt(3, composerId);
        prepstatement.executeUpdate();
    }



}

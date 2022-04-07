import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checker {

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean doesComposerExist(String composername, Connection con) throws SQLException {
        Integer count=0;

        String composernamelower = composername.toLowerCase();
        PreparedStatement prepstatement = con.prepareStatement("select * from Composers where lower(ComposerFullName) like ?");
        prepstatement.setString(1, composernamelower);
        ResultSet result = prepstatement.executeQuery();
        while(result.next()) {
            count = count + 1;
        }

        if(count==0) {
            return false;
        }else{
            return true;
        }
    }

    public boolean doesInstrumentExist(String composername, String instrumentname ,Connection con) throws SQLException {
        Integer count=0;
        IdGetter idgetter = new IdGetter();
        int composerId = idgetter.getComposerId(composername,con);

        String instrumentnamelower = instrumentname.toLowerCase();
        PreparedStatement prepstatement = con.prepareStatement("select * from PlayedInstruments where lower(InstrumentName) like ? and ComposerId like ?");
        prepstatement.setString(1, instrumentnamelower);
        prepstatement.setInt(2, composerId);
        ResultSet result = prepstatement.executeQuery();
        while(result.next()) {
            count = count + 1;
        }

        if(count==0) {
            return false;
        }else{
            return true;
        }
    }
    public boolean doesInstrumentExistOnlyName(String instrumentname ,Connection con) throws SQLException {
        Integer count=0;

        String instrumentnamelower = instrumentname.toLowerCase();
        PreparedStatement prepstatement = con.prepareStatement("select * from PlayedInstruments where lower(InstrumentName) like ? ");
        prepstatement.setString(1, instrumentnamelower);
        ResultSet result = prepstatement.executeQuery();
        while(result.next()) {
            count = count + 1;
        }

        if(count==0) {
            return false;
        }else{
            return true;
        }
    }
    public boolean doesPieceExist(String composername, String piecename ,Connection con) throws SQLException {
        Integer count=0;
        IdGetter idgetter = new IdGetter();
        int composerId = idgetter.getComposerId(composername,con);

        String piecenamelower = piecename.toLowerCase();
        PreparedStatement prepstatement = con.prepareStatement("select * from MostFamousPieces where lower(PieceName) like ? and ComposerId like ?");
        prepstatement.setString(1, piecenamelower);
        prepstatement.setInt(2, composerId);
        ResultSet result = prepstatement.executeQuery();
        while(result.next()) {
            count = count + 1;
        }

        if(count==0) {
            return false;
        }else{
            return true;
        }
    }



}

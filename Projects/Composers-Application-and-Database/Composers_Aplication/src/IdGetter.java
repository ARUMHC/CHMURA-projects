import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGetter {

    public int getComposerId(String composername, Connection con) throws SQLException {
        String composernamelower = composername.toLowerCase();
        PreparedStatement prepstatement = con.prepareStatement("select top 1 ComposerId from Composers where lower(ComposerFullName) like ?");
        prepstatement.setString(1, composernamelower);
        ResultSet result = prepstatement.executeQuery();
        result.next();
        Integer composerindex = result.getInt("ComposerId");
        result.close();
        return composerindex;
    }
}

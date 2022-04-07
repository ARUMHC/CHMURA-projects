import java.sql.*;

public class Printer {
    public String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public String leftpad(String text, int length) {
        return String.format("%" + length + "." + length + "s", text);
    }

    public Integer spaceCalculator(String table,String column, Connection con) throws SQLException {

        String sql = "select top 1 " + column + " from "+ table +" order by len(" + column + ") desc;";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        result.next();
        String maxname = result.getString(column);
        Integer spaces = maxname.length() + 2;
        result.close();
        statement.close();
        return spaces;
    }
    public void easterEgg(){ //because Im so extra
        System.out.println("_¶¶¶¶_________________________¶¶\n" +
                "__¶¶¶¶¶_______________________¶¶\n" +
                "__¶¶__¶¶_____________________¶¶¶¶\n" +
                "___¶¶__¶¶____________________¶¶¶¶¶\n" +
                "____¶¶_¶¶¶___________________¶¶__¶¶\n" +
                "____¶¶_¶¶¶___________________¶¶__¶¶\n" +
                "_____¶¶¶¶¶___________________¶¶_¶¶¶\n" +
                "_____¶¶¶¶______________¶¶¶¶ ¶¶__¶¶\n" +
                "____¶¶¶¶_____________¶¶¶¶¶¶¶¶¶_¶¶\n" +
                "___¶¶¶_¶¶__¶¶¶_______¶¶¶¶¶¶¶¶\n" +
                "__¶¶¶___¶¶¶¶¶¶¶¶¶_____¶¶¶¶¶¶\n" +
                "_¶¶¶¶__¶¶¶¶___¶¶¶¶_______________________¶¶\n" +
                "_¶¶¶__¶¶¶¶_¶¶¶__¶¶¶__________________¶¶¶¶¶¶\n" +
                "¶¶¶¶__¶¶¶¶¶¶¶¶¶__¶¶¶______________¶¶¶¶¶¶¶¶¶\n" +
                "_¶¶¶__¶¶¶_¶¶__¶__¶¶¶___________¶¶¶¶¶¶¶___¶¶\n" +
                "_¶¶¶¶__¶¶¶¶¶¶¶¶__¶¶________¶¶¶¶¶¶¶¶______¶¶\n" +
                "__¶¶¶¶____¶¶¶__¶¶¶______¶¶¶¶¶¶¶¶¶¶_______¶¶\n" +
                "___¶¶¶¶¶¶___¶¶¶¶¶______¶¶¶¶¶¶¶___¶¶_______¶¶\n" +
                "_____¶¶¶¶¶¶¶¶¶¶________¶¶¶¶¶_____¶¶___¶¶¶¶¶¶\n" +
                "________¶¶¶_¶¶¶________¶¶________¶¶__¶¶¶¶¶¶¶\n" +
                "_______¶¶¶¶¶_¶¶________¶¶_____¶¶¶¶___¶¶¶¶¶\n" +
                "_______¶¶¶___¶¶_________¶¶___¶¶¶¶¶¶\n" +
                "_________¶¶¶¶¶__________¶¶___¶¶¶¶¶¶\n" +
                "_________________________¶¶__¶¶¶¶\n" +
                "_____________________¶¶¶¶¶¶\n" +
                "____________________¶¶¶¶¶¶¶\n" +
                "____________________¶¶¶¶¶¶\n");
    }

}


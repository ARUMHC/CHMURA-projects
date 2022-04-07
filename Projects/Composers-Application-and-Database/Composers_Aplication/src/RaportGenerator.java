import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RaportGenerator {

    public void famousPiecesRaport(Connection con) throws SQLException {

        Printer pr = new Printer();
        Integer spaces1 = pr.spaceCalculator("MostFamousPieces","PieceName", con);
        Integer spaces2 = pr.spaceCalculator("Composers","ComposerFullName", con);
        Integer spaces3 = pr.spaceCalculator("MostFamousPieces","PieceGenre", con);
        Integer spaces4 = pr.spaceCalculator("MostFamousPieces","FormalPieceName", con);

        //gdyby sie zdarzyło tak że nazwa kolumny jest dłuższa niż każde z rekordów
        String str1 = "Piece Name";
        String str4 = "Formal Piece Name";
        String str3 = "Composer Name";
        String str2 = "Piece Genre";
        if(spaces1 < str1.length()){spaces1 = str1.length() + 2;}
        if(spaces4 < str1.length()){spaces4 = str4.length() + 2;}
        if(spaces2 < str1.length()){spaces2 = str2.length() + 2;}
        if(spaces3 < str1.length()){spaces3 = str3.length() + 2;}

        Statement fstatement = con.createStatement();
        ResultSet fresult = fstatement.executeQuery("select PieceName,FormalPieceName,ComposerFullName, PieceGenre  from MostFamousPieces mfp \n" +
                "left join Composers c  on mfp.ComposerId=c.ComposerId");

        System.out.println(pr.rightpad("|"+"Piece Name", spaces1+1) + "|"+pr.rightpad("Formal Piece Name", spaces4)+"|"+pr.rightpad("Composer Name ", spaces2)+"|"  + pr.rightpad("Piece Genre", spaces3)+"|");

        String str = "-";
        String repeated = str.repeat(spaces1+spaces2+spaces3+spaces4+5);
        System.out.println(repeated);

        while (fresult.next()) {

            String piecename = fresult.getString("PieceName");
            String formalpiecename = fresult.getString("FormalPieceName");
            String composername = fresult.getString("ComposerFullName");
            String genre = fresult.getString("PieceGenre");
            System.out.println("|"+pr.rightpad(piecename, spaces1) + "|"+
                    pr.rightpad(formalpiecename, spaces4) + "|" +
                    pr.rightpad(composername, spaces2) + "|" +
                    pr.rightpad(genre, spaces3) + "|");
        }
        fstatement.close();
        fresult.close();

        fresult.close();
        fstatement.close();
    }
    public void instrumentRaport(Connection con) throws SQLException {
        Printer pr = new Printer();
        Integer spaces1 = pr.spaceCalculator("Composers","ComposerFullName", con);
        Integer spaces2 = pr.spaceCalculator("PlayedInstruments","InstrumentName", con);
        Integer spaces3 = pr.spaceCalculator("PlayedInstruments","InstrumentCategory", con);

        //gdyby sie zdarzyło tak że nazwa kolumny jest dłuższa niż każde z rekordów
        String str1 = "Composer name";
        String str2 = "Instrument name";
        String str3 = "Instrument category";

        if(spaces1 < str1.length()){spaces1 = str1.length() + 2;}
        if(spaces2 < str2.length()){spaces2 = str2.length() + 2;}
        if(spaces3 < str3.length()){spaces3 = str3.length() + 2;}

        Statement fstatement = con.createStatement();
        ResultSet fresult = fstatement.executeQuery("select ComposerFullName, InstrumentName, InstrumentCategory from Composers c right join PlayedInstruments pi on \n" +
                "c.ComposerId=pi.ComposerId");

        System.out.println(pr.rightpad("|"+"Composer Name", spaces1+1) + "|"+pr.rightpad("Instrument Name", spaces2)+"|"+pr.rightpad("Instrument Category", spaces3)+"|");

        String str = "-";
        String repeated = str.repeat(spaces1+spaces2+spaces3+4);
        System.out.println(repeated);

        while (fresult.next()) {
            String composername = fresult.getString("ComposerFullName");
            String instrumentname = fresult.getString("InstrumentName");
            String instrumentcategory = fresult.getString("InstrumentCategory");
            System.out.println("|"+pr.rightpad(composername, spaces1) + "|"+
                    pr.rightpad(instrumentname, spaces2) + "|" +
                    pr.rightpad(instrumentcategory, spaces3) + "|");
        }
        fstatement.close();
        fresult.close();

        fresult.close();
        fstatement.close();

    }

}

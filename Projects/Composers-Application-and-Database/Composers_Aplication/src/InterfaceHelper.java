import java.awt.*;
import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class InterfaceHelper {


    public String[] getConnectionString(Scanner scan){
        System.out.println("Type adress of the database");
        String address = scan.nextLine();
        System.out.println("Type port of the database");
        String port = scan.nextLine();
        System.out.println("Type username for the database");
        String username = scan.nextLine();
        System.out.println("Type password for the databse");
        String password = scan.nextLine();
        String connectionString = "jdbc:sqlserver://"+address +":" + port+";database=MusicComposers";
        return new String[]{connectionString, username, password};

    }


    public Boolean adding(String table,Scanner scan, Connection con)  throws SQLException {
        Checker chk = new Checker();
        Inserter ins = new Inserter();
        Boolean back = true;
        switch (table) {
            case "c":
                System.out.println("Type the full name of the composer (use capital letters where they should be)");
                String name = scan.nextLine();
                if (chk.doesComposerExist(name, con) == true) {
                    System.out.println("This composer already exists in the database.");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the nationality of the composer");
                    String nationality = scan.nextLine();
                    System.out.println("Type the place of birth of the composer");
                    String place = scan.nextLine();
                    Integer yearint = 1;
                    boolean testyear = true;
                    while (testyear) {
                        System.out.println("Type the year of birth of the composer");
                        String year = scan.nextLine();
                        if (chk.isNumeric(year) == false) {
                            System.out.println("Please enter a number.");
                        } else {
                            yearint = Integer.parseInt(year);
                            testyear = false;
                        }
                    }
                    Integer piecesint = 1;
                    boolean testpieces = true;
                    while (testpieces) {
                        System.out.println("Type the number of composed pieces.");
                        String pieces = scan.nextLine();
                        if (chk.isNumeric(pieces) == false) {
                            System.out.println("Please enter a number.");
                        } else {
                            testpieces = false;
                            piecesint = Integer.parseInt(pieces);
                        }
                    }
                    ins.insertNewComposer(name, nationality, place, yearint, piecesint, con);
                    System.out.println("New composer added successfuly");
                    back = false;


                }
                break;
            case "i":
                System.out.println("Type the full name of the composer whose instrument you want to add (use capital letters where they should be)");
                String composername = scan.nextLine();
                if (chk.doesComposerExist(composername, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Please add a new composer first.");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the name of the instrument");
                    String instrumentname = scan.nextLine();
                    if (chk.doesInstrumentExist(composername, instrumentname, con) == true) {
                        System.out.println("This instrument already exists in the database.");
                        back = false;
                        break;
                    } else {
                        System.out.println("Type the instrument category");
                        String category = scan.nextLine();

                        ins.insertPlayedInstrument(composername, instrumentname, category, con);
                        System.out.println("New instrument added successfuly");

                    }

                }
                back = false;
                break;

            case "p":
                System.out.println("Type the full name of the composer whose piece you want to add (use capital letters where they should be)");
                String composername1 = scan.nextLine();
                if (chk.doesComposerExist(composername1, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Please add a new composer first.");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the name of the piece (the common name, not the formal one)");
                    String piecename = scan.nextLine();
                    if (chk.doesPieceExist(composername1, piecename, con) == true) {
                        System.out.println("This piece already exists in the database.");
                        back = false;
                        break;
                    } else {
                        System.out.println("Type the formal name of the piece");
                        String formalpiecename = scan.nextLine();
                        System.out.println("Type the genre of the piece");
                        String genre = scan.nextLine();
                        ins.insertFamousPiece(composername1, piecename, formalpiecename, genre, con);
                        System.out.println("New piece added successfuly");
                        back = false;

                    }


                }
            case"e":
                back=false;
                break;
            default:
                System.out.println("Please choose a valid option");
        }return back;

    }

    public Boolean removing(String tabler, Scanner scan, Connection con) throws SQLException {
        Checker chk = new Checker();
        Remover rmv = new Remover();
        Boolean back = true;

        switch (tabler){
            case"c":
                System.out.println("Type the full name of the composer (use capital letters where they should be)");
                String name = scan.nextLine();
                if (chk.doesComposerExist(name, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Nothing will be removed");
                    back = false;
                    break;
                } else {
                    System.out.println("Are you sure you want to delete this composer? Records connected to this composer also will be removed. \n Type 'yes' or 'no'");
                    String confirm = scan.nextLine();
                    if(confirm == "no"){
                        System.out.println("Operation aborted");
                        back = false;
                        break;
                    }else{
                        rmv.removeComposer(name, con);
                        System.out.println("Composer removed successfuly");
                        back = false;


                    }

                }break;

            case "i":
                System.out.println("Type the full name of the composer whose instrument you want to remove (use capital letters where they should be)");
                String composername = scan.nextLine();
                if (chk.doesComposerExist(composername, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Nothing will be removed");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the name of the instrument");
                    String instrumentname = scan.nextLine();
                    if(chk.doesInstrumentExist(composername, instrumentname, con) == false){
                        System.out.println("This instrument doesnt exists in the database. Nothing will be removed");
                        back = false;
                        break;
                    }else{
                        System.out.println("Are you sure you want to delete this instrument?\n Type 'yes' or 'no'");
                        String confirm = scan.nextLine();
                        if(confirm == "no"){
                            System.out.println("Operation aborted");
                            back = false;
                            break;
                        }else{
                            rmv.removeInstrument(composername, instrumentname, con);
                            System.out.println("Instrument removed successfuly");
                            back = false;
                            //break;

                        }
                    }


                }break;
            case "p":
                System.out.println("Type the full name of the composer whose piece you want to remove (use capital letters where they should be)");
                String composername1 = scan.nextLine();
                if (chk.doesComposerExist(composername1, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Nothing will be removed");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the name of the piece (the common name, not the formal one)");
                    String piecename = scan.nextLine();
                    if(chk.doesPieceExist(composername1, piecename, con) == false){
                        System.out.println("This piece doesnt exists in the database. Nothing will be removed");
                        back = false;
                        break;
                    }else{
                        System.out.println("Are you sure you want to delete this piece?\n Type 'yes' or 'no'");
                        String confirm = scan.nextLine();
                        if(confirm == "no"){
                            System.out.println("Operation aborted");
                            back = false;
                            break;
                        }else{
                            rmv.removeFamousPiece(composername1, piecename, con);
                            System.out.println("Piece removed successfuly");
                            back = false;

                        }
                    }
                }break;
            case"e":
                back=false;
                break;
            default:
                System.out.println("Please choose a valid option");
        }return back;


    }

    public Boolean raportGenerating(String raport, Scanner scan, Connection con) throws SQLException {
        RaportGenerator rgen = new RaportGenerator();
        Boolean back = true;
        switch (raport){
            case"1":
                System.out.println("Raport about most famous pieces and their composers\n");
                rgen.famousPiecesRaport(con);
                System.out.println("\nType any key to go back");
                String tmp = scan.nextLine();
                back = false;
                break;

            case"2":
                System.out.println("Raport about composers and their instruments\n");
                rgen.instrumentRaport(con);
                System.out.println("\nType any key to go back");
                String tmp1 = scan.nextLine();
                back = false;
                break;

            case"e":
                back = false;
                break;
            default:
                System.out.println("Please choose a valid option");
        }return back;
    }

    public Boolean composerModifying(String param, Scanner scan, Connection con) throws SQLException {
        Checker chk = new Checker();
        Modifier mdf = new Modifier();
        Boolean back = true;

        switch (param){
            case"n":
                System.out.println("Type the full name of the compositor whose name you want to modify");
                String oldname = scan.nextLine();
                if(chk.doesComposerExist(oldname,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the full new name of the composer");
                    String newname = scan.nextLine();
                    mdf.modifyComposerName(oldname, newname, con);
                    System.out.println("Composer's name modified successfuly");
                    back = false;

                }break;
            case"t":
                System.out.println("Type the full name of the composer whose nationality you want to modify");
                String composerame = scan.nextLine();
                if(chk.doesComposerExist(composerame,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the new nationality of the composer");
                    String nationality = scan.nextLine();
                    mdf.modifyComposerNationality(composerame, nationality, con);
                    System.out.println("Composer's nationality modified successfuly");
                    back = false;


                }break;
            case"b":
                System.out.println("Type the full name of the composer whose place of birth you want to modify");
                String composerame1 = scan.nextLine();
                if(chk.doesComposerExist(composerame1,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the new place of birth of the composer");
                    String place = scan.nextLine();
                    mdf.modifyComposerPlaceOfBirth(composerame1, place, con);
                    System.out.println("Composer's place of birth modified successfuly");
                    back = false;


                }break;
            case"y":
                System.out.println("Type the full name of the composer whose year of birth you want to modify");
                String composerame2 = scan.nextLine();
                if(chk.doesComposerExist(composerame2, con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    //sprawdzenie czy jest intem
                    Integer yearint = 1;
                    boolean testyear = true;
                    while (testyear) {
                        System.out.println("Type the new year of birth of the composer");
                        String year = scan.nextLine();
                        if (chk.isNumeric(year) == false) {
                            System.out.println("Please enter a number.");
                        } else {
                            yearint = Integer.parseInt(year);
                            testyear = false;
                        }
                    }
                    mdf.modifyComposerYearOfBirth(composerame2, yearint, con);
                    System.out.println("Composer's year of birth modified successfuly");
                    back = false;
                }
        }return back;
    }


    public Boolean pieceModifying(String param1, Scanner scan, Connection con) throws SQLException {
        Checker chk = new Checker();
        Modifier mdf = new Modifier();
        Boolean back = true;

        switch (param1){
            case"n":
                System.out.println("Type the full name of the composer whose piece you want to modify");
                String composerame = scan.nextLine();
                if(chk.doesComposerExist(composerame,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the old piece name you would like to modify");
                    String oldname = scan.nextLine();
                    if(chk.doesPieceExist(composerame, oldname, con) == false){
                        System.out.println("This piece doesnt exists in the database. Nothing will be modified");
                        back = false;
                        break;
                    }else{
                        System.out.println("Type new piece name");
                        String newname = scan.nextLine();
                        mdf.modifyPieceName(composerame, oldname, newname, con);
                        System.out.println("Piece's name modified successfuly");
                        back = false;

                    }
                }break;
            case"f":
                System.out.println("Type the full name of the composer whose piece you want to modify");
                String composerame1 = scan.nextLine();
                if(chk.doesComposerExist(composerame1,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the piece name you would like to modify");
                    String name = scan.nextLine();
                    if(chk.doesPieceExist(composerame1, name, con) == false){
                        System.out.println("This piece doesnt exists in the database. Nothing will be modified");
                        back = false;
                        break;
                    }else{
                        System.out.println("Type new formal piece name");
                        String formalname = scan.nextLine();
                        mdf.modifyFormalPieceName(composerame1, name,formalname, con);
                        System.out.println("Piece's formal name modified successfuly");
                        back = false;

                    }
                }break;

            case"g":
                System.out.println("Type the full name of the composer whose piece you want to modify");
                String composerame2 = scan.nextLine();
                if(chk.doesComposerExist(composerame2,con) == false){
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                }else{
                    System.out.println("Type the piece name you would like to modify");
                    String name = scan.nextLine();
                    if(chk.doesPieceExist(composerame2, name, con) == false){
                        System.out.println("This piece doesnt exists in the database. Nothing will be modified");
                        back = false;
                        break;
                    }else{
                        System.out.println("Type new genre of the piece");
                        String genre = scan.nextLine();
                        mdf.modifyPieceGenre(composerame2, name, genre, con);
                        System.out.println("Piece's genre modified successfuly");
                        back = false;

                    }
                }break;
            case"e":
                back = false;
                break;
            default:
                System.out.println("Please choose a valid option");

        }return back;
    }

    public Boolean intrumentModifying(String param2, Scanner scan, Connection con) throws SQLException {
        Checker chk = new Checker();
        Modifier mdf = new Modifier();
        Boolean back = true;

        switch (param2) {
            case "n":
                System.out.println("Type the full name of the composer whose instrument you want to modify");
                String composerame = scan.nextLine();
                if (chk.doesComposerExist(composerame, con) == false) {
                    System.out.println("This composer doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                } else {
                    System.out.println("Type the instrument name you would like to modify");
                    String name = scan.nextLine();
                    if (chk.doesInstrumentExist(composerame, name, con) == false) {
                        System.out.println("This instrument doesnt exists in the database. Nothing will be modified");
                        back = false;
                        break;
                    } else {
                        System.out.println("Type new name of the piece");
                        String newname = scan.nextLine();
                        mdf.modifyInstrumentName(composerame, name, newname, con);
                        System.out.println("Instrument's name  modified successfuly");
                        back = false;

                    }
                }
                break;
            case "c":
                System.out.println("Type the instrument name which category you want to choose (this will affect all instruments with this name in database)");
                String name = scan.nextLine();
                if (chk.doesInstrumentExistOnlyName(name, con) == false) {
                    System.out.println("This instrument doesnt exists in the database. Nothing will be modified");
                    back = false;
                    break;
                } else {
                    System.out.println("Type new instrument category");
                    String cat = scan.nextLine();
                    mdf.modifyInstrumentCategory(name, cat, con);
                    System.out.println("Instrument's category  modified successfuly");
                    back = false;

                }
                break;
            case "e":
                back = false;
                break;
            default:
                System.out.println("Please choose a valid option");
        }
        return back;


    }




}

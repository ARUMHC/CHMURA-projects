import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        InterfaceHelper ih = new InterfaceHelper();
        Scanner scan = new Scanner(System.in);
        Printer pr = new Printer();
        Boolean open = true;
        Connection con;


        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String[] connectionData = ih.getConnectionString(scan);
        System.out.println("Connecting to the database...");
        con = DriverManager.getConnection(connectionData[0], connectionData[1], connectionData[2]);
        System.out.println("Connected.");


        while(open){ //kiedy open zmieni się na false zamyka sie aplikacja

            System.out.println("\n Hello :) \n What do you want to do? \n Type letter to choose. To exit type 'e' \n a) Add a record \n r) Remove a record \n m) Modify a record \n g) Generate a raport");
            String action = scan.nextLine();
            Boolean back = true;
            while(back){
                switch (action){
                    //Adding
                    case "a":
                        System.out.println("What do you want to add? \n Type letter to choose. To go back type 'e' \n c) A composer \n p) A famous piece \n i) An instrument");
                        String table = scan.nextLine();
                        back = ih.adding(table, scan, con);
                        break;

                    //Removing
                    case "r":
                        System.out.println("What do you want to remove? \n Type letter to choose. To go back type 'e' \n c) A composer \n p) A famous piece \n i) An instrument");
                        String tabler = scan.nextLine();
                        back = ih.removing(tabler, scan, con);
                        break;
                    //Raport generating
                    case "g":
                        System.out.println("Which raport would you like?\n Type number to choose. To exit type 'e'\n 1) Raport about most famous pieces and their composers\n 2) Raport about composers and their instruments");
                        String raport = scan.nextLine();
                        back = ih.raportGenerating(raport, scan, con);
                        break;

                    //modifying
                    case"m":
                        System.out.println("What data would you like to modify?\n Type letter to choose. To exit type 'e'\n c) Composer's \n p) Famous Piece's \n i) Instrument's");
                        String tablem = scan.nextLine();
                        switch (tablem) {
                            case "c":
                                System.out.println("What would you like to modify?\nType letter to choose. To exit type 'e'\n n) Composer's name \n t) Composer's nationality \n b) Composer's place of birth \n y) Composer's year of birth \n p) Number of composed pieces");
                                String param = scan.nextLine();
                                back = ih.composerModifying(param, scan, con);
                                break;
                            case "p":
                                System.out.println("What would you like to modify?\nType letter to choose. To exit type 'e'\n n) Piece's name \n f) Piece's formal name \n g) Piece's genre ");
                                String param1 = scan.nextLine();
                                back = ih.pieceModifying(param1, scan, con);
                                break;

                            case "i":
                                System.out.println("What would you like to modify?\nType letter to choose. To exit type 'e'\n n) Instrument's name \n c) Instrument's category");
                                String param2 = scan.nextLine();
                                back = ih.intrumentModifying(param2, scan, con);
                                break;
                        }break;

                    case"ilovedatabases":
                        pr.easterEgg();
                        System.out.println("\nType any key to go back ;)");
                        String tmp = scan.nextLine();
                        back = false;
                        break;
                    case"e":
                        back = false;
                        open = false;
                        break;
                    default:
                        System.out.println("Please choose a valid option");

                }break;

            }
        }

    }
}

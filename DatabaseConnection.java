package varausjarjestelma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    /**
     * tietokannan osoite
     */
    private static final String CONNSTRING = "*****************************************"
            + "****?user=*********&password=*******";

    /**
     * luo yhteyden tietokantaan
     *
     * @return connection
     * @throws SQLException
     */
    protected static Connection openConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(CONNSTRING);
        return conn;
    }

    /**
     * sulkee yhteyden tietokantaan
     *
     * @param c connection
     * @throws SQLException
     */
    protected static void closeConnection(Connection c) throws SQLException {
        if (c != null) {
            c.close();
        }
        System.out.println("\t>> Tietokantayhteys suljettu");
    }

    /**
     * ottaa tietokannan kayttoon
     *
     * @param c connection
     * @throws SQLException
     */
    protected static void useDatabase(Connection c) throws SQLException {

        Statement stmt = c.createStatement();
        stmt.executeQuery("USE **********");
        System.out.println("Käytetään tietokantaa");
    }
}

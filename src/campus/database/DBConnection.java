//@author Knobs
package campus.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:sqlserver://Localhost:1433;"
            + "databaseName=CampusEquipmentDB;"
            + "integratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL);
    }//end getConnection method
}//end class

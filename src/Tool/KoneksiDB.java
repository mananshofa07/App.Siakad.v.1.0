
package Tool;

import java.sql.*;
public class KoneksiDB {
    public Connection getConnection() throws SQLException{
        Connection cnn;
        try{
            String server = "jdbc:mysql://localhost/dbsiakad_171530021";
            String drever = "com.mysql.jdbc.Driver";
            Class.forName(drever);
            cnn = DriverManager.getConnection(server, "root", "" );
            return cnn;
        }catch(SQLException | ClassNotFoundException se){
            System.out.println(se);
            return null;
        }
            
    }
}

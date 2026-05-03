
package carrentalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;


public class database {
    
    public static Connection connectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // NOTE!! MAKE YOUR OWN DATABASE
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/rentcar", "root", "");
//            Connection connect = DriverManager.getConnection(
//                "jdbc:mysql://localhost/rentcar?useSSL=false&serverTimezone=UTC",
//                "root",
//                ""
//            );            
// root is the default username while "" or empty is for the password
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloDB1 {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null, st2;
        ResultSet rs = null;
        
        String  jdbc_drivers = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/currency";
        String user = "root";
        String password = "Hanuman1!";
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
            System.out.println("Step 1");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println("My Version is: " +rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println("Does not connect");
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(HelloDB1.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
               System.out.println("It failed");
                Logger.getLogger(HelloDB1.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
    }
}

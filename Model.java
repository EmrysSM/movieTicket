package project3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class Model implements Serializable {
    
    private Connection con;
    private java.sql.Statement st;
    private ResultSet rs;
    private String  jdbc_drivers, url, user, password = "";
    private String current_user, current_native, current_lastConver;
    private String status;
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    String currentUser;
    
    public Model() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

   
    
    
    boolean userNameExists(String uName) {
        return true;
    }

    void createUser(String uName, String password) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");
            st = con.createStatement();
            st.executeUpdate("INSERT INTO user_info (username, password, nativeCountry, lastConversion) VALUES ('"+uName+"', '"+password+"', 'US', 'EURO')");
            setStatus("signup success");
            

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               setStatus("signup failed");
               
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
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
    }
    
    void login(String uName, String password) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user_info WHERE username = '"+uName+"' AND password = '"+password+"'");

            if (rs.next()) {
                current_user = rs.getString(1);
                current_native = rs.getString(3);
                current_lastConver = rs.getString(4);
                setStatus("login success");
            } else {
                setStatus("login failed");
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               setStatus("login failed");
               
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
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
    }

    void setCurrentUser(String user) {
        currentUser = user;
    }

    String getPassword(String uName) {
        return "";
    }
    
    void setStatus(String s) {
        status = s;
    }
    
    String getStatus() {
        return status;
    }
    
    String[] getUserInfo() {
        String[] temp = {current_user, current_native, current_lastConver};
        return temp;
    }
    
    public void database(){
        con = null;
        st = null;
        rs = null;
        
        jdbc_drivers = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/currency";
        user = "root";
        password = "";
        
    }

   
    void deleteUser() {
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");
            st = con.createStatement();
            st.executeUpdate("DELETE FROM user_info WHERE username = '"+current_user+"'");
            current_user = "";


        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               setStatus("signup failed");
               
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
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
    }
    
    
}

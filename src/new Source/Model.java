
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class Model {
    private Connection con;
    private java.sql.Statement st;
    private ResultSet rs;
    
    private String  jdbc_drivers, url, user, password = "";
    private String current_user, current_native, current_lastConver;
    private String status;
    String currentUser;

    public Model() {
        con = this.getConnection();
    }

    
    public Connection getConnection(){
           // connect to databese and set up Statement
            Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticket?autoReconnect=true&useSSL=false","root","root");
            st = conn.createStatement();

        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            //conn.close();
            System.exit(0);
        }
      
        return conn;
     }
    

    
    //Sign up Database Code!!!! 
    void createUser(String uName, String password) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");//update the connection and roots
            st = con.createStatement();
            //user_info is the table name , with column names being username and password.
            st.executeUpdate("INSERT INTO user_info (username, password) VALUES ('"+uName+"', '"+password+")");
           

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
  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", ""); //update the connection and roots
            st = con.createStatement();
             //user_info is the table name , with column names being username and password.
            rs = st.executeQuery("SELECT * FROM user_info WHERE username = '"+uName+"' AND password = '"+password+"'");

            

        } catch (SQLException ex) {
     
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
              
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
           
                            }
        }
    }
    void createDate(String date) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");//update the connection and roots
            st = con.createStatement();
            //user_info is the table name , with column names being username and password.
            st.executeUpdate("INSERT INTO user_info (date) VALUES ('"+date+"')");
           

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
    void createTime(String time) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");//update the connection and roots
            st = con.createStatement();
            //user_info is the table name , with column names being username and password.
            st.executeUpdate("INSERT INTO user_info (time) VALUES ('"+time+"')");
           

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
    void createMovie(String movie) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");//update the connection and roots
            st = con.createStatement();
            //user_info is the table name , with column names being username and password.
            st.executeUpdate("INSERT INTO user_info (movie) VALUES ('"+movie+"')");
           

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
    void createSeat(String seatNumber) {
        
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency", "root", "");//update the connection and roots
            st = con.createStatement();
            //user_info is the table name , with column names being username and password.
            st.executeUpdate("INSERT INTO user_info (seatNumber) VALUES ('"+seatNumber+"')");
           

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
    
    public int insert(String Table, ArrayList input) {
        try {
            String query="insert into "+Table+" ";
            query+= "values (";
            query+="'"+input.get(0)+"'";
            for(int i=1; i<input.size() ;i++){
                query+=", '"+input.get(i)+"'";
            }
            query+= " )";
            st.executeUpdate(query);
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return 0;
    }
    
    public int delete(String Table, String column, String value) {
        try {
            String query="DELETE FROM " + Table + " WHERE " + column + "=\'"+ value +"\';";
            st.executeUpdate(query);
        } catch(SQLException e) {
            System.err.println("SQL Error");
        }
        
        return 0;
    }
    
    public ResultSet select(String Table, String column, String value) {
        try {
            String query="SELECT * FROM " + Table + " WHERE " + column + "=\'"+ value +"\';";
            rs = st.executeQuery(query);
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return rs;
    }
    
    public int update(String Table, String col, String value, String rowID, String valueID) {
        try {
            String query="Update "+Table+" SET "+col+" = \'"+value+"\' WHERE "+rowID+" = \'"+valueID+"\'";
            st.executeUpdate(query);
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        // Model setup
        Model testModel = new Model();
        testModel.getConnection();
        
        // Testing the insert method
//        ArrayList columns = new ArrayList<>();
//        columns.add("TestUser");
//        columns.add("TestPassword");
//        columns.add("2010-10-10");
//        columns.add("Test Name");
//        testModel.insert("users", columns);

        // Testing update method
//        testModel.update("users", "fullname", "Test Name Update", "Username", "TestUser");

        // Testing select method
//        try {
//            ResultSet resultSet = testModel.select("users", "Username", "TestUser");
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
//            while (resultSet.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = resultSet.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println("");
//            }
//        } catch(SQLException e) {
//            System.err.println(e);
//        }

        // Testing delete method
        testModel.delete("users", "Username", "TestUser");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvsreminder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Samad
 */
public class DatabseConnection {

    Connection con;
     

         
    private static String dbURL = "jdbc:sqlite:TVSDb.db";
    public DatabseConnection() {
        try {
           Class.forName("org.sqlite.JDBC").newInstance();
            //Get a connection
            con = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }
    public Connection getConnection(){
        return con;
    }
}

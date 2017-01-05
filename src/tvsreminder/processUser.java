/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvsreminder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Casual
 */
public class processUser {

    Connection con;
    Statement st;
    ResultSet rs;

    public void insertUpdateUser(UserDTO userObj) throws Exception {
        DatabseConnection db = new DatabseConnection();
        try {
            con = db.getConnection();
            st = con.createStatement();
            st.executeUpdate("INSERT OR REPLACE INTO usXusers"
                    + "(us_usname, us_uspass, us_ustype) "
                    + "VALUES "
                    + "('" + userObj.getName() + "',"
                    + "'" + userObj.getPassword() + "', "
                    + "'" + userObj.getType() + "') ;");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void deleteUser(String userid, String username) throws Exception {
        DatabseConnection db = new DatabseConnection();
        try {
            con = db.getConnection();
            st = con.createStatement();
            st.executeUpdate("DELETE FROM usXusers where us_usid = '" + userid + "' AND us_usname = '" + username + "'");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}

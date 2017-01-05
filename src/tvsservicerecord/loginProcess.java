/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvsservicerecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tvsreminder.DatabseConnection;

/**
 *
 * @author Samad
 */
public class loginProcess {

    Statement st;
    Connection con;
    ResultSet rs;

    public loginClass checkAuth(String username, String password) throws SQLException {
        boolean authority = false;
        loginClass lgnCls = new loginClass(authority, null, null, null);;
        try {

            DatabseConnection db = new DatabseConnection();
            String userType = null;
            con = db.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT  count(*) as count, * from usXusers  where us_usname = '" + username + "' AND us_uspass = '" + password + "' group by us_usid;");
            int count = 0;
            if (rs.next()) {
                count = rs.getInt("count");
                userType = rs.getString("us_ustype");
            }
            if (count == 1) {
                lgnCls = new loginClass(true, username, password, userType);
                authority = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            lgnCls = new loginClass(authority, null, null, null);
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

            return lgnCls;
        }

    }

}

class loginClass {

    private boolean authenticated = false;
    private String username;
    private String password;
    private String type;

    public loginClass(boolean authenticated, String username, String password, String type) {
        this.authenticated = authenticated;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

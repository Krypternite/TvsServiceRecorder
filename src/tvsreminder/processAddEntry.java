/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvsreminder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casual
 */
public class processAddEntry {

    Connection con;
    Statement st;
    ResultSet rs;

    public void addEntry(serviceDTO serviceEntry) throws Exception {
        DatabseConnection db = new DatabseConnection();
        try {
            con = db.getConnection();
            st = con.createStatement();
            st.executeUpdate("INSERT OR REPLACE INTO srCservice ("
                    + "sr_chasis,"
                    + "sr_model,"
                    + "sr_custname,"
                    + "sr_custadd,"
                    + "sr_custphone1,"
                    + "sr_custphone2,"
                    + "sr_km,"
                    + "sr_fservicedate,"
                    + "sr_lservicedate,"
                    + "sr_nservicedate,"
                    + "sr_edtm,"
                    + "sr_eby"
                    + ") VALUES ("
                    + "'" + serviceEntry.getChasis() + "',"
                    + "'" + serviceEntry.getModel() + "',"
                    + "'" + serviceEntry.getCustName() + "',"
                    + "'" + serviceEntry.getCustAdd() + "',"
                    + "'" + serviceEntry.getCustPhone1() + "',"
                    + "'" + serviceEntry.getCustPhone2() + "',"
                    + "'" + serviceEntry.getKilometers() + "',"
                    + "'" + serviceEntry.getfServiceDate() + "',"
                    + "'" + serviceEntry.getlServiceDate() + "',"
                    + "'" + serviceEntry.getnServiceDate() + "',"
                    + "'" + serviceEntry.getEdtm() + "',"
                    + "'" + serviceEntry.getEby() + "')");

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

    public void FillTable(JTable table, String Query) throws Exception {
        try {
            DatabseConnection db = new DatabseConnection();
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(Query);

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }

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

    public void deleteEnrty(String chasis, String model) throws Exception {
        DatabseConnection db = new DatabseConnection();
        try {
            con = db.getConnection();
            st = con.createStatement();
            st.executeUpdate("DELETE FROM srCservice WHERE sr_chasis = '" + chasis + "' AND sr_model ='" + model + "'");

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

    public serviceDTO getServiceDetails(String chasis) throws Exception {
        DatabseConnection db = new DatabseConnection();
        serviceDTO sr = new serviceDTO();
        
        try {
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT "
                    + "sr_srid,"
                    + "sr_chasis,"
                    + "sr_model,"
                    + "sr_custname,"
                    + "sr_custadd,"
                    + "sr_custphone1,"
                    + "sr_custphone2,"
                    + "sr_km,"
                    + "strftime(\"%d/%m/%Y\", sr_fservicedate) AS sr_fservicedate,"
                    + "strftime(\"%d/%m/%Y\", sr_lservicedate) AS sr_lservicedate,"
                    + "strftime(\"%d/%m/%Y\", sr_nservicedate) AS sr_nservicedate,"
                    + "sr_eby,"
                    + "strftime(\"%d/%m/%Y\", sr_edtm) AS sr_edtm "
                    + "from srCservice WHERE sr_chasis = '"+chasis+"';");
            while (rs.next()) {
                sr.setChasis(rs.getString("sr_chasis"));
                sr.setModel(rs.getString("sr_model"));
                sr.setCustName(rs.getString("sr_custname"));
                sr.setCustAdd(rs.getString("sr_custadd"));
                sr.setCustPhone1(rs.getString("sr_custphone1"));
                sr.setCustPhone2(rs.getString("sr_custphone2"));
                sr.setKilometers(rs.getInt("sr_km"));
                sr.setfServiceDate(rs.getString("sr_fservicedate"));
                sr.setlServiceDate(rs.getString("sr_lservicedate"));
                sr.setnServiceDate(rs.getString("sr_nservicedate"));
                sr.setEby(rs.getString("sr_eby"));
                sr.setEdtm(rs.getString("sr_edtm"));
                sr.setRowFound(true);
            }

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
            return sr;
        }
    }
}

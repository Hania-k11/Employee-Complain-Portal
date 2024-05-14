
package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Complain {
   
   
    private String time;
    private String date;
    private String type;
   private String status;
    private String remarks;
    private String id;

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;


    public Complain() {
    }

    public Complain(String time, String date, String type, String status, String remarks) {
        this.time = time;
        this.date = date;
        this.type = type;
        this.status = status;
        this.remarks = remarks;
    }

   
    public String getStatus() {
        return status;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

 
    public String getDate() {
        return date;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
    
     public boolean deleteComplain(int ID) {
        String str = "delete from Complains where ID = '" + ID + "'";
        boolean b = false;
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(str);
            if (res > 0) {

                b = true;
            } else {

                b = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return b;
    }

    public String getRemarks() {
        return remarks;
    }
    
     
    public boolean updateCmp(int ID) {
        boolean b = false;

        String sql = "UPDATE Complains SET Status = '" + this.status + "',Remarks = '" + this.remarks + "' WHERE ID = '" + ID + "'";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {
                b = true;
            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }
}


package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Company {
     private String name,branch,email;
    Department d1;

    public Company() {
    }
    
    
      public Company(String name, String branch, String email, Department d1) {
        this.name = name;
        this.branch = branch;
        this.email = email;
        this.d1 = d1;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }
ConnectionToDB con = new ConnectionToDB();
    Connection con_obj=con.EstablishConnection();
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet res=null;
   public boolean addCompanydet() {
        boolean b = false;

        String sql = "insert into company_details(cmpName,cmpBranch,cmpEmail)values('" + this.name + "','" + this.branch + "','" + this.email + "')";

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
  public boolean deleteComp(int ID) {
        String str = "delete from company_details where ID = '" + ID + "'";
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
 public boolean searchCmp(int ID) {
        String str = "select * from company_details where ID = '" + ID + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                 this.name = res.getString("cmpName");
                this.email = res.getString("cmpEmail");
                this.branch = res.getString("cmpBranch");
                
                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }
  public boolean updateComplain(int ID) {
        boolean b = false;

        String sql = "UPDATE company_details SET cmpName = '" + this.name + "',cmpEmail = '" + this.email + "',cmpBranch = '" + this.branch + "' WHERE ID = '" + ID + "'";

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

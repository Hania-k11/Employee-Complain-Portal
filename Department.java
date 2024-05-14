
package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Department {
    private String name,Bulding_name;
    Employee e2;

    public Department() {
    }


    public Department(String name, String Building_name, Employee e2) {
        this.name = name;
        this.e2 = e2;
        this.Bulding_name = Building_name;
    }
 public String getBuildingName() {
        return this.Bulding_name;
    }
    public String getName() {
        return name;
    }
 ConnectionToDB con = new ConnectionToDB();
    Connection con_obj=con.EstablishConnection();
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet res=null;
   public boolean addDeptdet() {
        boolean b = false;

        String sql = "insert into dept_details(deptName,buildingName)values('" + this.name + "','" + this.Bulding_name + "')";

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
    
     public boolean deleteDept(int ID) {
        String str = "delete from dept_details where ID = '" + ID + "'";
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
     public boolean searchDep(int ID) {
        String str = "select * from dept_details where ID = '" + ID + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                 this.name = res.getString("deptName");
                this.Bulding_name = res.getString("buildingName");
               
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

        String sql = "UPDATE dept_details SET deptName = '" + this.name + "',buildingName = '" + this.Bulding_name + "' WHERE ID = '" + ID + "'";

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

package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Employee {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;
    UsernameInfo u = new UsernameInfo();
    private String name, email, designation, contact, id;

    public Employee() {
    }

    public Employee(String name, String email, String designation, String contact) {

        this.name = name;
        this.email = email;
        this.designation = designation;
        this.contact = contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDesignation() {
        return designation;
    }

    public String getContact() {
        return contact;
    }

    public boolean addEmpdet() {
        boolean b = false;

        String sql = "insert into emp_details(Fullname,email,number,Designation)values('" + this.name + "','" + this.email + "','" + this.contact + "','" + this.designation + "')";

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
     public boolean addEmpname() {
        boolean b = false;

        String sql = "insert into emp_details(Fullname)values('" + this.name + "','" + this.email + "','" + this.contact + "','" + this.designation + "')";

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

    public boolean fetchdata() {
        String str = "SELECT * FROM emp_details  ";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                name = res.getString("Fullname");
                email = res.getString("email");
                contact = res.getString("number");
                designation = res.getString("Designation");
                id = res.getString("ID");

                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }
    
    
    public boolean searchempppp(int ID) {
        String str = "select * from emp_details where ID = '" + ID + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
          
           this.name = res.getString("Fullname");
                this.id=res.getString("ID");

                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }
    
    public boolean fetchemppppp(int ID) {
        String str = "SELECT * FROM emp_details where ID = '" + ID + "'  ";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                name = res.getString("Fullname");
                id = res.getString("ID");

                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }

    public boolean fetchEmp(int ID) {
        String str = "select * from emp_details where ID = '" + ID + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                name = res.getString("Fullname");
                email = res.getString("email");
                contact = res.getString("number");
                designation = res.getString("Designation");
                id = res.getString("ID");

                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }

    public boolean deleteEmp(int ID) {
        String str = "delete from emp_details where ID = '" + ID + "'";
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

    public boolean updateEmp(int ID) {
        boolean b = false;

        String sql = "UPDATE emp_details SET Fullname = '" + this.name + "',email = '" + this.email + "',number = '" + this.contact + "',Designation = '" + this.designation + "' WHERE ID = '" + ID + "'";

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

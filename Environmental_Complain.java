
package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Environmental_Complain extends Complain {
  
  private  String description,ComplainName,des_type;
Employee e = new Employee();
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;

    public Environmental_Complain() {
    }

    public Environmental_Complain(String description, String ComplainName, String des_type, String time, String date, String type, String status, String remarks) {
        super(time, date, type, status, remarks);
        this.description = description;
        this.ComplainName = ComplainName;
        this.des_type = des_type;
    }

 


    public String getComplainName() {
        return ComplainName;
    }

    public String getDescription() {
        return description;
    }



    
public boolean addComplain() {
        e.searchempppp(Integer.parseInt(Interface.emp_id));
        boolean b = false;
        String sql = "insert into Complains(ComplainType,ComplainName,DescriptionType,Description,Date,Time,Status,Remarks,empID,empName)values('" + super.getType() + "','" + this.ComplainName + "','" + this.des_type + "','" + this.description + "','" + super.getDate() + "','" + super.getTime() + "','" + super.getStatus() + "','" + super.getRemarks() + "','" + e.getId() + "','" + e.getName() + "')";

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
    

   
    
    
    


    
    


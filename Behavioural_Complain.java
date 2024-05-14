package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Behavioural_Complain extends Complain {

    String description, ComplainName, des_type,empName,empID;

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;
Employee e = new Employee();
    public Behavioural_Complain() {
    }

    public Behavioural_Complain(String description, String ComplainName, String des_type, String time, String date, String type, String status, String remarks) {
        super(time, date, type, status, remarks);
        this.description = description;
        this.ComplainName = ComplainName;
        this.des_type = des_type;
    }

    public String getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public String getComplainName() {
        return ComplainName;
    }

    public String getDescription() {
        return description;
    }

    public boolean searchComplain(int ID) {
        String str = "select * from Complains where ID = '" + ID + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                super.setType(res.getString("ComplainType"));
                ComplainName = res.getString("ComplainName");
                des_type = res.getString("DescriptionType");
                description = res.getString("Description");
                super.setDate(res.getString("Date"));
                super.setTime(res.getString("Time"));
                super.setStatus(res.getString("Status"));
                super.setRemarks(res.getString("Remarks"));
                super.setId(res.getString("ID"));
                this.empID = res.getString("empID");
                this.empName = res.getString("empName");

                b = true;
                return b;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
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
            JOptionPane.showMessageDialog(null, "Complain Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return b;
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

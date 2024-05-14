/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logininterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class EstablishConnection {
    
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj=con.EstablishConnection();
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet res=null;
    private String name, id, password;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean loginAdmin(String auname, String apass) {

        String loginString = "Select * from admin_login where username='" +auname+ "' and password='" +apass+ "'";

        boolean b;
        try {

            pstmt = con_obj.prepareStatement(loginString);
            res = pstmt.executeQuery();

            if (res.next()) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }

        return b;
    }
public boolean loginUser(String auname, String apass) {

        String loginString = "Select * from user_login where username='" +auname+ "' and password='" +apass+ "'";

        boolean b;
        try {

            pstmt = con_obj.prepareStatement(loginString);
            res = pstmt.executeQuery();

            if (res.next()) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }

        return b;

    }


}
    

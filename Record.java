
package com.mycompany.logininterface;

import java.util.Vector;


public class Record {
       Vector <Employee>  EmployeeList = new Vector<>();

    public Record() {
        EmployeeList = new Vector<>();
    }
    public void AddEmployee(Employee e){
        EmployeeList.add(e);
        
    }
 public void Print_Record(){
     for(int i=0;i<EmployeeList.size();i++){
         Employee employeelist= EmployeeList.elementAt(i);
         System.out.println("EMLOYEE NAME:" + employeelist.getName());
         System.out.println("EMPLOYEE CONTACT:" + employeelist.getContact());
         System.out.println("EMPLOYEE EMAIL: " + employeelist.getEmail());
         System.out.println("EMPLOYEE DESIGNATION: " + employeelist.getDesignation());
     }
     
     
    
}
}

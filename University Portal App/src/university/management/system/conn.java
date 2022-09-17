package university.management.system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn() throws SQLException{  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");    
            s =c.createStatement();  
            System.out.println("Connected");
           
        }catch(Exception e){ 
            System.out.println(e);
        }
    }  
}  

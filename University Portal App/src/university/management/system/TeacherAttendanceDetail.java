/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings({ "serial", "unused" })
public class TeacherAttendanceDetail extends JFrame implements ActionListener{
	String r=Project.roll_no;
    JTable j1;
    JButton b1;
    String h[]={"Employee id","Date Time","First Half","Second Half"};
    String d[][]=new String[150][4];  
    int i=0,j=0;
    String a;
    TeacherAttendanceDetail(){
        super("View Teachers Attendance");
        setSize(800,300);
        setLocation(450,150);
        try{
        	
            conn c1=new conn();
            System.out.println(Project.roll_no);
            if(r==null) {
            	a="select * from attendance_teacher";
            }else {
            	a = "select * from attendance_teacher where emp_id = '"+r+"'";
            }
            System.out.println(a);
			ResultSet rs=c1.s.executeQuery(a);
            while(rs.next()){
                d[i][j++]=rs.getString("emp_id");
                d[i][j++]=rs.getString("Date");
                d[i][j++]=rs.getString("first");
                d[i][j++]=rs.getString("second");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new TeacherAttendanceDetail().setVisible(true);
    }
}
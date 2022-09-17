/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JTextArea t1;
   JPanel p1;
   JButton b1;
   
   Marks(){}
   Marks(String str){
       setSize(500,600);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();

       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(450,200);
       
       mark(str);
       
       b1=new JButton("Print");
       add(b1,"South");
       
       b1.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent e) {
    	   try{
               t1.print();
           }catch(Exception ae){}
       }});
   }
   
   public void mark(String s){
    try{
           conn c = new conn();
           conn c1=new conn();
           
           t1.setText("\tResult of Examination\n\n");
           
           ResultSet rs1 = c.s.executeQuery("select * from subject where rollno="+s);
           ResultSet rs2 = c1.s.executeQuery("select * from marks where rollno="+s);
           while(rs1.next()&&rs2.next()){
               t1.append("\nSubject\t\tMarks\n\n"+rs1.getString("subject1"));
               t1.append("\t\t"+rs2.getString("marks1"));
               t1.append("\n"+rs1.getString("subject2"));
               t1.append("\t\t"+rs2.getString("marks2"));
               t1.append("\n"+rs1.getString("subject3"));
               t1.append("\t\t"+rs2.getString("marks3"));
               t1.append("\n"+rs1.getString("subject4"));
               t1.append("\t\t"+rs2.getString("marks4"));
               t1.append("\n"+rs1.getString("subject5"));
               t1.append("\t\t"+rs2.getString("marks5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
               t1.append("\n-----------------------------------------");
               t1.append("\n");        
           }
          
          
           
          
         
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}
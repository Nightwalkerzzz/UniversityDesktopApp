package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class quizpopup extends JFrame implements ActionListener {
	
	 JButton b1, b2;
	    JTextField t1;
	    String roll = Project.roll_no1;
	    
	    quizpopup(){
	        setBounds(400, 200, 500, 500); // dleft, //dup // length, height ///////
	        getContentPane().setBackground(Color.WHITE);
	        setLayout(null);
	        
	        JLabel l2 = new JLabel("Quiz");
	        //l2.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
	        l2.setForeground(new Color(30, 144, 254));
	        l2.setBounds(100, 60, 300, 45);
	        add(l2);
	        
	        JLabel l3 = new JLabel("Roll No :");
	        l3.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
	        l3.setForeground(new Color(30, 144, 254));
	        l3.setBounds(100, 150, 300, 20);
	        add(l3);
	        
	        t1 = new JTextField();
	        t1.setBounds(100, 200, 300, 25);
	        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        add(t1);
	        t1.setText(roll);
	        
	        b1 = new JButton("Rules");
	        b1.setBounds(100, 270, 120, 25);
	        b1.setBackground(new Color(30, 144, 254));
	        b1.setForeground(Color.WHITE);
	        b1.addActionListener(this);
	        add(b1);
	        
	        b2 = new JButton("Exit");
	        b2.setBounds(300, 270, 120, 25);
	        b2.setBackground(new Color(30, 144, 254));
	        b2.setForeground(Color.WHITE);
	        b2.addActionListener(this);
	        add(b2);
	        
	        setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent ae){
	        if(ae.getSource() == b1){
	            this.setVisible(false);
	            new quizRules(roll);
	        }else{
	            System.exit(0);
	        }
	    }

	    public static void main(String[] args) {
	        new quizpopup();
	    }

}

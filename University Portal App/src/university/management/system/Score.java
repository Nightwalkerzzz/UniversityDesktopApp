package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  


public class Score extends JFrame implements ActionListener{
	
	Score(String username, int score){
        setBounds(100, 100, 916, 591);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel l2 = new JLabel("Roll Number : "+username);
        l2.setBounds(143, 206, 172, 32);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l2);
        
        JLabel l3 = new JLabel("Score : "+score);
        l3.setBounds(143, 264, 172, 32);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l3.setForeground(new Color(199, 21, 133));
        add(l3);
        
        JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(294, 201, 172, 32);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(294, 264, 172, 32);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("QUIZ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(143, 67, 296, 53);
		add(lblNewLabel_4);
        
        JButton b1 = new JButton("BACK");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        
        b1.setBounds(381, 394, 172, 32);
        add(b1);
        addfile(username,score);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        //new quizpopup().setVisible(true);
    }
    
    public static void main(String[] args){
        new Score("", 0).setVisible(true);
    }
    public void addfile(String username, int score) {
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now(); 
    	String time = dtf.format(now);
    	String tempPath="D:\\College\\Projects\\Mine\\University Portal\\QuizResult\\";
		String extension = ".txt";
		String path=tempPath+username+extension;
		String ans="\n"+time+" \t Roll No. : "+username+" \t Marks : "+Integer.toString(score)+"\n";
		try {
			File myObj = new File(path);
			if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
			Files.write(Paths.get(path), ans.getBytes(), StandardOpenOption.APPEND);
			//FileWriter myWriter = new FileWriter(path);
			//myWriter.write(ans);
			//myWriter.close();
			
		}catch (IOException ee) {
		      System.out.println("An error occurred.");
		      ee.printStackTrace();
		    }
    	
    }


}

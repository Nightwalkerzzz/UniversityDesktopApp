package university.management.system;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class teacherwrittenexam {

	private JFrame frame;
	
	JTextArea textArea_1;
	JComboBox comboBox;
	static JLabel lblNewLabel_2;
	static JLabel lblNewLabel_6;
	
	String subject = "";
	String marks = "";
	String[][] qset = new String[50][2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherwrittenexam window = new teacherwrittenexam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public teacherwrittenexam() {
		generatequestion();
		initialize();
		frame.setVisible(true);
		setmarks();
		apply();
	}
	
	public void setmarks() {
		lblNewLabel_2.setText(subject);
		lblNewLabel_6.setText(marks);
		
	}
	
	
	public void generatequestion() {
		try {
		      File myObj = new File("D:\\College\\Projects\\Mine\\University Portal\\Exam_files\\Question_paper\\question.txt");
		      //File myObj1 = new File("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\answer.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        if(i==0)subject=data;
		        else if(i==1)marks=data;
		        else {
		        	String utemp = "Question : "+Integer.toString(i-1);
		        	String ltemp = data;
		        	qset[i-2][0]=ltemp;
		        	qset[i-2][1]=utemp;
		        }
		        i++;
		      }
		      System.out.println("Marks : "+marks);
		      //textArea.append(marks);
		      //lblNewLabel_2.setText("bhsdk");
		      
		      myReader.close();
		    } catch (FileNotFoundException ee) {
		      System.out.println("An error occurred.");
		      ee.printStackTrace();
		    }
		System.out.println("Subject : " + subject);
		System.out.println(qset[0][1]);
		
	}
	
	public void apply() {
		System.out.println("Apply");
		int i=0;
		while(qset[i][0]!=null) {
			System.out.println(qset[i][1]);
			comboBox.addItem(new comboItem(qset[i][1], qset[i][0]));
			i++;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1209, 716);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EXAM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(531, 10, 142, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SUBJECT :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(622, 59, 123, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Null");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(732, 65, 410, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QUESTION NUMBER : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(77, 146, 207, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String value = ((comboItem)item).getValue();
				textArea_1.setText(value);
				
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		comboBox.setBounds(297, 146, 296, 32);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Total Marks : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(77, 104, 123, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Questions : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(77, 207, 123, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		JButton btnNewButton = new JButton("Previous");
		btnNewButton.setBounds(77, 632, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBounds(185, 632, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "update flag set value=1 where process='written'";
					c1.s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null,"Exam Started");
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//					
				}
				
			}
		});
		btnNewButton_2.setBounds(1060, 632, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 246, 1065, 376);
		frame.getContentPane().add(scrollPane);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane.setViewportView(textArea_1);
		
		
		
		lblNewLabel_6 = new JLabel("0");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(210, 104, 60, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_3 = new JButton("Stop");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "update flag set value=0 where process='written'";
					c1.s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null,"Exam Stopped");
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//					
				}
				
			}
		});
		btnNewButton_3.setBounds(922, 632, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		
	}
}

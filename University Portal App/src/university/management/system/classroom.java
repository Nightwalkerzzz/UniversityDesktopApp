package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.*;

public class classroom extends JFrame implements ActionListener, Runnable {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static JTextArea textArea;
	static JTextArea textArea_2 ;
	JTextArea textArea_1;
	String r = Project.roll_no1;
	
	
	public static String q = "";
	public static String a = "";
	
	
	BufferedWriter writer;
    BufferedReader reader;
    BufferedWriter writer1;

	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classroom window = new classroom();
					Thread t1 = new Thread(window);
					t1.start();
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
	
	public classroom() {
		initialize();
		try{
	           
	           Socket socketClient = new Socket("localhost", 2003);
	           writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
	           reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
	           
	           Socket socketClient1 = new Socket("localhost", 2000);
	           writer1 = new BufferedWriter(new OutputStreamWriter(socketClient1.getOutputStream()));
	       }catch(Exception e){}
	}
	
//	public void actionPerformed(ActionEvent ae){
//        String str = "Kaleen Bhaiya\n"+t1.getText();
//        try{
//            writer.write(str);
//            writer.write("\r\n");
//            writer.flush();
//        }catch(Exception e){}
//        t1.setText("");
//    }
    
    public void run(){
        try{
            String msg = "";
            while((msg = reader.readLine()) != null){
            	textArea.append(msg + "\n");
            }
        }catch(Exception e){}
    }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1376, 675);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(1053, 10, 279, 270);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 251, 164, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "YOU : "+textField.getText();
				if(textField.getText().toLowerCase().contains(a.toLowerCase())) {
					System.out.println("R");
					textArea_1.setForeground(Color.GREEN);
					textArea_1.append(str + "\n");
				}else {
					System.out.println("W");
					textArea_1.setForeground(Color.RED);
					textArea_1.append(str + "\n");
				}
				
				str = r+" : "+textField.getText();
		        try{
		            writer1.write(str);
		            writer1.write("\r\n");
		            writer1.flush();
		        }catch(Exception ee){}
		        textField.setText("");
				
			}
		});
		btnNewButton.setBounds(163, 250, 106, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(82, 0, 82, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ANSWER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(82, 150, 60, 13);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 17, 228, 123);
		panel.add(scrollPane_1);
		
		textArea_2 = new JTextArea();
		scrollPane_1.setViewportView(textArea_2);
		textArea_2.setText("No Question");
		
		JButton btnNewButton_7 = new JButton("Refresh");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      File myObj = new File("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\question.txt");
				      File myObj1 = new File("D:\\College\\Projects\\Mine\\University Portal\\inClassQuestion\\answer.txt");
				      Scanner myReader = new Scanner(myObj);
				      Scanner myReader1 = new Scanner(myObj1);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        System.out.println(data);
				        q=data;
				        textArea_2.setText(q);;
				        System.out.println("brrrr");
				      }
				      myReader.close();
				      while (myReader1.hasNextLine()) {
				        String data = myReader1.nextLine();
				        System.out.println(data);
				        a=data;
				      }
				      myReader1.close();
				    } catch (FileNotFoundException ee) {
				      System.out.println("An error occurred.");
				      ee.printStackTrace();
				    }
			}
		});
		btnNewButton_7.setBounds(153, 142, 85, 21);
		panel.add(btnNewButton_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 165, 228, 76);
		panel.add(scrollPane_2);
		
		textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1053, 290, 279, 340);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 302, 189, 38);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEND");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = r+" : "+textField_1.getText();
		        try{
		            writer.write(str);
		            writer.write("\r\n");
		            writer.flush();
		        }catch(Exception ee){}
		        textField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(186, 320, 93, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("CHAT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(98, 0, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("HIDE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str ="Unknown : "+textField_1.getText();
		        try{
		            writer.write(str);
		            writer.write("\r\n");
		            writer.flush();
		        }catch(Exception ee){}
		        textField_1.setText("");
			}
		});
		btnNewButton_2.setBounds(187, 301, 92, 21);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 228, 271);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(14, 12, 1025, 581);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.setBounds(466, 603, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("MIC");
		btnNewButton_4.setBounds(346, 603, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Camera");
		btnNewButton_5.setBounds(582, 603, 85, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Stream");
		btnNewButton_6.setBounds(698, 603, 85, 21);
		frame.getContentPane().add(btnNewButton_6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.*;



public class teacher_classroom extends JFrame implements ActionListener, Runnable {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JTextArea textArea;
	static JTextArea textArea_1;
	
	BufferedWriter writer;
    BufferedReader reader;
    
    static BufferedReader reader1;
    
    public static String Question;
    public static String Answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacher_classroom window = new teacher_classroom();
					Thread t1 = new Thread(window);
					t1.start();
					Qthread t2 = new Qthread();
					t2.start();
					System.out.println(Question+" "+Answer);
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
	public teacher_classroom() {
		initialize();
		System.out.println("FFFFFFFFF");
//		Thread t1 = new Thread(this);
//		t1.start();
//		Qthread t2 = new Qthread();
//		t2.start();
//		System.out.println(Question+" "+Answer);
//		frame.setVisible(true);
		try{
	           
	           Socket socketClient = new Socket("localhost", 2003);
	           writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
	           reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
	           
	           Socket socketClient1 = new Socket("localhost", 2000);
	           reader1 = new BufferedReader(new InputStreamReader(socketClient1.getInputStream()));
	       }catch(Exception e){}
	}
	
	public void run(){
        try{
            String msg = "";
            String msg1= "";
            System.out.println("Brrrrrr");
//            while(true){
//            	if((msg = reader.readLine()) != null)textArea.append(msg + "\n");
//            	if((msg1 = reader1.readLine()) != null)textArea_1.append(msg1 + "\n");
//            	
//            }
            while(true){
            	textArea.append(reader.readLine() + "\n");
            	//textArea_1.append(reader1.readLine() + "\n");
            	//if((msg1 = reader1.readLine()) != null)textArea_1.append(msg1 + "\n");
            	
            }
            
//            while((msg1 = reader1.readLine()) != null){
//            	textArea_1.append(msg1 + "\n");
//            }
        }catch(Exception e){}
    }
	public static String ques() {
		System.out.println("T "+Question);
		return Question;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1328, 732);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(963, 10, 307, 341);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Upload Question :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 24, 122, 19);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UPLOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miniQuestion m = new miniQuestion();
				m.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(171, 25, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Answer :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 66, 122, 19);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(10, 97, 287, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 287, 188);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Chat");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_2);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane.setViewportView(textArea_1);
		
		JButton btnNewButton_6 = new JButton("Submit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Question+" "+Answer);
				textField.setText(Answer);
				classroom.q=Question;
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setBounds(171, 67, 85, 21);
		panel.add(btnNewButton_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(963, 361, 324, 325);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 287, 272);
		panel_1.add(scrollPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("Chat");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblNewLabel_3);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 292, 219, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEND");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str ="Teacher : "+textField_1.getText();
		        try{
		            writer.write(str);
		            writer.write("\r\n");
		            writer.flush();
		        }catch(Exception ee){}
		        textField_1.setText("");
				
			}
		});
		btnNewButton_1.setBounds(239, 292, 75, 21);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 10, 941, 633);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(430, 653, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mic");
		btnNewButton_3.setBounds(293, 653, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Camera");
		btnNewButton_4.setBounds(563, 653, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Stream");
		btnNewButton_5.setBounds(694, 653, 85, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Switch");
		btnNewButton_7.setBounds(834, 653, 85, 21);
		frame.getContentPane().add(btnNewButton_7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


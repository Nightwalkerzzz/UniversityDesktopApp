package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Notice_writer extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Notice_writer();
	}

	/**
	 * Create the application.
	 */
	public Notice_writer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 530, 602);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Notice");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(189, 39, 119, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(45, 149, 65, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Text");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(45, 207, 65, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		title = new JTextField();
		title.setBounds(140, 149, 286, 25);
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		JTextPane text = new JTextPane();
		text.setBounds(140, 207, 286, 259);
		frame.getContentPane().add(text);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Project.roll_no==null) {
					
					String a=title.getText();
					String b=text.getText();
					 try{
			                conn cc = new conn();
			                String q = "insert into notice values('Admin','"+a+"','"+b+"')";
			                cc.s.executeUpdate(q);
			                JOptionPane.showMessageDialog(null,"Notice Uploaded Successfully");
			                frame.setVisible(false);
			            }catch(Exception ee){
			                System.out.println("The error is:"+ee);
			            }
				}else {
					
					String a=title.getText();
					String b=text.getText();
					 try{
			                conn cc = new conn();
			                String q = "insert into notice values('Teacher','"+a+"','"+b+"')";
			                cc.s.executeUpdate(q);
			                JOptionPane.showMessageDialog(null,"Notice Uploaded Successfully");
			                setVisible(false);
			            }catch(Exception ee){
			                System.out.println("The error is:"+ee);
			            }
				}
				
			}
		});
		submit.setFont(new Font("Calibri", Font.BOLD, 20));
		submit.setBounds(176, 483, 119, 37);
		frame.getContentPane().add(submit);
	}
}

package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class studentexamarea {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentexamarea window = new studentexamarea();
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
	
	public studentexamarea() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 408);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OBJECTIVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "select value from flag where process = 'quiz'";
					ResultSet rs  = c1.s.executeQuery(s1);
					if(rs.next()) {
						//System.out.println("Brrrr");
						flag=Integer.parseInt(rs.getString(1));
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null,"No Quiz Available");
					}else {
						quizpopup q = new quizpopup();
					}
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//				
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(192, 122, 169, 51);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBJECTIVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "select value from flag where process = 'written'";
					ResultSet rs  = c1.s.executeQuery(s1);
					if(rs.next()) {
						//System.out.println("Brrrr");
						flag=Integer.parseInt(rs.getString(1));
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null,"No Exam Available");
					}else {
						written_exam window = new written_exam();
						//threadwritten check = new threadwritten();
						//check.start();
					}
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(192, 208, 169, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Enter In Exam :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(125, 30, 236, 51);
		frame.getContentPane().add(lblNewLabel);
	}

}

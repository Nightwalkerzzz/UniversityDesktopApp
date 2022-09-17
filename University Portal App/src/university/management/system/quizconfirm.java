package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class quizconfirm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizconfirm window = new quizconfirm();
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
	public quizconfirm() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 405);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPLOAD QUIZ ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 84, 164, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("STOP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "update flag set value=0 where process='quiz'";
					c1.s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null,"Quiz Stopped");
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//					
				}
			}
		});
		btnNewButton.setBounds(135, 216, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag = 1;
					conn c1  = new conn();
					String s1 = "update flag set value=1 where process='quiz'";
					c1.s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null,"Quiz Started");
				}catch(Exception ee) {
					 System.out.println("The error is:"+ee);
//					
				}
			}
		});
		btnNewButton_1.setBounds(252, 216, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}

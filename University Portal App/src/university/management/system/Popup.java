package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class Popup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Popup window = new Popup();
	}

	/**
	 * Create the application.
	 */
	public Popup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(500, 300, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                PORTAL");
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setBounds(57, 0, 439, 36);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 31));
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		JButton btnNewButton_2 = new JButton("TEACHER");
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LoginT();
			}
		});
		btnNewButton_2.setBounds(219, 146, 208, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new LoginS();
				//frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setBounds(219, 192, 208, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADMIN");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
				//frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(219, 100, 208, 36);
		frame.getContentPane().add(btnNewButton_1);
		
//		JLabel lblNewLabel_1 = new JLabel("New label");
//		lblNewLabel_1.setIcon(new ImageIcon(Popup.class.getResource("/university/management/system/icons/first.png")));
//		lblNewLabel_1.setBounds(32, 100, 149, 128);
//		frame.getContentPane().add(lblNewLabel_1);
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/first.png"));
	     Image i2 = i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
	     ImageIcon i3 =  new ImageIcon(i2);
	     JLabel l3 = new JLabel(i3);
	     l3.setBounds(32, 81, 149, 165);
	     frame.getContentPane().add(l3);
	}
}

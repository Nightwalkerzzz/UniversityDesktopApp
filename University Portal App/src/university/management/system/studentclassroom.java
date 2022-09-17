package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class studentclassroom extends JFrame implements ActionListener, Runnable {

	private JFrame frame;
	private JTextField textField;
	
	JTextArea textArea;
	
	String r = Project.roll_no1;
	
	BufferedWriter writer;
    BufferedReader reader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentclassroom window = new studentclassroom();
					Thread t1 = new Thread(window);
					t1.start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static int count = 0;
	  
    // The method that calls the main() method
    static void mainCaller()
    {
  
        System.out.println("mainCaller!");
        count++;
  
        // Calling the main() only 3 times
        if (count < 1) {
  
            // Calling the main() method
        	classroom.main(null);
        }
    }

	/**
	 * Create the application.
	 */
	public studentclassroom() {
		initialize();
		try{
	           Socket socketClient = new Socket("localhost", 2002);
	           writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
	           reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
	    }catch(Exception e){}
		
		textArea.append(" Teacher: testing\n ");
		textArea.append("Teacher: 123\n ");
		textArea.append("101: hello\n ");
		textArea.append("102: hi\n ");
		textArea.append("101: testing\n ");
		textArea.append("Teacher: class\n ");
		textArea.append("103: new student\n ");
		
	}
	
	public void run(){
        try{
            String msg = "";
            while((msg = reader.readLine()) != null){
            	textArea.append(msg + "\n ");
            }
        }catch(Exception e){}
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1294, 670);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(915, 10, 355, 585);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Messages");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(915, 604, 261, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = r+" : "+textField.getText();
		        try{
		            writer.write(str);
		            writer.write("\r\n");
		            writer.flush();
		        }catch(Exception ee){}
		        textField.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1186, 603, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXAM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentexamarea window = new studentexamarea();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(352, 165, 174, 69);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ENTER CLASS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=-1;
				mainCaller();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(352, 263, 174, 69);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ATTENDANCE");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(352, 360, 174, 69);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Roll Number : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(90, 46, 153, 55);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Project.roll_no1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(250, 45, 276, 56);
		frame.getContentPane().add(lblNewLabel_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

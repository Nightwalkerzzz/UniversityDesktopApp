package university.management.system;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notice extends JFrame{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea t1;
	   JPanel p1;
	   JButton b1;
	public Notice(){
		setSize(500,600);
	       setLayout(new BorderLayout());
	       
	       p1 = new JPanel();

	       t1 = new JTextArea(50,15);
	       JScrollPane jsp = new JScrollPane(t1);
	       t1.setFont(new Font("Senserif",Font.ITALIC,18));
	       
	       add(p1,"North");
	       
	       add(jsp,"Center");
	       
	       setLocation(450,200);
	       
	       mark();
	       
	       b1=new JButton("Print");
	       add(b1,"South");
	       
	       b1.addActionListener(new ActionListener(){
	    	   public void actionPerformed(ActionEvent e) {
	    	   try{
	               t1.print();
	           }catch(Exception ae){}
	       }});
	}
	public void mark(){
	    try{
	           conn c = new conn();
	           ResultSet rs1;
	           t1.setText("\t      NOTICE    \n\n\n");
	           if(Project.roll_no!=null) {
	        	   	rs1 = c.s.executeQuery("select * from notice where type='Admin'");
	        	   	System.out.println("FFF");
	   			}else {
	   				rs1 = c.s.executeQuery("select * from notice");
	   				System.out.println("AHH");
	   			}
	          // ResultSet rs1 = c.s.executeQuery("select * from notice where type='Admin'");
	           
	           while(rs1.next()){
	        	   System.out.println("lalalala");
	               t1.append("\n"+rs1.getString("type")+"   :");
	               t1.append("\t"+rs1.getString("title"));
	               t1.append("\n\t"+rs1.getString("text"));
	               t1.append("\n-----------------------------------------------------------------------");
	               t1.append("\n");
	           }
	         
	       }catch(Exception e){
	           e.printStackTrace();
	       }
	   }
	
	public static void main(String[] args) {
		new Notice().setVisible(true);

	}

}

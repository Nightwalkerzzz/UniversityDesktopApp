package university.management.system;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class LoginS extends LoginT{
	LoginS(){
		super();
		setTitle("LOGIN---STUDENT");

	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1) {
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login_s where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new Project(1,2).setVisible(true);
                Project.roll_no1=v;
                setVisible(false);
                System.out.println(Project.roll_no1);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
                new LoginS();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    	}else if(ae.getSource()==b2) {
    		System.exit(0);
    	}
    }

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LoginS l = new LoginS();
	}

}

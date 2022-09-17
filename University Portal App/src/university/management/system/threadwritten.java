package university.management.system;

import java.sql.ResultSet;

public class threadwritten extends Thread {
	@Override
	   public void run(){
		
		try {
			while(true) {
				Thread.sleep(10000);
				int flag=1;
				conn c1  = new conn();
				String s1 = "select value from flag where process = 'written'";
				ResultSet rs  = c1.s.executeQuery(s1);
				if(rs.next()) {
					flag=Integer.parseInt(rs.getString(1));
				}
				if(flag==0) {
					written_exam.setVisible(false);
					System.out.println("Broken");
					break;
				}
				
			}
			
		}catch(Exception ee) {
			
		}
		
			
	   }
	
}

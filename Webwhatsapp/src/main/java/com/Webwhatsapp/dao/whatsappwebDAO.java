package com.Webwhatsapp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Webwhatsapp.ENTITY.whatsappuser;
public class whatsappwebDAO implements whatsappwebDAOInterface {

	//public class FacebookDAO implements FacebookDAOInterface {
		private Connection con;
		public whatsappwebDAO() {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
				
			}
			catch(ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public int createProfile(whatsappuser iu) {
			int i=0;
			try {
				PreparedStatement ps=con.prepareStatement("insert into detail values(?,?,?,?)");
				ps.setString(1, iu.getName());
				ps.setString(2, iu.getPassword());
				ps.setString(3, iu.getEmail());
				ps.setString(4, iu.getAddress());
				
				//step 4 executeQuery
				i=ps.executeUpdate();
								
				
			}
			catch(SQLException ee) {
				ee.printStackTrace();
			}
			return i;
		}

		@Override
		public boolean loginProfile(whatsappuser iu) {
			boolean i=false;
			try {
				PreparedStatement ps=con.prepareStatement("select * from detail where name=? and password=?");
				ps.setString(1, iu.getName());
				ps.setString(2, iu.getPassword());
				
				
				//step 4 executeQuery
				ResultSet res=ps.executeQuery();
				if(res.next()) {
					i=true;
				}
								
				
			}
			catch(SQLException ee) {
				ee.printStackTrace();
			}
			return i;
		}

		@Override
		public List<whatsappuser> friendlistdao(whatsappuser iu) {
			List<whatsappuser> ll=new ArrayList<whatsappuser>();
			whatsappuser f=new whatsappuser();
			f.setName("mohan");
			f.setAddress("Chennai");
			
			whatsappuser f1=new whatsappuser();
			f1.setName("Chunnilal");
			f1.setAddress("Mumbai");
			
			ll.add(f1);
			ll.add(f);
			/*try {
				PreparedStatement ps=con.prepareStatement("select * from friendlist where name=?");
				ps.setString(1, iu.getName());
			
				
				
				//step 4 executeQuery
				ResultSet res=ps.executeQuery();
				while(res.next()) {
					FacebookEmployee f=new FacebookEmployee();
					f.setName(res.getString(1));
					f.setAddress(res.getString(4));
					ll.add(f);
				}
								
				
			}
			catch(SQLException ee) {
				ee.printStackTrace();
			}*/
			return ll;
		}


}

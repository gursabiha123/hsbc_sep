package com.study.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import com.study.entity.Instausers;
@Repository
public class studyDAO implements StudydaoInterface{

	@Override
	public List<Instausers> viewAllprofiledao() {
		
			List<Instausers> ll=new ArrayList<Instausers>();
			Connection con=null;
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

				con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
			PreparedStatement ps=con.prepareStatement("select * from detail");
					
			ResultSet res=ps.executeQuery();
			
			
			
			while(res.next()) {
				Instausers uu=new Instausers();
				uu.setName(res.getString(1));
				uu.setPassword(res.getString(4));
				uu.setEmail(res.getString(3));
				uu.setAddrs(res.getString(2));
				System.out.println("view:\t name is" +res.getString(1)+"\t email is"+res.getString(3)+"\t passwrd is"+res.getString(2));
				ll.add(uu);
			}
			}
			catch(ClassNotFoundException|SQLException e1) {
				e1.printStackTrace();
			}
		
			
			return ll;

		}

	public Instausers createProfileDAO(Instausers iu){
		int i=0;Connection con=null;
		Instausers uu=null;
		uu=new Instausers();
		try {
			
			
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				
				 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
				
				PreparedStatement ps=con.prepareStatement("insert into detail values(?,?,?,?)");//? represents that we are going to take values for questions
				ps.setString(1, iu.getName());
				
				ps.setString(2, iu.getAddrs());
				
				ps.setString(3, iu.getEmail());
				
				ps.setString(4,iu.getPassword());
				uu.setEmail(iu.getEmail());
uu.setName(iu.getName());uu.setPassword(iu.getPassword());
				System.out.println("create:\t name is" +iu.getName()+"\t email is"+iu.getEmail()+"\t passwrd is"+iu.getPassword());
				//step4 executeQuery
				i=ps.executeUpdate();
			}
				
				
				catch(ClassNotFoundException|SQLException e1)
			{
					e1.printStackTrace();
			}
				finally
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return uu;



}
/*

	public void editProfileDAO() {
		// TODO Auto-generated method stub
		

	}
	
	public int editprofilebynamedao(Instagramuser iu){
		
		
		Connection con=null;int i=0;
		
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	
		 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("update detail set passowrd = ? where name =?");//? represents that we are going to take values for questions
		
		ps.setString(1,iu.getPassword());
		
		ps.setString(2, iu.getName());
		i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		//step4 executeQuery
		return i;

		
		
	}


	public int deleteProfileDAO(Instagramuser iu) {
		
		Connection con = null;
		int p = 0;		
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("delete from detail where name=? and email=?");
				
		ps.setString(1, iu.getName());//1 means pehla ? and = pehle column ki value
		
		ps.setString(2, iu.getEmail());
		 p=ps.executeUpdate();
		//System.out.println("value p"+p);
		}
		catch(ClassNotFoundException|SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			//con.close();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
		
	}
	
	
	
	

	public Instagramuser viewProfileDAO(Instagramuser iu)   //return type object
	{
		
		Connection con=null;
		Instagramuser uu=null;
		try {
		//step 1 nd 2 always used to connect to db
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("select * from detail where name=?");//? represents that we are going to take values for questions
		ps.setString(1, iu.getName());//1 means pehla ? and = pehle column ki value
		
		
		ResultSet res=ps.executeQuery();
		//how to verify resultset is having result
		//via next() method,if next() method will return true then resultset hav some result otherwise no result
		//Instagramuser uu=null;
		if(res.next())//it is F if no data returned 
		{
			uu=new Instagramuser();
			uu.setName(res.getString(1));//1st column
			uu.setAddress(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setPassword(res.getString(4));
		}
		
		}
		
		catch(ClassNotFoundException|SQLException e1)
		{
			e1.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uu;
		

	}

	@Override
	public Map<String, List<Instagramuser>> userdetailwithhistorydao() {
		Map<String, List<Instagramuser>> m=new HashMap<String, List<Instagramuser>>();
		
		List<Instagramuser> l1=viewallProfileDAO();
		List<Instagramuser> l2=viewallProfileDAO();
		
		m.put("studentlist", l1);
		m.put("proflist", l2);
		
		return m;
	}
	
}

}*/

	@Override
	public void deleteProfileDAO(String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		int p = 0;		
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("delete from detail where email=?");
				
		System.out.println("successul");
		
		ps.setString(1, email);
		 p=ps.executeUpdate();
		
		}
		catch(ClassNotFoundException|SQLException e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			//con.close();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

@Override
public Instausers updateProfileDAO(Instausers todo) {
	Connection con = null;
	Instausers uu=null;
	uu=new Instausers();
	int p = 0;		
	try {
	
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	
	 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
	
	PreparedStatement ps=con.prepareStatement("update  detail set password = ? , name =? where email=? ");
			
	System.out.println("successul");
	
	ps.setString(1, todo.getPassword());
	
	ps.setString(2, todo.getName());
	ps.setString(3, todo.getEmail());
	uu.setPassword(todo.getPassword());uu.setEmail(todo.getEmail());
	uu.setName(todo.getName());
	 p=ps.executeUpdate();
	
	}
	catch(ClassNotFoundException|SQLException e1)
	{
		e1.printStackTrace();
	}
	finally
	{
		//con.close();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return uu;
}}

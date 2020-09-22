package com.Instagram.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.sql.*;

import com.Instagram.utility.instaexcept;
import com.Intagram.Entity.Instagramuser;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class InstagramDAO implements InstagramDAOInterface{

	
	//create profile - db
	/*
public int createProfileDAO(Instagramuser iu) {
	int i=0;Connection con=null;
	try {
		
		//step1 load driver
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//for oracle
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//for sql
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step2Create connection with database
		 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		//step3 create query
		PreparedStatement ps=con.prepareStatement("insert into detail values(?,?,?,?)");//? represents that we are going to take values for questions
		ps.setString(1, iu.getName());//1 means pehla ? and = pehle column ki value
		
		ps.setString(2, iu.getAddress());
		
		ps.setString(3, iu.getEmail());
		
		ps.setString(4,iu.getPassword());
		
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
		return i;

	}
*/

//create profile - file
	
	public int createProfileDAO(Instagramuser iu) {
		int i=0;
		try {
			
			File f=new File("d:/hsbc_file/one.txt");FileOutputStream out=new FileOutputStream(f,true);
			String x =iu.getName();
			for(int j=0;j<iu.getName().length();j++) {
				out.write(iu.getName().charAt(j));}
			out.write('\t');
			String st = iu.getAddress();
			for(int j=0;j<iu.getAddress().length();j++) {
				out.write(iu.getAddress().charAt(i));
			}
			out.write('\t');
			st=iu.getEmail();
			for(int j=0;j<iu.getEmail().length();j++) {
				out.write(iu.getEmail().charAt(j));
			}
			out.write('\t');
			st=iu.getPassword();
			for(int k=0;k<st.length();k++) {
				out.write(st.charAt(k));
			}
			out.write('\n');
			
			out.close();
			File f1=new File("d:/hsbc_file/two.txt");FileOutputStream out1=new FileOutputStream(f1);
			//step4 executeQuery
			//i=ps.executeUpdate();
			System.out.println("viewing all profiles created ");
			FileInputStream in=new FileInputStream(f);		
			int c=0;
			while(!((c=in.read())==-1))//-1 is end of file and c stores aschii of characters
				{
				System.out.write(c);out1.write(c);
			}
			in.close();
			
		}
			
			
			catch(Exception e1)
		{
				e1.printStackTrace();
		}
			return 1;

		}


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
	
	
	
	public List<Instagramuser> Displaycurrentinf(Instagramuser iu) {
		
		Connection con = null;
		List<Instagramuser> ll=new ArrayList<Instagramuser>();
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		 con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("select * from detail where name=? and email=?");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getName());

		ResultSet res=ps.executeQuery();
		
		
		
		while(res.next())//it is F if no data returned 
		{
			Instagramuser uu=new Instagramuser();
			uu.setName(res.getString(1));//1st column
			uu.setAddress(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setPassword(res.getString(4));
			ll.add(uu);
		}
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

		
		return ll;

	}

	
	

	public List<Instagramuser> searchProfileDAO(Instagramuser iu)throws instaexcept {
		
		Connection con=null;
		List<Instagramuser> ll=new ArrayList<Instagramuser>();
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		
		PreparedStatement ps=con.prepareStatement("select * from detail where name=?");
		ps.setString(1, iu.getName());
		

		ResultSet res=ps.executeQuery();
		
		
		
		while(res.next())//it is F if no data returned 
		{
			Instagramuser uu=new Instagramuser();
			uu.setName(res.getString(1));//1st column
			uu.setAddress(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setPassword(res.getString(4));
			ll.add(uu);
		}
		if((ll.size()==0))
		{
			throw new instaexcept("");
		}
		}
		
		catch(ClassNotFoundException|SQLException e1)
		{
			e1.printStackTrace();
		}
		finally {
			
			//con.close();
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return ll;

	}

	public List<Instagramuser> viewallProfileDAO() {
		// TODO Auto-generated method stub
		List<Instagramuser> ll=new ArrayList<Instagramuser>();
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			con=DriverManager.getConnection("jdbc:derby:D:/myfirstdb;create=true","laptop","laptop");
		PreparedStatement ps=con.prepareStatement("select * from detail");
				
		ResultSet res=ps.executeQuery();
		
		
		
		while(res.next()) {
			Instagramuser uu=new Instagramuser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ll;

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

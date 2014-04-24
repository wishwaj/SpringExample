package com.mkyong.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDb {

	public static void main(String[] args) {
		try
		  {
		        
		   Class.forName ("com.ddtek.jdbc.openedge.OpenEdgeDriver");
		   System.out.println("Driver loaded");
		   Connection con = DriverManager.getConnection("jdbc:datadirect:openedge://localhost:20000;databaseName=sports2","sysprogress","sys");
		   System.out.println("Connected");
		   Statement stmt = con.createStatement();
		   System.out.println("Statement created");
		   ResultSet rs = stmt.executeQuery("select Name from pub.Customer");
		   System.out.println("ResultSet : \n");
		   while (rs.next())
		   {
		    System.out.println(rs.getString(1));
		   }
		   rs.close();
		   stmt.close();
		   con.close();
		  }
		  catch (Exception x) {x.printStackTrace();}
		 }

	

}

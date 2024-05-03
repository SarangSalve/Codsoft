package Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student_Management_System {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		char d;
		
		System.out.println(" ***** WELCOME TO STUDENT MANAGEMENT SYSTEM *****");
		
		do {
			
			System.out.println();
			
			System.out.println("Enter 1. add the Student informations\r\n" + 
					"Enter 2. view the list of Student in tabular form\r\n" +  
					"Enter 3. search the Student by their id\r\n" + 
					"Enter 4. delete the Student information.\r\n" + 
					"");
			int num=sc.nextInt();	
			
			switch(num) {
			
			case 1 :
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Management_System", "root", "root");
					
					String sql="insert into info values(?,?,?)";
					
					PreparedStatement ps=con.prepareStatement(sql);
					
					System.out.println("Enter Student Id");
					int id=sc.nextInt();
					System.out.println("Enter Student Name");
					String name=sc.next();
					System.out.println("Enter Student Roll Number");
					int roll_number=sc.nextInt();
					
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setInt(3, roll_number);
					
					ps.executeUpdate();
					
					System.out.println("*****************************************");
					
					System.out.println("Data has been successfully inserted!!!");
					
					System.out.println("*****************************************");
						
				}catch(Exception e) {
					System.out.println(e);
				}break;
			
			case 2 :
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Management_System", "root", "root");
					
					String sql="select * from info";
					
					PreparedStatement ps=con.prepareStatement(sql);
					
					ResultSet rs=ps.executeQuery();
					
	System.out.println("Id\t"+"Name\t"+"Roll Number\t\t\t");
				    
				    while(rs.next()) {
				    	  System.out.println(rs.getInt(1) +"\t"+rs.getString(2) +"\t"+rs.getInt(3)+"\t");
				    }	
					
				} catch (Exception e) {
					System.out.println(e);
					
				}break;	
				
			case 3 : 
				
				try {
					
				Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Management_System", "root", "root");
					
					System.out.println("Enter ID To Search");
					int id=sc.nextInt();
					
					String sql="select * from info where id="+id;
					
					  PreparedStatement ps=con.prepareStatement(sql);
					    
						ps.execute();
						
						  ResultSet rs1 = ps.executeQuery();
						  
						System.out.println("data of id "+id+ " is \n");
						  System.out.println("Id\t"+"Name\t"+"Roll Number\n");
						    
						    while(rs1.next()) {
						    	  System.out.println(rs1.getInt(1) +"\t"+rs1.getString(2) +"\t"+rs1.getInt(3));
						    }			
						
					
					}catch (Exception e) {
						System.out.println(e);
					}break;	
				
			case 4 :
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Management_System", "root", "root");
					
					System.out.println("Enter ID To Delete");
					int id=sc.nextInt();
					
					int status=0;
					
					String sql="Delete from info where id="+id;
					
					PreparedStatement ps=con.prepareStatement(sql);
			
					status=ps.executeUpdate();
					
					System.out.println("*****************************************");
					
					if(status>0) {
					System.out.println("Your data has been Successfully deleted");
					}else {
						System.out.println("Something Went Wronge");
					}
					
					System.out.println("*****************************************");
					
					
				}catch (Exception e) {
					System.out.println(e);
					
				}break;	
				
			default:{
				System.out.println("Entered Wrong Number");
			}
			
			}
			
			System.out.println();
			System.out.println("Press Y or y to Continue");
			d=sc.next().charAt(0);
			
			
			
		}while(d=='Y' || d=='y');

	}

}

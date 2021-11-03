package jdbc;
import java.util.*;
import java.sql.*;
public class muledemo {
 
    public static void main(String[] args){
        try {
        Class.forName("org.sqlite.JDBC");
        Connection con=DriverManager.getConnection("jdbc:sqlite:Movies.db");
        Scanner sc=new Scanner(System.in);
        if(con!=null)
        {
            System.out.println("connection established successfully");
        
        Statement stmt=con.createStatement();
        //int n=stmt.executeUpdate("create table Movies(MovieName varchar(20),Actor varchar(20),Actress varchar(20),Director varchar(20),YearofRelease varchar2(10))");
        //System.out.println("created");
        System.out.println("Enter choice");
        int number=sc.nextInt(); 
        
        switch(number){  
  
        case 1: 
        	PreparedStatement pstmt=con.prepareStatement("INSERT INTO Movies(Moviename,Actor,Actress,Director,yearofRelease) "+"VALUES(?,?,?,?,?)");
        	System.out.println("Enter Movie Name");
        	String name=sc.next();
        	System.out.println("Enter Actor Name");
        	String Actor=sc.next();
        	System.out.println("Enter Actress Name");
        	String Actress=sc.next();
        	System.out.println("Enter Director Name");
        	String Director=sc.next();
        	System.out.println("Enter year of Release");
        	int year=sc.nextInt();
        	pstmt.setString(1,name);
        	pstmt.setString(2,Actor);
        	pstmt.setString(3,Actress);
        	pstmt.setString(4,Director);
        	pstmt.setInt(5,year);
        	pstmt.executeUpdate();
        break;  
        case 2: 
        	PreparedStatement pstmt1=con.prepareStatement("select * from Movies");
        	ResultSet rs=pstmt1.executeQuery();
        	System.out.println("Moviename\tActor\tActress\tDirector\tyearofRelease");
        	System.out.println("__________________________________________________________");
        	  while(rs.next())
        	            {
        	             System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
        	            }
        break;  
        default:System.out.println("Invalid Number");  
        }  
        
        
        }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
}


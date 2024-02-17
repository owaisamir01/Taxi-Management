package taximanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class database {
  
   private Connection con;
   private Statement st;
   private ResultSet rs;
   
   database(){
   
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taximanagment", "root","");
        st=con.createStatement();
           System.out.println("data conct");
       }catch(Exception e){
         System.out.println(e);
       }
   }
       public void registerStudent(String s_name,String s_pasword){
        
      String query="insert into signup(username,pasword)values('"+s_name+"','"+s_pasword+"')";
      System.out.println(query);
       try{
       st.executeUpdate(query);
       
       }catch(Exception e){
        System.out.println(e);
       }
    }

   public ResultSet MatchUser(String user, String pass){
   
        String query="select * from signup where username='"+user+"' and pasword='"+pass+"'";
        try{
        
         rs=st.executeQuery(query);
        
        }catch(Exception e){
        System.out.println(e);
        }
        
        return rs;
   }   
       public int bookingrecord(String name, String pickup,String drop,int price,String taxitype){    
      int a =0;  
      String query="insert into bookingrecord(name,pickuplocation,droplocation,price,taxitype)values('"+name+"','"+pickup+"','"+drop+"','"+price+"','"+taxitype+"')";
  System.out.println(query);
       try{
       a = st.executeUpdate(query);
       
       }catch(Exception e){
        System.out.println(e);
       }
       return a;
    }
     public ResultSet getrecords(){
   
        String query="select * from bookingrecord"; 
        try{
        
         rs=st.executeQuery(query);
        
        }catch(Exception e){
        System.out.println(e);
        }
        
        return rs;
   }
     
 public void contactus(String nam,String emai,String comment,String country){
     String query="insert into contactus(name, email, comments,country) VALUES ('"+nam+"','"+emai+"','"+comment+"','"+country+"')";
     System.out.println(query);
     try{
         st.executeUpdate(query);
         
     }catch(Exception e){
         System.out.println(e);
     }
 }    
  
 public ResultSet getcontactrecord(){
   
        String query="select * from contactus"; 
        try{
        
         rs=st.executeQuery(query);
        
        }catch(Exception e){
        System.out.println(e);
        }
        
        return rs;
   }
     
       
  
  public static void main(String [] args) 
  {
database b=new database();  
  
  
  }
}

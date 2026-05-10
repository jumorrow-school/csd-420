/*
 * Justin Morrow - 05/09/26
 * Modified Select5.java file from the original by Professor Darrell Payne from Bellevue University
 */

/* I added the package name under the src folder */
package morrowmysqlmod92;

import java.sql.*;

public class Select5{

  public static void main(String args[]){

    try{

      Connection con;

      Class.forName("com.mysql.cj.jdbc.Driver");

	/* I changed database33 to databasedb */
      String url = "jdbc:mysql://localhost:3306/databasedb?";

	/* I changed student33 to student1 */
      con = DriverManager.getConnection(url + "user=student1&password=pass");

      System.out.println("Connection established - now executing a select");

	/* I changed address33 to address */
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM address");

     System.out.println("Received Results:");

     int i = rs.getMetaData().getColumnCount();

     while(rs.next()){

       for(int x = 1; x <= i; ++x){

         System.out.println(rs.getString(x));
       }

       System.out.println("");
     }

     stmt.close();
     con.close();
    }
    catch (java.lang.Exception ex){

      ex.printStackTrace();
    }
  }
}
 /*
 * Justin Morrow - 05/09/26
 * Modified CreateTable.java file from the original by Professor Darrell Payne from Bellevue University
 */

/* I added the package name under the src folder */
package morrowmysqlmod92;
 
import java.net.URL;
import java.sql.*;

public class CreateTable{

  Connection con;

  Statement stmt;

  public CreateTable(){

    try{

      Class.forName("com.mysql.cj.jdbc.Driver");

	/* I changed database33 to databasedb */
      String url = "jdbc:mysql://localhost:3306/databasedb?";

	/* I changed student33 to student1 */
      con = DriverManager.getConnection(url + "user=student1&password=pass");

      stmt = con.createStatement();
    }
    catch(Exception e){

      System.out.println("Error connection to database.");
      System.exit(0);
	  e.printStackTrace();
    }

    try{

	/* I changed address33 to address */
      stmt.executeUpdate("DROP TABLE address");
      System.out.println("Table address Dropped");
    }
    catch(SQLException e){

      System.out.println("Table address does not exist");
    }

    try{

	/* I changed address33 to address */
      stmt.executeUpdate("CREATE TABLE address(ID int PRIMARY KEY,LASTNAME varchar(40)," +
                         "FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40)," +
                         "ZIP varchar(40))");
      System.out.println("Table address Created");
    }
    catch(SQLException e){

      System.out.println("Table address Creation failed");
    }

    try{

      stmt.close();

      con.close();
      System.out.println("Database connections closed");
    }
    catch(SQLException e){

      System.out.println("Connection close failed");
    }
  }

  public static void main(String args[]) {

    CreateTable createTable = new CreateTable();
  }
}
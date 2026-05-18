 /*
  * Justin Morrow - 05/17/26
  * Modified SelectData.java file from the original by Professor Darrell Payne from Bellevue University
  * Modified to work with the "fans" table in databasedb
  * Handles DB connectivity and navigation buttons for (first, next, previous, last) using a scrollable ResultSet
  */


 import java.sql.*;

 public class SelectFansData {

     Connection con;
     Statement stmt;
     ResultSet resultSet;

     public SelectFansData() {

         try {

             Class.forName("com.mysql.cj.jdbc.Driver");

             String url = "jdbc:mysql://localhost:3306/databasedb?";

             con = DriverManager.getConnection(url + "user=student1&password=pass");

             stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

             resultSet = stmt.executeQuery("SELECT * FROM fans ORDER BY id");

         } catch (Exception e) {

             System.out.println("Error connection to database.");
             System.exit(0);
         }

         try {

             resultSet = stmt.executeQuery("SELECT * FROM fans ORDER BY id");

         }
         catch (SQLException e) {

             System.out.println(e);
             System.out.println("Result Request Failed");
         }
     }

     public FanRecord getFirst() {

         FanRecord fanrecord = new FanRecord();

         try {
             resultSet.first();

             fanrecord.setId(resultSet.getString("id"));
             fanrecord.setFirstName(resultSet.getString("firstName"));
             fanrecord.setLastName(resultSet.getString("lastName"));
             fanrecord.setFavoriteTeam(resultSet.getString("favoriteTeam"));

         } catch (Exception e) {
             System.out.println(e);
         }

         return fanrecord;
     }

     public FanRecord getNext() {

         FanRecord fanrecord = new FanRecord();

         try {
             if (!resultSet.next()) {
                 return getFirst();
             }

             fanrecord.setId(resultSet.getString("id"));
             fanrecord.setFirstName(resultSet.getString("firstName"));
             fanrecord.setLastName(resultSet.getString("lastName"));
             fanrecord.setFavoriteTeam(resultSet.getString("favoriteTeam"));

         } catch (Exception e) {
             System.out.println(e);
         }

         return fanrecord;
     }

     public FanRecord getPrevious() {

         FanRecord fanrecord = new FanRecord();

         try {
             if (!resultSet.previous()) {
                 return getLast();
             }

             fanrecord.setId(resultSet.getString("id"));
             fanrecord.setFirstName(resultSet.getString("firstName"));
             fanrecord.setLastName(resultSet.getString("lastName"));
             fanrecord.setFavoriteTeam(resultSet.getString("favoriteTeam"));

         } catch (Exception e) {
             System.out.println(e);
         }

         return fanrecord;
     }

     public FanRecord getLast() {

         FanRecord fanrecord = new FanRecord();

         try {
             resultSet.last();

             fanrecord.setId(resultSet.getString("id"));
             fanrecord.setFirstName(resultSet.getString("firstName"));
             fanrecord.setLastName(resultSet.getString("lastName"));
             fanrecord.setFavoriteTeam(resultSet.getString("favoriteTeam"));

         } catch (Exception e) {

             System.out.println(e);
         }

         return fanrecord;
     }

     public void close() {

         try {
             stmt.close();
             con.close();
         } catch (SQLException e) {
             System.out.println("Connection close failed");
         }
     }

     public static void main(String args[]) {

         SelectFansData selectFansData = new SelectFansData();

         System.out.println(selectFansData.getFirst());
         System.out.println(selectFansData.getLast());

         selectFansData.close();
     }
 }
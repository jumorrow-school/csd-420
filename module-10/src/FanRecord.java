 /*
  * Justin Morrow - 05/17/26
  * Modified MyRecord.java file from the original by Professor Darrell Payne from Bellevue University
  * Modified to work with the "fans" table in databasedb
  * Stores a single record of sport fans data including id, first name, last name, and favorite team
  */


public class FanRecord {

    String id;
    String firstName;
    String lastName;
    String favoriteTeam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = new String(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = new String(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = new String(lastName);
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = new String(favoriteTeam);
    }

    public String toString() {

        return new String(
                id.toString().trim() + ", " +
                        firstName.toString().trim() + ", " +
                        lastName.toString().trim() + ", " +
                        favoriteTeam.toString().trim()
        );
    }
}
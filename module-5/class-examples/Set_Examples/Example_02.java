/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 * A Set contains no duplicate elements
 *   No duplicate example with Strings
 */
public class Example_02{

  public static void main(String [] args){

    java.util.Set <String> stringSet = new java.util.HashSet <>();

    stringSet.add("Red Sox");
    stringSet.add("Pirates");
    stringSet.add("White Sox");
    stringSet.add("Cubs");
    stringSet.add("Tigers");
    stringSet.add("Athletics");
    stringSet.add("Giants");
    stringSet.add("Phillies");
    stringSet.add("Reds");
    stringSet.add("Yankees");
    stringSet.add("Cardinals");

    stringSet.forEach(e -> System.out.print(e.toUpperCase() + ", "));
    System.out.println();
    System.out.println(stringSet.size());

    System.out.println();

    stringSet.add("Red Sox");
    stringSet.add("Pirates");
    stringSet.add("White Sox");
    stringSet.add("Cubs");
    stringSet.add("Tigers");
    stringSet.add("Braves");
    stringSet.add("Athletics");
    stringSet.add("Giants");
    stringSet.add("Phillies");
    stringSet.add("Reds");
    stringSet.add("Yankees");
    stringSet.add("Cardinals");

    stringSet.forEach(e -> System.out.print(e.toUpperCase() + ", "));
    System.out.println();
    System.out.println(stringSet.size());
  }
}
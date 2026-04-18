/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 * TreeSet
 *
 * TreeSet uses the interface of Set
 * TreeSet implements the SortedSet Interface
 *
 * Provides methods such as:
 *   first(), last(), higher(), lower(), floor(), ceiling() ect.

 */
public class Example_05{

  public static void main(String [] args){

    java.util.Set <String> stringSet = new java.util.LinkedHashSet <>();
    java.util.TreeSet <String> treeStringSet;

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

    treeStringSet = new java.util.TreeSet<>(stringSet);

    System.out.println(treeStringSet.size());

    // Returns the first and last elements in the Set
    System.out.println(treeStringSet.first());
    System.out.println(treeStringSet.last());

    System.out.println();

    // Returns elements before Tigers
    System.out.println("headSet: " + treeStringSet.headSet("Tigers"));
    // Returns elements after Cubs, including Cubs
    System.out.println("tailSet: " + treeStringSet.tailSet("Cubs"));

    System.out.println();

    // Return largest element less than C
    System.out.println("treeSet.lower(C): " + treeStringSet.lower("C"));
    // Returns the smallest elements greater than C
    System.out.println("tailSet.higher(C): " + treeStringSet.higher("C"));

    System.out.println();
  }
}
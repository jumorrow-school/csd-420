/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 * LinkedHashSet extends HashSet
 *
 * Supports ordering of the elements
 *
 * LinkedHashSet can be retrieved in the order in which they
 *  were inserted in to the Set
 *
 * LinkedHashSet can be created using one of LinkedHashSet's four constructors.
 */
public class Example_04{

  public static void main(String [] args){

    java.util.Set <String> stringSet = new java.util.LinkedHashSet <>();

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

    System.out.println(stringSet);
    
    System.out.println();

    for(String element : stringSet){

      System.out.print(element.toLowerCase() + " - ");
      System.out.println(element.toUpperCase() + ", ");
    }

    System.out.println();
  }
}
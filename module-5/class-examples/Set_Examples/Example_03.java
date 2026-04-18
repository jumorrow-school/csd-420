/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 * Using an Iterator
 */
public class Example_03{

  public static void main(String [] args){

    java.util.Set <String> stringSet = new java.util.HashSet <>();
    java.util.Iterator<String> iterator;

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

    iterator = stringSet.iterator();

    while(iterator.hasNext()){

      System.out.print(iterator.next().toUpperCase() + ", ");
    }
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

    iterator = stringSet.iterator();

    while(iterator.hasNext()){

      System.out.print(iterator.next().toUpperCase() + ", ");
    }
    System.out.println(stringSet.size());

    System.out.println();
  }
}
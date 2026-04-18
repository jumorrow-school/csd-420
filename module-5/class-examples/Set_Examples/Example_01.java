/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 * A Set contains no duplicate elements
 * A Set can be a 
 *   HashSet, LinkedHashSet, or a TreeSet
 *
 * HashSet is a concrete class of Set
 *   just as an ArrayList and LinkedList are a 
 *   concrete class of List
 *
 * No duplicate and duplicate example with Integers
 */
public class Example_01{

  public static void main(String [] args){

    java.util.List <Integer> list = new java.util.LinkedList <>();
    java.util.Set <Integer> set = new java.util.HashSet <>();

    for(int i = 0; i < 10; i++){

      list.add(new Integer(i + 1));
      set.add(new Integer(i + 1));
    }

    System.out.println("Set Size = " + set.size());
    System.out.println("List Size = " + list.size() + "\n");

    for(int i = 0; i < 10; i++){

      list.add(new Integer(i + 1));
      set.add(new Integer(i + 1));
    }

    System.out.println("Set Size = " + set.size());
    System.out.println("List Size = " + list.size() + "\n");

    for(int i = 0; i < 10; i++){

      list.add(new Integer(i + 1));
      set.add(new Integer(i + 1));
    }

    System.out.println("Set Size = " + set.size());
    System.out.println("List Size = " + list.size() + "\n");

    System.out.println();
  }
}
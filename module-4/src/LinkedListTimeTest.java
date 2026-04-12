/*
 * Justin Morrow | Date: 04/12/26
 * CSD-420 Module 4.2: Compare processing time for LinkedList traversal using Iterator and get(index)
 *
 * Online Resource:
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
 * https://docs.oracle.com/javase/tutorial/collections/implementations/list.html
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 *
 * Reading Assignment: (Chapter 20 from Introduction to Java: Programming and Data Structures)
 * 20.3 To use the Iterator interface to traverse the elements in a collection
 * 20.6 To explore how and when to use ArrayList or LinkedList to store a list of elements
 *
 * Professors Example Files:
 * Example_11–14.java: Simple loops and basic ArrayList for traversing a collection
 * Example_13.java: Use Iterator to traverse a collection (Efficient for LinkedList)
 * Example_15.java: Basic comparison of ArrayList vs LinkedList behavior
 */


import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTimeTest {

    public static void main(String[] args) {

        // Run the 1st test with 50,000 elements
        integerListSize(50000);

        // Run the 2nd test with 500,000 elements
        integerListSize(500000);

        // Calls the final summary notes that print to the screen after both tests have completed running
        finalSummary();
    }

    // Create the method that builds a LinkedList and compares the traversal times for each test
    public static void integerListSize(int intCount) {

        // Displays which of the tests is running (50,000 or 500,000)
        System.out.println("\nRunning LinkedList test with " + intCount + " total elements");

        // Add a separator line for a cleaner output on the screen
        System.out.println("--------------------------------------------------");

        // Create the LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Add each number to the list
        for (int i = 0; i < intCount; i++) {
            list.add(i);
        }

        // Get the start time for the Iterator traversal
        long startIterator = System.currentTimeMillis();

        // Create the Iterator
        Iterator<Integer> iterator = list.iterator();

        // Traverse using Iterator which moves through each element
        while (iterator.hasNext()) {
            iterator.next();
        }

        // Get the end time after the Iterator traversal completes
        long endIterator = System.currentTimeMillis();

        // Calculate the total time
        long iteratorTime = (endIterator - startIterator);

        // Print the Iterator results
        System.out.println("Time using Iterator traversal: " + iteratorTime + " ms");

        // Get the start time for the get(index) method
        long startGet = System.currentTimeMillis();

        // Traverse the list using get(index) which accesses the element by its index
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        // Get the end time after the get(index) traversal completes
        long endGet = System.currentTimeMillis();

        // Calculate the total time
        long getTime = (endGet - startGet);

        // Print the get(index) results
        System.out.println("Time using get(index) traversal: " + getTime + " ms");

        // Print the difference between both methods
        System.out.println("Difference between both methods: " + (getTime - iteratorTime) + " ms");

    }

    // Final summary print statements
    public static void finalSummary() {

        System.out.println("\nSummary of the Results:");
        System.out.println("--------------------------------------------------");
        System.out.println("The Iterator method moves through the list one element at a time without restarting.");
        System.out.println("The get(index) method takes more time because each lookup requires starting over.");
        System.out.println("Performance decreased significantly as the list size grew from 50,000 to 500,000.");
        System.out.println("These tests show that both methods work, but they do not scale the same as the list grows.");
        System.out.println("Conclusion: A LinkedList performs better with sequential access rather than index-based access.");
    }
}
/*
 * Justin Morrow | Date: 04/25/26
 * CSD-420 Module 6.2: Using bubble sort, sort the elements using Comparable interface and then Comparator interface.
 *
 * Reading Assignment: (Chapter 24 from Introduction to Java: Programming and Data Structures)
 * Used for Implementing Lists, Stacks, Queues, and Priority Queues
 *
 * Example Files for Reference:
 * Bubble_Sort.java used as an example for bubble sort from this weeks assignment
 * RemoveArrayListDuplicates.java from Module 3.2 (Create ArrayList with random numbers) instead of using fixed numbers
 *
 * Online Reference:
 * Cloning of Array used to pass my random numbered elements to preserve the unsorted values for both elements:
 * https://www.geeksforgeeks.org/java/arrays-copyof-in-java-with-examples/
 * Comparator comp.compare(a, b) for comparison sorting:
 * https://stackoverflow.com/questions/22134406/how-to-correctly-initialize-a-comparator
 * Used for generics and methods to see proper syntax and structure:
 * https://www.geeksforgeeks.org/java/java-cheat-sheet/
 */


import java.util.Arrays;
import java.util.Comparator;


public class mod62BubbleSort {
    public static void main(String[] args) {

        // Create an array with an integer size of 10 elements
        Integer[] testValues = new Integer[10];

        // Fill the array with random numbers between 1 and 50 (adapted from Module 3.2)
        for (int i = 0; i < testValues.length; i++) {
            testValues[i] = (int)(Math.random() * 50) + 1;
        }

        // Clone the initial array list to use for the Comparable interface (Bubble Ascending Sort)
        Integer[] arrayComparable = Arrays.copyOf(testValues, testValues.length);

        // Clone of initial array list to use for the Comparator interface (Bubble Descending Sort)
        Integer[] arrayComparator = Arrays.copyOf(testValues, testValues.length);

        // Print the original array list values (Unsorted)
        System.out.println("\nUnsorted Array List with 10 random numbers between 1 and 50:");
        printArray(testValues);

        // Sort the Array in ascending order using Comparable
        bubbleSortComparable(arrayComparable);

        // Display the results of the Comparable Ascending Bubble Sort
        System.out.println("\n\nAscending Comparable Bubble Sort of the Array List:");
        printArray(arrayComparable);

        // Sort the Array in descending order using Comparator
        bubbleSortComparator(arrayComparator, Comparator.reverseOrder());

        // Display the results of the Comparator Descending Bubble Sort
        System.out.println("\n\nDescending Comparator Bubble Sort of the Array List:");
        printArray(arrayComparator);
    }


    // Generic method used to Bubble Sort the Array using the Comparable interface (Ascending)
    public static <E extends Comparable<E>> void bubbleSortComparable(E[] testValues) {

        // temp is used for swapping. Used generic type E since int can't be used with generics
        E temp;

        // i starting at 0
        for (int i = 0; i < testValues.length - 1; ++i) {

            // j starting at 0
            for (int j = 0; j < testValues.length - 1; ++j) {

                // if testValues[0] > testValues[1] then swap
                if (testValues[j].compareTo(testValues[j + 1]) > 0) {

                    // temp = testValues[0];
                    temp = testValues[j];

                    // testValues[0] = testValues[1]
                    testValues[j] = testValues[j + 1];

                    // testValues[1] = temp or testValues[0]
                    testValues[j + 1] = temp;
                }
            }
        }
    }

    // Generic method used to Bubble Sort the Array using the Comparator interface (Descending)
    public static <E> void bubbleSortComparator(E[] testValues, Comparator<E> comp) {

        // temp is used for swapping. Used generic type E since int can't be used with generics
        E temp;

        // i starting at 0
        for (int i = 0; i < testValues.length - 1; ++i) {

            // j starting at 0
            for (int j = 0; j < testValues.length - 1; ++j) {

                // compare using comparator passed to method (comp.compare) - StackOverflow Reference.
                if (comp.compare(testValues[j], testValues[j + 1]) > 0) {

                    // stores the current element in temp before swapping
                    temp = testValues[j];

                    // testValues[0] = testValues[1]
                    testValues[j] = testValues[j + 1];

                    // testValues[1] = temp or testValues[0]
                    testValues[j + 1] = temp;
                }
            }
        }
    }


    // Prints the array. Integer is used instead of int because arrays use wrapper types
    public static void printArray(Integer [] arrayParam) {
        for (Integer e : arrayParam) {
            System.out.print(" [" + e + "] ");
        }
    }
}

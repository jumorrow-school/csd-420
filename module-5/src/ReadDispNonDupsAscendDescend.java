/*
 * Justin Morrow | Date: 04/17/26
 * CSD-420 Module 5.2: Read words from a file, remove duplicates, and display in ascending and descending order
 *
 * Reading Assignment: (Chapters 21 and 23 from Introduction to Java: Programming and Data Structures)
 * Used for storing nonduplicates, HashSet, LinkedHashSet and TreeSet and sorting
 *
 * Example Files:
 * Example_01–05.java: Set behavior and TreeSet sorting (From Professors Examples)
 * TestMap.java: Structured output and collection usage (From Chapter 21.5)
 */


import java.util.*;
import java.io.*;

public class ReadDispNonDupsAscendDescend {

    public static void main(String[] args) {

        // Create an empty TreeSet that automatically sorts elements and removes duplicates as they are added
        TreeSet<String> foodList = new TreeSet<>();

        // File name I created with the 20 food items which includes duplicates
        String fileName = "collection_of_words.txt";

        // Counter for total words read from file (including duplicates) starting at 0 and increments after each word
        int originalWordCount = 0;

        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println("Contents of the file: collection_of_words.txt:");

        try {
            // Create a File object to reference the text file and a Scanner object to read its contents
            File textFile = new File(fileName);
            Scanner input = new Scanner(textFile);

            // Read each word in file, print the original list, then add each word ignoring duplicates to the TreeSet
            while (input.hasNext()) {
                String word = input.next();
                System.out.print(word + ", ");

                originalWordCount = originalWordCount + 1;
                foodList.add(word);
            }

            // Close the while loop of adding each word from the file to the TreeSet
            input.close();

        // Catch file not found error if the text file isn't found in the module-5 directory
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        // Print the File: collection_of_words.txt word count
        System.out.println("\n\nWord count: " + originalWordCount);
        System.out.println("-----------------------------------------------------------------------------------");

        // Display the TreeSet ascending order with no duplicates
        System.out.println("TreeSet (Default: Ascending Order and No Duplicates):");
        System.out.println(foodList + "\n");

        // Display the TreeSet in descending order with no duplicates
        System.out.println("TreeSet (Descending Order with No Duplicates):");
        System.out.println(foodList.descendingSet());

        // Print the TreeSet word count which removes duplicates automatically
        System.out.println("\nWord count: " + foodList.size());
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
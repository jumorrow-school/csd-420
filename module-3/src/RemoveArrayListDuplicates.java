/*
 * Justin Morrow | Date: 04/11/26
 * CSD-420 Module 3.2: Create an ArrayList with 50 random numbers 1-20, then copy to new ArrayList and remove duplicates
 *
 * Online Resource:
 * https://stackoverflow.com/questions/29398049/removing-duplicates-in-an-arraylist-using-generics
 *
 * Professors Example Files:
 * GenericStack.java & MyStack.java: ArrayList<E> and Looping
 * Example_13.java: Generic method <E>
 */


import java.util.ArrayList;

public class RemoveArrayListDuplicates {

    public static void main(String[] args) {

        // Create the Original Integer ArrayList
        ArrayList<Integer> originalList = new ArrayList<>();

        // Fill the Original Integer ArrayList with 50 random values between 1 and 20
        for (int i = 0; i < 50; i++) {
            originalList.add((int)(Math.random() * 20) + 1);
        }

        // Print to Screen the Original Integer ArrayList
        System.out.println("\nOriginal List with 50 Random Numbers:");
        printList(originalList);

        // New Integer ArrayList called duplicatesRemoved by calling the removeDuplicates method on OriginalList
        ArrayList<Integer> duplicatesRemoved = removeDuplicates(originalList);

        // Print to Screen the DuplicatesRemoved ArrayList
        System.out.println("\nNew List After Removing the Duplicates from the Original List:");
        printList(duplicatesRemoved);
    }


    // Generic method to remove duplicates from an ArrayList from Example_13 and StackOverFlow Resource
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        // Create a New ArrayList to store the unique numbers from the OriginalList
        ArrayList<E> uniqueResult = new ArrayList<>();

        // Loop through each number in the OriginalList
        for (int i = 0; i < list.size(); i++) {

            // Get the element/item at the current index (Generic type E: Integer, Double, String)
            E element = list.get(i);

            // Only add the element/item if it is not already in the uniqueResult list
            if (!uniqueResult.contains(element)) {
                uniqueResult.add(element);
            }
        }

        // Return the new ArrayList containing only unique elements/items (which in this case are unique numbers)
        return uniqueResult;
    }

    // Helper method to print ArrayList from Example_13
    public static <E> void printList(ArrayList<E> list) {

        // Loop through each element/item in the ArrayList (which in this case are integers/numbers)
        for (int i = 0; i < list.size(); i++) {

            // Adding a comma and space after each number for better printing to screen
            System.out.print(list.get(i) + ", ");
        }

        // Print a blank row between the Original List output and New List
        System.out.println();
    }
}
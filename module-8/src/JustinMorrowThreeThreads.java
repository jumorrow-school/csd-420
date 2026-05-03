/*
 * Justin Morrow | Date: 05/02/26
 * CSD-420 Module 8.2: JavaFX using Three Threads displaying 10,000 random characters in a GUI text area
 *
 * Class Material Resources:
 * Reading: Ch.32 referenced in the instructions but the digital book ends at Ch.30
 *
 * Files:
 *  - Example_03: Thread.sleep() used better control the execution time to prevent freezing/crashing issues
 *  - Example_12 & Example_13: use of Runnable, creating multiple threads, use of start() to start the threads
 *  - StartApplication.java used for reference
 *
 * Online Reference (Multithreading concepts and examples):
 * https://www.geeksforgeeks.org/java/java-multithreading-tutorial/
 * https://stackoverflow.com/questions/58948047/in-java-how-do-i-use-multithreading-in-textarea-do-i-need-to-synchronize-my-th
 */

// imports to support GUI elements like JFrame, JTextArea, JScrollPane and the BorderLayout
import javax.swing.*;
import java.awt.*;

/*
 * Main class to launch the GUI application
 */
public class JustinMorrowThreeThreads {

  public static void main(String[] args) {

    // Create the GUI window and title displayed at the top
    JFrame frame = new JFrame("3 interleaved threads Letters/Numbers/Symbols: Total=30k");

    // Create a JTextArea to display the character output from each thread
    JTextArea textArea = new JTextArea();

    // Enable line wrapping for a better output display
    textArea.setLineWrap(true);

    // Add the text area to a scroll pane due to the output being 30,000 characters
    JScrollPane scrollPane = new JScrollPane(textArea);

    // Add the scroll pane to the frame
    frame.add(scrollPane, BorderLayout.CENTER);

    // Set window size (width:500 and height:500)
    frame.setSize(500, 500);

    // Close operation for when the user clicks the X to close the GUI window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Display the window
    frame.setVisible(true);

    // Create the Runnable objects for each thread type (Letters, Numbers and Symbols)
    Runnable letters = new CharacterGenerator(textArea, "letters");
    Runnable numbers = new CharacterGenerator(textArea, "numbers");
    Runnable symbols = new CharacterGenerator(textArea, "symbols");

    // Create each of the 3 threads (Letters, Numbers and Symbols)
    Thread thread1 = new Thread(letters);
    Thread thread2 = new Thread(numbers);
    Thread thread3 = new Thread(symbols);

    // Start each of the 3 threads (Letters, Numbers and Symbols)
    thread1.start();
    thread2.start();
    thread3.start();
  }
}


// Runnable class used to generate the characters
class CharacterGenerator implements Runnable {

  private JTextArea textArea;
  private String type;

  // Constructor used to pass in shared JTextArea and define the characters for the thread (letters, numbers or symbols)
  public CharacterGenerator(JTextArea textArea, String type) {
    this.textArea = textArea;
    this.type = type;
  }


  // Method executed by each thread
  @Override
  public void run() {

    // Loop to generate 10,000 characters
    for (int i = 0; i < 10000; i++) {

      char outputChar = ' ';

      // Generate the random letters (a–z)
      if (type.equals("letters")) {
        outputChar = (char) ('a' + (int)(Math.random() * 26));
      }

      // Generate the random numbers (0–9)
      else if (type.equals("numbers")) {
        outputChar = (char) ('0' + (int)(Math.random() * 10));
      }

      // Generate the random symbols limited to (!, @, #, $, %, &, *)
      else if (type.equals("symbols")) {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        outputChar = symbols[(int)(Math.random() * symbols.length)];
      }

      // Continuously Add/Append characters to the GUI text area
      textArea.append(String.valueOf(outputChar));

      // Small time delay to allow the threads to better interleave the output
      try {
        Thread.sleep(1);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Print to the CLI/Run window when each thread completes running its 10,000 random output for each type
    System.out.println("\t\tThread " + type + " has now completed generating 10,000 characters");
  }
}
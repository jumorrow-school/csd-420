/*
 * Justin Morrow | Date: 04/04/26
 * CSD-420 Module 2.2: Read and display the contents of the justin-datafile.dat created by random-value-writer.java
 *
 * Professors Example Files:
 * RandomFile_01.java: Read all data in the file using a while loop with getFilePointer & length
 * RandomFile_02.java: Read double values from the file
 * RandomFile_03.java: File handling for opening/closing files & sequential reading for each appended run & IO Exceptions
 */


import java.io.*;

public class RandomValueReader {

  public static void main(String[] args) {

    try {

      // Open file for reading. Seen in RandomFile_01.java & RandomFile_02.java
      RandomAccessFile randomAccessFile = new RandomAccessFile("justin-datafile.dat", "r");

      // Move pointer to the beginning. Seen in RandomFile_01.java
      randomAccessFile.seek(0);

      System.out.println("Reading all the data from the file justin-datafile.dat:\n");

      // Reads all appended batches of 5 random entries. Seen in RandomFile_01.java
      while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {

        System.out.println("5 Random Integers:");

        // Reads the 5 integers
        for (int i = 0; i < 5; i++) {
          System.out.println(randomAccessFile.readInt());
        }

        System.out.println("5 Random Doubles:");

        // Reads the 5 doubles
        for (int i = 0; i < 5; i++) {
          System.out.println(randomAccessFile.readDouble());
        }

        System.out.println("-----------------------------------");
      }

      // Close file and handle I/O Exceptions. Seen in RandomFile_03.java
      randomAccessFile.close();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
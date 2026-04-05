/*
 * Justin Morrow | Date: 04/04/26
 * CSD-420 Module 2.2: Write 5 random integers and 5 radom double values to a file called justin-datafile.dat
 *
 * Professors Example Files:
 * RandomFile_01.java: Reading/Writing integers to a file using RandomAccessFile & positioning the file pointer with seek 
 * RandomFile_02.java: Writing double values to a file using RandomAccessFile 
 * RandomFile_03.java: File handling for opening/closing files & sequential reading for each appended run & IO Exceptions
 */


import java.io.*;

public class RandomValueWriter {

  public static void main(String[] args) {

    try {

      // Create the random access file, "rw" = read/write, If file does not exist it will be created
      RandomAccessFile randomAccessFile = new RandomAccessFile("justin-datafile.dat", "rw");

      // Move the file pointer to end for appending the data. Seen in RandomFile_01.java & RandomFile_02.java
      randomAccessFile.seek(randomAccessFile.length());

      // Create the integer/double arrays.
      int[] integerArray = new int[5];
      double[] doubleArray = new double[5];

      // Fill the integer/double arrays with random values. Seen in RandomFile_01.java & RandomFile_02.java
      for (int i = 0; i < 5; i++) {
        integerArray[i] = (int)(Math.random() * 100);
        doubleArray[i] = Math.random() * 100;
      }

      // Write the 5 random integers to the file justin-datafile.dat. Seen in RandomFile_01.java
      for (int i = 0; i < 5; i++) {
        randomAccessFile.writeInt(integerArray[i]);
      }

      // Write the 5 random doubles to the file justin-datafile.dat. Seen in RandomFile_02.java
      for (int i = 0; i < 5; i++) {
        randomAccessFile.writeDouble(doubleArray[i]);
      }

      System.out.println("Data appended to file justin-datafile.dat.\n");

      // Close file and handle I/O Exceptions. Seen in RandomFile_03.java
      randomAccessFile.close();

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Recursively finds the nth fibonacci number.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-04-23
 */

// Fibonacci class
public final class Fibonacci {

  /** Private constructor to prevent instantiation. */
  private Fibonacci() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    // Creates the input and output file paths.
    final File inputPath = new File("input.txt");
    final File outputPath = new File("output.txt");

    try {
      // Creates scanner and writer.
      Scanner sc = new Scanner(inputPath);
      FileWriter fileWriter = new FileWriter(outputPath);
      BufferedWriter writer = new BufferedWriter(fileWriter);
      while (sc.hasNextLine()) {
        // Tries to cast the input to an int and pass it to RecFib.
        try {
          // Gets the integer value of the line.
          int input = Integer.parseInt(sc.nextLine());
          // Writes the fibonacci number to the output file.
          writer.write(String.valueOf(RecFib(input)));
          // Creates a new line in the output file.
          writer.newLine();
          // If there wasn't an integer to be read from the input file.
        } catch (Exception e) {
          writer.write("Must enter an integer!");
        }
      }
      sc.close();
      writer.close();
      // Error thrown if an invalid file path was defined.
    } catch (Exception e) {
      System.out.println("Invalid path(s)!");
    }
  }

  /**
   * Method to recursively find the nth fibonacci number
   *
   * @param n passed.
   * @return 0.
   * @return 1.
   * @return RecFib(n-1) + RecFib(n-2).
   */
  private static int RecFib(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return RecFib(n - 1) + RecFib(n - 2);
    }
  }
}

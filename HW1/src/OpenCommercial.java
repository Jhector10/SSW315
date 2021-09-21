/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    URL url = new URL("https://www." + inputLine + ".com"); 
    // Constructor used to create a URL
    InputStream open = url.openStream(); 
    // Opens a connection to this URL and returns an InputStream for reading from that connection
    InputStreamReader read = new InputStreamReader(open);
    // Decodes the url to characters
    BufferedReader buff = new BufferedReader(read);
    
    String[] arr = new String[5]; // create an Array of 5 elements to hold the lines
    
    for(int j = 0; j < 5; j++) { // add the website lines into the array
    	arr[j] = buff.readLine();
    }
    
    for(int i = 4; i >= 0; i--) { // print out the array (with the lines) in reverse order
    	System.out.println(arr[i]);
    }
    
  }
}

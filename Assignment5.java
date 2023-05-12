// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The Assignment 5 class displays a menu of choices
//               (add summer camp, search summer camp title,
//               list summer camps, quit, display menu) to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.io.IOException;

public class Assignment5
{
  public static void main (String[] args)
  {
     char input1;
     String inputInfo = new String();
     String line = new String();
     boolean operation;

     // ArrayList object is used to store SummerCamp objects
     ArrayList<SummerCamp> summerCampList = new ArrayList<SummerCamp>();

     try {
         printMenu();     // print out menu

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do {
           System.out.println("What action would you like to perform?");
           line = stdin.readLine().trim();
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);
           SummerCamp camp = null;

           if (line.length() == 1)
           {
             switch (input1)
             {
               case 'A':   //Add SummerCamp
                 System.out.print("Please enter some summer camp information to add:\n");
                 inputInfo = stdin.readLine().trim();
                 SummerCampParser scp = new SummerCampParser();
                 camp = scp.parseStringToSummerCamp(inputInfo);
                 summerCampList.add(camp);//adds each camp object to the array list
                 break;

               case 'C': //calculate total cost
                  double total = 0;
                  for (int i = 0; i < summerCampList.size(); i++) {
                    camp = summerCampList.get(i);
                    camp.computeTotalCosts();//calls upon the computeTotalCosts method from the different classes
                  }
                  System.out.print("total costs computed\n");
                  break;

               case 'D':   //Search for SummerCamp
                 System.out.print("Please enter a summer camp title to search:\n");
                 inputInfo = stdin.readLine().trim();
                 operation = false;
                 for (int i = 0; i < summerCampList.size(); i++) {
                   String k = summerCampList.get(i).getCampTitle();
                   if (k.equals(inputInfo) || k.equals(inputInfo) || k.equals(inputInfo)) {//condition to see if the camp name has been entered into the list
                     operation = true;
                   }
                 }
                  if (operation == true) {
                   System.out.print("SummerCamp found\n");
                 } else {
                   System.out.print("SummerCamp not found\n");
                 }
                 break;

               case 'L': //list all camps entered
                  for (int i = 0; i < summerCampList.size(); i++) {
                    camp = summerCampList.get(i);
                    System.out.print(camp.toString());//calls upon the toString method from the other classes to display all the necessary information
                  }
                  if (summerCampList.isEmpty()) {
                    System.out.print("no summer camp\n");//if the list is empty
                  }
                 break;

               case 'Q':   //Quit
                 break;
                 
               case '?':   //Display Menu
                 printMenu();
                 break;

               default:
                 System.out.print("Unknown action\n");
                 break;
             }

           } else {
             System.out.print("Unknown action\n");
           }
         } while (input1 != 'Q'); // stop the loop when Q is read

     }
     catch (IOException exception) {
        System.out.println("IO Exception");
     }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
  {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd SummerCamp\n" +
                      "C\t\tCompute Total Costs\n" +
                      "D\t\tSearch for SummerCamp\n" +
                      "L\t\tList SummerCamps\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
   }
}

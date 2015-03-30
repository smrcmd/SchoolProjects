/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaverage;

import java.util.Scanner;

/**
 *
 * @author Sophie
 */
public class MyAverage 
{

public static void main(String args[])
    {
         int num = 0, count = 0, total = 0;
         Scanner in = new Scanner(System.in);
         
         while (num != -99)
            { 
              System.out.print("Enter a whole number, and -99 to quit: ");
              num = in.nextInt(); // accept input
              if (num != -99)
              {
                count++; // increment counter 
                total += num; //accumulate the sum 
              }
            }
         float average = (float) total/count;
         System.out.println("You keyed in " + new Integer(count) + " numbers \n");
         System.out.println("The average  is: " + new Float(average));
    }
}


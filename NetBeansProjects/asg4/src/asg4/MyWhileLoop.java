/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg4;
import java.util.Scanner;
/**
 *
 * @author Sophie
 */
public class MyWhileLoop 
{
   
    public static void main(String args[])
    {
        MyWhileLoop mwl = new MyWhileLoop(); // calling default constructor on itself
        float tempavg = mwl.myAverage(); //passes control to the whileLoop method
        char lettergrade = mwl.getlettergrade(tempavg);
        System.out.println("Your average is: " + tempavg);
        System.out.println("Your letter grade: " + lettergrade);
    }
    
    float myAverage() 
    {
        int  num, count = 0, total = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a whole number, and -99 to quit: ");
        num = in.nextInt(); // accept input

        while (num != -99) 
        { // test the condition
            count++; // increment counter 
            total += num; //accumulate the sum 
            System.out.print("Enter a whole number, and -99 to quit: ");
            num = in.nextInt(); // accept input
        } 

        float average = (float) total/count; 
        System.out.println("You keyed in " + count + " numbers \n");
        System.out.println("The average is: " + average);
        return(average);
    }
    char getlettergrade(float myavg)
    {
        char lg = 'A';
        if(myavg >= 90)
        {
            lg = 'A';
        }
        else if(myavg >=80)
        {
            lg = 'B';
        }
        else if(myavg >=70)
        {
            lg = 'C';
        }
        else if(myavg >=60)
        {
            lg = 'D';
        }
        else;
        {
            lg = 'F';
        }
        
        return lg; 
    }
}

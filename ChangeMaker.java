/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changemaker;
import java.util.Scanner;
/**
 *
 * @author Sophie
 */
public class ChangeMaker 
{

    
    public static void main(String[] args) 
    {
        int change;
        int afterQuarters;
        int afterNickles;
        int afterDimes;
        int quarters;
        int dimes;
        int nickles;
        int pennies;
        
        System.out.println("Please enter the amount of change: ");
        Scanner in = new Scanner(System.in);
        change = in.nextInt();
        afterQuarters = change % 25; 
        afterDimes = afterQuarters % 10;
        afterNickles = afterDimes % 5;
        
        quarters = (change/25);
        dimes = afterQuarters / 10;
        nickles = afterDimes / 5;
        pennies = afterNickles;
        
        System.out.println("The amount of quarters is: " + quarters);
        System.out.println("The amount of dimes is: " + dimes);
        System.out.println("The amount of nickles is: " + nickles);
        System.out.println("The amount of pennies are: " + pennies);
        
       
    }
}

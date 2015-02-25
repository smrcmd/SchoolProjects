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
        int quarters;
        int dimes;
        int nickles;
        int pennies;
        
        System.out.println("Please enter the amount of change: ");
        Scanner in = new Scanner(System.in);
        change = in.nextInt();
        
        quarters = (change/25);
        change = change % 25;
        dimes = change/10;
        change %= 10;
        nickles = change/5;
        change %= 5; 
        pennies = change;
        
        System.out.println("The amount of quarters is: " + quarters);
        System.out.println("The amount of dimes is: " + dimes);
        System.out.println("The amount of nickles is: " + nickles);
        System.out.println("The amount of pennies are: " + pennies);
        
       
    }
}

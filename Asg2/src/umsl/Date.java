/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umsl;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Sophie
 */
public class Date {
    
    public String Date()
    {
        System.out.println("Please enter a future date in the format of 5/24/2015");
        System.out.println(" ");
        Scanner in = new Scanner(System.in);
        String dateInput = in.nextLine();
        return(dateInput);
    }
}

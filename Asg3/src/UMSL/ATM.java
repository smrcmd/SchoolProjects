/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMSL;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author Sophie
 */
public class ATM {
    
    Account[] AcctArray = new Account[3];
    
    public static void main(String args[]) throws IOException, NotSerializableException, EOFException
    {
        ATM aa = new ATM();
        
        System.out.println("Is this your first time banking with Sophie Bank? 'yes' or 'no':");
        Scanner response = new Scanner(System.in);
        String answer = response.nextLine();

        if(answer.equalsIgnoreCase("yes"))
        {
           aa.populateArray();
           //aa.readArray();
           aa.selectAccount();
           aa.writeArray();
        }
        
        else 
        {
           aa.readArray();
           aa.selectAccount();
           aa.writeArray();
        }
      
//        System.out.println("Do you wish to make another transaction? 'yes' or 'no'");
//        Scanner response2 = new Scanner(System.in);
//        String answer2 = response2.nextLine();
//        
//        while(answer2.equalsIgnoreCase("yes"))
//        {
//           aa.readArray();
//           aa.selectAccount();
//           aa.writeArray();
//        }
        //menu.Asg2Menu(balance); 
    }
    
    public void populateArray() throws IOException, NotSerializableException, EOFException, InvalidClassException
    {
        for(int i=0; i<AcctArray.length; i++)
            {
                    AcctArray[i] = new Account();	
                    //AcctArray[i].setBalance(100);
            }
            
            System.out.println("There are " + AcctArray.length + " accounts available.");
            System.out.println();
            
//            try
//            {
//                OutputStream fout = new FileOutputStream("file.out");
//                OutputStream buffer = new BufferedOutputStream(fout);
//                ObjectOutputStream oout = new ObjectOutputStream(buffer);
//                oout.writeObject(AcctArray);
//                oout.flush();
//                fout.close();
//                System.out.println("Populate array has written to a file.");
//                
//            }
//            catch (Throwable f)
//            {
//                System.err.println(f);
//            }
    } 
    
    public void readArray() throws EOFException, InvalidClassException
    {
        try
        {
            FileInputStream fIn = new FileInputStream("file.out");
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            AcctArray = (Account[])oIn.readObject();
            
            fIn.close();
        }
        catch (Throwable e)
        {
            System.err.println(e);
        }
        System.out.println(AcctArray.length + " arrays to choose from.");
    }

    public void writeArray() throws ArrayIndexOutOfBoundsException
    {
            try
            {
                OutputStream fout = new FileOutputStream("file.out");
                OutputStream buffer = new BufferedOutputStream(fout);
                ObjectOutputStream oout = new ObjectOutputStream(buffer);
                oout.writeObject(AcctArray);
                oout.flush();
                fout.close();
                System.out.println("Array has written to a file.");
                
            }
            catch (Throwable g)
            {
                System.err.println(g);
            }
    }
    /**
     *
     * @return
     */
    public void selectAccount() throws ArrayIndexOutOfBoundsException
        {
            int input = 0;
            try
            {
                while (input == 0 || input == 1 || input == 2)
                {
                System.out.println("Please enter the account you wish to access (0,1,2) and -99 to exit:" );
                Scanner select = new Scanner(System.in);
                input = select.nextInt();
                Account menu = new Account(); //call Asg2Menu from AccountArray
                AcctArray[input].menu();
                }
            }
            catch (Throwable o)
                {
                    System.exit(0);
                }
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sophie
 */
public class Student 
{
    String Fname;
    String Lname;
    int exam1;
    int exam2;
    double avg;
    char lettergrade;
    
    public Student()
    {
        Fname = "Jane";
        Lname = "Doe";
        exam1 = 75;
        exam2 = 75;
    }
    
    public Student (String Fname, String Lname, int ex1, int ex2)
    {
        this.Fname = Fname;
        this.Lname = Lname;
        exam1 = ex1;
        exam2 = ex2;
    }
    
    public void myAverage()
    {
        avg = (exam1 + exam2)/2;
    }
    
    public void getlettergrade()
    {
        char lg = 'A';
        if(avg >= 90)
        {
            lg = 'A';
        }
        else if(avg >=80)
        {
            lg = 'B';
        }
        else if(avg >=70)
        {
            lg = 'C';
        }
        else if(avg >=60)
        {
            lg = 'D';
        }
        else;
        {
            lg = 'F';
        }
        
        lettergrade = lg; 
    }
    
    public void showResults()
    {
        System.out.println("Your average is:" + avg);
        System.out.println("Your letter grade is:" + lettergrade);
    }
}

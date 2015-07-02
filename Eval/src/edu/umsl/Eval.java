/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import org.apache.derby.jdbc.*;

/**
 *
 * @author brilaw
 */
public class Eval extends JFrame implements ActionListener, ItemListener {
    //DECLARE THE ELEMENTS OR OBJECTS THAT YOU WILL PUT IN YOUR FRAME
    //NOTICE HOW A PANEL IS CREATED FOR EACH ONE THIS WILL MAKE IT EASIER BUILD

    public JLabel teamLabel;
    private JComboBox teamComboBox;
    private JPanel teamPanel;
    private JSlider teamTechSlider;
    private JLabel teamTechLabel;
    private JPanel teamTechPanel;
    private JPanel teamClarityPanel;
    private JSlider teamClaritySlider;
    private JLabel teamClarityLabel;
    private JPanel teamUsefulPanel;
    private JSlider teamUsefulSlider;
    private JLabel teamUsefulLabel;
    private JPanel teamOverallPanel;
    private JSlider teamOverallSlider;
    private JLabel teamOverallLabel;
    private JPanel buttonPanel;
    private JButton submitButton;
    private JLabel commentBoxLabel;
    private JPanel commentBoxPanel;
    private JTextArea commentBox;
    private JLabel teamAvgScore;
    private JButton commentButton;
    private JButton clearButton;
    private JPanel avgPanel;
    // instance variables used to manipulate database
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;

    //these are fields that will be used to hold the values pulled from the interface
    String teamname;
    int q1; //numeric
    int q2; //numeric
    int q3; //numeric
    int q4; //numeric
    String comments; //varchar
    double teamAvg; //double

   //MAIN METHOD: NOTICE WE TAKE IN THE ARGUMENTS THAT ARE
    //PASSED IN AND INSTANTIATE OUR CLASS WITH THEM
    public static void main(String args[]) {
        // check command-line arguments
        //if ( args.length == 2 )
        //{
        // get command-line arguments
        String databaseDriver = "org.apache.derby.jdbc.ClientDriver";
        //String databaseDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String databaseURL = "jdbc:derby://localhost:1527/Evaluation;create=true";

        // create new Eval
        Eval eval = new Eval(databaseDriver, databaseURL);
        eval.createUserInterface(); // set up GUI
        eval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //CONSTRUCTOR: WE SET UP OUR DATABASE HERE THEN MAKE A CALL
    //TO A FUNCTION CALLED CREATEUSERINTERFACE TO BUILD OUR GUI
    public Eval(String databaseDriver, String databaseURL) {
        // establish connection to database
        try {
         // load Sun driver
            //Class.forName( databaseDriver );
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            // connect to database
            myConnection = DriverManager.getConnection(databaseURL);
            // create Statement for executing SQL
            myStatement = myConnection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void createUserInterface() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        teamPanel = new JPanel();
        teamPanel.setBounds(40, 20, 276, 48);
        teamPanel.setBorder(BorderFactory.createEtchedBorder());
        teamPanel.setLayout(null);
        contentPane.add(teamPanel);
        // set up Instructor Label
        teamLabel = new JLabel();
        teamLabel.setBounds(25, 15, 100, 20);
        teamLabel.setText("Teams:");
        teamPanel.add(teamLabel);
        // set up accountNumberJComboBox
        teamComboBox = new JComboBox();
        teamComboBox.setBounds(150, 15, 96, 25);
        teamComboBox.addItem("");
        teamPanel.add(teamComboBox);

        teamTechPanel = new JPanel();
        teamTechPanel.setBounds(40, 80, 276, 48);
        teamTechPanel.setBorder(BorderFactory.createEtchedBorder());
        teamTechPanel.setLayout(null);
        contentPane.add(teamTechPanel);
        teamTechLabel = new JLabel();
        teamTechLabel.setBounds(25, 15, 100, 20);
        teamTechLabel.setText("Tech:");
        teamTechPanel.add(teamTechLabel);
        teamTechSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        teamTechSlider.setMajorTickSpacing(2);
        teamTechSlider.setPaintTicks(true);
        teamTechSlider.setPaintLabels(true);
        teamTechSlider.setSnapToTicks(true);
        teamTechSlider.setBounds(150, 1, 96, 50);
        teamTechPanel.add(teamTechSlider);
        
        teamClarityPanel = new JPanel();
        teamClarityPanel.setBounds(40, 130, 276, 48);
        teamClarityPanel.setBorder(BorderFactory.createEtchedBorder());
        teamClarityPanel.setLayout(null);
        contentPane.add(teamClarityPanel);
        teamClarityLabel = new JLabel();
        teamClarityLabel.setBounds(25, 15, 100, 20);
        teamClarityLabel.setText("Clarity:");
        teamClarityPanel.add(teamClarityLabel);
        teamClaritySlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        teamClaritySlider.setMajorTickSpacing(2);
        teamClaritySlider.setPaintTicks(true);
        teamClaritySlider.setPaintLabels(true);
        teamClaritySlider.setSnapToTicks(true);
        teamClaritySlider.setBounds(150, 1, 96, 50);
        teamClarityPanel.add(teamClaritySlider);

        teamUsefulPanel = new JPanel();
        teamUsefulPanel.setBounds(40, 180, 276, 48);
        teamUsefulPanel.setBorder(BorderFactory.createEtchedBorder());
        teamUsefulPanel.setLayout(null);
        contentPane.add(teamUsefulPanel);
        teamUsefulLabel = new JLabel();
        teamUsefulLabel.setBounds(25, 15, 100, 20);
        teamUsefulLabel.setText("Useful:");
        teamUsefulPanel.add(teamUsefulLabel);
        teamUsefulSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        teamUsefulSlider.setMajorTickSpacing(2);
        teamUsefulSlider.setPaintTicks(true);
        teamUsefulSlider.setPaintLabels(true);
        teamUsefulSlider.setSnapToTicks(true);
        teamUsefulSlider.setBounds(150, 1, 96, 50);
        teamUsefulPanel.add(teamUsefulSlider);
        
        teamOverallPanel = new JPanel();
        teamOverallPanel.setBounds(40, 230, 276, 48);
        teamOverallPanel.setBorder(BorderFactory.createEtchedBorder());
        teamOverallPanel.setLayout(null);
        contentPane.add(teamOverallPanel);
        teamOverallLabel = new JLabel();
        teamOverallLabel.setBounds(25, 15, 100, 20);
        teamOverallLabel.setText("Overall:");
        teamOverallPanel.add(teamOverallLabel);
        teamOverallSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        teamOverallSlider.setMajorTickSpacing(2);
        teamOverallSlider.setPaintTicks(true);
        teamOverallSlider.setPaintLabels(true);
        teamOverallSlider.setSnapToTicks(true);
        teamOverallSlider.setBounds(150, 1, 96, 50);
        teamOverallPanel.add(teamOverallSlider);
        commentBoxPanel = new JPanel();
        commentBoxPanel.setBounds(40, 280, 276, 100);
        commentBoxPanel.setBorder(BorderFactory.createEtchedBorder());
        commentBoxPanel.setLayout(null);
        contentPane.add(commentBoxPanel);
        commentBoxLabel = new JLabel();
        commentBoxLabel.setBounds(25,15,100,30);
        commentBoxLabel.setText("Comments");
        commentBoxPanel.add(commentBoxLabel);
        commentBox = new JTextArea();
        commentBox.setBounds(150, 10, 96, 75);
        commentBox.setBorder(BorderFactory.createEtchedBorder());
        commentBoxPanel.add(commentBox);
        commentButton = new JButton("Comment");
        commentButton.setBounds(15, 65, 75, 33);
        commentBoxPanel.add(commentButton);
        
        
        
        buttonPanel = new JPanel();
        buttonPanel.setBounds(40, 380, 276, 100); //x, y, width and height
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        buttonPanel.setLayout(null);
        contentPane.add(buttonPanel);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(15, 10, 78, 30);
        buttonPanel.add(submitButton);
        clearButton = new JButton("Clear");
        clearButton.setBounds(15, 65, 75, 33);
        buttonPanel.add(clearButton);
        teamAvgScore = new JLabel();
        teamAvgScore.setBounds(150, 10, 78, 30);
        teamAvgScore.setText("Avg is: " + teamAvg);
        teamAvgScore.setVisible(true);
        buttonPanel.add(teamAvgScore);
        
        submitButton.addActionListener(this);
        teamComboBox.addActionListener(this);
        commentButton.addActionListener(this);
        clearButton.addActionListener(this);
        loadTeams();

        setTitle("EVAL");   // set title bar string
        setSize(400, 550); // set window size
        setVisible(true);  // display window
    }

    private void loadTeams() {
        // get all account numbers from database
        try {
            //this is a sql query
            //app is the schema, teamname is the primary key, teams is the name of the table
            myResultSet = myStatement.executeQuery("SELECT DISTINCT TEAMNAME FROM APP.TEAMS");

            while (myResultSet.next()) {
                teamComboBox.addItem(myResultSet.getString("TEAMNAME"));
            }
            myResultSet.close(); // close myResultSet
        } // end try
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        teamname = teamComboBox.getSelectedItem().toString();
        q1 = teamTechSlider.getValue();
        q2 = teamClaritySlider.getValue();
        q3 = teamUsefulSlider.getValue();
        q4 = teamOverallSlider.getValue();
        comments = commentBox.getText();
        
        teamAvg = calcTeamAvg(q1, q2, q3, q4);
        teamAvgScore.setText("Avg is: " + teamAvg);
        updateTeams();
        
        if (teamname==null || q1 == 0 && q2 == 0 && q3 == 0 && q4 == 0)
        {
            submitButton.setEnabled(false);
        }
        else if (event.getSource() == commentButton)
        {
            submitButton.setEnabled(true);
            teamAvgScore.setVisible(true);
            updateTeams();
        }
        else if (event.getSource() == clearButton)
        {
            teamComboBox.setSelectedIndex(0);
            teamTechSlider.setValue(5);
            teamClaritySlider.setValue(5);
            teamUsefulSlider.setValue(5);
            teamOverallSlider.setValue(5);
            commentBox.setText(" ");
            teamAvgScore.setText(null);
        }
        
    }
    
    public double calcTeamAvg(int q1, int q2, int q3, int q4){
    
        teamAvg = (q1+q2+q3+q4)/4;
        return teamAvg;
    }

    @Override
    public void itemStateChanged(ItemEvent event) {

     
    }

    private void updateTeams() {
        // update balance in database
        try {
            String sql = "UPDATE APP.TEAMS SET Q1TECH = " + q1 + "," + "Q2CLARITY = " 
                    + q2 + "," + "Q3USEFUL = " + q3 + "," + "Q4OVERALL = " + q4 + "," 
                    + "TEAMAVG = " + teamAvg + "," + "COMMENTS = " + "'" + comments + "'" + 
                    "WHERE " + "TEAMNAME = " + "'" + teamname + "'"; 
            //when using numerics in SQL you can do = then the number, then a comma 
            //when using strings in SQL you have to "'", the string, then "'"
            //String sql2 =  "UPDATE APP.TEAMEVAL" + " SET q2 = " + q2 + " WHERE " + 
            //           "TEAMNAME = '" + myteamname + "'" + "and course = '" + courseName + "'";
            myStatement.executeUpdate(sql);
            // myStatement.executeUpdate(sql2);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

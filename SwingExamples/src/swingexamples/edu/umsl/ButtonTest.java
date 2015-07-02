/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexamples.edu.umsl;

import java.awt.*;
import java.awt.event.*;
 
// Java extension packages
import javax.swing.*;
 
public class ButtonTest extends JFrame implements ActionListener 
{
   private JButton plainButton, fancyButton;
 
   // set up GUI
   public ButtonTest()
   {
      super( "Testing Buttons" );
   }
   
   public void buildInterface()
   {
   // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );
 
      // create buttons
      plainButton = new JButton( "Plain Button" );
      container.add( plainButton );
 
      Icon bug1 = new ImageIcon( "bug1.gif" );
      Icon bug2 = new ImageIcon( "bug2.gif" );
      fancyButton = new JButton( "Fancy Button", bug1 );
      fancyButton.setRolloverIcon( bug2 );
      container.add( fancyButton );
 
      // create an instance of inner class ButtonHandler
      // to use for button event handling

      fancyButton.addActionListener( this );
      plainButton.addActionListener( this );
 
      setSize( 275, 100 );
      setVisible( true );
   }
 
   // execute application
   public static void main( String args[] )
   {
      ButtonTest application = new ButtonTest();
      application.buildInterface();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   @Override
  public void actionPerformed( ActionEvent event )
  {
     JOptionPane.showMessageDialog( null,
        "You pressed: " + event.getActionCommand() );
  }
 
  
 
}  // end class ButtonTest
/*  StartUp
    Last Modified: Jan 26, 2022
    Author: Amber R
    Startup for all day postal service
*/

//import classes
import javax.swing.*;

public class StartUp{

    //initialize model and GUI, and JFrame for program
    public static void main(String[] args) throws Exception {
        
        //initialize model and GUI objects
        MailService userService = new MailService(); //model
        MailServiceGUI userScreen = new MailServiceGUI(userService); //view

        //frame initialize
        JFrame a = new JFrame();

        //set JFrame
        a.setTitle("All Day Postal Service");
        a.setLocation(1,1);
        a.setSize(800,210);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setContentPane(userScreen);
        a.setVisible(true);

    }//main

}//ADPService
/*  MailServiceGUI
    Last Modified: April 26, 2022
    Author: Amber R
    GUI/view for ADP Service
*/

//import classes
import javax.swing.*;
import java.awt.*;

public class MailServiceGUI extends JPanel{

    //declare JComponents
    private MailService service;
    private LocationPanel locationPane;
    private NumPadPanel numPadPane;

    //constructor
    public MailServiceGUI(MailService newTransaction){

        super();
        this.service = newTransaction;
        this.locationPane = new LocationPanel(newTransaction);
        this.numPadPane = new NumPadPanel(newTransaction); 
        this.update();       

    }//end of constructor

    //update whole GUI when change occurs
    public void update(){

        //update each pane
        this.locationPane.update();
        this.numPadPane.update();

    }//update
    
}//MailServiceGUI

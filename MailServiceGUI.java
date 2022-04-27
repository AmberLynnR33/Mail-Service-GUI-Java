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

        //connect model to GUI
        super();
        this.service = newTransaction;
        
        //set up panels and add them to main panel
        this.locationPane = new LocationPanel(newTransaction);
        this.numPadPane = new NumPadPanel(newTransaction);
        this.layoutPanel();

        //connect GUI to model and display it
        this.service.setGUI(this);
        this.update();

    }//end of constructor

    //layout JPanel
    private void layoutPanel(){

        //add JPanels to main JPanel
        this.setLayout(new BorderLayout());

        this.add(this.locationPane, BorderLayout.WEST);
        this.add(this.numPadPane, BorderLayout.EAST);


    }//end of layoutPanel

    //update whole GUI when change occurs
    public void update(){

        //update each pane
        this.locationPane.update();
        this.numPadPane.update();

    }//update
    
}//MailServiceGUI

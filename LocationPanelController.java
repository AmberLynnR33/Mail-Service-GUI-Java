/*  Controller
    Last Modified: Jan 26, 2022
    Author: Amber R
    Controller for buttons in GUI of ADPService
*/

//import classes
import javax.swing.*;
import java.awt.event.*;

public class LocationPanelController implements ActionListener {

    //declare instance variables
    private MailService service;
    private JButton b1, b2, b3, b4, b5, cancel;

    public LocationPanelController(MailService model, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton cancelButton){

        //attach model to controller
        this.service = model;

        //attach JComponents of GUI to controller
        this.b1 = button1;
        this.b2 = button2;
        this.b3 = button3;
        this.b4 = button4;
        this.b5 = button5;
        this.cancel = cancelButton;

    }//contructor

    //what occurs when different JButtons are pressed
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == b1){

            //sets location
            this.service.setLocation(0);

            //disable buttons and enable weight input
            this.service.setButtonEnable(false);
            this.service.setWeightScaleVisible(true);

        }else if(e.getSource() == b2){

            //sets location
            this.service.setLocation(1);

            //disable buttons and enable weight input
            this.service.setButtonEnable(false);
            this.service.setWeightScaleVisible(true);

        }else if(e.getSource() == b3){

            //sets location
            this.service.setLocation(2);

            //disable buttons and enable weight input
            this.service.setButtonEnable(false);
            this.service.setWeightScaleVisible(true);

        }else if(e.getSource() == b4){

            //sets location
            this.service.setLocation(3);

            //disable buttons and enable weight input
            this.service.setButtonEnable(false);
            this.service.setWeightScaleVisible(true);

        }else if(e.getSource() == b5){

            //sets location
            this.service.setLocation(4);

            //disable buttons and enable weight input
            this.service.setButtonEnable(false);
            this.service.setWeightScaleVisible(true);

        }else if(e.getSource() == cancel){

            //reset location
            this.service.setLocation(10);

            //disable weight scale enter and enable buttons for new selection
            this.service.setButtonEnable(true);
            this.service.setWeightScaleVisible(false);

            this.service.setTextField(false);
            this.service.setTextField(true);

            //reset any errors if any occured
            this.service.setError(3);

        }else{
        }//fi

    }//actionPerformed
    
}//Controller

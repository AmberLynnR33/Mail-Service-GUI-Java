/*  Controller
    Last Modified: Jan 26, 2022
    Author: Amber R
    Controller for buttons in GUI of ADPService
*/

//import classes
import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener {

    //declare instance variables
    private MailService service;
    private JButton b1, b2, b3, b4, b5, enter, cancel;
    private JTextField weight;

    public Controller(MailService model, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton enterButton, JButton cancelButton, JTextField enterWight){

        //attach model to controller
        this.service = model;

        //attach JComponents of GUI to controller
        this.b1 = button1;
        this.b2 = button2;
        this.b3 = button3;
        this.b4 = button4;
        this.b5 = button5;
        this.enter = enterButton;
        this.cancel = cancelButton;
        this.weight = enterWight;

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

        }else if(e.getSource() == enter){

            //outputs recipt for user if valid weight input
            try{

                //attempt to convert String to double
                this.service.setWeight(Double.parseDouble(this.weight.getText()));

                //ensure weight is a positive value
                if (this.service.getWeight() <=0){

                    this.service.setError(1);

                }else{

                    //get recipt for user
                    this.service.recipt();

                }//fi

            }catch (NumberFormatException n){

                this.service.setError(1);

            }//yrt


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

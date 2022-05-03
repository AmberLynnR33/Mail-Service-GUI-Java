/*  NumPadController
    Created by: Amber R
    Last Modified: 26/04/22
    Controller for NumPad components
*/

//imports
import javax.swing.*;
import java.awt.event.*;

public class NumPadController implements ActionListener{

    //declare attributes
    private MailService service;
    private JButton s1,s2,s3,s4,s5,s6,s7,s8,s9,s0,enter,cancel,decimal;

    //constructor
    public NumPadController(MailService model, JButton s1, JButton s2, JButton s3, JButton s4, JButton s5, JButton s6, JButton s7, JButton s8, JButton s9, JButton s0, JButton enter, JButton cancel, JButton decimal){

        //conect model to controller
        this.service = model;

        //connect components to controller
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.s9 = s9;
        this.s0 = s0;
        this.enter = enter;
        this.cancel = cancel;
        this.decimal = decimal;

    }//end of constructor

    //what occurs when each button is pressed
    public void actionPerformed(ActionEvent e){

        //what to do when a button is pressed
        if(e.getSource() == this.s0){

            this.service.setWeightText("0");

        }else if(e.getSource() == this.s1){

            this.service.setWeightText("1");

        }else if(e.getSource() == this.s2){

            this.service.setWeightText("2");

        }else if(e.getSource() == this.s3){

            this.service.setWeightText("3");

        }else if(e.getSource() == this.s4){

            this.service.setWeightText("4");

        }else if(e.getSource() == this.s5){

            this.service.setWeightText("5");

        }else if(e.getSource() == this.s6){

            this.service.setWeightText("6");

        }else if(e.getSource() == this.s7){

            this.service.setWeightText("7");

        }else if(e.getSource() == this.s8){

            this.service.setWeightText("8");

        }else if(e.getSource() == this.s9){

            this.service.setWeightText("9");

        }else if(e.getSource() == this.decimal){

            this.service.setWeightText(".");

        }else if(e.getSource() == this.cancel){

            this.service.setWeightText("clear");

        }else if(e.getSource() == this.enter){

            this.service.setNumPadEnable(false);
            this.service.completeInteraction();

        }else{
        }//fi

    }//end of actionPerformed
    
}//end of class
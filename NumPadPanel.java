/*  NumPadPanel
    Created by: Amber R
    Last Modified: 26/04/22
    Number pad for the user to enter a weight
*/

import javax.swing.*;
import java.awt.*;

public class NumPadPanel extends JPanel{

    private MailService service;

    //declare components
    private JPanel numPadPanel = new JPanel(); //overall panel
    private JPanel numPad = new JPanel();
    private BorderLayout numPadPanelLayout;
    private GridLayout numPadLayout;

    private JLabel getWeight = new JLabel(); //allows user to enter weight

    private JButton select1 = new JButton("1"); //number 1
    private JButton select2 = new JButton("2"); //number 2
    private JButton select3 = new JButton("3"); //number 3
    private JButton select4 = new JButton("4"); //number 4
    private JButton select5 = new JButton("5"); //number 5
    private JButton select6 = new JButton("6"); //number 6
    private JButton select7 = new JButton("7"); //number 7
    private JButton select8 = new JButton("8"); //number 8
    private JButton select9 = new JButton("9"); //number 9
    private JButton select0 = new JButton("0"); //number 0
    private JButton selectDecimal = new JButton("."); //decimal for package weight accuracy

    private JButton clearNum = new JButton("Clear"); //clears getWeight if error
    private JButton enterNum = new JButton("Enter"); //enters value in getWeight

    //put panel together
    private JPanel createPanel(){

        //add layout manager
        this.setLayout();
        this.setAttributes();

        //add values to panel
        this.numPad.add(this.select1);
        this.numPad.add(this.select2);
        this.numPad.add(this.select3);
        this.numPad.add(this.select4);
        this.numPad.add(this.select5);
        this.numPad.add(this.select6);
        this.numPad.add(this.select7);
        this.numPad.add(this.select8);
        this.numPad.add(this.select9);
        this.numPad.add(this.select0);
        this.numPad.add(this.selectDecimal);
        this.numPad.add(this.clearNum);

        //add components to overall number pad
        this.numPadPanel.add(this.getWeight, BorderLayout.NORTH);
        this.numPadPanel.add(this.numPad, BorderLayout.WEST);
        this.numPadPanel.add(this.enterNum, BorderLayout.CENTER);

        return(this.numPadPanel);

    }//end of createPanel

    //set layouts of panels
    private void setLayout(){

        //layout of number pad
        this.numPadLayout = new GridLayout(4,3);
        this.numPad.setLayout(this.numPadLayout);

        //layout of overall panel
        this.numPadPanelLayout = new BorderLayout();
        this.numPadPanel.setLayout(this.numPadPanelLayout);

    }//end of setLayout()

    //set attributes of JComponents
    private void setAttributes(){

        //size
        this.getWeight.setPreferredSize(new Dimension(this.numPadPanel.getWidth(),100));

    }//end of setAttributes

    //Accessor method: get panel for overall GUI
    public JPanel getNumPadPanel(){

        return(this.createPanel());

    }//end of getNumPadPanel

    public void registerControllers(){

        NumPadController controller = new NumPadController(this.service, this.select1, this.select2, this.select3, this.select4, this.select5, this.select6, this.select7, this.select8, this.select9, this.select0, this.enterNum, this.clearNum, this.selectDecimal);
        
        //add action listeners to JComponents
        this.select1.addActionListener(controller);
        this.select2.addActionListener(controller);
        this.select3.addActionListener(controller);
        this.select4.addActionListener(controller);
        this.select5.addActionListener(controller);
        this.select6.addActionListener(controller);
        this.select7.addActionListener(controller);
        this.select8.addActionListener(controller);
        this.select9.addActionListener(controller);
        this.select0.addActionListener(controller);

        this.selectDecimal.addActionListener(controller);
        this.enterNum.addActionListener(controller);
        this.clearNum.addActionListener(controller);

    }//end of register controllers

    //update features of Panel
    public void update(){

        if(service.getNumPadEnable()){

            this.select0.setEnabled(true);
            this.select1.setEnabled(true);
            this.select2.setEnabled(true);
            this.select3.setEnabled(true);
            this.select4.setEnabled(true);
            this.select5.setEnabled(true);
            this.select6.setEnabled(true);
            this.select7.setEnabled(true);
            this.select8.setEnabled(true);
            this.select9.setEnabled(true);
            this.selectDecimal.setEnabled(true);
            this.clearNum.setEnabled(true);
            this.enterNum.setEnabled(true);

        }else{

            this.select0.setEnabled(false);
            this.select1.setEnabled(false);
            this.select2.setEnabled(false);
            this.select3.setEnabled(false);
            this.select4.setEnabled(false);
            this.select5.setEnabled(false);
            this.select6.setEnabled(false);
            this.select7.setEnabled(false);
            this.select8.setEnabled(false);
            this.select9.setEnabled(false);
            this.selectDecimal.setEnabled(false);
            this.clearNum.setEnabled(false);
            this.enterNum.setEnabled(false);

        }//fi

        this.getWeight.setText(service.getWeightText());

    }//end of update

    /*public static void main(String [] args){

        NumPadPanel b = new NumPadPanel();

        JFrame a = new JFrame();

        //set JFrame
        a.setTitle("All Day Postal Service");
        a.setLocation(250, 250);
        a.setSize(300,300);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setContentPane(b.createPanel());
        a.setVisible(true);
        
    }*/
    
}//end of class
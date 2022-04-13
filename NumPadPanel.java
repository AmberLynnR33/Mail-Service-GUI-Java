/*  NumPadPanel
    Created by: Amber R
    Last Modified: 12/04/22
    Number pad for the user to enter a weight
*/

import javax.swing.*;
import java.awt.*;

public class NumPadPanel extends JPanel{

    //declare components
    private JPanel numPadPanel = new JPanel(); //overall panel
    private JPanel numPad = new JPanel();
    private BoxLayout numPadPanelLayout;
    private GridLayout numPadLayout;
    private JTextField getWeight = new JTextField(1); //allows user to enter weight

    private JButton select1 = new JButton("1"); //number 1
    private JButton select2 = new JButton("2"); //number 2
    private JButton select3 = new JButton("3"); //number 3
    private JButton select4 = new JButton("4"); //number 4
    private JButton select5 = new JButton("5"); //number 5
    private JButton select6 = new JButton("6"); //number 6
    private JButton select7 = new JButton("7"); //number 7
    private JButton select8 = new JButton("8"); //number 8
    private JButton select9 = new JButton("9"); //number 9
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
        this.numPad.add(this.clearNum);
        this.numPad.add(this.selectDecimal);
        this.numPad.add(this.enterNum);

        //add components to overall number pad
        this.numPadPanel.add(this.getWeight);
        this.numPadPanel.add(this.numPad);

        return(this.numPadPanel);

    }//end of createPanel

    //set layouts of panels
    private void setLayout(){

        //layout of number pad
        this.numPadLayout = new GridLayout(4,3);
        this.numPad.setLayout(this.numPadLayout);

        //layout of overall panel
        this.numPadPanelLayout = new BoxLayout(this.numPadPanel, BoxLayout.Y_AXIS);
        this.numPadPanel.setLayout(this.numPadPanelLayout);

    }//end of setLayout()

    //set attributes of JComponents
    private void setAttributes(){

        //size
        this.numPadPanel.setPreferredSize(new Dimension(300,350));;
        this.numPad.setPreferredSize(new Dimension(300,250));
        this.getWeight.setPreferredSize(new Dimension(300,100));

    }//end of setAttributes

    //Accessor method: get panel for overall GUI
    public JPanel getNumPadPanel(){

        return(this.createPanel());

    }//end of getNumPadPanel

    public static void main(String [] args){

        NumPadPanel b = new NumPadPanel();

        JFrame a = new JFrame();

        //set JFrame
        a.setTitle("All Day Postal Service");
        a.setLocation(250, 250);
        a.setSize(300,300);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setContentPane(b.createPanel());
        a.setVisible(true);
        
    }
    
}//end of class
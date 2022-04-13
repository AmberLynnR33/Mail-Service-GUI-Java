
//practice of look of numberpad

import javax.swing.*;
import java.awt.*;

public class practiceNumPad {

    private JPanel numPad = new JPanel(new GridLayout(4,3));
    private JPanel enterWeight = new JPanel();
    private BoxLayout layoutNumPad;
    private JTextField getWeight = new JTextField(20); //allows user to enter weight

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

    public static void main(String [] args){

        practiceNumPad b = new practiceNumPad();

        JFrame a = new JFrame();

        //set JFrame
        a.setTitle("All Day Postal Service");
        a.setLocation(250, 250);
        a.setSize(650,700);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setContentPane(b.createPanel());
        a.setVisible(true);
        
    }

    private JPanel createPanel(){

        //add layout manager
        this.layoutNumPad = new BoxLayout(this.enterWeight, BoxLayout.Y_AXIS);
        this.enterWeight.setLayout(layoutNumPad);

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
        this.enterWeight.add(this.getWeight);
        this.enterWeight.add(this.numPad);

        return(this.enterWeight);

    }
    
}

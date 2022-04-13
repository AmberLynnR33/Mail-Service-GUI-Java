/*  MailServiceGUI
    Last Modified: Jan 26, 2022
    Author: Amber R
    GUI/view for ADP Service
*/

//import classes
import javax.swing.*;
import java.awt.*;

public class MailServiceGUI extends JPanel{

    //declare JComponents
    private MailService service;

    private JLabel weightMessage = new JLabel("Weight your package on the scale and enter the weight here: "); //instructs user on entering weight

    private JLabel title = new JLabel("Welcome to All Day Postal. Please enter destination code:  "); //instructs user on what to do when program starts
    private JLabel errorCode = new JLabel(""); //displays error code if error occurs

    private JButton b1 = new JButton(); //select location 1
    private JButton b2 = new JButton(); //select location 2
    private JButton b3 = new JButton(); //select location 3
    private JButton b4 = new JButton(); //select location 4
    private JButton b5 = new JButton(); //select location 5

    private JButton enter = new JButton(); //allows user to enter all input to get recipt
    private JButton cancel = new JButton(); //resets screen so user can restart selection

    //JComponents of the number pad
    private JPanel numPad = new JPanel(new GridLayout(4,3));
    private JPanel enterWeight = new JPanel();
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

    //constructor
    public MailServiceGUI(MailService newTransaction){

        super();
        this.service = newTransaction;
        this.service.setGUI(this);
        this.layoutPanel();
        this.registerControllers();
        this.update();

    }//end of constructor

    //look of components in JPanel
    private void layoutPanel(){

        //declare JPanel
        JPanel layout = new JPanel();

        //create LocationChaart JComponent
        JComponent chart = new LocationChart(this.service.getCosts(), this.service.getLocations());

        //set button text and size
        this.b1.setText("1");
        this.b1.setPreferredSize(new Dimension(100,25));

        this.b2.setText("2");
        this.b2.setPreferredSize(new Dimension(100,25));

        this.b3.setText("3");
        this.b3.setPreferredSize(new Dimension(100,25));

        this.b4.setText("4");
        this.b4.setPreferredSize(new Dimension(100,25));

        this.b5.setText("5");
        this.b5.setPreferredSize(new Dimension(100,25));

        this.enter.setText("Enter");
        this.enter.setPreferredSize(new Dimension(100, 25));

        this.cancel.setText("Cancel");
        this.cancel.setPreferredSize(new Dimension(100,25));

        //add to JPanel
        layout.add(title);
        layout.add(chart);
        layout.add(b1);
        layout.add(b2);
        layout.add(b3);
        layout.add(b4);
        layout.add(b5);
        layout.add(weightMessage);
        //layout.add(getWeight);
        layout.add(enter);
        layout.add(cancel);
        layout.add(errorCode);

        layout.add(this.numPad());

        //create BorderLayout for Panel
        this.setLayout(new BorderLayout());
        this.add(layout, BorderLayout.CENTER);

    }//layoutPanel

    //add components to the numberPad JPanel
    private JPanel numPad(){

        //add layout manager
        BoxLayout layout = new BoxLayout(this.enterWeight, BoxLayout.Y_AXIS);
        this.enterWeight.setLayout(layout);

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

    }//end of numPad

    public void registerControllers(){

        //create controller to get input from JComponents
        Controller buttonControl = new Controller(this.service, this.b1, this.b2, this.b3, this.b4, this.b5, this.enter, this.cancel, this.getWeight);
        
        //add action listeners to JButtons and JTextFields so they can control program
        this.b1.addActionListener(buttonControl);
        this.b2.addActionListener(buttonControl);
        this.b3.addActionListener(buttonControl);
        this.b4.addActionListener(buttonControl);
        this.b5.addActionListener(buttonControl);
        this.enter.addActionListener(buttonControl);
        this.cancel.addActionListener(buttonControl);
        this.getWeight.addActionListener(buttonControl);

    }//registerControllers

    public void update(){

        //sets section of GUI visible or invisible
        this.enter.setVisible(this.service.getWeightScaleVisible());
        this.cancel.setVisible(this.service.getWeightScaleVisible());
        //this.getWeight.setVisible(this.service.getWeightScaleVisible());
        this.weightMessage.setVisible(this.service.getWeightScaleVisible());

        //enable or disable location buttons
        this.b1.setEnabled(this.service.getButtonEnable());
        this.b2.setEnabled(this.service.getButtonEnable());
        this.b3.setEnabled(this.service.getButtonEnable());
        this.b4.setEnabled(this.service.getButtonEnable());
        this.b5.setEnabled(this.service.getButtonEnable());

        //clears JTextField if user resets package information
        if (this.service.getClearTextField() == true){

            this.getWeight.setText("");

        }//fi

        //set error code text (if error has occured)
        this.errorCode.setText(this.service.getErrorMessage());

    }//update
    
}//MailServiceGUI

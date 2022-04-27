/* LocationPanel
    Created by: Amber R
    Last Modified: 26/04/22
    JPanel for selecting a location
*/

//imports
import javax.swing.*;
import java.awt.*;

public class LocationPanel extends JPanel{

    //declare attributes
    private MailService service;

    private JPanel buttons = new JPanel();
    private BorderLayout mainLayout;
    private GridLayout buttonsLayout;

    private JLabel instruction = new JLabel(); //instructs user on what to do throughout program

    private JButton b1 = new JButton(); //select location 1
    private JButton b2 = new JButton(); //select location 2
    private JButton b3 = new JButton(); //select location 3
    private JButton b4 = new JButton(); //select location 4
    private JButton b5 = new JButton(); //select location 5

    private JButton enter = new JButton(); //allows user to enter all input to get recipt
    private JButton cancel = new JButton(); //resets screen so user can restart selection

    //constructor
    public LocationPanel(MailService newTransaction){

        super();
        this.service = newTransaction;
        this.layoutPanel();
        this.registerControllers();
        this.update();

    }//end of constructor

    //look of components in JPanel
    private void layoutPanel(){

        //create LocationChaart JComponent
        JComponent chart = new LocationChart(this.service.getCosts(), this.service.getLocations());

        //setup components to be added to JPanel
        this.setLayout();
        this.setAttributes();

        //add to JPanels
        this.buttons.add(b1);
        this.buttons.add(b2);
        this.buttons.add(b3);
        this.buttons.add(b4);
        this.buttons.add(b5);
        this.buttons.add(enter);
        this.buttons.add(cancel);

        this.add(chart, BorderLayout.NORTH);
        this.add(this.buttons, BorderLayout.CENTER);
        this.add(this.instruction, BorderLayout.SOUTH);

    }//layoutPanel

    //sets layout managers for JPanels
    private void setLayout(){

        this.mainLayout = new BorderLayout();
        this.setLayout(this.mainLayout);

        this.buttonsLayout = new GridLayout(1,7);
        this.buttons.setLayout(this.buttonsLayout);


    }//end of setLayout

    //sets attributes for JComponents
    private void setAttributes(){

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

    }//end of setAttributes

    //ensures JButtons are interactable
    private void registerControllers(){

        //create controller to get input from JComponents
        LocationPanelController buttonControl = new LocationPanelController(this.service, this.b1, this.b2, this.b3, this.b4, this.b5, this.cancel);
        
        //add action listeners to JButtons and JTextFields so they can control program
        this.b1.addActionListener(buttonControl);
        this.b2.addActionListener(buttonControl);
        this.b3.addActionListener(buttonControl);
        this.b4.addActionListener(buttonControl);
        this.b5.addActionListener(buttonControl);
        this.cancel.addActionListener(buttonControl);

    }//end of registerControllers

    //updates components as needed
    public void update(){

        //enable or disable location buttons
        this.b1.setEnabled(this.service.getButtonEnable());
        this.b2.setEnabled(this.service.getButtonEnable());
        this.b3.setEnabled(this.service.getButtonEnable());
        this.b4.setEnabled(this.service.getButtonEnable());
        this.b5.setEnabled(this.service.getButtonEnable());

        //display current instruction
        this.instruction.setText(this.service.getInstruction());

    }//end of update
    
}//end of class
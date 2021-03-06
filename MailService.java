/*  MailService
    Last Modified: April 26, 2022
    Author: Amber R
    Model for APDService
*/

//import classes
import java.util.*;
import java.io.*;

public class MailService extends Object{

    //declare instance variables
    private MailServiceGUI view; //attaches GUI object to model

    private final double TAX = 0.13; //HST
    
    private int baseCost; //cost to first location, London, England in this case
    private int[] costs = new int[5]; //costs to mail to all locations

    private String[] locations = new String[5]; //name of all locations mail to

    private String [] instructionMsg = new String[4]; //message instructing user of what to do, or any errors
    private int currentInstruction; //current message to be displayed

    private int location; //location user is shipping to
    private double weight; //weight of package
    private int packageNum; //package number of user

    private double subtotal; //subtotal to send letter
    private double withTax; //tax in sending letter
    private double total; //total cost to send letter with tax

    private boolean buttonEnable; //enable or disable location buttons
    private boolean numPadEnable; //enable or disable number pad

    private StringBuffer weightText = new StringBuffer(); //what shows up on weight screen

    private PrintWriter recipt; //prints recipt

    //initialize model
    public MailService(){

        super();

        //initialize array data
        this.generateBaseCost();
        this.generateShippingCosts();
        this.generateLocationNames();
        this.generateInstructions();

        //initialize attributes
        this.currentInstruction = 0;
        this.buttonEnable = true;
        this.numPadEnable = false;
        this.weightText.append("");

    }//mailService

    //connect GUI to model
    public void setGUI(MailServiceGUI thisGUI){

        this.view = thisGUI;

    }//setGUI

    //create base cost for first location
    private void generateBaseCost(){

        this.baseCost = (int)(Math.random()*5 + 4);

    }//generateBaseCost

    //create package number for user recipt
    private void generatePackageNum(){

        this.packageNum = (int)(Math.random()*1000000000+1);

    }//generatePackageNum

    //create costs for each location based on base location
    private void generateShippingCosts(){

        int currentCost = this.baseCost;
        
        //generate costs of letters based on base cost
        for (int i = 0; i<5; i++){
             //calculates cost of letter (if not heading to base location)
            if (i!=0){
               currentCost += 2;
             }//fi
        
          costs[i] = currentCost;
                
         }//rof

    }//generateShippingCosts

    //locations mailing to, for easy location edits
    private void generateLocationNames(){

        this.locations[0] = "London, England";
        this.locations[1] = "Paris, France";
        this.locations[2] = "Tokyo, Japan";
        this.locations[3] = "Seoul, South Korea";
        this.locations[4] = "Wellington, New Zealand";

    }//generateLocationNames

    private void generateInstructions(){

        instructionMsg[0] = "Welcome to ADP. Please enter the destination your package is being sent to.";
        instructionMsg[1] = "Please enter the package weight, with the panel on the right.";
        instructionMsg[2] = "Please enter a valid weight and try again.";
        instructionMsg[3] = "Processing error. Please try again.";

    }//end of generateInstructions

    //accessor method to get costs array
    public int[] getCosts(){

        return this.costs;

    }//getCosts

    //accessor method to get locations array
    public String[] getLocations(){

        return this.locations;

    }//getLocations

    //accessor method for name of location sending to
    public String getNameLocation(){

        return this.locations[location];

    }//end of getNameLocation


    //accessor method for weight of package
    public double getWeight(){

        return this.weight;

    }//getWeight

    //accessor method to check if location buttons should be visible
    public boolean getButtonEnable(){

        return this.buttonEnable;

    }//getButtonEnable

    //accessor method to check if number pad buttons should be enabled
    public boolean getNumPadEnable(){

        return this.numPadEnable;

    }//end of getNumPadEnable

    public String getWeightText(){

        return(this.weightText.toString());

    }//end of getWeightText

    //accessor method to check if error message should be displayed
    public String getInstruction(){

        return this.instructionMsg[currentInstruction];

    }//getErrorMessage

    //change location to location user wants to send letter to
    public void setLocation(int locationCode){

        this.location = locationCode;

    }//setLocation

    //converts what user has input as the weight to a weight value
    private boolean setWeight(){

        //declare variables
        boolean canSetWeight; //T if weight was converted successfully, F is not

        try{

            this.weight = Double.parseDouble(this.weightText.toString().trim());
            canSetWeight = true;

            //ensure value is not zero
            if(this.weight == 0.0){

                this.setInstructionMsg(2);
                canSetWeight = false;

            }//fi

        }catch(NumberFormatException e){

            this.setInstructionMsg(2);
            canSetWeight = false;

        }//yrt

        return(canSetWeight);

    }//end of setWeight

    //set error message to be displayed if user inputs invalid data, or error with program
    public void setInstructionMsg(int code){

        this.currentInstruction = code;

        //update GUI to display message
        this.view.update();

    }//setError

    //makes location buttons to appear or disappear based on argument input
    public void setButtonEnable(boolean isVisible){

        //set instance variable
        this.buttonEnable = isVisible;

        //update GUI
        this.view.update();

    }//setButtonEnable

    //enables or disables number pad
    public void setNumPadEnable(boolean isEnabled){

        //set instance variable
        this.numPadEnable = isEnabled;

        //update GUI
        this.view.update();

    }//end of setNumPadEnable

    //clears text field if necessary
    public void setWeightText(String toAppend){

        //clears what is on screen if asked. Otherwise, adds to what is on screen
        if(toAppend.equals("clear")){

            //clear
            this.weightText.setLength(0);
            this.weightText.append("");

        }else{

            //set instance variable
            this.weightText.append(toAppend);

        }//fi

        //update GUI
        this.view.update();

    }//setTextField

    //calculates subtotal of sending package
    private void calculateSubtotal(){

        int timesWeight;

        //calculate how many 100g increments of package to pay for from weight
        timesWeight = (int)(Math.ceil(this.weight/100));

        //set instance variable
        this.subtotal = this.costs[location] * (int)(timesWeight);

    }//calculateSubtotal

    //calculate tax user will pay
    private void calcualteTax(){

        this.withTax = this.subtotal * this.TAX;

    }//calculateTax

    //calculate total user will pay
    private void calculateTotal(){

        this.total = this.subtotal + this.withTax;

    }//calculateTotal

    //completes transation for user if they've entered a proper weight
    public void completeInteraction(){

        //only completes interaction if successfully converted weight
        if(setWeight()){

            this.recipt();

        }//fi

    }//end of completeInteraction

    //get information to print recipt (total, package number, and print recipt)
    private void recipt(){

        this.calculateSubtotal();
        this.calcualteTax();
        this.calculateTotal();

        this.generatePackageNum();

        this.printRecipt();

    }//recipt

    //puts recipt for user in txt file
    private void printRecipt(){

        try{

            this.recipt = new PrintWriter(new FileWriter("ADP Recipt " + this.packageNum + ".txt"));
            this.recipt.println("All Day Postal");

            this.recipt.println("---------------------------------------------------------------");
            this.recipt.println("Package Destination: " + this.getNameLocation());
            this.recipt.println("---------------------------------------------------------------");

            this.recipt.printf("Subtotal:\t\t\t\t\t$%10.2f", this.subtotal);
            this.recipt.println();

            this.recipt.printf("Tax:\t\t\t\t\t\t$%10.2f", this.withTax);
            this.recipt.println();

            this.recipt.printf("Total:\t\t\t\t\t\t$%10.2f", this.total);
            this.recipt.println();

            this.recipt.printf("Your Package Number:\t\t %10d", this.packageNum);
            this.recipt.println();

            this.recipt.println("Please Proceed to service counter. Thank you.");

            this.recipt.close();


        }catch(IOException g){

            //gives error if PrintWriter throws error
            this.setInstructionMsg(4);
            this.view.update();

        }//yrt       

    }//printRecipt
    
}//MailService
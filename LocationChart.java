/*  LocationChart
    Last Modified: 0427/22
    Author: Amber R
    Custom JComponent of chart for locations that can be mailed to
*/

//import classes
import java.awt.*;
import javax.swing.*;

public class LocationChart extends JComponent{

  //declare instance variables
  private int[] pricingList = new int[5];
  private String[] destinationList = new String[5];

  //initialize location chart based on costs and locations provided by model
  public LocationChart(int[] costList, String[] locationList){
  
    super ();

    //initialize variables
    this.pricingList = costList;
    this.destinationList = locationList;

    //set size of component
    this.setPreferredSize(new Dimension(500,131));

  }

  //look of component
  public void paintComponent(Graphics g){

    super.paintComponent(g);

    //write chart information
    g.drawString("Code",1,20);
    g.drawString("Destination (from Toronto, Canada)", 40,20);
    g.drawString("Cost to Send Letter (per 100g)", 255,20);

    //write destination codes
    g.drawString("1", 1,41);
    g.drawString("2",1,61);
    g.drawString("3",1,81);
    g.drawString("4",1,101);
    g.drawString("5",1,121);

    //write locations for each destination
    g.drawString(this.destinationList[0], 40,41);
    g.drawString(this.destinationList[1], 40,61);
    g.drawString(this.destinationList[2], 40,81);
    g.drawString(this.destinationList[3], 40,101);
    g.drawString(this.destinationList[4], 40,121);

    //pull out the costs of each location for chart
    for (int i=0; i<5; i++){

      g.drawString("$" + this.pricingList[i] + ".00", 255, 41 + 20*i);

     }//rof

    //draw cost chart lines
    g.drawLine(1, 26, 500, 26);
    g.drawLine(35, 1, 35, 130);
    g.drawLine(250, 1, 250, 130);

  }//paintComponent

}//LocationChart
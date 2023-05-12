
// Assignment #: Arizona State University CSE205 #6
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30-11:45
//  Description: ReviewPane displays a list of available clubs
//  from which a user can select and compute their total number of members.

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;

import javafx.collections.ObservableList;
import javafx.scene.Node;

//import all other necessary javafx classes here
//----

public class SelectPane extends BorderPane
{
   private ArrayList<Club> clubList;
   private String clubInfo = "?";
   private CheckBox checkbox;
   private Label topLabel, bottomLabel;
   private int totalMembers = 0;
   private VBox vbox;
   private ArrayList<CheckBox> cboxList;
   

   //constructor
   public SelectPane(ArrayList<Club> list)
   {
   	   //initialize instance variables
       this.clubList = list;
       
       //set up the layout
       //----
       
    
       //create an empty pane where you can add check boxes later
       //----
       
       this.vbox = new VBox();
       
      
       topLabel = new Label("Select some clubs");
       this.setTop(topLabel);//sets topLabel at the top of the pane
       bottomLabel = new Label("The total number of members for the selected club(s): " + totalMembers);
       this.setBottom(bottomLabel);
       vbox.getChildren().addAll(topLabel);//adds the topLabel to the vbox
       this.setCenter(vbox);//centers the vbox
       checkbox = new CheckBox();//instantiate the empty checkbox for later
       cboxList = new ArrayList<CheckBox>();//create an array list for the checkbox objects
       

       
       
       //SelectPane is a BorderPane - add the components here
       //----
       

       
   } //end of constructor

 //This method uses the newly added parameter Club object
 //to create a CheckBox and add it to a pane created in the constructor
 //Such check box needs to be linked to its handler class
 public void updateClubList(Club newClub)
 {
     
     checkbox = new CheckBox(newClub.toString());//calls on the toString method from Club.java
     vbox.getChildren().add(checkbox);//putting the new checkbox into the vbox
     cboxList.add(checkbox);//adds checkbox to array list cboxList
     checkbox.setOnAction(new SelectionHandler());//register the event
     
 }
 
  
 //checkbox.setOnAction(new SelectionHandler());

 //create a SelectionHandler class
 private class SelectionHandler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent event) {
		checkbox = (CheckBox) event.getSource();//sets the event
		totalMembers = 0;//sets the totalNumbers to zero when checkbox is unselected
		for (int i = 0; i < cboxList.size(); i++) {
	    	if (cboxList.get(i).isSelected()) {
	    		totalMembers += clubList.get(i).getNumberOfMembers();//adds the number of clubs
	    	}
	    	
	    	
		}
	    
	    bottomLabel.setText("The total number of members for the selected club(s): " + totalMembers);//changes the bottomLabel to reflect the new number of current members
		   
        //Override the abstract method handle()
	}
 }
}
			
 
        
            //When any radio button is selected or unselected
            //the total number of members of selected clubs should be updated
            //and displayed using a label.
            
            



            
        

     
    //end of SelectHandler class
 //end of SelectPane class

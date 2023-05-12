
// Assignment #: Arizona State University CSE205 #6
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30-11:45
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//import all other necessary javafx classes here
//----

public class CreatePane extends HBox
{
	ArrayList<Club> clubList;

    //The relationship between CreatePane and SelectPane is Aggregation
    private SelectPane selectPane;
    private Label title, numMembers, uni, topLabel;//private variables to support encapsulation
    private TextField titleField, numberField, uniField;
    private TextArea tArea;

	//constructor
	public CreatePane(ArrayList<Club> list, SelectPane sePane)
	{
		this.clubList = list;
        this.selectPane = sePane;
        topLabel = new Label("");
        topLabel.setTextFill(Color.RED);//sets the color of the text in topLabel to red
        this.selectPane.setTop(topLabel);//puts the topLabel at the top of the pane
        title = new Label("Title");
        numMembers = new Label("Number of Members");//setting the different labels
        uni = new Label("University");

        //left side
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_CENTER);//aligned the pane to be centered at the top
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));//formatting
        pane.setHgap(1);
        pane.setVgap(5.5);
        

         titleField = new TextField();
         numberField = new TextField();//create the new text fields for user input
         uniField = new TextField();

        pane.add(topLabel, 0, 0, 1, 1);
        
        pane.add(title, 0, 1);
        pane.add(titleField, 1, 1);//adding the components to the pane

        pane.add(numMembers, 0, 2);
        pane.add(numberField, 1, 2);

        pane.add(uni, 0, 3);
        pane.add(uniField, 1, 3);

        Button btCreate = new Button("Create a Club");//making a new button
        pane.add(btCreate, 1, 4);//adding the button to the pane
        //pane.setHalignment(btCreate, HPos.LEFT);
        
        

        
        //Right side
        tArea = new TextArea("No club");
        
        HBox pane2 = new HBox();      
        pane2.getChildren().addAll(tArea);//adding the text area to the pane2
        pane2.setMinSize(200, 200);
        
        
        HBox hbox = new HBox();    //set the horizontal spacing between the nodes    
        hbox.setSpacing(20);    //set the minimum size of the pane's width & height    
        hbox.setMinSize(200,200);    
        hbox.getChildren().addAll(pane, pane2); //adding the left and right panes together
        this.getChildren().addAll(hbox);//putting it all on the same screen
          
        
        
        



        
        
        
        //initialize each instance variable (textfields, labels, textarea, button, etc.)
        //and set up the layout
        //----
        
        //create a GridPane hold those labels & text fields.
        //you can choose to use .setPadding() or setHgap(), setVgap()
        //to control the spacing and gap, etc.
        //----
        
        
        //You might need to create a sub pane to hold the button
        //----
        
        //Set up the layout for the left half of the CreatePane.
        //----
        
        
        //the right half of the CreatePane is simply a TextArea object
        //Note: a ScrollPane will be added to it automatically when there are no
        //enough space
        
        //Add the left half and right half to the CreatePane
        //Note: CreatePane extends from HBox
        //----
        
        //register/link source object with event handler
        //----
        
        btCreate.setOnAction(new ButtonHandler());//sets the button click to be the event

	} //end of constructor

    //Create a ButtonHandler class
    //ButtonHandler listens to see if the button "Create" is pushed or not,
    //When the event occurs, it get a club's Title, its number of members, and its university
    //information from the relevant text fields, then create a new club and add it inside
    //the clubList. Meanwhile it will display the club's information inside the text area.
    //using the toString method of the Club class.
    //It also does error checking in case any of the text fields are empty,
    //or a non-numeric value was entered for its number of members
    private class ButtonHandler implements EventHandler<ActionEvent>
   	 {
   	    //Override the abstract method handle()
   	    public void handle(ActionEvent event)
        {
            //declare any necessary local variables here
            //---
   	    	Club club = new Club();//instantiates a club object
   	    	
   	    	
   	    	
            
            //when a text field is empty and the button is pushed
           if (titleField.getText().equals("") || numberField.getText().equals("") || uniField.getText().equals("")) {
            	topLabel.setText("Please fill all fields");//if any of the fields are empty
            	
           } else {
           
               boolean pass = true;   
               try {
                	int v = 0;
                	v = Integer.parseInt(numberField.getText());
                	
                
               } catch (NumberFormatException nf) {
                	topLabel.setText("Please enter an integer for number of members");//if a non-integer is entered for the numberField
                	pass = false;
               }
               
               if (pass == true) {//if there are no unentered fields or numberformatexceptions
            	   club.setClubName(titleField.getText());//setting up the club object
            	   club.setNumberOfMembers(Integer.parseInt(numberField.getText()));
            	   club.setUniversity(uniField.getText());
            	   boolean duplicate = false;//flag value
            	   for (int i = 0; i<clubList.size(); i++) {

            		   if (club.getClubName().equals(clubList.get(i).getClubName()) && club.getNumberOfMembers() == clubList.get(i).getNumberOfMembers() && club.getUniversity().equals(clubList.get(i).getUniversity())) {//checks to see if the club is a duplicate
            			   
            			   topLabel.setText("Club not added - duplicate");//if there is a duplicate
            			   duplicate = true;
            		   } 
            		   
            		   
	                	   
            		   
            		   //if (tArea.getText().equals("No club")) {
                		  // tArea.setText("");
            		  // }
            	   }
            	   if (duplicate == false) {//if all the conditions are met
	            	   clubList.add(club);//add the club to clubList
	            	   topLabel.setText("Club added");//set the topLabel 
	            	   if (tArea.getText().equals("No club")) {//get rid of the "No club"
	         		  		tArea.setText("");
	            	   }
	            	   tArea.setText(tArea.getText()+ club.toString());//prints out the insformation of the club object
	        		   selectPane.updateClubList(club);//adds each club object to the list
            	   }
            	   
            		  
            	   
               }
                    
            
        }     
     } //end of handle() method
   } //end of ButtonHandler class

}

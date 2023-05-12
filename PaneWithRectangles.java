// Assignment #: Arizona State University CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: PaneWithRectangles class creates a pane where we can use
//               mouse key to drag on grids and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

//import any classes necessary here
//----
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class PaneWithRectangles extends BorderPane
{
   private ComboBox<String> primaryColorCombo;
   private ComboBox<String> backColorCombo;
   private ComboBox<String> widthCombo;
    
   private Color primaryColor, backgroundColor, secondaryColor;
   private Label pcolor, swidth, bcolor;
   private double selectWidth;

   private Rectangle[][] rectArray;
   private GridPane grid;


   public PaneWithRectangles()
   {
       primaryColor = Color.BLACK;
       secondaryColor = Color.GRAY;
       backgroundColor = Color.WHITE;
       selectWidth = 1.0;
       
       //Instantiate and initialize labels, combo boxes
       pcolor = new Label("PrimaryColor");
       swidth = new Label("StrokeWidth");
       bcolor = new Label("BackgroundColor");
       
       primaryColorCombo = new ComboBox<String>();
       primaryColorCombo.getItems().addAll(
           "Black",
           "Blue",
           "Red",
           "Green"
       );//sets up the primary color combo box
       primaryColorCombo.setValue("Black");//sets primary color by default to black
       
       backColorCombo = new ComboBox<String>();
       backColorCombo.getItems().addAll(
               "White",
               "Yellow",
               "Orange"
       );//sets up the background color combo box
       backColorCombo.setValue("White");//sets the default background color to white
       
       widthCombo = new ComboBox<String>();
       widthCombo.getItems().addAll(
               "1",
               "3",
               "5",
               "7"
       );//sets up the width combo box
       widthCombo.setValue("1");//default width = 1
       
       

       //Instantiate and initialize the two dimensional array rectArray
       //to contain 7 columns and 7 rows (49 rectangles total)
       //It is recommended to use nested loops
       
       
       //grid is a GridPane containing 49 rectangles.
       grid = new GridPane();
       grid.setVgap(5);
       grid.setHgap(5);
       rectArray = new Rectangle[7][7];
       for (int i = 0; i<7; i++) {//makes the array of squares
    	   for (int j = 0; j<7; j++) {
    		   rectArray[i][j] = new Rectangle(470/7, 390/7);//given dimensions
    		   rectArray[i][j].setFill(Color.WHITE);
    		   rectArray[i][j].setStroke(Color.BLACK);
    		   grid.add(rectArray[i][j], i, j);
    	   }
       }
       //---- add 49 rectangles to the grid pane, it is recommended to use nested loops
       //----
       //----

       //leftPane is a VBox, it should contain labels and combo boxes
       VBox leftPane = new VBox();
       leftPane.setSpacing(20);//spacing
       leftPane.setPadding(new Insets(10, 0, 10, 0));


       //add the left pane to the left of the pane
       //and the grid pane contains rectangles at the center
       this.setLeft(leftPane);
       this.setCenter(grid);
       leftPane.getChildren().addAll(pcolor, primaryColorCombo, bcolor, backColorCombo, swidth, widthCombo);//adds all the components to the pane
       

      //register/link the source nodes with its handler objects
      grid.setOnMouseDragged(new MouseHandler());
      primaryColorCombo.setOnAction(new PrimColorHandler());//sets up the listeners for the event handlers
      backColorCombo.setOnAction(new BackColorHandler());
      widthCombo.setOnAction(new WidthHandler());
      
      //----
      //----
  
   }
    

   //Step #2(A) - MouseHandler
   private class MouseHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent event)
       {
            //handle MouseEvent here
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            	
            	Node node1 = event.getPickResult().getIntersectedNode();
	           // int yCoordinate = grid.getRowIndex(node1);
	           // int xCoordinate = grid.getColumnIndex(node1);
            	
            	
            	for (int i = 0; i<7; i++) {
      	    	   for (int j = 0; j<7; j++) {
      	    		 rectArray[i][j].setFill(backgroundColor);
      	    	   }
            	}
            	
            	if (grid.getRowIndex(node1) == 0 && (grid.getColumnIndex(node1) == 0)) {//rectArray[0][0] (top left corner)
            		  node1 = event.getPickResult().getIntersectedNode();
            		  
            		//yCoordinate = grid.getRowIndex(node1);
                   // xCoordinate = grid.getColumnIndex(node1);
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);//middle square where clicked gets the primary color
	            		rectArray[grid.getColumnIndex(node1) + 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) + 1].setFill(secondaryColor);//squares around clicked square gets secondary color
                    } 
                    catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            	} if (grid.getRowIndex(node1) == 0 && (grid.getColumnIndex(node1) == 6)) {//rectArray[0][6] (top right corner)
            		
            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);//middle square where clicked gets the primary color
            		rectArray[grid.getColumnIndex(node1) - 1][grid.getRowIndex(node1)].setFill(secondaryColor);
            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) + 1].setFill(secondaryColor);//squares around clicked square gets secondary color
            		
            	} if (grid.getRowIndex(node1) == 6 && (grid.getColumnIndex(node1) == 0)) {//rectArray[6][0] (bottom left corner)
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) + 1][grid.getRowIndex(node1)].setFill(secondaryColor);//gives primary and secondary colors to clicked square
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) - 1].setFill(secondaryColor);//and squares around it
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            		
            	} if (grid.getRowIndex(node1) == 6 && (grid.getColumnIndex(node1) == 6)) {//rectArray[6][6] (bottom right corner)
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) -1][grid.getRowIndex(node1)].setFill(secondaryColor);//adds primary and secondary colors to clicked square and squares around
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) - 1].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            	} if (grid.getRowIndex(node1) == 0 && (grid.getColumnIndex(node1) > 0 && grid.getColumnIndex(node1) < 6)) {//top border from x = 1 to x = 5
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) + 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1) - 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)+1].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            	} if (grid.getRowIndex(node1) == 6 && (grid.getColumnIndex(node1) > 0 && grid.getColumnIndex(node1) < 6)) {//bottom border from x = 1 to x = 5
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) - 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1) + 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)-1].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            	} if (grid.getColumnIndex(node1) == 0 && (grid.getRowIndex(node1) > 0 && grid.getRowIndex(node1) < 6)) {//left border from y = 1 to y = 6
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)-1].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)+1].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)+1][grid.getRowIndex(node1)].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            		
            	} if (grid.getColumnIndex(node1) == 6 && (grid.getRowIndex(node1) > 0 && grid.getRowIndex(node1) < 6)) {//right border from y = 1 to y = 6
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) - 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) - 1].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) + 1].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
                    
            	} else {
            		
                    try {
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1)].setFill(primaryColor);
	            		rectArray[grid.getColumnIndex(node1) - 1][grid.getRowIndex(node1)].setFill(secondaryColor);//if squares not on the border of the pane are clicked
	            		rectArray[grid.getColumnIndex(node1) + 1][grid.getRowIndex(node1)].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) + 1].setFill(secondaryColor);
	            		rectArray[grid.getColumnIndex(node1)][grid.getRowIndex(node1) - 1].setFill(secondaryColor);
                    } catch (Exception NullPointerException)
                    {
                    	
                    }
            	}
            	
            	
            	
            
            }


          
      }//end handle()

   }//end MouseHandler

   //A handler class used to handle primary and secondary colors
   private class PrimColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
          if (primaryColorCombo.getSelectionModel().getSelectedItem().equals("Black")) {//if black is selected in combobox
        	  primaryColor = Color.BLACK;//sets primary color
        	  secondaryColor = Color.GRAY;    //sets secondary color	  
          }
          
          if (primaryColorCombo.getSelectionModel().getSelectedItem().equals("Blue")) {//if blue is selected in combobox
        	  primaryColor = Color.BLUE;
        	  secondaryColor = Color.POWDERBLUE;    	  
          }
          
          if (primaryColorCombo.getSelectionModel().getSelectedItem().equals("Red")) {//if red is selected in combobox
        	  primaryColor = Color.RED;
        	  secondaryColor = Color.PINK;    	  
          }
          
          if (primaryColorCombo.getSelectionModel().getSelectedItem().equals("Green")) {//if green is selected in combobox
        	  primaryColor = Color.GREEN;
        	  secondaryColor = Color.LIGHTGREEN;    	  
          }
          
      }
   }//end PrimColorHandler
    
   //A handler class used to handle background color
    private class BackColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	if (backColorCombo.getSelectionModel().getSelectedItem().equals("White")) {//if background color combobox selection is white
        		for (int i = 0; i<7; i++) {
     	    	   for (int j = 0; j<7; j++) {
     	    		   backgroundColor = Color.WHITE;
     	    		   rectArray[i][j].setFill(backgroundColor);//sets the background color
     	    	   }
        		}
        	} else if (backColorCombo.getSelectionModel().getSelectedItem().equals("Yellow")) {//if yellow
        		for (int i = 0; i<7; i++) {
     	    	   for (int j = 0; j<7; j++) {
     	    		   backgroundColor = Color.YELLOW;
     	    		   rectArray[i][j].setFill(backgroundColor);//sets the background color
     	    	   }
        		}
        	} else if (backColorCombo.getSelectionModel().getSelectedItem().equals("Orange")) {//if orange
        		for (int i = 0; i<7; i++) {
     	    	   for (int j = 0; j<7; j++) {
     	    		   backgroundColor = Color.ORANGE;
     	    		   rectArray[i][j].setFill(backgroundColor);//sets the background color
     	    	   }
        		}
        	}
        	
        }
    }//end BackColorHandler
    
    //A handler class used to handle stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	if (widthCombo.getSelectionModel().getSelectedItem().contentEquals("1")) {//if width combo box selection is 1
        		for (int i = 0; i<7; i++) {
        	    	   for (int j = 0; j<7; j++) {
        	    		   selectWidth = 1.0;
        	    		   rectArray[i][j].setStrokeWidth(selectWidth);//sets width
        	    	   }
        		}	
        	}
        	
        	if (widthCombo.getSelectionModel().getSelectedItem().contentEquals("3")) {//if width 3
        		for (int i = 0; i<7; i++) {
        	    	   for (int j = 0; j<7; j++) {
        	    		   selectWidth = 3.0;
        	    		   rectArray[i][j].setStrokeWidth(selectWidth);//sets the width
        	    	   }
        		}	
        	}
        	if (widthCombo.getSelectionModel().getSelectedItem().contentEquals("5")) {// if width 5
        		for (int i = 0; i<7; i++) {
        	    	   for (int j = 0; j<7; j++) {
        	    		   selectWidth = 5.0;
        	    		   rectArray[i][j].setStrokeWidth(selectWidth);//sets the width
        	    	   }
        		}	
        	}
        	if (widthCombo.getSelectionModel().getSelectedItem().contentEquals("7")) {//
        		for (int i = 0; i<7; i++) {
        	    	   for (int j = 0; j<7; j++) {
        	    		   selectWidth = 7.0;
        	    		   rectArray[i][j].setStrokeWidth(selectWidth);
        	    	   }
        		}	
        	}
            //write your own codes here
            //----
        }
    }//end WidthHandler
} //end of PaneWithRectangles

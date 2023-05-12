// Assignment #: 10
//         Name: Conner Hoban
//    StudentID: 1214317142
//  Lab Lecture: T/Th 10:30
//  Description: The LinkedList class is a class utilized by Assignment
// 10 class to perform various operations on a LinkedList, such as adding 
// strings in alphabetical order, removing strings at indices, etc.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;//each String entered
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;
   private int numberOfNodes;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
      numberOfNodes = 0;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         final NoSuchElementException ex = new NoSuchElementException();
         throw ex;
      } else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst() {
      if (first == null) {
         final NoSuchElementException ex = new NoSuchElementException();
         throw ex;
      } else {
         final Object element = first.data;
         first = first.next; // change the reference since it's removed.
         return element;
      }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(final Object element) {
      // create a new node
      final Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      // change the first reference to the new node.
      first = newNode;
      //numberOfNodes++;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator() {
      return new LinkedListIterator();
   }

   /*********************************************************
    * Add your methods here
    *********************************************************/

   public String toString() {//prints out all the strings in the LinkedList
      ListIterator it = listIterator();
      String result = "{ ";
      while (it.hasNext()) {//tests to see if it.next() == null
         result += it.next() + " ";//concactenation
      }
      return result + "}" + "\n";
   }

   public int size() {
      return numberOfNodes;//keep track of the numberOfNodes throughout code
   }

   public void addElement(final Object element) {
      numberOfNodes++;//adds to the total number of nodes
      ListIterator it = listIterator();//instantiates a LinkedListIterator object
      if (first != null) {
         Node temp = first;//making a temporary Node to traverse through the LinkedList
         String eString = (String) element;//formatting
         String tempString = (String) temp.data;//accessing the string in the node
         while (tempString.compareTo(eString) < 0 && temp!= null) {//checks for alphabetical order
            temp = temp.next;
            if (temp != null) {
               tempString = (String) temp.data;
            }
            it.next();
         }
         

         
      }
      it.add(element);//will be added in the proper place

      
      
      
   }
      

   public void removeElementsAtEvenIndices() {
      
      int index = 0;
      int number = numberOfNodes;
      if (first != null) {
         Node temp = first;
         Node prev = null;
          // Store first node  
         
      
        // If first node is not empty 
         
        if (temp != null && index == 0)  
        {  
            first = temp.next; // Changed head  
            temp = first;         // Change Temp  
            index++;
            numberOfNodes--;
        }  
      
        // Delete occurrences other than first 
        while (temp != null && index<number)  
        {  
              
            // keep track of the previous node  
            // as we need to change 'prev->next'  
            while (temp != null && index%2 != 0)   
            {  
                prev = temp;  
                temp = temp.next;  
                index++;
            }   
            if (temp != null) {
                  prev.next = temp.next; // Unlink the node from linked list
                  temp = prev.next; //Update Temp for next iteration of outer loop
                  numberOfNodes--;
                  index++;
            }

        }
        

      }

   }

   public int howManyAppearBefore(final Object element) {
      int count = 0;
      int index = 0;
      if (first != null) {
         Node temp = first; 
         
         String eString = (String) element;
         String tempString = (String) temp.data;
         while (!tempString.equals(eString) && temp != null && index<numberOfNodes) {
            temp = temp.next;
            if (temp != null) {
               tempString = (String) temp.data;
            }
            count++;//keeps track of number of elements before searched element
            index++;//keeps track of where we are in the LinkedList
            
         }
        

      }
      if (count == numberOfNodes) {
         count = -1;//if the String entered is not in the LinkedList
      }
      return count;
     
   }

   public int indexOfLast(final Object element) {
         int indexOfLast = -1;
         int index = 0;
         
         if (first != null) {
            Node temp = first;
            String eString = (String) element;
            String tempString = (String) temp.data;
            while (index<numberOfNodes) {
               
               if (temp != null && tempString.equals(eString)) {//if the searched string is equal to a string in the linkedlist
                  indexOfLast = index;
               }
               temp = temp.next;
               if (temp != null) {//will take care of last instance of string
                  tempString = (String) temp.data;
               }
               index++;

            }
            
         }
         return indexOfLast;
   }

   public void duplicateEach() {
      if (first != null) {
         
         ListIterator it = listIterator();
         while (it.hasNext()) {
            Object element = it.next();
            it.add(element);//adds each element to itself using the add method
            numberOfNodes++;
            
         }
      }

   }

   public Object removeElementAt(final int i) {
         int index = 0;
         Object tempString = null;//making an object of type string to hold the data
         
         if (i>=numberOfNodes || i<0) {//if index out of bounds
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            throw ex;
         }
         else if (first != null) {
            Node temp = first;//temporary node to traverse the LinkedList
            Node prev = null;
            tempString = (String) temp.data;
            if (i == 0) {
               tempString = first.data;
               first = temp.next; // Changed head  
               temp = first;         // Change Temp  
               index++;
               numberOfNodes--;//keeps track of numberOfNodes

            }
            else {
               while (index<i && temp != null) {//keep moving through the LinkedList
                  prev = temp;
                  temp = temp.next;
                  if (temp != null) {
                     tempString = (String) temp.data;
                  }
                  index++;
                  
               }
               if (temp != null) {
                  tempString = (String) temp.data;
                  prev.next = temp.next; // Unlink the node from linked list
                  temp = prev.next; //Update Temp for next iteration of outer loop
                  numberOfNodes--;
               }
               
               
               

            }
         }
         if (tempString == null) {//if first == null
            final IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            throw ex;
         }
         return tempString;
      
   }

   // nested class to define its iterator
   private class LinkedListIterator implements ListIterator {
      private Node position; // current position
      private Node previous; // it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator() {
         position = null;
         previous = null;
      }

      // Tests if there is an element after the iterator position.
      public boolean hasNext() {
         if (position == null) // not traversed yet
         {
            if (first != null)
               return true;
            else
               return false;
         } else {
            if (position.next != null)
               return true;
            else
               return false;
         }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next() {
         if (!hasNext()) {
            final NoSuchElementException ex = new NoSuchElementException();
            throw ex;
         } else {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
         }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(final Object element) {
         if (position == null) // never traversed yet
         {
            addFirst(element);
            position = first;
         } else {
            // making a new node to add
            final Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            // change the link to insert the new node
            position.next = newNode;
            // move the position forward to the new node
            position = newNode;
         }
         // this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove() {
         if (previous == position) // not after next() is called
         {
            final IllegalStateException ex = new IllegalStateException();
            throw ex;
         } else {
            if (position == first) {
               removeFirst();
            } else {
               previous.next = position.next; // removing
            }
            // stepping back
            // this also means that remove() cannot be called twice in a row.
            position = previous;
         }
      }

      // Sets the last traversed element to a different value.
      public void set(final Object element) {
         if (position == null) {
            final NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class

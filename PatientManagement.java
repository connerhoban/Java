// Assignment #: 11
// Name: Conner Hoban
// StudentID: 1214317142
// Lecture: T/Th 10:30 AM
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.

import java.util.LinkedList;

public class PatientManagement
{
    private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
    private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
    private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.

    private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out

    private Doctor[] doctorList; //an array of doctors
     
  //Constructor to initialize member variables
  public PatientManagement(int numOfDoctors)
    {
        highPriorityQueue = new LinkedList<Patient>();
        intermediateQueue = new LinkedList<Patient>();
        delayedCareQueue = new LinkedList<Patient>();
        checkOutQueue = new LinkedList<Patient>();

        //creating doctor objects
        doctorList = new Doctor[numOfDoctors];
        for (int i=0; i<doctorList.length; i++)
        {
            doctorList[i] = new Doctor(i);
        }
    }
     
   //The printQueue prints out the content
   //of the queues and the array of doctors
   public void printPatientQueues()
     {
         System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
         System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
         System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
         for (int i = 0; i < doctorList.length; i++)
         {
             System.out.println(doctorList[i].toString());
         }
         System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
     }
     
   //More Methods need to be added here

   public boolean addPatient(int patientID, String conditionLevel) {//adds patient to queue
       
       if (conditionLevel.equals("High Priority")) {//if the patient is of condition level high priority
           Patient patient = new Patient(patientID, conditionLevel);//making a new patient object
           highPriorityQueue.add(patient);   //adding to the queue
           return true;
       }

       else if (conditionLevel.equals("Intermediate")) {//if intermediate
           Patient patient = new Patient(patientID, conditionLevel);//making a new patient object
           intermediateQueue.add(patient); //adding to the queue
           return true;
       }

       else if (conditionLevel.equals("Delayed Care")) {//if delayed care
           Patient patient = new Patient(patientID, conditionLevel);
           delayedCareQueue.add(patient);//adding to the queue
           return true;//if added
       }
       else {
            return false;
       }
       
       
   }

   public Patient assignPatientToDoctor() {//assigns patient to doctor
      
         if(!highPriorityQueue.isEmpty()) {//if there is a patient in the high priority queue
                int i = 0;
                if (i<doctorList.length) {//to not have an array index out of bounds exception
                    while (doctorList[i].hasPatient() && i<doctorList.length-1) {
                        i++;//traversing through the doctorList array
                    } 
                    if (!doctorList[i].hasPatient() && i<doctorList.length) {
                            
                        doctorList[i].assignPatient(highPriorityQueue.getFirst());//assigns patient to first available doctor
                        return highPriorityQueue.removeFirst();//returns the patient that has been assigned a doctor
                    }
                } 
                else {
                    return null;
                }
                
                
         }

         else if(!intermediateQueue.isEmpty()) {//if the intermediate queue is empty
                int i = 0;
                if (i < doctorList.length) {//for exceptions
                    while (doctorList[i].hasPatient() && i<doctorList.length) {
                        i++;//traversing through the array
                    }
                    if (!doctorList[i].hasPatient() && i<doctorList.length) {
                        doctorList[i].assignPatient(intermediateQueue.getFirst());//assigns patient to first available doctor
                        return intermediateQueue.removeFirst();
                    }   
                }
                
                else {
                    return null;
                }
         }

         else if(!delayedCareQueue.isEmpty()) {//delayed care queue
                int i = 0;
                if (i<doctorList.length) {
                    while (doctorList[i].hasPatient() && i<doctorList.length) {
                        i++;//traversing through the array
                    }
                    if (!doctorList[i].hasPatient()) {
                        doctorList[i].assignPatient(delayedCareQueue.getFirst());
                        return delayedCareQueue.removeFirst();//returns the patient that has just been assigned a doctor
                    }  
                }
                
                else {
                    return null;
                }
                
         }
      
        return null;
    }

    public Patient releasePatientFromDoctorToCheckOutQueue(int doctorID) {//releases patient from doctor and puts them in the checkOutQueue
            if (doctorID > doctorList.length || doctorID<0) {
                return null;//to watch for exceptions
            }

            else if (doctorList[doctorID].hasPatient()) {
                Patient patient = doctorList[doctorID].releasePatient();//makes a new patient object to show the patient that was released
                checkOutQueue.add(patient);//adds patient to checkOutQue
                return patient;//returns released patient
            } 
        else {
            return null;
        }
        

        
   }

   public Patient checkOutPatient() {
       if (!checkOutQueue.isEmpty()) {
            return checkOutQueue.removeFirst();  //returns first patient in check out que that has been released
       }

       else {
           return null;//returns null in all other cases
       }
       
   }
     
     
}
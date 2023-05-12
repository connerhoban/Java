// Assignment #: 11
// Name: Conner Hoban
// StudentID: 1214317142
// Lecture: T/Th 10:30 AM
// Description: The Doctor class creates a doctor object, to which patients can be assigned


public class Doctor
 {
  private int doctorID;
  private Patient currentPatient;

  //Constructor to initialize member variables
  //Initially no patient is assigned
  public Doctor(int id)
   {
    this.doctorID = id;
    currentPatient = null;
   }

  //toString method returns a string containing
  //the information of a doctor 
  public String toString()
   {
    String result = "Doctor id " + doctorID;

    if (currentPatient == null)
      result += " is not seeing any patient";
    else
      result += " is seeing a patient with id " + currentPatient.getPatientID();

    return result;
   }
     
  //More Methods need to be added here

  public boolean hasPatient() {//checks to see if doctor currently has a patient assigned to them
      boolean hasPatient = true;
      if (currentPatient == null) {
          hasPatient = false;//if no patients
      }
      return hasPatient;
  }

  public boolean assignPatient(Patient patient1) {//assigns patient to doctor
        boolean assignPatient = true;
        if (hasPatient()) {
            assignPatient = false;//if there is already a patient assigned to that doctor
        }
        else {
            currentPatient = patient1;//assign the current patient to the doctor
        }
        return assignPatient;
      
  }

  public Patient releasePatient() {//release the patient from the doctor
        Patient released = null;
        if (hasPatient()) {
            released = currentPatient;
            currentPatient = null;//sets the doctor's current patient back to null
        }
        return released;//returns the released patient
  }
     
 }

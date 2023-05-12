// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: RoboticsCamp class creates a RoboticsCamp object of type SummerCamp
import java.util.Locale;
import java.text.NumberFormat;
public class RoboticsCamp extends SummerCamp {//to allow for inheritance
  private double facilityFee;
  private double competitionFee;
  Locale us = new Locale("en","US");//format into USD
  NumberFormat usMoney = NumberFormat.getCurrencyInstance(us);

  public RoboticsCamp(String title, String location, double rate,//constructs a RoboticsCamp object
  int weeks, double facilFee, double compFee){
    super(title, location, rate, weeks);
    facilityFee = facilFee;
    competitionFee = compFee;
  }

  public void computeTotalCosts() {
    super.totalCost = (super.weeklyRate * super.numberOfWeeks) +//calculates the total cost
    facilityFee + competitionFee;
  }

  public String toString() {//inherited from SummerCamp
    return "\nRobotics Camp:" + super.toString() + "Facility Fee:\t\t"
    + usMoney.format(facilityFee) + "\n" + "Competition Fee:\t" + usMoney.format(competitionFee) +//displays the information about the newly constructed RoboticsCamp object
    "\n\n";
  }
}

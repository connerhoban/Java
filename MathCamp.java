// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: MathCamp class constructs a MathCamp object of type SummerCamp
import java.util.Locale;
import java.text.NumberFormat;
public class MathCamp extends SummerCamp {
  private boolean testTaking;
  Locale us = new Locale("en","US");//set to US Dollars
  NumberFormat usMoney = NumberFormat.getCurrencyInstance(us);

  public MathCamp(String title, String location, double rate, int weeks, String tTaking) {//constructor for a MathCamp object
    super(title, location, rate, weeks);
    if (tTaking.equals("yes")) {
      testTaking = true;//condition to show if test taking is selected
    } else {
      testTaking = false;
    }
  }

  public void computeTotalCosts() {
    if (testTaking == true) {
      super.totalCost = super.weeklyRate * super.numberOfWeeks + 25;//total cost if there is test taking
    } else {
      super.totalCost = super.weeklyRate * super.numberOfWeeks;//total cost if no test taking
    }
  }

  public String toString() {
    if (testTaking == true) {
      return "\nMath Camp:" + super.toString() + "Test Taking:\t\tyes\n\n";//shows the information about the object if there is test taking
    } else {
      return "\nMath Camp:" + super.toString() + "Test Taking:\t\tno\n\n";//shows the information about the object if there is no test taking
    }
  }

}

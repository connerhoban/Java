// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: DebateCamp class is to construct a DebateCamp object of type SummerCamp
import java.util.Locale;
import java.text.NumberFormat;
public class DebateCamp extends SummerCamp {//extends SummerCamp class to be able to use its methods
  private double materialFee;
  private boolean groupDiscount;
  Locale us = new Locale("en","US");//set to USD
  NumberFormat usMoney = NumberFormat.getCurrencyInstance(us);

  public DebateCamp(String title, String location, double rate,//constructor for the DebateCamp object
  int weeks, double fee, String discount) {
    super(title, location, rate, weeks);
    materialFee = fee;
    if (discount.equals("yes")) { //sets up the conditions for a group discount
      groupDiscount = true;
    } else {
      groupDiscount = false;
    }
  }

  public void computeTotalCosts() {//inherited from SummerCamp
    if (groupDiscount == true) {
      super.totalCost = (super.weeklyRate * super.numberOfWeeks * 0.9)//total cost with discount
      + materialFee;
    } else {
      super.totalCost = (super.weeklyRate * super.numberOfWeeks) +//total cost without discount
      materialFee;//total cost without discount
    }
  }
  
  public String toString() {

    if (groupDiscount == true) {
      return "\nDebate Camp:" + super.toString() + "Material Fee:\t\t" +
      usMoney.format(materialFee) + "\n" + "Group Discount:\t\tyes\n\n";//displays the information about the object if there is a discount
    } else {
      return "\nDebate Camp:" + super.toString() + "Material Fee:\t\t" +
      usMoney.format(materialFee) + "\n" + "Group Discount:\t\tno\n\n";//displays the information about the object if there is no discount
    }

  }
}

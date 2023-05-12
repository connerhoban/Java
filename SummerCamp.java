// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: SummerCamp class is an abstract super class of the debate, math, and robotics camps that allows them to use certain methods
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Currency;//all of the imports are to allow formatting to US currency
public abstract class SummerCamp {
  protected String title;
  protected String location;
  protected double weeklyRate;//all the variables are protected to allow for polymorphism
  protected int numberOfWeeks;
  protected double totalCost = 0.0;
  Locale us = new Locale("en","US");//set to US Dollars
  NumberFormat usMoney = NumberFormat.getCurrencyInstance(us);

  public SummerCamp(String t, String l, double rate, int weeks) {//constructs a SummerCamp object with the given parameters
    title = t;
    location = l;
    weeklyRate = rate;
    numberOfWeeks = weeks;
    totalCost = 0.0;
  }

  public String getCampTitle() {//returns the title
    return title;
  }

  public abstract void computeTotalCosts();//leaves it as abstract so the subclasses can use this method

  public String toString() {//displays the informationa bout the summer camp
    return "\nCamp Title:\t\t" + title + "\n" + "Location:\t\t" + location
    + "\n" + "Weekly Rate:\t\t" + usMoney.format(weeklyRate) + "\n" + "Weeks:\t\t\t"
    + numberOfWeeks + "\nTotal Cost:\t\t" + usMoney.format(totalCost) + "\n";
  }
}

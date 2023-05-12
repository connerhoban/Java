// Assignment #: 5
// Arizona State University - CSE205
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: SummerCampParser class is to take the information entered by the user and use it to construct a summer camp object.  From that information, it determines
//                whether that object will be MathCamp, DebateCamp, or RoboticsCamp
public class SummerCampParser {

  public static SummerCamp parseStringToSummerCamp (String lineToParse) {
    String[] parse = new String[7];
    SummerCamp camp = null;
    parse = lineToParse.split(":");//splits the string into substrings around the character :
    String type = parse[0];
    if (type.equals("DebateCamp")){//conditions to make a DebateCamp object
      String title = parse[1];
      String location = parse[2];
      double weeklyRate = Double.parseDouble(parse[3]);//setting the input to represent the necessary values
      int numberOfWeeks = Integer.parseInt(parse[4]);
      double materialFee = Double.parseDouble(parse[5]);
      String discount = parse[6];
      camp = new DebateCamp(title, location, weeklyRate, numberOfWeeks, materialFee, discount);//calls the constructor from DebateCamp

    } else if (type.equals("MathCamp")) {//conditions to make a MathCamp object
      String title = parse[1];
      String location = parse[2];
      double weeklyRate = Double.parseDouble(parse[3]);
      int numberOfWeeks = Integer.parseInt(parse[4]);//setting the input to represent the necessary values to create the object
      String testTaking = parse[5];
      camp = new MathCamp(title, location, weeklyRate, numberOfWeeks, testTaking);//calls the constructor from class MathCamp

    }else {
      String title = parse[1];
      String location = parse[2];
      double weeklyRate = Double.parseDouble(parse[3]);
      int numberOfWeeks = Integer.parseInt(parse[4]);
      double facilityFee = Double.parseDouble(parse[5]);//setting the input to represent the necessary values to create the object
      double competitionFee = Double.parseDouble(parse[6]);
      camp = new RoboticsCamp(title, location, weeklyRate, numberOfWeeks, facilityFee, competitionFee);//calls the constructor from class RoboticsCamp
    }
    return camp;
  }
}

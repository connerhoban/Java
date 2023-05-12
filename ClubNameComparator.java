// Assignment #: 8
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The ClubNameComparator class implements the comparator interface to compare the 
//                names of the clubs to sort them
import java.util.Comparator;
public class ClubNameComparator implements Comparator<Club> {//compares the first letter of the club names

    public int compare(Club first, Club second) {
       int reported = 0;
       reported = first.getClubName().compareTo(second.getClubName());
       return reported;
    }
    
}

// Assignment #: 8
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The MemberNumberComparator implements the comparator interface to compare the 
//                names of the clubs to sort them
import java.util.Comparator;
public class MemberNumberComparator implements Comparator<Club> {
    public int compare(Club first, Club second) {//makes use of the comparator interface to compare the number of members
        int result = 0;
        result = first.getNumberOfMembers() - second.getNumberOfMembers();//if positive, first>second
        return result;
    }
}

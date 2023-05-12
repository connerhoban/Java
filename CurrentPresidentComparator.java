// Assignment #: 8
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The CurrentPresidentComparatorClass implements the comparator interface to compare the 
//                names of the clubs to sort them
import java.util.Comparator;
public class CurrentPresidentComparator implements Comparator<Club> {
    public int compare(Club first, Club second) {//compares the last and then first names of the presidents to sort them
        int result = 0;
        result = first.getCurrentPresident().getLastName().compareTo(second.getCurrentPresident().getLastName());
        if (result == 0) {
            result = first.getCurrentPresident().getFirstName().compareTo(second.getCurrentPresident().getFirstName());
        }
        return result;
    }
}
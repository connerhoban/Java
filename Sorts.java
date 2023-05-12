// Assignment #: 8
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The Sorts class calls upon the different comparator methods to complete a selection sort of the 
// club objects based on their respective parameters
import java.util.Comparator;
public class Sorts {


    public static void sort(Club[] clubList, int size, Comparator<Club> comparator) {
            //selection sort
            int min;
            for (int i = 0; i < size -1; i++) {
                min = i;
                for (int scan = i + 1; scan < size; scan++) {
                    if (comparator.compare(clubList[scan], clubList[min]) <0) {//if club 1 < club 2
                        min = scan;//now the new location of the minimum
                    }
                    swap (clubList, min, i);
                }
            }

    }
    public static void swap(Club[] clubList, int min, int i) {
        Club temp = clubList[min];
        clubList[min] = clubList[i];//switch positions
        clubList[i] = temp;
    }
}

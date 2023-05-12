// Assignment #: 8
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The ClubManagement class works with clubs and an array of clubs to perform multiple different functions

import java.io.Serializable;
public class ClubManagement implements Serializable {
    private Club[] clubList;
    private int numberOfClubs;
    private int maxSize;
    private static final long serialVersionUID = 1L;//for serializable
    public ClubManagement(int maximumsize) {
        this.numberOfClubs = 0;
        this.maxSize = maximumsize;
        clubList = new Club[maxSize];//makes a new club array
        
    }
    public int clubExists(String clubName, String university) {//returns the index
        int index = -1;
        for (int i = 0; i< numberOfClubs; i++) {
            Club club = clubList[i];
            if (club.getClubName().equals(clubName) &&
            club.getUniversity().equals(university)) {//if the club already exists
                index = i; //setting index equal to the position
            }
        }
        return index;//not found by default, changes if the  club already exists
        }

    public int currentPresidentExists(String firstName, String 
    lastName, String academicLevel) {
        int index = -1;
        //president's first name, last name, academic level
        for (int i = 0; i < numberOfClubs; i++) {
            Club club = clubList[i];
            if (club.getCurrentPresident().getLastName().equals(lastName) &&//testing the conditions
            club.getCurrentPresident().getFirstName().equals(firstName)) {
                index = i; 
            }
        
        }
        return index;
        
    }
    public boolean addClub(String clubName, int numberOfMembers, String university,
    String firstName, String lastName, String academicLevel) {
        //add a club object to club list and return true if added and false
        //if can't add due to the array being full or it being duplicate
        boolean isAdded = false;//false by default
        int flag1 = clubExists(clubName, university);
        //int flag2 = currentPresidentExists(firstName, lastName, academicLevel);
        if (flag1 == -1){
            if (numberOfClubs<maxSize) {
                
                Club club = new Club();
                club.setClubName(clubName);
                club.setNumberOfMembers(numberOfMembers);//calling the methods from club.java to set the values
                club.setUniversity(university);
                club.setCurrentPresident(firstName, lastName, academicLevel);
                clubList[numberOfClubs] = club;//add it to the list of clubs
                numberOfClubs++;//incremement the number of clubs
                isAdded = true;
            }
        }
        return isAdded;
    } 
    public boolean removeClub(String clubName, String university) {
        boolean isRemoved = false;
        for (int i = 0; i<numberOfClubs; i++) {
            if (clubList[i].getClubName().equals(clubName) &&
            clubList[i].getUniversity().equals(university)){//if there is a club that matches with the search parameters
                isRemoved = true;
                numberOfClubs--;//decrement the number of clubs
                for(int j = i; j < maxSize; j++){
                    clubList[i] = clubList[i+1];//shift all the values of the array after the club removed over one to the left
                   
                }
            }
        }

        return isRemoved;//if removed
    }
    public void sortByClubNames() {//sorts by club names using ClubNameComparator
        ClubNameComparator nameComparator = new ClubNameComparator();
        Sorts.sort(this.clubList, this.numberOfClubs, nameComparator);
        
   }
   public void sortByMemberNumbers() {//sorts by club member number using MemberNumberComparator
        MemberNumberComparator numberComparator = new MemberNumberComparator();
        Sorts.sort(clubList, numberOfClubs, new MemberNumberComparator()); 
   }
    public void sortByCurrentPresidents() {//uses president comparator
        CurrentPresidentComparator presComparator = new CurrentPresidentComparator();
        Sorts.sort(clubList, numberOfClubs, presComparator);
   }
    public String listClubs() {//calls on the toString method
        String str = "";
        for (int i = 0; i<numberOfClubs; i++) {
                str += clubList[i].toString();
        }
        if (str.equals("")){
            str = "\nno club\n\n";
        }
        return str;
    }
    public void closeClubManagement() {//closes club management
        
        clubList = new Club[maxSize];
        numberOfClubs = 0;
    }
}
// Assignment #: 9
//         Name: Conner Hoban
//    StudentID: 1214317142
//      Lecture: T/Th 10:30
//  Description: The Assignment 9 class takes integers inputted from the user, puts them into an array, 
//               and then uses recursive methods to return the minimum number, count of odd integers, 
//               largest even integer, and the sum of numbers larger than the first number
//               
import java.io.*;//import statement
public class Assignment9 {
    
    
    public static void main (String[] args) {
        try {
           InputStreamReader isr = new InputStreamReader (System.in);//setting up the readers
           BufferedReader stdin = new BufferedReader (isr);//setting up the readers
           int[] numbers = new int[100];//initializing the array
           String elementString;
           int element; 
           for (int i = 0; i<99; i++) { //sets up the for loop to add elements into the array
            elementString = stdin.readLine();//reads the input
            element = Integer.parseInt(elementString);//gathers the integer from the inputted String
            numbers[i] = element;//adding the elements to each position of the array
            //System.out.println(element);
            if (element == 0) {
                int endIndex = i;//keep track of how many elements have been entered
                int startIndex = 0;
                i = 99;//ends the for loop
                System.out.println("The minimum number is " + findMin(numbers, startIndex, endIndex));
                System.out.println("The count of odd integers in the sequence is " + countOddNumbers(numbers, startIndex, endIndex));//print statements
                System.out.println("The largest even integer in the sequence is " + computeLargestEven(numbers, startIndex, endIndex));
                System.out.println("The sum of numbers larger than the first is " + sumOfNumbersLargerThanFirst(numbers, startIndex, endIndex)); 
            }
           }
           


        }
        catch (IOException e) {
            System.out.print("IOException " + e);
        }
    }
    public static int findMin(int[] numbers, int startIndex, int endIndex) {//finds the minimum in the sequence
        int min = 0;
        if (startIndex == endIndex) {//base case
            min = numbers[startIndex];
            
            
        }
        else {
            
            if (numbers[startIndex] < numbers[endIndex]) {
            
                return findMin(numbers, startIndex, endIndex-1);//numbers[startIndex] is the current min
            }
            else if (numbers[endIndex] < numbers[startIndex]) {
                
                return findMin(numbers, startIndex+1, endIndex);//numbers[endIndex] is the current min
            }
            else if (numbers[startIndex] == numbers[endIndex]) {
                return findMin(numbers, startIndex, endIndex - 1);//numbers[startIndex] is the current min
            }
            
            
            
        }
        return min;
        
        
    }
    public static int countOddNumbers(int[] numbers, int startIndex, int endIndex) {//returns a count of the odd numbers in the sequence
        int countOdds = 0;

        
        if (startIndex > endIndex) {//base case
            return countOdds;
        }
        else {
        
            if ((numbers[startIndex]%2) != 0) {//if numbers[startIndex] is odd
                countOdds++;
                countOdds+= countOddNumbers(numbers, startIndex + 1, endIndex);//calls the recursive method
            }
            else {
                return countOddNumbers(numbers, startIndex + 1, endIndex);//move through the array if even without adjusting the count
            }
        }
        return countOdds;
    }

    public static int computeLargestEven(int[] numbers, int startIndex, int endIndex) {//method to return the largest even number in the sequence of integers
        int largest = 0;
        if (startIndex > endIndex) {//base case
            largest = numbers[startIndex];
        }
        else {
            if ((numbers[startIndex]%2)==0) {//if numbers[startIndex] is even
                if (numbers[startIndex]>numbers[endIndex]) {
                    
                    return computeLargestEven(numbers, startIndex, endIndex-1);//numbers[startIndex] is the current maximum even integer
                }
                else if (numbers[startIndex]<numbers[endIndex]) {
                    if (numbers[endIndex]%2 == 0) {//if numbers[endIndex] is even
                        return computeLargestEven(numbers, startIndex+1, endIndex);//numbers[endIndex] is the current maximum even integer
                    }
                    else {
                        return computeLargestEven(numbers, startIndex, endIndex-1);
                    }
                }
                else {
                    return computeLargestEven(numbers, startIndex, endIndex-1);//numbers[startIndex] is the current maximum even integer
                }
            }
            else {
                return computeLargestEven(numbers, startIndex+1, endIndex);//shifts through the array if numbers[startIndex] is odd
            }
        }
        return largest;
    }

    public static int sumOfNumbersLargerThanFirst(int[] numbers, int startIndex, int endIndex) {//returns the sum of entered numbers larger than the first entered number
        int sum = 0;
        if (startIndex == endIndex) {//base case
            return sum;
        }
        else {
            if (numbers[startIndex]<numbers[endIndex]) {
                sum += numbers[endIndex];//add to the sum
                sum += sumOfNumbersLargerThanFirst(numbers, startIndex, endIndex-1);//call the recursive method to keep adding to the sum
            }
            else {
                return sumOfNumbersLargerThanFirst(numbers, startIndex, endIndex-1);//shift through the array
            }
        }
        return sum;
    }
}
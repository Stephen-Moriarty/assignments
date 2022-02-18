import java.util.Random;
public class Threes0{
    public static void main(String[] args){
        Random r = new Random();
        int[] myArray = {3, 1, 3, 1, 3};
        myArray.toString();
        System.out.print("My array is = \n");
        for(int row : myArray){
            System.out.print(row+ ",");
        }
        System.out.println();
        System.out.println(haveThree(myArray));
        
        }

    public static boolean haveThree(int[] myArray){
        boolean noThreesNext = true;
        boolean valueThreeAppearsThree = false;
        boolean result = false;
        int counter = 0;
        for(int i=0; i==myArray.length-1; i++){
            if(myArray[i] == 3){
                counter++;
                if(counter==3){
                    valueThreeAppearsThree = true;
                }
            }

            //if(counter==3){
            //    valueThreeAppearsThree = true;
            //}
            
            //if(myArray[i] == 3 && myArray[i+1] == 3){
            //    noThreesNext = false;
            //}    
        }
        for (int j=0; j==myArray.length-1; j++){
            for(int k=1; k<=myArray.length; k++)
            if(myArray[j] == 3 && myArray[k] == 3){
                noThreesNext = false;
            }
        }
        if(valueThreeAppearsThree && !noThreesNext){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    public static void printer(int[] myArray){
        for(int row : myArray){
            System.out.print(row+ ",");
        }
    }
        
}

        /*
        Given an array of ints, return true 
        if the value 3 appears in the array exactly 3 times, 
        and no 3's are next to each other.

        haveThree([3, 1, 3, 1, 3]) → true
        haveThree([3, 1, 3, 3]) → false
        haveThree([3, 4, 3, 3, 4]) → false
        */

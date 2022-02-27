import java.util.Scanner;
import java.util.Random;
public class MatrixMethods1 {
    static Random r = new Random();
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        /*
        For this assignment, create a program with the methods listed below. You are highly encouraged to reference past assignments in order to make these methods.

Include methods for:

Generating an array
random and incremental
Generating a square matrix of size n
random and incremental
Printing a 2 dimensional array
not guaranteed to be square
Calculating the trace of a matrix
matrix should be auto generated
Transposing a matrix
original matrix auto generated
Rotating a square array 90 deg to the right
original matrix auto generated
Rotating a square array 90 deg to the left
original matrix auto generated 
Hint: remember rotating to the left is rotating to the right three times
These should be user selectable through a reasonable means, such as a switch case. Each case should ask for appropriate input.

Printing a multidimensional array should NOT be selectable from a menu. You should use it in your other methods
Generating a square matrix of size n should NOT be selectable from a menu. You should use it in your other methods.
        */
        /*
        for loop copy paste:
        for(int i=0; i<s.length-1; i++){
            for(int j=0; j<s.length-1; j++){

            }
        }
        */
        int userNum = 0;
        int userY = 0;
        int userX = 0;
        int testNum = 4;
        
        String input = "0";
        char choice = '0';
        boolean keepGoing = true;
        System.out.println("Og:");
        sqToString((auto()));
        
        do{
            
            System.out.print("Would you like to:\n0.)Generate an array?\n1.)Calculate the trace of a matrix?\n2.)Transpose a matrix?\n3.)Rotate a square matrix 90 deg to the left?\n4.)Rotate a square matrix 90 deg to the right?\n5.)Get an array of a size of your choosing?\n6.)Not want\n>");
            input = "0";
            input = k.next();
            choice = input.charAt(0);
            
            switch(choice){
                case '0':
                    //Generating an array
                    //random and incremental:
                    System.out.print("What size do you want your array?\n>");
                    userNum = k.nextInt();
                    //Printing a 2 dimensional array
                    //not guaranteed to be square:
                    arToString(fillAr(userNum));
                break;

                case '1':
                    System.out.print("The trace:");
                    System.out.println(trace(auto()));
                break;

                case '2':
                    System.out.println("Transposed:");
                    sqToString(transpose(auto()));
                break;

                case '3':
                    System.out.println("Rotated left:");
                    sqToString(rL(auto()));
                break;

                case '4':
                    System.out.println("Rotated right:");
                    sqToString(rR(auto()));
                break;
                case '5':
                    System.out.print("What size do you want your y?\n>");
                    userY = k.nextInt();
                    System.out.print("What size do you want your x?\n>");
                    userX = k.nextInt();
                    nonSqToString(fillNonSquare(userY, userX), userY, userX);
                break;
                case '6':
                    keepGoing = false;
                    System.out.println("Okay bye.");
                break;

                default:
                    System.out.println("Not an option, try again.");
            }
        }while(keepGoing);

        
        
        // //Generating a matrix of size n:
        // System.out.print("What size do you want your square matrix?\n>");
        // userNum = k.nextInt();
        // sqToString(fillSq(userNum));

    }
    
    public static int[] fillAr(int n){
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }
    
    public static int trace(int[][] s){
        int theTrace = 0;
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length; j++){
                if(i==j){
                    theTrace += s[i][j];
                }
            }
        }
        return theTrace;
    }

    //For non sqaure matrix
    public static int[][] fillNonSquare(int y, int x){
        int c = 0;
        int[][] matrix = new int[y][x];
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                matrix[i][j] = c++;
            }
        }
        return matrix;
    }
    //for square
    public static int[][] fillSq(int n){
        int c = 0;
        int[][] matrix = new int[n][n];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                matrix[i][j] = c++;
            }
        }
        return matrix;
    }
    public static int[][] auto(){
        int n = 3;
        int c = 0;
        int[][] matrix = new int[n][n];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                matrix[i][j] = c++;
            }
        }
        return matrix;
    }

    //These three go together
    public static void arToString(int[] arr){
        for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] + " ");   
        }
        System.out.println();
    }
    public static void sqToString(int[][] matr){
        for(int i=0; i<matr.length; i++){
            for(int j=0; j<matr.length; j++){
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void nonSqToString(int[][] matr, int y, int x){
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //Rotate
    public static int[][] rL(int[][] s){
        int[][] rM = new int[s.length][s.length];
        int y = 2;
        int x = 0;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                
                rM[y][x] = s[i][j];
                y--;
                
                if(y==0){
                    y=2;
                    x++;
                }
                if(x>2){
                    x=0;
                }
                
            }
        }
        return rM;
    }

    public static int[][] rR(int[][] s){
        int[][] rM = new int[s.length][s.length];
        int y = 0;
        int x = 2;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                
                rM[y][x] = s[j][i];
                x--;
                
                if(x==0){
                    x=2;
                    y++;
                }
                if(y>2){
                    y=0;
                }
                
            }
        }
        return rM;
        
    }
    public static int[][] transpose(int[][] s){
        int[][] tM = new int[s.length][s.length];
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length; j++){ 
                if(i==j){
                    tM[i][j] = s[i][j];
                }else{
                    
                    tM[j][i] = s[i][j];
                }
            }
        }
        return tM;
    }

}

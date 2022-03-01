import java.util.Scanner;
import java.util.Random;

public class MatrixMethods2 {
    static Random r = new Random();
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        int userNum = 3;
        int userY = 0;
        int userX = 0;

        boolean increment = false;
        boolean keepGoing = true;
        boolean nC = false;

        String input = "0";
        char choice = '0';
        
        do{
            do{
                System.out.print("Would you like to:\n0.)Have random?\n1.)Have incremental?\nor\n2.)Change default size of square matrix?\n>");
                input = "0";
                input = k.next();
                choice = input.charAt(0);
                switch(choice){
                    case '0':
                        increment = false;

                        nC = false;
                    break;

                    case '1':
                        increment = true;

                        nC = false;
                    break;
                    case '2':
                        System.out.print("What size do you want the next matrix to be?\n>");
                        userNum = k.nextInt(); 
                        nC = true;
                    break;

                    default:
                    tryAgain();
                    nC = true;
                }
            }while(nC);

            System.out.print("Would you like to:\n0.)Generate an array?\n1.)Calculate the trace of a matrix?\n2.)Transpose a matrix?\n3.)Rotate a square matrix 90 deg to the left?\n4.)Rotate a square matrix 90 deg to the right?\n5.)Get an matrix of a size of your choosing?\n6.)Go back to first set of options?\n7.)End program?\n>");
            input = "0";
            input = k.next();
            choice = input.charAt(0);
            
            switch(choice){
                case '0':
                    System.out.print("What size do you want your array?\n>");
                    userNum = k.nextInt();
                    arToString(fillAr(userNum, increment));
                break;

                case '1':
                    System.out.println(trace(auto(userNum,increment)));
                break;

                case '2':
                    sqToString(transpose(auto(userNum,increment)));
                break;

                case '3':
                    sqToString(rL(auto(userNum,increment)));
                break;

                case '4':
                    sqToString(rR(auto(userNum,increment)));
                break;

                case '5':
                    System.out.print("What size do you want your y? (How far down)\n>");
                    userY = k.nextInt();
                    System.out.print("What size do you want your x? (How far right)\n>");
                    userX = k.nextInt();
                    nonSqToString(fillNonSquare(userY, userX, increment), userY, userX);
                break;

                case '6':
                    keepGoing = true;
                break;
                case '7':
                    keepGoing = false;
                    System.out.println("Okay bye.");
                break;

                default:
                    tryAgain();
            }
        }while(keepGoing);
    }
    
    //Fills:
    public static int[] fillAr(int n, boolean incremental){
        int[] arr = new int[n];
        if(incremental){
            for(int i=0; i<arr.length; i++){
                arr[i] = i;
            }
        }else{
            for(int i=0; i<arr.length; i++){
                arr[i] = r.nextInt(9)+1;
            }
        }
        return arr;
    }
    public static int[][] fillNonSquare(int y, int x, boolean incr){
        int c = 0;
        int[][] matrix = new int[y][x];
        
        if(incr){
            for(int i=0; i<y; i++){
                for(int j=0; j<x; j++){
                    matrix[i][j] = c++;
                }
            }
        }else{
            for(int i=0; i<y; i++){
                for(int j=0; j<x; j++){
                    matrix[i][j] = r.nextInt(9)+1;
                }
            }
        }
        return matrix;
    }
    public static int[][] auto(int s, boolean incr){
        int c = 0;
        int[][] matrix = new int[s][s];
        if(incr){
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix.length; j++){
                    matrix[i][j] = c++;
                }
            }
        }else{
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix.length; j++){
                    matrix[i][j] = r.nextInt(9)+1;
                }
            }
        }
        return matrix;
    }
    //Trace
    public static int trace(int[][] s){
        printer(s);
        int theTrace = 0;
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length; j++){
                if(i==j){
                    theTrace += s[i][j];
                }
            }
        }
        System.out.print("The trace of that matrix is: ");
        return theTrace;
    }
    //Printers:
    public static void arToString(int[] arr){
        System.out.print("(");
        for(int i=0; i<arr.length; i++){
            if(i<arr.length-1){
                System.out.print(arr[i] + ",");
            }else{
                System.out.print(arr[i]);
            }
                
        }
        System.out.print(")\n");
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
    public static void printer(int[][] ogMatrix){
        System.out.println("The matrix is:");
        sqToString(ogMatrix);
    }
    public static void modIs(){
        System.out.println("The modified matrix is:");
    }
    public static void tryAgain(){
        System.out.println("Not an option, try again.");
    }
    //Rotate methods:
    public static int[][] rL(int[][] s){
        printer(s);
        int[][] rM = new int[s.length][s.length];
        int y = s.length;
        int x = 0;
        
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length; j++){
                y--;
                if(y<0){
                    y=s.length-1;
                    x++;
                }
                rM[y][x] = s[i][j];
                if(x>s.length-1){
                    x=0;
                }  
            }
        }
        modIs();
        return rM;
    }
    public static int[][] rR(int[][] s){
        printer(s);
        int[][] rM = new int[s.length][s.length];
        int y = 0;
        int x = s.length;
        
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length; j++){
                x--;
                if(x<0){
                    x=s.length-1;
                    y++;
                }
                rM[y][x] = s[j][i];
                if(y>s.length-1){
                    y=0;
                }  
            }
        }
        modIs();
        return rM; 
    }
    //transposer:
    public static int[][] transpose(int[][] s){
        printer(s);
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
        modIs();
        return tM;
    }  
}

import java.util.Scanner;
public class ModifyString0 {
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Hello user, give me a string.\n>");
        String userString = k.nextLine();
        //int counter=3;
        //System.out.println(withoutEnd(userString));
        withoutEnd(userString);

    }
    // Doesn't work yet:
    // public static String withoutEnd(String userString){
    //     String newString = "";
    //     char newChar = ' ';
    //     for(int i=1;  i<userString.length()-1; i++){
    //         newChar = userString.charAt(i);
    //         newString = newChar + "";
    //     }
    //     newString = newChar + "";
    //     return newString;
    // }

    // Works fine but (technically) wrong
    public static void withoutEnd(String userString){
        String newString = userString;
        for(int i=1;  i<userString.length()-1; i++){
            System.out.print(newString.charAt(i));
        }
    }

}

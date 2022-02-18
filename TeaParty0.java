import java.util.Scanner;
public class TeaParty0 {
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        int tea = 0;
        int candy = 0;
        System.out.print("Give me the amount of candy.\n>");
        candy = k.nextInt();
        System.out.print("Give me the amount of tea.\n>");
        tea = k.nextInt();
        
        teaParty(tea, candy);
        if(teaParty(tea, candy) == 0){
            System.out.println(teaParty(tea, candy) + "=bad");
        }else if(teaParty(tea, candy) == 1){
            System.out.println(teaParty(tea, candy) + "=good");
        }else{
            System.out.println(teaParty(tea, candy) + "=great");
        }
        
    }

    public static int teaParty(int tea, int candy){
        int conclusion = 0;
        if(tea >= candy*2 || candy >= tea*2){
            conclusion = 2;
        }else if(tea>=5 && candy>=5){
            conclusion = 1;
        }
        else if(tea<5 || candy<5){
            conclusion = 0;
        }
        return conclusion;
    }

}



/*
        We are having a party with amounts of tea and candy. 
        Return the int outcome of the party encoded 
        as 0=bad, 1=good, or 2=great. 
        A party is good (1) if both tea and candy are at least 5. 
        However, if either tea or candy is at least double the amount of the other one, 
        the party is great (2). 
        However, in all cases, if either tea or candy is less than 5, the party is always bad (0).

        teaParty(6, 8) → 1
        teaParty(3, 8) → 0
        teaParty(20, 6) → 2
        Within your main method, allow the user to type in values that are 
        passed to these parameters for testing and printed out to the terminal.
        */

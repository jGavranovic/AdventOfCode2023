import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;


public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("D:\\Java\\Day2\\day2.txt");
        Scanner scan = new Scanner(textFile);

        int sum=0;

        /*for (int i=1;i<=100;i++){
            String str = scan.nextLine();

            if (isAllValid(parseSubString(str))) sum+=i;
        }*/
        scan.nextLine();
        String str = scan.nextLine();
        //System.out.println(Arrays.toString(parseNum(parseSubString(str)[2])));
        System.out.println(parseSubString(str)[2]);



        scan.close();
    }

    static boolean isAllValid(String[] strs){
        for (int i=0;i<strs.length;i++)
            if (isOneValid(parseNum(strs[i]))==false) return false;
        return true;
    }

    static boolean isOneValid(int[] balls){
        final int REDMAX = 12, GREENMAX = 13, BLUEMAX = 14;

        if (balls[0]>REDMAX) return false;
        if  (balls[1]>GREENMAX) return false;
        if (balls[2]>BLUEMAX) return false;
        return true;
        
    }

    static int[] parseNum(String str){
        int redNum=0,greenNum=0,blueNum=0;

        int redPos = str.indexOf("red");
        if (redPos>=0)
            redNum = Integer.parseInt(str.substring(redPos-2,redPos-1));

        int greenPos = str.indexOf("green");
        if (greenPos>=0)
            greenNum = Integer.parseInt(str.substring(greenPos-2,greenPos-1));

        int bluePos = str.indexOf("blue");
        if (bluePos>=0)
            blueNum = Integer.parseInt(str.substring(bluePos-2,bluePos-1));

        return new int[] {redNum, greenNum, blueNum};
    }

    static String[] parseSubString(String str){
        int semiColonCount=0;

        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==';')
                semiColonCount++;
        }

        int trials = semiColonCount+1;

        String[] subStrings = new String[trials];
        int semiColonPos = str.indexOf(";");

        for (int i=0;i<trials;i++){
            if (i==0)
                subStrings[i] = str.substring(str.indexOf(":")+1,trials>1?str.indexOf(";"):str.length());
            else {
                int nextSemiColon = str.indexOf(";",semiColonPos+1);
                subStrings[i] = str.substring(semiColonPos+1, nextSemiColon!=-1?nextSemiColon:str.length());
                semiColonPos=nextSemiColon;
            }
        }

        return subStrings;
    }
}

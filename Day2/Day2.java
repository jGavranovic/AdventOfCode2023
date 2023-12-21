import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;


public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        File textFile = new File("D:\\Java\\Day2\\day2.txt");
        Scanner scan = new Scanner(textFile);

        int sum=0;
        //Part 1
        for (int i=1;i<=100;i++){
            String str = scan.nextLine();

            if (isAllValid(parseSubString(str))) sum+=i;
        }
        
        System.out.println(sum);

        //Part 2
        int power = 0;


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
            redNum = Integer.parseInt(str.substring(str.substring(0,redPos-1).lastIndexOf(" ")+1,redPos-1));

        int greenPos = str.indexOf("green");
        if (greenPos>=0)
            greenNum = Integer.parseInt(str.substring(str.substring(0,greenPos-1).lastIndexOf(" ")+1,greenPos-1));

        int bluePos = str.indexOf("blue");
        if (bluePos>=0)
            blueNum = Integer.parseInt(str.substring(str.substring(0,bluePos-1).lastIndexOf(" ")+1,bluePos-1));

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

    static int[] minSet(String[] strs){
        int redMin, greenMin, blueMin;
        for (int i=0;i<strs.length;i++){
            if (i==0){
                redMin = parseNum(strs[i])[0];
                greenMin = parseNum(strs[i])[1];
                blueMin = parseNum(strs[i])[2];
            }
            else {
                if (parseNum(strs[i])[0]>redMin) redMin = parseNum(strs[i])[0];
                if (parseNum(strs[i])[1]>greenMin) greenMin = parseNum(strs[i])[1];
                if (parseNum(strs[i])[2]>blueMin) blueMin = parseNum(strs[i])[2];
            }

            return new int[] {redMin, greenMin,blueMin};
    }
}

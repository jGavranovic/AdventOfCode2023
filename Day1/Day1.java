import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Day1{
    public static void main(String[] args) throws FileNotFoundException {

        File file = new  File("day1.txt");
        Scanner scan = new Scanner(file);

        int sum=0;
        String[] digits = {"one","two","three","four","five","six","seven","eight","nine"};

        for (int i=0;i<1000;i++){
            String str = scan.nextLine();
            int leftNum=0,rightNum=0,leftPos=0,rightPos=0;

            for (int j=0;j<str.length();j++){
                try {
                    leftNum = Integer.parseInt(str.substring(j,j+1));
                    leftPos=j;
                    break;
                }
                catch (NumberFormatException nfe){}

            }
            
            for (int j=str.length()-1;j>=0;j--){
                try {
                    rightNum = Integer.parseInt(str.substring(j,j+1));
                    rightPos=j;
                    break;
                }
                catch (NumberFormatException nfe){}
            }

            for (int j=0;j<digits.length;j++){
                int digitPos = str.indexOf(digits[j]);
                
                if (digitPos>=0&&digitPos<leftPos){
                    leftNum=j+1;
                    leftPos=digitPos;
                }
            }

            for (int j=0;j<digits.length;j++){
                int digitPos = str.lastIndexOf(digits[j]);
                
                if (digitPos>=0&&digitPos>rightPos){
                    rightNum=j+1;
                    rightPos=digitPos;
                }
            }

            sum+=10*leftNum+rightNum;
    
        }

        System.out.println(sum);
        scan.close();

    }
}

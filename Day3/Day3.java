import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Day3 {

    private static final char[] DIGITS ={'0','1','2','3','4','5','6','7','8','9'};
    private static final char[] SYMBOLS = {'@','#','$','%','&','*','-','+','=','/'};
    private static int total = 0;
    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("D:\\Java\\Day3\\day3.txt");
       
        
        char[][] engineMap = mapEngine(input);
        getTotal(engineMap);

        System.out.println(total);     

    }

    static boolean isDigit(char ch){
        for (int i=0;i<DIGITS.length;i++){
            if (ch==DIGITS[i]) return true;
        }
        return false;
    }

    static boolean isSymbol(char ch){
        for (int i=0;i<SYMBOLS.length;i++){
            if (ch==SYMBOLS[i])
                return true;
        }
        return false;
    }

    static char[][] mapEngine(File file) throws FileNotFoundException {
        char [][] map = new char[140][140];
         Scanner scan = new Scanner(file);

        for (int i=0;i<140;i++){
            String str = scan.nextLine();
            for (int j=0;j<140;j++){
                map[i][j]=str.charAt(j);
            }
        }
        scan.close();
        return map;
    }

    static void getTotal(char[][] engineMap){
        for (int i=0;i<engineMap.length;i++){
            for (int j=0;j<engineMap[i].length;j++){
                int partNum = 0,end=0;
                if (isDigit(engineMap[i][j])){
                    end = j+1;
                    while (end!=140&&isDigit(engineMap[i][end])){
                        end++;
                    }
                
                int numLength = end-j;
                
                for(int k=0;k<numLength;k++){
                    partNum+=Character.getNumericValue(engineMap[i][end-1-k])*Math.pow(10,k);
                }

                if (isValidPart(engineMap,i,j,numLength)) total+=partNum;

                j+=numLength;
            }
        }

        }
    }

    static boolean isValidPart(char[][] engineMap, int i,int j,int numLength)throws ArrayIndexOutOfBoundsException{
        for (int row=i-1;row<i+2;row++){
            //try{
                //char[] test = engineMap[row];
                for (int col=j-1;col<j+1+numLength;col++){
                    try{
                        if (isSymbol(engineMap[row][col])) return true;
                    } catch(ArrayIndexOutOfBoundsException e) {}
                }
            //} catch(ArrayIndexOutOfBoundsException e){}
        }
        return false;
    }

    static int getGearSum(char[][] engineMap ){
        for (int i=0;i<engineMap.length;i++){
            for (int j=0;j<engineMap[i].length;j++){
                int partNum = 0,end=0;
                if (engineMap[i][j]=='*'){
                    
                
                
                
                for(int k=0;k<numLength;k++){
                    partNum+=Character.getNumericValue(engineMap[i][end-1-k])*Math.pow(10,k);
                }

                if (isValidPart(engineMap,i,j,numLength)) total+=partNum;

                j+=numLength;
            }
        }

        }
    }

    static boolean isValidGear(char[][] engineMap, int i,int j){
        for (int row=i-1;row<i+2;row++){
            for (int col=j-1;col<j+2;col++){
                try{
                    if (isDigit(engineMap[row][col])){
                        do {
                            col++;
                        } while (isDigit(engineMap[row][col]));

                        
                    }   
                } catch(ArrayIndexOutOfBoundsException e){}
            }
        }
    }
    
}   

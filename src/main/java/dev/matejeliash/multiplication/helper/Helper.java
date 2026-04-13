package dev.matejeliash.multiplication.helper;

// general static helper methods,
public class Helper {


    public static boolean isStrNum(String numStr){
        if (numStr == null || numStr.isEmpty()){
            return false;
        }
        // optional - and more than 0 digits
        return numStr.matches("-?\\d+");

    }

    public static void printMultProcess(String numStrA,String numStrB, String result){

        System.out.printf("%s\n*\n%s\n=\n%s\n",numStrA,numStrB,result);
    }





}

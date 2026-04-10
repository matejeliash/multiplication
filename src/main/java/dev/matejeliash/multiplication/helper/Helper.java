package dev.matejeliash.multiplication.helper;

import dev.matejeliash.multiplication.exception.CLIArgException;
import dev.matejeliash.multiplication. exception.CLIArgExceptionMessage;
import dev.matejeliash.multiplication.exception.InvalidNumberException;

import java.util.Set;

// general static helper methods,
public class Helper {


    public static boolean isStrNum(String numStr){
        if (numStr == null || numStr.isEmpty()){
            return false;
        }
                            // optional - and 1- inf digit
        return numStr.matches("-?\\d+");

    }

    public static void printMultProcess(String numStrA,String numStrB, String result){

        System.out.printf("%s\n*\n%s\n=\n%s\n",numStrA,numStrB,result);
    }





}

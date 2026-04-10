package dev.matejeliash.multiplication.multiplicator;

import dev.matejeliash.multiplication.exception.InvalidNumberException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MultiplicatorB extends AbstractMultiplicator {

    private int sign=1;

    public MultiplicatorB(String strNumA, String strNumB) throws InvalidNumberException {
        super(strNumA, strNumB);
    }
    @Override
    public String multiply() {
        if(strNumA.equals("0") || strNumB.equals("0")){
            return "0";
        }
        // remove signs
        if(strNumA.charAt(0) == '-'){
            sign*=(-1);
            strNumA=strNumA.substring(1);
        }
        if(strNumB.charAt(0) == '-'){
            sign*=(-1);
            strNumB=strNumB.substring(1);
        }

        int numALen=strNumA.length();
        int numBLen=strNumB.length();



        int[] resArr= new int[numBLen + numALen];

        // go from lowest digit to highest
        for(int i =numALen -1 ; i>=0;i--){
            for (int j=numBLen -1 ;j>=0;j--){
                // get the value of digit from ASCII  -> '9' - '0'  == 9
                int mul= (strNumA.charAt(i) -'0') * (strNumB.charAt(j) - '0');
                // !!! must do, this position may have carried from prev. calculation
                int sum = resArr[i+j+1] + mul;
                // keep just last number (reminder)
                resArr[i+j+1] = sum %10;
                // add number of 10ns to carry to next position
                resArr[i+j] += sum / 10;

            }
        }


        String resWithoutSign= Arrays.stream(resArr)
                .dropWhile(n -> n ==0) // drop possible 0 at the beginning
                .mapToObj(String::valueOf).
                collect(Collectors.joining());
        // add sign if negative
        if(sign == -1){
            return "-" + resWithoutSign;
        }

        return resWithoutSign;


    }
}

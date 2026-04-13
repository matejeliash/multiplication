package dev.matejeliash.multiplication;


import dev.matejeliash.multiplication.multiplicator.MultiplicatorA;
import dev.matejeliash.multiplication.multiplicator.MultiplicatorB;
import org.junit.jupiter.api.Test;

public class PerformanceTests {

    // run many calculations sequentially,
    public void runMultiplications(int iterCount, char multiplicatorType)  {

        // warm up JIT, so startup is not slow
        for(int i=0;i<1000;i++) {
            String numA = MultiplicationTests.generateRandomNumStr();
            String numB = MultiplicationTests.generateRandomNumStr();
            if(multiplicatorType == 'A'){
                new MultiplicatorA(numA,numB).multiply();

            }else{
                new MultiplicatorB(numA,numB).multiply();

            }
        }

        long totalTime = 0;
        for(int i=0;i<iterCount;i++){
            String numA = MultiplicationTests.generateRandomNumStr();
            String numB = MultiplicationTests.generateRandomNumStr();

            long startTime ;
            long endTime ;

             new MultiplicatorA(numA,numB).multiply();

            if(multiplicatorType == 'A'){
                startTime = System.nanoTime();
                new MultiplicatorA(numA,numB).multiply();
                endTime = System.nanoTime();

            }else{
                startTime = System.nanoTime();
                new MultiplicatorB(numA,numB).multiply();
                endTime = System.nanoTime();

            }


            long iterationRime = endTime - startTime;
            totalTime+=iterationRime;

        }
        System.out.println("performance for " + "Multiplicator" + multiplicatorType + " " +
                "average iteration time: " + (totalTime/iterCount) / 1_000_000.0 + "ms");

    }



    @Test
    public void testMultiplicatorA(){
        runMultiplications(10000,'A');
    }


    @Test
    public void testMultiplicatorB(){
        runMultiplications(10000,'B');
    }


}


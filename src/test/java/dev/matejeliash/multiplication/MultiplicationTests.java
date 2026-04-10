package dev.matejeliash.multiplication;

import dev.matejeliash.multiplication.exception.InvalidNumberException;
import dev.matejeliash.multiplication.multiplicator.MultiplicatorA;
import dev.matejeliash.multiplication.multiplicator.MultiplicatorB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTests {

    public static String generateRandomNumStr(){
        Random random = new Random();
        // 24-34 length
        int len = random.nextInt(11) + 25;

        return random.ints(len,0,10)
                .mapToObj(String::valueOf)
                .dropWhile( s -> s.equals("0"))
                .reduce("", (res,s) -> (res + s));




    }

    @Test
    // simple test to compare both Multiplicators
    public void testCompareMultiplicators(){

        String strNumA=generateRandomNumStr();
        String strNumB=generateRandomNumStr();

        String resA=new MultiplicatorA(strNumA,strNumB).multiply();
        String resB=new MultiplicatorB(strNumA,strNumB).multiply();

        assertEquals(resA,resB);

    }

    @Test
    // test for one large number to negative
    public void testCompareMultiplicatorsOneNegative(){

        String strNumA="-" + generateRandomNumStr();
        String strNumB=generateRandomNumStr();

        String resA=new MultiplicatorA(strNumA,strNumB).multiply();
        String resB=new MultiplicatorB(strNumA,strNumB).multiply();

        assertEquals(resA,resB);

         strNumA= generateRandomNumStr();
         strNumB="-" + generateRandomNumStr();

         resA=new MultiplicatorA(strNumA,strNumB).multiply();
         resB=new MultiplicatorB(strNumA,strNumB).multiply();

        assertEquals(resA,resB);

    }


    @Test
    public void testSimpleEdgeCasesMultiplicationA(){

        String strNumA=  generateRandomNumStr();

        assertEquals("0",new MultiplicatorA("0","0").multiply());
        assertEquals("0",new MultiplicatorA("0","1").multiply());

        assertEquals("1",new MultiplicatorA("-1","-1").multiply());
        assertEquals("-1",new MultiplicatorA("-1","1").multiply());

        assertEquals("0",new MultiplicatorA("0","1").multiply());

        assertEquals("0",new MultiplicatorA("0",strNumA).multiply());
        assertEquals("0",new MultiplicatorA(strNumA,"0").multiply());

        assertEquals(strNumA,new MultiplicatorA(strNumA,"1").multiply());
        assertEquals(strNumA,new MultiplicatorA("1",strNumA).multiply());


    }
    @Test
    public void testSimpleEdgeCasesMultiplicationB(){

        String strNumA= generateRandomNumStr();

        assertEquals("0",new MultiplicatorB("0","0").multiply());
        assertEquals("0",new MultiplicatorB("0","1").multiply());

        assertEquals("1",new MultiplicatorB("-1","-1").multiply());
        assertEquals("-1",new MultiplicatorB("-1","1").multiply());

        assertEquals("0",new MultiplicatorB("0",strNumA).multiply());
        assertEquals("0",new MultiplicatorB(strNumA,"0").multiply());

        assertEquals(strNumA,new MultiplicatorB(strNumA,"1").multiply());
        assertEquals(strNumA,new MultiplicatorB("1",strNumA).multiply());


    }

    @Test
    // no need to test both Multiplicators, both use same constructor
    public void testWrongNumbesrUsedToInitMultiplicator(){
        assertThrows(InvalidNumberException.class, ()->{
             new MultiplicatorA(" "," ");

        });
        assertThrows(InvalidNumberException.class, ()->{
             new MultiplicatorA("","");

        });
        assertThrows(InvalidNumberException.class, ()->{
             new MultiplicatorA("123","");

        });

        assertThrows(InvalidNumberException.class, ()->{
            new MultiplicatorA("123","-");

        });

    }


    @Test
    public void testCorrectNumbersUsedToInitMultiplicator(){
        assertDoesNotThrow( ()->{
            new MultiplicatorB(generateRandomNumStr(),generateRandomNumStr());

        });

        assertDoesNotThrow( ()->{
            new MultiplicatorB("-1",generateRandomNumStr());

        });

        assertDoesNotThrow( ()->{
            new MultiplicatorB("0",generateRandomNumStr());

        });
    }

    // naive test that works on linux, math operation is passed as input to bc and stdout is captured
    @Test
    @EnabledOnOs(OS.LINUX) // just work on Linux
    public void shouldAnswerWithTrue() {
        assertTrue(true);
        try {
            String numA = generateRandomNumStr();
            String numb = generateRandomNumStr();
            MultiplicatorA multiplicator= new MultiplicatorA(numA,numb);
            String result = multiplicator.multiply();

            MultiplicatorB multiplicatorB= new MultiplicatorB(numA,numb);
            String resultB = multiplicatorB.multiply();

            // expression to pass to bc as input
            String bcExpr = String.format("%s * %s",numA, numb);
            Process process = new ProcessBuilder("bc", "-l").start();
            String bcResult;

            // write expression as input from user
            try (PrintWriter writer = new PrintWriter(process.getOutputStream())) {
                writer.println(bcExpr);
                writer.println("quit"); // !!! tell bc to quit to capture output
            }

            // read output of bc
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                 bcResult = reader.readLine();

            }

            process.waitFor();

            bcResult.strip(); // do this so newline is not present

            assertEquals(bcResult,result);
            assertEquals(bcResult,resultB);
            assertEquals(result,resultB);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}



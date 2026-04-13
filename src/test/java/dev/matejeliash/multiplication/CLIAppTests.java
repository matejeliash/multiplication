package dev.matejeliash.multiplication;

import dev.matejeliash.multiplication.cli.CLI;
import dev.matejeliash.multiplication.exception.CLIArgException;
import dev.matejeliash.multiplication.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


// tests of CLI app class testing
public class CLIAppTests {


    @Test
    public void testSimpleCorrectAppRun(){

        String[] args = {"--alg1","1","1"};
        CLI cli = new CLI(args);
        assertEquals("1",cli.calculate());


    }

    @Test
    public void testAppRunIncorrectAlgo(){
        assertThrows(CLIArgException.class, ()->{
            String[] args = {"--alg3","1","1"};
             new CLI(args);
        });

    }

    @Test
    public void testAppRunIncorrectArgCount(){

        assertThrows(CLIArgException.class, ()->{
            String[] args = {"--alg1","1"};
             new CLI(args);
        });
        assertThrows(CLIArgException.class, ()->{
            String[] args = {};
            new CLI(args);
        });



    }

    @Test
    public void testAppRunIncorrectNumber(){

        assertThrows(InvalidNumberException.class, ()->{
            String[] args = {"--alg2","asd","1"};
             new CLI(args);
        });


    }


}

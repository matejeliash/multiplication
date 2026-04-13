package dev.matejeliash.multiplication;
import dev.matejeliash.multiplication.cli.CLI;
import dev.matejeliash.multiplication.exception.CLIArgException;
import dev.matejeliash.multiplication.exception.InvalidNumberException;
import dev.matejeliash.multiplication.multiplicator.*;

public class Main {


    public static void main(String[] args) {

        // create CLI and run application
        try{
            CLI cli= new CLI(args);

            String result = cli.calculate();
            System.out.println(result);

        }catch (CLIArgException e){
            System.out.println("App exited because incorrect args were used:" + "\n" + e.getMessage());

        }catch (InvalidNumberException e){
            System.out.println("App exited because incorrect numbers were used:" + "\n" + e.getMessage());
        }
















    }

}


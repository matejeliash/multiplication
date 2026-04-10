package dev.matejeliash.multiplication.cli;

import dev.matejeliash.multiplication.exception.CLIArgException;
import dev.matejeliash.multiplication.exception.CLIArgExceptionMessage;
import dev.matejeliash.multiplication.exception.InvalidNumberException;
import dev.matejeliash.multiplication.helper.Helper;
import dev.matejeliash.multiplication.multiplicator.AbstractMultiplicator;
import dev.matejeliash.multiplication.multiplicator.MultiplicatorA;
import dev.matejeliash.multiplication.multiplicator.MultiplicatorB;

import java.util.Set;

// simple object to create cli app that accepts args
// creates Multiplicator and allows to calculate
public class CLI {

    private final String[] args;
    private AbstractMultiplicator multiplicator;

    public CLI(String args[]) throws  CLIArgException,InvalidNumberException{
        this.args =args;
        checkCmdArgs();
    }

    public String calculate() throws CLIArgException,InvalidNumberException{

        // select Multiplicator
        if (args[0].equals("--alg1")){
            multiplicator = new MultiplicatorA(args[1],args[2]);
        }else{
            multiplicator = new MultiplicatorB(args[1],args[2]);
        }

        return multiplicator.multiply();

    }

    public void checkCmdArgs() throws CLIArgException, InvalidNumberException {
        // check for exactly 3 args
        if (args.length != 3){
            throw new CLIArgException(CLIArgExceptionMessage.WRONG_ARG_NUM.getMsg());
        }

        // allow just these two args
        Set<String> allowedAlgos = Set.of("--alg1","--alg2");

        if (!allowedAlgos.contains(args[0])){
            throw new CLIArgException(
                    String.format(
                            "provided arg <%s> on position 0 is incorrect, acceptable is only {--alg1|--alg2}",args[0]
                    )
            );

        }

        if (!Helper.isStrNum(args[1])){

            throw  new InvalidNumberException(
                    String.format(
                            "provided arg <%s> on position 1 is not a number",args[1]
                    )
            );
        }

        if (!Helper.isStrNum(args[2])){

            throw  new InvalidNumberException(
                    String.format(
                            "provided arg <%s> on position 2 is not a number",args[1]
                    )
            );
        }

    }

}

package dev.matejeliash.multiplication.exception;

// exception is thrown when wrong arg/args are detected
public class CLIArgException extends  RuntimeException{
    public CLIArgException(String msg){
        super(msg);
    }

    public static CLIArgException wrongNumberOfArgs(){
        return new CLIArgException("wrong number of args: there must be 3 args {--alg1|--alg2} <number> <number>");

    }

    public static CLIArgException wrongArgOnPos0(String arg){

        String msg = String.format(
                "provided arg <%s> on position 0 is incorrect, acceptable is only {--alg1|--alg2}",arg
        );
        return new CLIArgException(msg);
    }

}

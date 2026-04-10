package dev.matejeliash.multiplication.exception;

public class CLIArgException extends  RuntimeException{
    public CLIArgException(String msg){
        super(String.format(msg));
    }
}

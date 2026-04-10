package dev.matejeliash.multiplication.exception;

public class InvalidNumberException extends RuntimeException{

        public InvalidNumberException (String str){
            super("not valid number: " + str);
        }
    }



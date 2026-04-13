package dev.matejeliash.multiplication.exception;

// used when non digit only string is found where only digits are allowed
public class InvalidNumberException extends RuntimeException{
        public InvalidNumberException (String strNum){
            super("not valid number: " + strNum);
        }
    }



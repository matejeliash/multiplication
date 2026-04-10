package dev.matejeliash.multiplication.exception;
// Not needed, but we may use it to predefine error messages for CLI
public enum CLIArgExceptionMessage {
    WRONG_ARG_NUM("wrong number of args: there must be 3 args {--alg1|--alg2} <number> <number>");

    private final String msg;

    CLIArgExceptionMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

}

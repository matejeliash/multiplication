package dev.matejeliash.multiplication.multiplicator;

import dev.matejeliash.multiplication.exception.InvalidNumberException;
import dev.matejeliash.multiplication.helper.Helper;


// general abstract multiplicator
public abstract class AbstractMultiplicator {
    // numbers held as strings
    protected String strNumA;
    protected String strNumB;

    public abstract String multiply();

    // throw invalid number in case when object is created
    public AbstractMultiplicator(String strNumA, String strNumB ) throws InvalidNumberException {

        if(!Helper.isStrNum(strNumA)){
            throw new InvalidNumberException(strNumA);
        }

        if(!Helper.isStrNum(strNumB)){
            throw new InvalidNumberException(strNumB);
        }

        this.strNumA = strNumA;
        this.strNumB = strNumB;


    }
}

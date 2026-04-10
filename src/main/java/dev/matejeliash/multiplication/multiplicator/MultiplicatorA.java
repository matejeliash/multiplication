package dev.matejeliash.multiplication.multiplicator;

import dev.matejeliash.multiplication.exception.InvalidNumberException;

import java.math.BigInteger;

public class MultiplicatorA extends AbstractMultiplicator {


    public MultiplicatorA(String strNumA, String strNumB) throws InvalidNumberException {
        super(strNumA, strNumB);
    }

    @Override
    public String multiply(){
        BigInteger intA = new  BigInteger(strNumA);
        BigInteger intB = new  BigInteger(strNumB);

        return intA.multiply(intB).toString();
    }
}

package com.me;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.pow;

public class Expo{

    private int count;
    private long countRest;
    private long restValue = 1;

    public BigInteger factorer(long num, int exponent){

        if(num <10){ // code for powers of 2, breaking the calculation to make it more efficient

        if(exponent < 32){ return BigInteger.valueOf(pot(num, exponent)); }


        count = exponent / 31;
        countRest = exponent % 31;

        BigInteger base = BigInteger.valueOf(pot(num, 31));

        BigInteger result = base.pow(count);

        if(countRest != 0){
            restValue = pot(num, countRest);
        }

        BigInteger rest = BigInteger.valueOf(restValue);

        BigInteger finalResult = result.multiply(rest);

        return finalResult;

        }

        BigInteger res2 = BigInteger.valueOf(num);
        BigInteger result2 = res2.pow(exponent);

        return result2;

    }


    public BigDecimal exponenter(int num, int exponent){ // BigDecimal to return power of negative exponents

        BigDecimal d = BigDecimal.valueOf(1); // to calculate negative exponents
        BigDecimal nu = BigDecimal.valueOf(num); // to use the BigDecimal pow function

        if(exponent < 0){ // power of negative exponents is equal to 1 divided by the respective positive power

            exponent = exponent * -1;
            return d.divide(exponenter(num, exponent));

        }


        if(exponent ==0) return d;//  zero power rule


        return nu.pow(exponent); //BigDecimal power function allows calculation of very big numbers with very big exponents


    }


    public long pot(long num, long exponent){ //recursive function to calculate positive powers

        if(exponent <= 0) return 1;

        return num * pot(num, exponent -1);// recursive call to the function, equivalent to n * n-1 * n-2 ...

    }



    public double defaut(long num, long exponent){

        return pow(num, exponent); /* mathematical function to calculate powers, more limited range than the BigInteger
        and BigDecimal versions
        */

    }
}

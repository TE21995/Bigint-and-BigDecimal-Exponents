package com.me;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.pow;

public class Expo{

    private BigInteger base = BigInteger.valueOf(pot(2, 30));
    private int b = base.intValue();

    public BigInteger power(BigInteger num, BigInteger exponent){ // method that uses the BigInteger pow method

        int compareV = exponent.compareTo(base);

        if(compareV <= 0){
            int exp = exponent.intValue();
            return num.pow(exp);
        }

        BigInteger count = exponent.divide(base);

        BigInteger result1 = num.pow(b);

        return power(result1, count);

    }


    public BigDecimal exponenter(int num, int exponent){ // BigDecimal to return power of negative exponents

        BigDecimal d = BigDecimal.ONE; // to calculate negative exponents
        BigDecimal nu = BigDecimal.valueOf(num); // to use the BigDecimal pow function

        if(exponent < 0){ // power of negative exponents is equal to 1 divided by the respective positive power

            exponent = exponent * -1;
            return d.divide(exponenter(num, exponent));

        }


        if(exponent ==0) return d;//  zero power rule


        return nu.pow(exponent); //BigDecimal power function allows calculation of very big numbers with very big exponents


    }


    public long pot(long num, long exponent){ //recursive method to calculate positive powers

        if(exponent <= 0) return 1;

        return num * pot(num, exponent -1);// recursive call to the method, equivalent to n * n-1 * n-2 ...

    }

    public BigInteger pot(BigInteger num, BigInteger exponent){ //recursive method to calculate positive powers og BigIntegers

        if(exponent.compareTo(BigInteger.ZERO) <=  0) return BigInteger.ONE;

        return num.multiply(pot(num, exponent.subtract(BigInteger.ONE)));// recursive call to the method, equivalent to n * n-1 * n-2 ...

    }



    public double defaut(long num, long exponent){

        return pow(num, exponent); /* mathematical function to calculate powers, more limited range than the BigInteger
        and BigDecimal versions
        */

    }
}

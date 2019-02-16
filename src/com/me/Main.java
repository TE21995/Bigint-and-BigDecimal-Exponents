package com.me;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

     Expo test = new Expo();

        BigInteger prin = test.factorer(2,42);

        System.out.println(prin.toString());

        System.out.println(test.exponenter(2, 42));

        System.out.println(test.exponenter(2, -42));

	// write your code here
    }
}

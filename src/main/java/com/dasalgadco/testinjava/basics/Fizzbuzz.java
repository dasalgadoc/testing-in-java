package com.dasalgadco.testinjava.basics;

public class Fizzbuzz {
  public static String evaluate(int number) {
    if (number % 3 == 0) {
      return "Fizz";
    }
    if (number % 5 == 0) {
      return "Buzz";
    }
    return String.valueOf(number);
  }
}

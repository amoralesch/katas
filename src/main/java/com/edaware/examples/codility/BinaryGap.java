package com.edaware.examples.codility;

public class BinaryGap {
  public String toBinary(int number) {
    if (number <= 0)
      throw new IllegalArgumentException("number has to be positive");

    StringBuilder result = new StringBuilder();

    while (number > 0) {
      result.insert(0, number % 2);
      number /= 2;
    }

    return result.toString();
  }

  public int gapOf(int number) {
    if (number <= 0)
      throw new IllegalArgumentException("number has to be positive");

    String binary = toBinary(number);
    int maxGap = 0;
    int currentGap = 0;

    for (char c: binary.toCharArray())
      if (c == '0')
        currentGap++;
      else {
        if (currentGap > maxGap)
          maxGap = currentGap;

        currentGap = 0;
      }

    return maxGap;
  }
}

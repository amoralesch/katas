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

	// public Object calculate(int i) {
	// 	return null;
	// }
}

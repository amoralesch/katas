package com.edaware.examples.codility;

import static java.util.Objects.requireNonNull;

class MissingInteger {
  private static final int MAX_VALUE = 1000001;

  public int solution(int[] array) {
    requireNonNull(array, "array may not be null");

    boolean[] found = new boolean[MAX_VALUE];

    for (int i : array)
      if (i > 0)
        found[i] = true;

    for (int i = 1; i < found.length; i++)
      if (!found[i])
        return i;

    return 1;
  }
}

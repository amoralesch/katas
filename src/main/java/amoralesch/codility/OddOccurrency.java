package amoralesch.codility;

import static java.util.Objects.requireNonNull;

public class OddOccurrency {

  public int solution(int[] array) {
    requireNonNull(array, "array may not be null");

    if (array.length % 2 == 0)
      throw new IllegalArgumentException(
        "array should have odd number of elements");

    byte missing = 0;

    for (int i : array)
      missing ^= i;

    return missing;
  }
}

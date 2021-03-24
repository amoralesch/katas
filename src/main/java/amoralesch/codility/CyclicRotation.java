package amoralesch.codility;

import static java.util.Objects.requireNonNull;

public class CyclicRotation {
  public int[] solution(int[] array, int rotation) {
    requireNonNull(array, "array may not be null");

    if (rotation < 0)
      throw new IllegalArgumentException("rotation may not be negative");

    int arrLen = array.length;

    if (arrLen == 0 || rotation == 0 || arrLen == rotation)
      return array;

    int[] solution = new int[arrLen];

    for (int i = 0; i < arrLen; i++)
      solution[(i + rotation) % arrLen] = array[i];

    return solution;
  }
}

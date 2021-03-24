package amoralesch.codility;

import static java.util.Objects.requireNonNull;

public class Equi {
  public int solution(int[] array) {
    requireNonNull(array, "array may not be null");

    int len = array.length;

    if (len == 0)
      return -1;

    int pos = 0;
    byte left = 0;
    byte right = 0;

    for (int i = 1; i < len; i++)
      right += array[i];

    while (pos < len - 1) {
      if (left == right)
        return pos;

      left += array[pos++];
      right -= array[pos];
    }

    return pos;
  }
}

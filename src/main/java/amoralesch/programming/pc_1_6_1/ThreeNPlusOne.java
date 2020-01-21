package amoralesch.programming.pc_1_6_1;

public class ThreeNPlusOne {
  private static final int MIN_VALUE = 1;

  private static final int MAX_VALUE = 1000000;

  public int cycleLength(int number)
  {
    if (number < MIN_VALUE || number > MAX_VALUE)
      throw new IllegalArgumentException("number is out of range");

    if (number == 1)
      return 1;

    if ((number % 2) == 0)
      return 1 + cycleLength(number / 2);

    return 1 + cycleLength(number * 3 + 1);
  }

  public int biggestCycleInRange(int start, int end)
  {
    if (end < start)
      throw new IllegalArgumentException("end may not be smaller than start");

    if (end == start)
      return cycleLength(start);

    int biggest = 0;
    for (int i = start; i <= end; i++) {
      int length = cycleLength(i);

      if (length > biggest)
        biggest = length;
    }

    return biggest;
  }
}

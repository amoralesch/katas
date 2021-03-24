package amoralesch.codility;

public class BinaryGap {
  public int gapOf(int number) {
    if (number <= 0)
      throw new IllegalArgumentException("number has to be positive");

    boolean startCounting = false;
    int n = number;
    int maxGap = 0;
    int currentGap = 0;

    while (n > 0) {
      if (n % 2 == 1) {
        startCounting = true;

        if (currentGap > maxGap)
          maxGap = currentGap;

        currentGap = 0;
      } else if (startCounting)
        currentGap++;

      n /= 2;
    }

    return maxGap;
  }
}

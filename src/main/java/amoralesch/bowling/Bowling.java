package amoralesch.bowling;

public class Bowling {
  private final int[] shots = new int[21];

  private int shotIndex = 0;

  public void shoot(int pines)
  {
    shots[shotIndex++] = pines;
  }

  public int score()
  {
    int pos = 0;
    int total = 0;

    for (int frame = 0; frame < 10; frame++) {
      int score = shots[pos] + shots[pos + 1];;

      if (isStrike(pos) || isSpare(pos))
        score += shots[pos + 2];

      if (isStrike(pos))
        pos++;
      else
        pos += 2;

      total += score;
    }

    return total;
  }

  private boolean isStrike(int i) {
    return shots[i] == 10;
  }

  private boolean isSpare(int i) {
    return shots[i] + shots[i + 1] == 10;
  }
}

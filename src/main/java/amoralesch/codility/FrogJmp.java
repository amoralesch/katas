package amoralesch.codility;

public class FrogJmp {
  public int solution(int X, int Y, int D)
  {
    if (X > Y | D <= 0)
      throw new IllegalArgumentException("invalid parameters");

    int diff = Y - X;
    int fullJumps = diff / D;

    return diff % D == 0 ? fullJumps : fullJumps + 1;
  }
}

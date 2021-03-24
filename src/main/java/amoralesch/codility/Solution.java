package amoralesch.codility;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private static final int MAX_CHARS = 300000;

  public int solution(String S) {
    requireNonNull(S, "string may not be null");

    if (S.length() > MAX_CHARS)
      throw new IllegalArgumentException("string is too big");

    String theString = S;
    int charsToRemove = 0;
    List<Integer> charCountSet = new ArrayList<>();

    while (!theString.isEmpty()) {
      char thisChar = theString.charAt(0);

      if (thisChar < 'a' || thisChar > 'z')
         throw new IllegalArgumentException("only lowercase letters are allowed");

      String nextString = theString.replace("" + thisChar, "");
      int thisCharCount = theString.length() - nextString.length();

      while (true) {
        if (thisCharCount == 0)
          break;

        if (!charCountSet.contains(thisCharCount)) {
          charCountSet.add(thisCharCount);
          break;
        }

        thisCharCount--;
        charsToRemove++;
      }

      theString = nextString;
    }

    return charsToRemove;
  }
}

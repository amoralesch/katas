package com.edaware.examples.codility;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private static final int MAX_CHARS = 300000;

  public int solution(String S) {
    requireNonNull(S, "string may not be null");

    if (S.length() > MAX_CHARS)
      throw new IllegalArgumentException("string is too big");

    int charsToRemove = 0;
    List<Character> charSeen = new ArrayList<>();
    List<Integer> charCountSet = new ArrayList<>();

    for (int i = 0; i < S.length(); i++) {
      char thisChar = S.charAt(i);

      if (thisChar < 'a' || thisChar > 'z')
         throw new IllegalArgumentException("only lowercase letters are allowed");

      if (charSeen.contains(thisChar))
        continue;

      charSeen.add(thisChar);

      int thisCharCount = 0;

      for (int j = i; j < S.length(); j++)
        if (S.charAt(j) == thisChar)
          thisCharCount++;

      while (true) {
        if (thisCharCount == 0)
          break;

        if (charCountSet.contains(thisCharCount)) {
          thisCharCount--;
          charsToRemove++;
        } else {
          charCountSet.add(thisCharCount);
          break;
        }
      }
    }

    return charsToRemove;
  }
}

package com.edaware.examples.codility;

import static java.util.Objects.requireNonNull;

class Solution {
  private static final int MAX_CHARS = 300000;

  private static final int NUM_CHARS = 'z' - 'a';

  public int solution(String S) {
    requireNonNull(S, "string may not be null");

    if (S.length() > MAX_CHARS)
      throw new IllegalArgumentException("string is too big");

    int[] letters = new int[NUM_CHARS + 1];

    for (char c : S.toCharArray()) {
      if (c < 'a' || c > 'z')
        throw new IllegalArgumentException("only lowercase letters are allowed");

      letters[c - 'a']++;
    }

    int count = 0;

    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == 0)
        continue;

      for (int j = 0; j < letters.length; j++) {
        if (letters[j] == 0 || i == j)
          continue;

        if (letters[i] == letters[j]) {
          letters[i--] -= 1;
          count++;
          break;
        }
      }
    }

    return count;
  }
}

package com.edaware.examples.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class SolutionTest {
  private final Solution s = new Solution();

  @Test
  void solution_ThrowsException_WhenStringIsNull()
  {
    assertThatThrownBy(() -> s.solution(null))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void solution_ReturnsZero_WhenStringIsEmpty()
  {
    assertThat(s.solution("")).isEqualTo(0);
  }

  @Test
  void solution_ReturnsZero_WhenStringHasSameLetter()
  {
    assertThat(s.solution("aaaaa")).isEqualTo(0);
  }

  @Test
  void solution_ReturnsZero_WhenStringHasMultipleLettersDiffTimes()
  {
    assertThat(s.solution("abb")).isEqualTo(0);
  }

  @Test
  void solution_ReturnOne_WhenTwoLettersHaveSameNumberOfTimes()
  {
    assertThat(s.solution("aabb")).isEqualTo(1);
  }

  @Test
  void solution_ReturnsThree_WhenALetterNeedsToBeRemovedCompletely()
  {
    assertThat(s.solution("aabbcc")).isEqualTo(3);
  }

  @Test
  void solution_ReturnsCorrectValue_WhenUsingExamplesFromWeb()
  {
    assertThat(s.solution("aaaabbbb")).isEqualTo(1);
    assertThat(s.solution("ccaaffddecee")).isEqualTo(6);
    assertThat(s.solution("eeee")).isEqualTo(0);
    assertThat(s.solution("example")).isEqualTo(4);

    assertThat(s.solution("aaaaaaaaaabbbbbbbbbbccccccccddddeeefffgghhhiijjjkkllmmmmmmnnnoooppppppqqqqqrrrrsssstttttuuuuvvvvvwwwwwwxxxxxyyyyyyyzzzzzzzz")).isEqualTo(68);
  }

  @Test
  void solution_ThrowsException_WhenMoreThanThirtyThousandLetters()
  {
    Random r = new Random();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= 300000; i++)
      sb.append(r.nextInt(9));

    assertThatThrownBy(() -> s.solution(sb.toString()))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void solution_ThrowsException_WhenStringHasInvalidCharacters()
  {
    assertThatThrownBy(() -> s.solution("ABC"))
      .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> s.solution("ab1c"))
      .isInstanceOf(IllegalArgumentException.class);
  }
}

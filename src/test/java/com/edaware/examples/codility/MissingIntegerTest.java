package com.edaware.examples.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MissingIntegerTest {
  private final MissingInteger mi = new MissingInteger();

  @Test
  void solution_ThrowsError_WhenNullArray()
  {
    assertThatThrownBy(() -> mi.solution(null))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void solution_ReturnsOne_WhenArrayIsEmpty()
  {
    int[] array = new int[0];

    assertThat(mi.solution(array)).isEqualTo(1);
  }

  @Test
  void solution_ReturnsNextMissingPositiveInteger_WhenArrayHasSomeElements()
  {
    int[] array = new int[] { 1, 3, 4, 5 };

    assertThat(mi.solution(array)).isEqualTo(2);
  }

  @Test
  void solution_ReturnsOne_WhenArrayContainsOnlyNegativeNumbers()
  {
    int[] array = new int[] { -1, -2, -3, -4, -10 };

    assertThat(mi.solution(array)).isEqualTo(1);
  }

  @Test
  void solution_ReturnsExpectedValue_WhenUsingExampleValuesFromWebSite()
  {
    assertThat(mi.solution(new int[] { 1, 3, 6, 4, 1, 2 }))
      .isEqualTo(5);

    assertThat(mi.solution(new int[] { 1, 2, 3 }))
      .isEqualTo(4);

    assertThat(mi.solution(new int[] { -1, -3 }))
      .isEqualTo(1);
  }
}

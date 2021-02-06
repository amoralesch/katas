package com.edaware.examples.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class FrogJmpTest {
  private final FrogJmp frog = new FrogJmp();

  @Test
  void solution_ThrowsException_WhenValuesAreWrong()
  {
    assertThatThrownBy(() -> frog.solution(10, 5, 5))
      .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> frog.solution(10, 100, 0))
      .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> frog.solution(10, 100, -10))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void solution_ReturnsSameAsWebpage_Always(){
    assertThat(frog.solution(10, 85, 30)).isEqualTo(3);
  }

  @Test
  void solution_ReturnsMinimumJumps_WhenItArrives(){
    assertThat(frog.solution(10, 20, 10)).isEqualTo(1);
  }
}

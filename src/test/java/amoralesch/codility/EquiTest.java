package amoralesch.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class EquiTest {
  private final Equi e = new Equi();

  @Test
  void solution_ThrowsException_WhenArrayIsNull()
  {
    assertThatThrownBy(() -> e.solution(null))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void solution_ReturnsMinusOne_WhenArrayIsEmpty()
  {
    assertThat(e.solution(new int[0])).isEqualTo(-1);
  }

  @Test
  void solution_ReturnsZero_WhenArrayHasOneElementOnly()
  {
    int[] array = new int[] { 0 };

    assertThat(e.solution(array)).isEqualTo(0);
  }

  @Test
  void solution_ReturnsMiddleOfArray_WhenBothSidesMatches()
  {
    int[] array = new int[] { 1, 5, 1 };

    assertThat(e.solution(array)).isEqualTo(1);
  }

  @Test
  void solution_ReturnsFirstPivotPoint_WhenBothSidesSumTheSame()
  {
    int[] array = new int[] { 2, 1, 5, 1, 1, 1 };

    assertThat(e.solution(array)).isEqualTo(2);
  }

  @Test
  void solution_ReturnsCorrectPivotPoint_WhenArrayHasNegativeNumbersToo()
  {
    int[] array = new int[] { -5, 4, 10, -7, 42, -2, 2, -4, 6 };

    assertThat(e.solution(array)).isEqualTo(4);
  }
}

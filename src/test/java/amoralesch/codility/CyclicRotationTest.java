package amoralesch.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CyclicRotationTest {
  private final CyclicRotation cr = new CyclicRotation();

  @Test
  void solution_ThrowsException_WhenNullArray()
  {
    assertThatThrownBy(() -> cr.solution(null, 1))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void solution_ThrowsException_WhenRotationIsNegative()
  {
    assertThatThrownBy(() -> cr.solution(new int[0], -1))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void solution_ReturnsSameArray_WhenArrayIsEmpty()
  {
    int[] array = new int[0];

    assertThat(cr.solution(array, 1)).isSameAs(array);
  }

  @Test
  void solution_ReturnsSameArray_WhenRotationIsZero()
  {
    int[] array = new int[] { 5 };

    assertThat(cr.solution(array, 0)).isSameAs(array);
  }

  @Test
  void solution_ReturnsSameArray_WhenRotationIsSameAsLength()
  {
    int[] array = new int[] { 1, 2, 3, 4, 5 };

    assertThat(cr.solution(array, 5)).isSameAs(array);
  }

  @Test
  void solution_RotatesArray_WhenRotatingByOne()
  {
    int[] input = new int[] { 1, 2, 3, 4, 5 };
    int[] expected = new int[] { 5, 1, 2, 3, 4 };

    assertThat(cr.solution(input, 1)).isEqualTo(expected);
  }

  @Test
  void solution_RotatesArray_WhenRotatingByTwo()
  {
    int[] input = new int[] { 1, 2, 3, 4, 5 };
    int[] expected = new int[] { 4, 5, 1, 2, 3 };

    assertThat(cr.solution(input, 2)).isEqualTo(expected);
  }

  @Test
  void solution_RotatesArray_WhenRotatingByMoreElementsThanPresent()
  {
    int[] input = new int[] { 1, 2, 3, 4, 5 };
    int[] expected = new int[] { 2, 3, 4, 5, 1 };

    assertThat(cr.solution(input, 9)).isEqualTo(expected);
  }

  @Test
  void solution_RotatesArray_SameAsWebPageExample()
  {
    int[] input = new int[] { 3, 8, 9, 7, 6 };
    int[] expected = new int[] { 9, 7, 6, 3, 8 };

    assertThat(cr.solution(input, 3)).isEqualTo(expected);
  }
}

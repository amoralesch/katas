package amoralesch.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class OddOccurrencyTest {
  private final OddOccurrency oo = new OddOccurrency();

  @Test
  void solution_ThrowsException_WhenNullArray()
  {
    assertThatThrownBy(() -> oo.solution(null))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void solution_ThrowsException_WhenEmptyArray()
  {
    assertThatThrownBy(() -> oo.solution(new int[0]))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void solution_ThrowsException_WhenArrayIsEven()
  {
    assertThatThrownBy(() -> oo.solution(new int[2]))
      .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> oo.solution(new int[4]))
      .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> oo.solution(new int[8]))
      .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> oo.solution(new int[10]))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void solution_ReturnsSameElement_WhenArrayHasOneElement()
  {
    int[] arr = new int[] { 5 };

    assertThat(oo.solution(arr)).isEqualTo(5);
  }

  @Test
  void solution_ReturnsLonelyValue_WhenPairIsMissing()
  {
    int[] arr = new int[] { 1, 2, 1 };

    assertThat(oo.solution(arr)).isEqualTo(2);
  }

  @Test
  void solution_ReturnsInvalidValue_WhenMultiplaValuesWithoutPair()
  {
    int[] arr = new int[] { 1, 2, 1, 4, 5 };

    assertThat(oo.solution(arr))
      .isNotEqualTo(2)
      .isNotEqualTo(4)
      .isNotEqualTo(5);
  }

  @Test
  void solution_ReturnsCorrectValue_WhenUsingExampleFromPage()
  {
    int[] arr = new int[] { 9, 3, 9, 3, 9, 7, 9 };

    assertThat(oo.solution(arr)).isEqualTo(7);
  }

}

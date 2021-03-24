package amoralesch.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BinaryGapTest {
  private final BinaryGap bg = new BinaryGap();

  @Nested
  class gapOf {
    @Test
    void throwsException_WhenZeroOrNegativeNumbers()
    {
      assertThatThrownBy(() -> bg.gapOf(0))
        .isInstanceOf(IllegalArgumentException.class);
      assertThatThrownBy(() -> bg.gapOf(-1))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void returnsCorrectValue_WhenNumberIsPositive()
    {
      assertThat(bg.gapOf(9)).isEqualTo(2);
      assertThat(bg.gapOf(529)).isEqualTo(4);
      assertThat(bg.gapOf(20)).isEqualTo(1);
      assertThat(bg.gapOf(15)).isEqualTo(0);
      assertThat(bg.gapOf(32)).isEqualTo(0);
      assertThat(bg.gapOf(1041)).isEqualTo(5);
      assertThat(bg.gapOf(32)).isEqualTo(0);
    }
  }
}

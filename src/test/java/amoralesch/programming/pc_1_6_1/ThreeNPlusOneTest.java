package amoralesch.programming.pc_1_6_1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ThreeNPlusOneTest {
  private ThreeNPlusOne algorithm = new ThreeNPlusOne();

  @Nested
  class cycleLength {
    @Test
    void throwsException_WhenNumberIsZero()
    {
      assertThatThrownBy(() -> algorithm.cycleLength(0))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsException_WhenNumberIsNegative()
    {
      assertThatThrownBy(() -> algorithm.cycleLength(-1))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsException_WhenNumberIsGreaterThanAMillion()
    {
      assertThatThrownBy(() -> algorithm.cycleLength(1000001))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void returnsOne_WhenNumberIsOne()
    {
      assertThat(algorithm.cycleLength(1)).isEqualTo(1);
    }

    @Test
    void returnsTwo_WhenNumberIsTwo()
    {
      assertThat(algorithm.cycleLength(2)).isEqualTo(2);
    }

    @Test
    void returnsThree_WhenNumberIsFour()
    {
      assertThat(algorithm.cycleLength(4)).isEqualTo(3);
    }

    @Test
    void returnsEight_WhenNumberIsThree()
    {
      assertThat(algorithm.cycleLength(3)).isEqualTo(8);
    }

    @Test
    void returnsSixteen_WhenNumberIsTwentyTwo()
    {
      assertThat(algorithm.cycleLength(22)).isEqualTo(16);
    }
  }

  @Nested
  class biggestCycleInRange {
    @Test
    void throwsException_WhenTopIsSmallerThatBottom()
    {
      assertThatThrownBy(() -> algorithm.biggestCycleInRange(3, 2))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsException_WhenRangeIsLowerThanMinimum()
    {
      assertThatThrownBy(() -> algorithm.biggestCycleInRange(0, 10))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwsException_WhenRangeIsBiggerThanMaximum()
    {
      assertThatThrownBy(() -> algorithm.biggestCycleInRange(50, 1000001))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void returnCycleLength_WhenStartAndEndAreTheSame()
    {
      assertThat(algorithm.biggestCycleInRange(3, 3))
        .isEqualTo(algorithm.cycleLength(3));
    }

    @Test
    void returnsBiggestCycleLength_WhenRangeIsValid()
    {
      assertThat(algorithm.biggestCycleInRange(1, 10)).isEqualTo(20);
      assertThat(algorithm.biggestCycleInRange(100, 200)).isEqualTo(125);
      assertThat(algorithm.biggestCycleInRange(201, 210)).isEqualTo(89);
      assertThat(algorithm.biggestCycleInRange(900, 1000)).isEqualTo(174);
    }
  }
}

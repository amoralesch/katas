package com.edaware.examples.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BinaryGapTest {
  @Nested
  class toBinary {
    private BinaryGap bg = new BinaryGap();

    @Test
    void throwsException_WhenZeroOrNegativeNumbers()
    {
      assertThatThrownBy(() -> bg.toBinary(0))
        .isInstanceOf(IllegalArgumentException.class);
      assertThatThrownBy(() -> bg.toBinary(-1))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void formatsNumberInBinary_Always()
    {
      assertThat(bg.toBinary(1)).isEqualTo("1");
      assertThat(bg.toBinary(3)).isEqualTo("11");
      assertThat(bg.toBinary(7)).isEqualTo("111");
      assertThat(bg.toBinary(15)).isEqualTo("1111");
      assertThat(bg.toBinary(31)).isEqualTo("11111");
      assertThat(bg.toBinary(63)).isEqualTo("111111");
      assertThat(bg.toBinary(127)).isEqualTo("1111111");

      assertThat(bg.toBinary(2)).isEqualTo("10");
      assertThat(bg.toBinary(4)).isEqualTo("100");
      assertThat(bg.toBinary(8)).isEqualTo("1000");
      assertThat(bg.toBinary(16)).isEqualTo("10000");
      assertThat(bg.toBinary(32)).isEqualTo("100000");
      assertThat(bg.toBinary(64)).isEqualTo("1000000");
      assertThat(bg.toBinary(128)).isEqualTo("10000000");

      assertThat(bg.toBinary(9)).isEqualTo("1001");
      assertThat(bg.toBinary(529)).isEqualTo("1000010001");
      assertThat(bg.toBinary(20)).isEqualTo("10100");
      assertThat(bg.toBinary(1041)).isEqualTo("10000010001");
    }
  }

  // @Test
  // void calculate_ReturnsCorrectValue_Always()
  // {
  //   BinaryGap bg = new BinaryGap();

  //   assertThat(bg.calculate(9)).isEqualTo(2);
  //   assertThat(bg.calculate(529)).isEqualTo(4);
  //   assertThat(bg.calculate(20)).isEqualTo(1);
  //   assertThat(bg.calculate(15)).isEqualTo(0);
  //   assertThat(bg.calculate(32)).isEqualTo(0);
  //   assertThat(bg.calculate(1041)).isEqualTo(5);
  //   assertThat(bg.calculate(32)).isEqualTo(0);
  // }
}

package amoralesch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {
  @Test
  void of_ThrowsException_WhenNegativeNumber()
  {
    assertThatThrownBy(() -> FizzBuzz.of(-1))
      .isInstanceOf(IllegalArgumentException.class);
  }
  
  @Test
  void of_ThrowsException_WhenNumberIsZero()
  {
    assertThatThrownBy(() -> FizzBuzz.of(0))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void of_ReturnsSameNumber_WhenNumberNotMultipleOfThreeOrFive()
  {
    assertThat(FizzBuzz.of(1)).isEqualTo("1");
    assertThat(FizzBuzz.of(2)).isEqualTo("2");
    assertThat(FizzBuzz.of(4)).isEqualTo("4");
    assertThat(FizzBuzz.of(7)).isEqualTo("7");
    assertThat(FizzBuzz.of(8)).isEqualTo("8");
  }

  @Test
  void of_ReturnsFizz_ForMultiplesOfThree()
  {
    assertThat(FizzBuzz.of(3)).isEqualTo("Fizz");
    assertThat(FizzBuzz.of(6)).isEqualTo("Fizz");
    assertThat(FizzBuzz.of(9)).isEqualTo("Fizz");
    assertThat(FizzBuzz.of(12)).isEqualTo("Fizz");
    assertThat(FizzBuzz.of(18)).isEqualTo("Fizz");
  }

  @Test
  void of_ReturnsBuzz_ForMultiplesOfFive()
  {
    assertThat(FizzBuzz.of(5)).isEqualTo("Buzz");
    assertThat(FizzBuzz.of(10)).isEqualTo("Buzz");
    assertThat(FizzBuzz.of(20)).isEqualTo("Buzz");
    assertThat(FizzBuzz.of(25)).isEqualTo("Buzz");
    assertThat(FizzBuzz.of(35)).isEqualTo("Buzz");
  }

  @Test
  void of_ReturnsFizzBuzz_ForMultiplesOfThreeAndFive()
  {
    assertThat(FizzBuzz.of(15)).isEqualTo("FizzBuzz");
    assertThat(FizzBuzz.of(30)).isEqualTo("FizzBuzz");
    assertThat(FizzBuzz.of(45)).isEqualTo("FizzBuzz");
    assertThat(FizzBuzz.of(60)).isEqualTo("FizzBuzz");
    assertThat(FizzBuzz.of(75)).isEqualTo("FizzBuzz");
  }
}

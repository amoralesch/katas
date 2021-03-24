package amoralesch.codility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class LetterRemoverTest {
  private final LetterRemover s = new LetterRemover();

  @Test
  void charsCountToRemove_ThrowsException_WhenStringIsNull()
  {
    assertThatThrownBy(() -> s.charsCountToRemove(null))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void charsCountToRemove_ReturnsZero_WhenStringIsEmpty()
  {
    assertThat(s.charsCountToRemove("")).isEqualTo(0);
  }

  @Test
  void charsCountToRemove_ReturnsZero_WhenStringHasSameLetter()
  {
    assertThat(s.charsCountToRemove("aaaaa")).isEqualTo(0);
  }

  @Test
  void charsCountToRemove_ReturnsZero_WhenStringHasMultipleLettersDiffTimes()
  {
    assertThat(s.charsCountToRemove("abb")).isEqualTo(0);
  }

  @Test
  void charsCountToRemove_ReturnOne_WhenTwoLettersHaveSameNumberOfTimes()
  {
    assertThat(s.charsCountToRemove("aabb")).isEqualTo(1);
  }

  @Test
  void charsCountToRemove_ReturnsThree_WhenALetterNeedsToBeRemovedCompletely()
  {
    assertThat(s.charsCountToRemove("aabbcc")).isEqualTo(3);
  }

  @Test
  void charsCountToRemove_ReturnsCorrectValue_WhenUsingExamplesFromWeb()
  {
    assertThat(s.charsCountToRemove("aaaabbbb")).isEqualTo(1);
    assertThat(s.charsCountToRemove("ccaaffddecee")).isEqualTo(6);
    assertThat(s.charsCountToRemove("eeee")).isEqualTo(0);
    assertThat(s.charsCountToRemove("example")).isEqualTo(4);

    assertThat(s.charsCountToRemove("aaaaaaaaaabbbbbbbbbbccccccccddddeeefffgghhhiijjjkkllmmmmmmnnnoooppppppqqqqqrrrrsssstttttuuuuvvvvvwwwwwwxxxxxyyyyyyyzzzzzzzz")).isEqualTo(68);
  }

  @Test
  void charsCountToRemove_ThrowsException_WhenMoreThanThirtyThousandLetters()
  {
    Random r = new Random();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= 300000; i++)
      sb.append(r.nextInt(9));

    assertThatThrownBy(() -> s.charsCountToRemove(sb.toString()))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void charsCountToRemove_ThrowsException_WhenStringHasInvalidCharacters()
  {
    assertThatThrownBy(() -> s.charsCountToRemove("ABC"))
      .isInstanceOf(IllegalArgumentException.class);

    assertThatThrownBy(() -> s.charsCountToRemove("ab1c"))
      .isInstanceOf(IllegalArgumentException.class);
  }
}

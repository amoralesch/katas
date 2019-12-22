package amoralesch.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BowlingTest {
  private final Bowling game = new Bowling();

  @Test
  void score_ReturnsZero_WhenAllThrowsMissed()
  {
    shoot(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertThat(game.score()).isEqualTo(0);
  }

  @Test
  void score_ReturnsTwenty_WhenAllThrowsHitOnes()
  {
    shoot(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

    assertThat(game.score()).isEqualTo(20);
  }

  @Test
  void score_ReturnsSixty_WhenAllThrowsHitThree()
  {
    shoot(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

    assertThat(game.score()).isEqualTo(60);
  }

  @Test
  void score_CalculateSpares_WhenSpareHappens()
  {
    shoot(5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertThat(game.score()).isEqualTo(20);
  }

  @Test
  void score_CalculatesStrikes_WhenStrikeHappens()
  {
    shoot(10, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertThat(game.score()).isEqualTo(22);
  }

  @Test
  void score_CalculatesThreeHundred_WhenPerfectGame()
  {
    shoot(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

    assertThat(game.score()).isEqualTo(300);
  }

  @Test
  void score_CalculatesCorrectly_WhenAllSpares()
  {
    shoot(0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 5);

    assertThat(game.score()).isEqualTo(105);
  }

  @Test
  void score_CalculatesCorrectly_WhenAllSparesAgain()
  {
    shoot(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

    assertThat(game.score()).isEqualTo(150);
  }

  private void shoot(int ... pines)
  {
    for (int pin: pines)
      game.shoot(pin);
  }
}

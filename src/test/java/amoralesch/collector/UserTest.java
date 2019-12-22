package amoralesch.collector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest
{
  @Test
  void hashCode_ReturnsHashCodeOfName_Always() {
    assertThat(new User("John").hashCode()).isEqualTo("John".hashCode());
  }

  @Test
  void equals_FulfillContract_Always() {
    User u = new User("John");

    assertThat(u.equals(null)).isFalse();

    assertThat(u.equals(u)).isTrue();

    assertThat(u.equals(new User("John"))).isTrue();
    assertThat(new User("John").equals(u)).isTrue();

    assertThat(u.equals(new User("Pepe"))).isFalse();
  }

  @Test
  void equals_IgnoreAliases_Always()
  {
    User u1 = new User("John");
    User u2 = new User("John");

    assertThat(u1.equals(u2)).isTrue();

    u1.getAliases().add("Johnny");
    u2.getAliases().add("Jim");

    assertThat(u1.equals(u2)).isTrue();
  }
}

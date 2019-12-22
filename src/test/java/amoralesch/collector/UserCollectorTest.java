package amoralesch.collector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector.Characteristics;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserCollectorTest
{
  private UserCollector collector = new UserCollector();

  @Test
  void characteristics_ReturnsIdentity_Always() {
    assertThat(collector.characteristics())
      .containsExactly(Characteristics.IDENTITY_FINISH);
  }

  @Test
  void supplier_ReturnsNewEmptyList_Always() {
    Supplier<List<User>> supplier1 = collector.supplier();
    Supplier<List<User>> supplier2 = collector.supplier();

    assertThat(supplier1.get()).isEmpty();
    assertThat(supplier2.get()).isEmpty();
    assertThat(supplier1.get()).isNotSameAs(supplier2.get());
  }

  @Nested
  class accumulator
  {
    private BiConsumer<List<User>, User> accumulator =
      collector.accumulator();

    @Test
    void throwsException_WhenListIsNull()
    {
      assertThatThrownBy(() -> accumulator.accept(null, u("John")))
        .isInstanceOf(NullPointerException.class);
    }

    @Test
    void throwsException_WhenListNewUserIsNull()
    {
      assertThatThrownBy(() -> accumulator.accept(l(), null))
        .isInstanceOf(NullPointerException.class);
    }

    @Test
    void addUser_WhenListIsEmpty()
    {
      User u = u("John");
      List<User> list = l();

      accumulator.accept(list, u);

      assertThat(list).containsExactly(u);
    }

    @Test
    void addUsers_WhenNotPresentInList()
    {
      User u1 = u("John");
      User u2 = u("Jane");
      User u3 = u("Joe");
      List<User> list = l();

      accumulator.accept(list, u1);
      accumulator.accept(list, u2);
      accumulator.accept(list, u3);

      assertThat(list).containsExactly(u1, u2, u3);
    }

    @Test
    void aggregatesAlias_WhenSameUser()
    {
      User u1 = u("John");
      User u2 = u("John");
      List<User> list = l();

      u1.getAliases().add("Johny");
      u2.getAliases().add("Joe");

      accumulator.accept(list, u1);
      accumulator.accept(list, u2);

      assertThat(list.size()).isEqualTo(1);
      assertThat(list.get(0).getAliases())
        .containsExactly("Johny", "Joe");
    }

    @Test
    void aggregatesAlias_EvenIfNotInOrder()
    {
      User u1 = u("John");
      User u2 = u("Jane");
      User u3 = u("John");
      List<User> list = l();

      u1.getAliases().add("Johny");
      u3.getAliases().add("Joe");

      accumulator.accept(list, u1);
      accumulator.accept(list, u2);
      accumulator.accept(list, u3);

      assertThat(list.size()).isEqualTo(2);
      assertThat(list).extracting(User::getName)
        .containsExactly("John", "Jane");
      assertThat(list.get(0).getAliases())
        .containsExactly("Johny", "Joe");
      assertThat(list.get(1).getAliases()).isEmpty();
    }

    private List<User> l(User ... uu)
    {
      List<User> l = new ArrayList<>();

      Collections.addAll(l, uu);

      return l;
    }

    private User u(String name)
    {
      return new User(name);
    }
  }

  @Test
  void combiner_ReturnsOperatorThatThrowsException_Always() {
    BinaryOperator<List<User>> combiner = collector.combiner();

    assertThatThrownBy(() -> combiner.apply(null, null))
      .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void finisher_ReturnsSameAsInput_Always()
  {
    List<User> input = Collections.emptyList();
    Function<List<User>, List<User>> finisher = collector.finisher();

    assertThat(finisher.apply(null)).isNull();
    assertThat(finisher.apply(input)).isSameAs(input);
  }
}

package amoralesch.collector;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

class UserCollector implements Collector<User, List<User>, List<User>> {
  @Override
  public Set<Characteristics> characteristics() {
    return Stream.of(Characteristics.IDENTITY_FINISH).collect(toSet());
  }

  @Override
  public Supplier<List<User>> supplier() {
    return ArrayList::new;
  }

  @Override
  public BiConsumer<List<User>, User> accumulator() {
    return (l, u) -> {
      requireNonNull(l, "list may not be null");
      requireNonNull(u, "user may not be null");

      int i = l.indexOf(u);
      if (i > -1) {
        User o = l.get(i);
        o.getAliases().addAll(u.getAliases());
      } else
        l.add(u);
    };
  }

  @Override
  public BinaryOperator<List<User>> combiner() {
    return (t, u) -> {
      throw new UnsupportedOperationException("Not implemented yet");
    };
  }

  @Override
  public Function<List<User>, List<User>> finisher() {
    return Function.identity();
  }
}

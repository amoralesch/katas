package amoralesch.collector;

import java.util.ArrayList;
import java.util.List;

class User
{
  private final String name;

  private final List<String> aliases = new ArrayList<>();

  public User(String n) {
    name = n;
  }

  public List<String> getAliases() {
    return aliases;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || o.getClass() != this.getClass())
      return false;

    User other = (User)o;

    return name.equals(other.name);
  }
}

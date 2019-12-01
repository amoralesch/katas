package amoralesch;

public class FizzBuzz {
  public static String of(int n)
  {
    if (n <= 0)
      throw new IllegalArgumentException();

    String result = "";

    result += n % 3 == 0 ? "Fizz" : "";
    result += n % 5 == 0 ? "Buzz" : "";

    return result.isEmpty() ? String.valueOf(n) : result;
  }
}

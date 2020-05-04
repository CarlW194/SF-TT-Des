package builder;

public class UseBuilder {
  public static void main(String[] args) {
    BuildMe.Builder builder = BuildMe.builder();
    BuildMe it = builder
        .count(4)
        .name("Fred")
        .build();
    System.out.println(it);
    BuildMe it2 = builder
        .count(100)
        .build();
    System.out.println("it " + it);
    System.out.println("it2 " + it2);
    System.out.println(it == it2);
  }
}

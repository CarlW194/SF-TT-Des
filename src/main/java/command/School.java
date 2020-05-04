package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
 /*
 document execute(Command c) -- mutates document...
 document unexecute(Command c) -- undo
 Usually define a Stack<Command> and "undo" merely pops top of stack, and
 calls "unexecute"
  */
public class School {
  public static <E> List<E> filter(
      List<E> ls, Predicate<E> pred) {
    List<E> out = new ArrayList<>();
    for (E s : ls) {
      if (pred.test(s)) { // behavior varies independently, use
        // object because of the behavior it contains...
        // this is the Command pattern
        // in functional programming this is "merely"
        // one type of "higher order function"
        out.add(s);
      }
    }
    return out;
  }

  public static <E> void show(List<E> ls) {
    for (E s : ls) {
      System.out.println(s);
    }
    System.out.println("--------------------------");
  }

   // "functional Decorator" -- also Python
   // also higher order function again :)
   public static <E> Predicate<E> negate(Predicate<E> p) {
     return e -> !p.test(e);
   }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        new Student("Fred", 3.2),
        new Student("Jim", 2.6),
        new Student("Sheila", 3.9)
    );

    Predicate<Student> isSmart = s -> s.getGpa() > 3;
    show(filter(roster, isSmart));
    Predicate<Student> firstHalf = s -> s.getName().charAt(0) <= 'M';
    show(filter(roster, firstHalf));

    show(filter(Arrays.asList("Short", "very long indeed", "I"), s -> s.length() > 5));

    roster.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
    show(roster);

    show(filter(roster, negate(isSmart)));
    show(filter(roster, negate(firstHalf)));

  }
}

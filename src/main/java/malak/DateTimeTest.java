package malak;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DateTimeTest {
public static void main(String[] args) {
    

    LocalDate  SemsetarStart= LocalDate.of(2023,9,11);
LocalDate  SemsetarEnds= SemsetarStart.plus(10,ChronoUnit.WEEKS);
    LocalDate  flightDay = LocalDate.of(2024,1,1);

    System.out.println("the days between your flight and the end of the semester is "+Period.between(SemsetarEnds, flightDay).getDays()+" Days");
    LocalTime ten= LocalTime.of(10,39);
    System.out.println(ten.getHour()); 
    LocalTime nine= LocalTime.of(9,39);
    
   long   between= ten.isAfter(nine) ? Duration.between(nine, ten).getSeconds() :  0;
   System.out.println(between);

  System.out.println(SemsetarStart.format(DateTimeFormatter.ofPattern("MMM dd,YYYY"))); 
  System.out.println(ten.format(DateTimeFormatter.ofPattern("h:mm a")));
   Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
   System.out.println(allZoneIds.toString());
LocalDate dob= LocalDate.of(2003, 6, 14);
LocalDate now =LocalDate.now();
   System.out.println(now.minusYears(dob.getYear()).getYear()+" Years old ");
   /* 
    int[][] m = {{1, 2, 3}, {3, 4, 5}, {5, 2}, {1, 3}};
    System.out.println(
      Stream.of(m).parallel().map(e -> IntStream.of(e))
        .reduce((e1, e2) -> IntStream.concat(e1, e2))
        .get().distinct().mapToObj(e -> e + "")
        .reduce((e1, e2) -> e1 + ", " + e2).get());
        System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .mapToObj(e -> e + "").reduce((e1, e2) -> e1 + " " + e2).get());
  System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .reduce(0, (e1, e2) -> e1 + e2));
  System.out.println(IntStream.of(2, 5, 5, 4, 5).parallel()
  .collect(() -> new TreeSet(), (c, e) -> c.add(e),
    (c1, c2) -> c1.addAll(c2)));
*/
    int[][] m = {{1, 2, 3}, {3, 4, 5}, {5, 2}, {1, 3}};
    Stream.of(m).parallel().map(e -> IntStream.of(e))
      .reduce((e1, e2) -> IntStream.concat(e1, e2))
      .get().distinct()
      .forEach(e -> System.out.print(e + " "));

      String s = "good";
Stream.of(s.toCharArray()).forEach(e ->
  System.out.print(e + " "));

  
  Stream.of(toCharacterArray(s.toCharArray())).forEach(e ->
    System.out.print(e + " "));
    IntStream.of(1, 2, 3, 4, 5).parallel()
  .forEach(e -> System.out.print(e + " "));
  System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .reduce(1, (e1, e2) -> e1 * e2));
  System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .reduce(Integer.MAX_VALUE, (e1, e2) -> Math.min(e1, e2)));
  System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .mapToObj(e -> e + "").reduce((e1, e2) -> e1 + " " + e2).get());
  Character[] chars = {'D', 'B', 'A', 'C'};
System.out.println(Stream.of(chars).mapToInt(e -> e - 'A').sum());
System.out.println(IntStream.of(1, 2, 3, 4, 5).parallel()
  .reduce(0, (e1, e2) -> e1 + e2));

  System.out.println(IntStream.of(2, 5, 5, 4, 5).parallel()
  .collect(() -> new TreeSet(), (c, e) -> c.add(e),
    (c1, c2) -> c1.addAll(c2)));
}

public static Character[] toCharacterArray(char[] list) {
  Character[] result = new Character[list.length];
  for (int i = 0; i < result.length; i++) {
    result[i] = list[i];
  }
  return result;
}



}


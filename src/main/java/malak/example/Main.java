package malak.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
        public static void main(String[] args) {
    String[] names = {"Jamal", "Peter", "Soraya", "Kim", "Imani", 
      "Giorgio", "Alan", "Stacy", "Michelle", "jamal"};
    System.out.println("The number of characters for all names: " +
      Stream.of(names).parallel().collect(StringBuilder::new, 
        StringBuilder::append, StringBuilder::append).length());
    
    List<String> list = Stream.of(names).collect(ArrayList::new, 
      ArrayList::add, ArrayList::addAll);
    System.out.println(list);
    
    list = Stream.of(names).collect(Collectors.toList());
    System.out.println(list);
    Set<String> set = Stream.of(names).map(e -> e.toUpperCase()).
      collect(Collectors.toSet());
    System.out.println(set);
    
    Map<String, Integer> map = Stream.of(names).collect(
      Collectors.toMap(e -> e, e -> e.length()));
    System.out.println(map);
    
    System.out.println("The total number of characters is " +
      Stream.of(names).
        collect(Collectors.summingInt(e -> e.length())));

    java.util.IntSummaryStatistics stats = Stream.of(names).
      collect(Collectors.summarizingInt(e -> e.length()));
    System.out.println("Max is " + stats.getMax());
    System.out.println("Min is " + stats.getMin());
    System.out.println("Average is " + stats.getAverage());
    ////////////////////////
    String[] namess = {"Jamal", "Peter", "Soraya", "Kim", "Imani", 
    "Giorgio", "Alan", "Stacy", "Michelle", "jamal"};
  
  Map<String, Long> map1 = Stream.of(namess).
    map(e -> e.toUpperCase()).collect(
    Collectors.groupingBy(e -> e, Collectors.counting()));
  System.out.println(map1);


  Map<Character, Long> map2 = Stream.of(namess).collect(
      Collectors.groupingBy(e -> e.charAt(0), 
        Collectors.counting()));
    System.out.println(map2);
    MyStudent[] students = {new MyStudent("John", "Lu", "CS", 32, 78),
    new MyStudent("Susan", "Yao", "Math", 31, 85.4),
    new MyStudent("Kim", "Johnson", "CS", 30, 78.1)};
  
  System.out.printf("%10s%10s\n", "Department", "Average");
  Stream.of(students).collect(Collectors.
    groupingBy(MyStudent::getMajor, TreeMap::new,
    Collectors.averagingDouble(MyStudent::getScore))).
    forEach((k, v) -> System.out.printf("%10s%10.2f\n", k, v));
    }
}
class MyStudent {
  private String firstName;
  private String lastName;
  private String major;
  private int age;
  private double score;
  
  public MyStudent(String firstName, String lastName, String major, 
      int age, double score) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.major = major;
    this.age = age;
    this.score = score;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
   
  public String getMajor() {
    return major;
  }
  
  public int getAge() {
    return age;
  }
  
  public double getScore() {
    return score;
  }
}
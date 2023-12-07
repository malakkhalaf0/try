package malak;


    
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class count {
  private static int count = 0;
  
  public static void main(String[] args) {
 /*    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    
    count = 0; // Reset the count for columns
    System.out.println("The occurrences of each letter are:");
    Stream.of(toCharacterArray(s.toCharArray()))
      .filter(ch -> Character.isLetter(ch))
      .map(ch -> Character.toUpperCase(ch))
      .collect(Collectors.groupingBy(e -> e, 
           TreeMap::new, Collectors.counting()))
         .forEach((k, v) -> { System.out.print(v + " " + k 
              + (++count % 10 == 0 ? "\n" : " "));
         });*/
         String [] names={"shahd","malak","shouq","mays"};
      int sum=  Stream.of(names).mapToInt(e->e.length()).sum();
      System.out.println(sum);

 StringBuilder s=Stream.of(names).collect(()-> new StringBuilder(),(a,b)-> a.append(b), (a1,b1)-> a1.append(b1));
System.out.println(s.length());
 System.out.println(Stream.of(names).anyMatch(e-> e.startsWith("s")));
System.out.println(Stream.of(names).collect(Collectors.joining("")).length());



MyStudent[] students = {new MyStudent("John", "Lu", "CS", 32, 78),
new MyStudent("Susan", "Yao", "Math", 31, 85.4),
new MyStudent("Kim", "Johnson", "CS", 30, 78.1)};

System.out.printf("%10s%10s\n", "Department", "Average");
Stream.of(students).collect(Collectors.
groupingBy(s2-> s2.getMajor(), 
Collectors.averagingDouble(s1->s1.getScore()))).
forEach((k, v) -> System.out.printf("%10s%10.2f\n", k, v));
System.out.println(" hi iam shahd ");

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

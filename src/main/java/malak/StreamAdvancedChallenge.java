package malak;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private List<String> courses;

    public Student(String name, int age, List<String> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }
}

public class StreamAdvancedChallenge {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 22, Arrays.asList("Math", "Physics", "Computer Science")),
                new Student("Bob", 20, Arrays.asList("Math", "Chemistry", "Biology")),
                new Student("Charlie", 21, Arrays.asList("Physics", "Computer Science")),
                new Student("David", 23, Arrays.asList("Math", "Chemistry")),
                new Student("Eve", 22, Arrays.asList("Computer Science", "Biology"))
        );

        // Your stream pipeline here...

        // 1. Create a Map<String, List<Student>> where the key is the course name, and the value is a list of students enrolled in that course.
        Map<String, List<Student>> courseToStudents = students.stream()
                .flatMap(student -> student.getCourses().stream().map(course -> Map.entry(course, student)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        // 2. Find the average age of students for each course.
        Map<String, Double> averageAgeByCourse = students.stream()
                .flatMap(student -> student.getCourses().stream().map(course -> Map.entry(course, student.getAge())))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingInt(Map.Entry::getValue)));

        // 3. Find the course with the highest average student age.
        String courseWithHighestAvgAge = averageAgeByCourse.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        // Output the results
        System.out.println("1. Map of courses to students: " + courseToStudents);
        System.out.println("2. Average age of students for each course: " + averageAgeByCourse);
        System.out.println("3. Course with the highest average student age: " + courseWithHighestAvgAge);
    }
}




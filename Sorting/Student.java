package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Comparable<Student> {
    private static final Logger logger = Logger.getLogger(Student.class.getName());
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // Ascending order by age
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

  

    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 22),
            new Student("Bob", 20),
            new Student("Charlie", 23)
        };

        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name); // Ascending order by name
            }
        });

        Arrays.sort(students, (s1, s2) -> s1.age - s2.age); // Ascending order by age using lambda
        logger.log(Level.INFO, "Sorted by name: {0}", Arrays.toString(students));
    }
    
}

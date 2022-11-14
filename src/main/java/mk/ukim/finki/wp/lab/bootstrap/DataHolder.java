package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Student> students = new ArrayList<>(5);
    public static List<Course> courses = new ArrayList<>(5);
    public static List<Teacher> teachers = new ArrayList<>(5);

    @PostConstruct
    public void init() {
        Student s1 = new Student("petar.petrov", "pp","Petar","Petrov");
        Student s2 = new Student("mile.milev", "mm","Mile","Milev");
        Student s3 = new Student("gjorgji.gjorgjiev", "gjgj","Gjorgji","Gjorgjiev");
        Student s4 = new Student("jovan.jovanov", "jj","Jovan","Jovanov");
        Student s5 = new Student("milosh.kuzmanovski", "mk","Milosh","Kuzmanovski");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        Teacher t1 = new Teacher("Teacher 1", "One");
        Teacher t2 = new Teacher("Teacher 2", "Two");
        Teacher t3 = new Teacher("Teacher 3", "Three");
        Teacher t4 = new Teacher("Teacher 4", "Four");
        Teacher t5 = new Teacher("Teacher 5", "Five");

        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);

        courses.add(new Course("Veb programiranje","Kurs za veb programiranje", teachers.get(0)));
        courses.add(new Course("Operativni sistemi","Kurs za operativni sistemi",teachers.get(1)));
        courses.add(new Course("Elektronska i mobilna trgovija","Kurs za elektronska i mobilna trgovija",teachers.get(2)));
        courses.add(new Course("Kompjuterski mrezi","Kurs za kompjuterski mrezi",teachers.get(3)));
        courses.add(new Course("Bazi na podatoci","Kurs za bazi na podatoci",teachers.get(4)));
    }
}

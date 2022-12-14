package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.enums.Type;
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
        students.add(new Student("petar.petrov", "pp","Petar","Petrov"));
        students.add(new Student("mile.milev", "mm","Mile","Milev"));
        students.add(new Student("gjorgji.gjorgjiev", "gjgj","Gjorgji","Gjorgjiev"));
        students.add(new Student("jovan.jovanov", "jj","Jovan","Jovanov"));
        students.add(new Student("milosh.kuzmanovski", "mk","Milosh","Kuzmanovski"));

        teachers.add(new Teacher("Teacher 1", "One"));
        teachers.add(new Teacher("Teacher 2", "Two"));
        teachers.add(new Teacher("Teacher 3", "Three"));
        teachers.add(new Teacher("Teacher 4", "Four"));
        teachers.add(new Teacher("Teacher 5", "Five"));

        courses.add(new Course("Veb programiranje","Kurs za veb programiranje", teachers.get(0), Type.ELECTIVE));
        courses.add(new Course("Operativni sistemi","Kurs za operativni sistemi",teachers.get(1), Type.MANDATORY));
        courses.add(new Course("Elektronska i mobilna trgovija","Kurs za elektronska i mobilna trgovija",teachers.get(2), Type.SUMMER));
        courses.add(new Course("Kompjuterski mrezi","Kurs za kompjuterski mrezi",teachers.get(3), Type.MANDATORY));
        courses.add(new Course("Bazi na podatoci","Kurs za bazi na podatoci",teachers.get(4), Type.WINTER));
    }
}

package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public static List<Student> students = new ArrayList<>();
    @PostConstruct
    public void init() {
        students.add(new Student("petar.petrov", "pp","Petar","Petrov"));
        students.add(new Student("mile.milev", "mm","Mile","Milev"));
        students.add(new Student("gjorgji.gjorgjiev", "gjgj","Gjorgji","Gjorgjiev"));
        students.add(new Student("jovan.jovanov", "jj","Jovan","Jovanov"));
        students.add(new Student("milosh.kuzmanovski", "mk","Milosh","Kuzmanovski"));
    }

    public List<Student> findAllStudents() {
        return this.students;
    }

    public List<Student> findAllByNameOrSurname(String text) {
        return students.stream().filter(student -> student.getName().contains(text)).collect(Collectors.toList());
    }

    public Student findStudentByUsername(String username) {
        return students.stream().filter(student -> student.getUsername().equals(username)).findFirst().get();
    }

    public Student save(Student student) {
        students.add(student);
        return student;
    }
}

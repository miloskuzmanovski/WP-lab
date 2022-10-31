package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static mk.ukim.finki.wp.lab.repository.StudentRepository.students;

@Repository
public class CourseRepository {
    private final StudentRepository studentRepository;

    public static List<Course> courses = new ArrayList<>();
    public CourseRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void init() {
        courses.add(new Course(1L, "Veb programiranje","Kurs za veb programiranje", students));
        courses.add(new Course(2L, "Operativni sistemi","Kurs za operativni sistemi",students));
        courses.add(new Course(3L, "Elektronska i mobilna trgovija","Kurs za elektronska i mobilna trgovija",students));
        courses.add(new Course(4L, "Kompjuterski mrezi","Kurs za kompjuterski mrezi",students));
        courses.add(new Course(5L, "Bazi na podatoci","Kurs za bazi na podatoci",students));
    }

    public List<Course> findAllCourses() {
        return courses;
    }
    public Course findById(Long courseId) {
        return courses.stream().filter(course -> course.getCourseId() == courseId).findFirst().get();
    }
    public List<Student> findAllStudentsByCourse(Long courseId) {
        return findById(courseId).getStudents();
    }
    public Course addStudentToCourse(Student student, Course course) {
        findById(course.getCourseId()).addStudent(student);
        return findById(course.getCourseId());
    }

}

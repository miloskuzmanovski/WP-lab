package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplemented implements CourseService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public CourseServiceImplemented(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAllCourses();
    }
    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }
    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = this.studentRepository.findStudentByUsername(username);
        Course course = this.courseRepository.findById(courseId);
        return this.courseRepository.addStudentToCourse(student, course);
    }
    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId);
    }
}

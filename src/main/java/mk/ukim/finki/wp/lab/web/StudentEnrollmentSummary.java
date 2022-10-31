package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student_enrollment_summary", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {
    private final CourseService courseService;
    private final StudentService studentService;
    private final SpringTemplateEngine springTemplateEngine;

    public StudentEnrollmentSummary(CourseService courseService, StudentService studentService, SpringTemplateEngine springTemplateEngine) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Long courseId = null;
        try {
            courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
        } catch (Exception e) {
            resp.sendRedirect("/listCourses");
            return;
        }
        Course course = courseService.findById(courseId);
        List<Student> students = courseService.listStudentsByCourse(courseId);
        context.setVariable("courseName", course.getName());
        context.setVariable("students", students);
        this.springTemplateEngine.process("studentsInCourse.html", context, resp.getWriter());
    }

    //@Override
    //protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    //}
}

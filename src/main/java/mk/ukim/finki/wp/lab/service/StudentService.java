package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();

    List<Student> searchByNameOrSurname(String text);

    Student getByUsername(String username);

    Student save(String username, String password, String name, String surname);

    List<Student> search(String term);

    List<Student> findAll();

    Student findByUsername(String student);
}
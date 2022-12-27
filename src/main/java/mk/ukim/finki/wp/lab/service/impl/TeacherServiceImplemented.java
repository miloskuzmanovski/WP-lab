package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.jpa.JpaTeacherRepository;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImplemented implements TeacherService {
    private final JpaTeacherRepository teacherRepository;

    public TeacherServiceImplemented(JpaTeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> search(String term) {
        return teacherRepository.findAll().stream().filter(teacher -> teacher.getFullName().getName().contains(term) || teacher.getFullName().getSurname().contains(term)).collect(Collectors.toList());
    }

    @Override
    public Teacher save(String name, String surname) {
        return teacherRepository.save(new Teacher(name, surname));
    }
}
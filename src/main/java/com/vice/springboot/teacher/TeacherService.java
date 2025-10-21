package com.vice.springboot.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeacher1() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getTeacher2() {
        return List.of(
                new Teacher(
                        1L,
                        "Mariam",
                        "mariam@gmail.com",
                        "date",
                        "22"
                )
        );
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherByEmail = teacherRepository.
                findTeacherByEmail(teacher.getEmail());
        if (teacherByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);
        if (!exists) {
            throw new IllegalStateException(
                    "teacher with id " + teacherId + " does not exists");
        } else {
            teacherRepository.deleteById(teacherId);
        }
    }

    @Transactional
    public void updateTeacher(
            Long teacherId,
            String name,
            String email) {

        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException(
                        "teacher with id " + teacherId + " does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(teacher.getName(), name)) {
            teacher.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(teacher.getEmail(), email)) {
            Optional<Teacher> teacherOptional = teacherRepository
                    .findTeacherByEmail(email);
            if (teacherOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            teacher.setEmail(email);
        }
    }

}


package com.vice.springboot.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin

public class TeacherController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(path = "api/v1/teacher1")
    @GetMapping
    public List<Teacher> getTeacher1() {
        return teacherService.getTeacher1();
    }

    @RequestMapping(path = "api/v1/teacher2")
    @GetMapping
    public List<Teacher> getTeacher2() {
        return teacherService.getTeacher2();
    }

    @RequestMapping(path = "api/v1/storeNewTeacher")
    @PostMapping
    public String postTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
        return "New Teacher Added";
    }

    @RequestMapping(path = "api/v1/deleteTeacher/{teacherId}")
    @DeleteMapping
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    @RequestMapping(path = "api/v1/deleteTeacher")
    @DeleteMapping
    public void deleteTeacher1(@RequestBody Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    @RequestMapping(path = "api/v1/updateTeacher/{teacherId}")
    @PutMapping
    public void updateTeacher1(
            @PathVariable("teacherId") Long teacherId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        teacherService.updateTeacher(teacherId, name, email);
    }

    @RequestMapping(path = "api/v1/updateTeacher")
    @PutMapping
    public void updateTeacher2(
            @RequestBody Long teacherId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        teacherService.updateTeacher(teacherId, name, email);
    }

}


package com.example.cassandraspringboot.controller;

import com.example.cassandraspringboot.entity.Student;

import com.example.cassandraspringboot.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController

public class AdminController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String helloController(){
        return "Hey the Application is running on port 8050";
    }

    //get all students
    @GetMapping("/admin/branch/section/students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();

    }
    //get all students of a class
    @GetMapping("/admin/branch/{branch}/section/{section}/students")
    public List<Student> getStudentsByBranch(@PathVariable String branch, @PathVariable String section){
        return studentService.getAllStudentsByBranch(branch,section);
    }

//    //get all students of a class of a subject
//    @GetMapping("/admin/branch/{branch}/section/{section}/students/subjectId/{subjectId}")
//    public List<Student> getStudentsBySubjectId(@PathVariable String branch, @PathVariable String section, @PathVariable int subjectId){
//        return studentService.getStudentsBySubjectId(branch,section,subjectId);
//    }

    @GetMapping("/admin/branch/section/students/subjectId/1/studentId/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/admin/branch/{branch}/section/{section}/students/studentId/{studentId}")
    public String deleteStudentById(@PathVariable String branch, @PathVariable String section, @PathVariable int studentId){
        return studentService.deleteStudentById(branch, section, studentId);
    }
    
     @PutMapping("/admin/branch/section/students/subj_id/{new_attendance}")
    public List<Student> updateAllStudentsAttendance(@PathVariable Integer new_attendance) {
        return studentService.updateAllStudentsAttendance(new_attendance);
    }
    @PostMapping("/admin/branch/section/add/student")
    public Student addStudent(@RequestBody Student s) {
        return studentService.addStudent(s);

        }


}


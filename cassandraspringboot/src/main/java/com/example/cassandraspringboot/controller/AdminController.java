package com.example.cassandraspringboot.controller;

import com.example.cassandraspringboot.entity.Student;

import com.example.cassandraspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/admin/branch/section/students/subjectId/1/studentId/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }


//    @GetMapping(value = "/employee/{id}")
//    public Student getEmployeeById(@PathVariable("id") int id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//
//    @PostMapping("/employee")
//    public Employee createEmployee(@Valid @RequestBody Employee emp) {
//
//        return employeeService.createEmployee(emp);
//    }
//
//
//    @PutMapping(value = "/employee/{id}")
//    public Employee UpdateEmployeeById(@PathVariable("id") int id, @RequestBody Employee emp) {
//        return employeeService.updateEmployeeById(id,emp);
//    }
//
//
//    @DeleteMapping(value = "/employee/{id}")
//    public String deleteEmployeeById(@PathVariable("id") int id) {
//        employeeService.deleteEmployeeById(id);
//        return "Employee with id " + id + " has been deleted!";
//    }
}


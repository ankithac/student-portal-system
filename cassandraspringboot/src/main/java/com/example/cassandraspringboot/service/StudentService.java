package com.example.cassandraspringboot.service;


import com.example.cassandraspringboot.entity.Student;

import com.example.cassandraspringboot.exceptions.StudentNotFoundException;
import com.example.cassandraspringboot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }


    public Optional<Student> getStudentById(int id){
        Optional <Student> optionalStudent = studentRepo.findById(id);
        if(!optionalStudent.isPresent())
            throw new StudentNotFoundException("Student not found!");
        return studentRepo.findById(id);

    }




//
//    public Employee updateEmployeeById(int id, Employee emp) {
//        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
//        if (!optionalEmployee.isPresent())
//            throw new EmployeeNotFoundException("Employee not found");
//        emp.setEmpId(id);
//        return employeeRepo.save(emp);
//    }
//
//    public void deleteEmployeeById(int id) {
//        Optional<Employee> optionalUser = employeeRepo.findById(id);
//        if (!optionalUser.isPresent())
//            throw new EmployeeNotFoundException("Employee Not Found");
//        employeeRepo.deleteById(id);
//    }
}


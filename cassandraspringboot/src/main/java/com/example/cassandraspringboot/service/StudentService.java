package com.example.cassandraspringboot.service;


import com.example.cassandraspringboot.entity.Student;

import com.example.cassandraspringboot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


//    public Employee createEmployee(Employee emp) {
//
//        return employeeRepo.save(emp);
//    }


    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    public List<Student> getAllStudentsBySection(){
         List<Student> students = studentRepo.findAll();
         List<Student> newList = null;
         for(Student student : students){
             if((student.getStudentBranch() == "Electronics") && (student.getStudentSection()=="A")){
                 newList.add(student);
             }
         }
         return null;

    }

    public Optional<Student> getStudentById(int id){
        return studentRepo.findById(id);
    }

//    public Employee getEmployeeById(int id) {
//        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
//        if (!optionalEmployee.isPresent())
//            throw new EmployeeNotFoundException("Employee with ID not found!");
//        return employeeRepo.findById(id).get();
//    }
//
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


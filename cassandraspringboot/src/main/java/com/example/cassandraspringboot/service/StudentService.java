package com.example.cassandraspringboot.service;


import com.example.cassandraspringboot.entity.Student;

import com.example.cassandraspringboot.exceptions.StudentNotFoundException;
import com.example.cassandraspringboot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }
    public List<Student> getAllStudentsByBranch(String branch,String section){
        List<Student> students = studentRepo.findAll();
        List<Student> newList =new ArrayList<Student>();
        for(Student student: students){
            if((student.getStudentBranch().equals(branch))&& (student.getStudentSection().equals(section))){
                System.out.println(student);
                newList.add(student);
            }
        }
        if(newList.isEmpty()){
            throw new StudentNotFoundException("Student Not Found");
        }
        return newList;
    }

//    public List<Student> getStudentsBySubjectId(String branch,String section,int subjectId){
//        List<Student> students = studentRepo.findAll();
//        List<Student> newList =new ArrayList<Student>();
//
//        for(Student student:students){
//            if((student.getStudentBranch().equals(branch)) && (student.getStudentSection().equals(section))){
//                System.out.print(student.getStudentName());
//                newList.add(student);
//                for(int i =0;i<4;i++){
//                    System.out.print(student.getStudentDetails()[subjectId][i]);
//                }
//                System.out.println(" ");
//            }
//        }
//        return newList;
//
//    }


    public Optional<Student> getStudentById(int id){
        Optional <Student> optionalStudent = studentRepo.findById(id);
        if(!optionalStudent.isPresent())
            throw new StudentNotFoundException("Student not found!");
        return studentRepo.findById(id);

    }

    public String deleteStudentById(String branch,String section, int studentId){
        Optional <Student> optionalStudent = studentRepo.findById(studentId);
        if(!optionalStudent.isPresent())
            throw new StudentNotFoundException("Student not found!");
        studentRepo.deleteById(studentId);
        return "Done!";

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


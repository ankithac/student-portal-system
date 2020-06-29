package com.example.cassandraspringboot.repository;


import com.example.cassandraspringboot.entity.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudentRepo extends CassandraRepository<Student, Integer> {
}
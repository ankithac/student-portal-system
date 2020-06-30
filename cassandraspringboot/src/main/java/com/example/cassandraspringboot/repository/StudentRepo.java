package com.example.cassandraspringboot.repository;


import com.example.cassandraspringboot.entity.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface StudentRepo extends CassandraRepository<Student, Integer> {

}
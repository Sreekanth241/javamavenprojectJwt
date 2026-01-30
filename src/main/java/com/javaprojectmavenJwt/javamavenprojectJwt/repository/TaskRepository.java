package com.javaprojectmavenJwt.javamavenprojectJwt.repository;

import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUsersId(long userid);
}

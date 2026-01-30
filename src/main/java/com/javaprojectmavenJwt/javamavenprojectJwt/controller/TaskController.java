package com.javaprojectmavenJwt.javamavenprojectJwt.controller;

import com.javaprojectmavenJwt.javamavenprojectJwt.payload.TaskDto;
import com.javaprojectmavenJwt.javamavenprojectJwt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/{userid}/task")
    public ResponseEntity<TaskDto>saveTask(
            @PathVariable(name = "userid")long userid,
            @RequestBody TaskDto taskDto
    ){
        return new ResponseEntity<>(taskService.saveTask(userid,taskDto), HttpStatus.CREATED);

    }
    @GetMapping("/{userid}/tasks")
    public ResponseEntity<List<TaskDto>>getAllTask(
            @PathVariable(name = "userid")long userid
    ){
        return new ResponseEntity<>(taskService.getAllTasks(userid), HttpStatus.OK);
    }
    @GetMapping("/{userid}/tasks/{taskid}")
    public  ResponseEntity<TaskDto>getTask(
            @PathVariable(name = "userid")long userid,
            @PathVariable(name = "taskid")long taskid
            ){
        return new  ResponseEntity<>(taskService.getTask(userid,taskid),HttpStatus.OK);

    }
    @DeleteMapping("/{userid}/tasks/{taskid}")
    public  ResponseEntity<String >deleteTask(
            @PathVariable(name = "userid")long userid,
            @PathVariable(name = "taskid")long taskid
    ){
        taskService.deleteTask(userid,taskid);
        return new  ResponseEntity<>("user  deleted successfully",HttpStatus.OK);

    }

}

package com.javaprojectmavenJwt.javamavenprojectJwt.ServiceImpl;

import com.javaprojectmavenJwt.javamavenprojectJwt.exception.APIException;
import com.javaprojectmavenJwt.javamavenprojectJwt.exception.TaskNotFound;
import com.javaprojectmavenJwt.javamavenprojectJwt.exception.UserNotFound;
import com.javaprojectmavenJwt.javamavenprojectJwt.payload.TaskDto;
import com.javaprojectmavenJwt.javamavenprojectJwt.repository.TaskRepository;
import com.javaprojectmavenJwt.javamavenprojectJwt.repository.UserRepository;
import com.javaprojectmavenJwt.javamavenprojectJwt.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Task;
import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceIml implements TaskService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  TaskRepository taskRepository;

    @Override
    public TaskDto saveTask(long userid, TaskDto taskDto) {
        Users users = userRepository.findById(userid).orElseThrow(
                () -> new UserNotFound(String.format("user id  not  found", userid)));
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUsers(users);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }


    @Override
    public List<TaskDto> getAllTasks(long userid) {
        userRepository.findById(userid).orElseThrow(
                () -> new UserNotFound(String.format("user id  not  found", userid)));
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(
                task -> modelMapper.map(task, TaskDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTask(long userid, long taskid) {
        Users users=userRepository.findById(userid).orElseThrow(
                ()-> new UserNotFound(String.format("user Id %d not found", userid))
        );
        Task task =taskRepository.findById(taskid).orElseThrow(
                () -> new TaskNotFound(String.format("Task Id %d not found",taskid))
        );
        if (users.getId()!=task.getUsers().getId()){
            throw  new APIException(String.format("Task Id %d is not  belongs to User Id %d", taskid, userid));
        }
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public void deleteTask(long userid, long taskid) {
        Users users=userRepository.findById(userid).orElseThrow(
                ()-> new UserNotFound(String.format("user Id %d not found", userid))
        );
        Task task =taskRepository.findById(taskid).orElseThrow(
                () -> new TaskNotFound(String.format("Task Id %d not found",taskid))
        );
        if (users.getId()!=task.getUsers().getId()){
            throw  new APIException(String.format("Task Id %d is not  belongs to User Id %d", taskid, userid));
        }
        taskRepository.deleteById(taskid);
    }

}

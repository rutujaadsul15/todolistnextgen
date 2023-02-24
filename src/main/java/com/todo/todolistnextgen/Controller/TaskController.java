package com.todo.todolistnextgen.Controller;

import com.todo.todolistnextgen.Model.TaskDetails;
import com.todo.todolistnextgen.Service.TaskDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskDetailImpl taskDetailImpl;

    @PostMapping("/add")
    public ResponseEntity<TaskDetails> addTask(@RequestBody @Valid TaskDetails taskDetails) {
        TaskDetails taskDetails1 = taskDetailImpl.addTaskInfo(taskDetails);
        return ResponseEntity.ok(taskDetails1);
    }

    @PutMapping("/update")
    public  ResponseEntity<TaskDetails> updateTask(@RequestBody @Valid TaskDetails taskDetails){
        TaskDetails taskDetails1= taskDetailImpl.updateTaskDetails(taskDetails);
        return ResponseEntity.ok(taskDetails1);
    }

    @DeleteMapping ("/delete")
    public  TaskDetails deleteTask(@RequestParam("id") Integer id){
       return taskDetailImpl.deleteTaskDetails(id);

    }


        @GetMapping("/getTaskList")
    public ResponseEntity<List<TaskDetails>> getTaskByContactNumber(@RequestParam("contactNumber") String contactNumber) {
        List<TaskDetails> taskDetailsList = taskDetailImpl.getTaskByContactNumber(contactNumber);
        return ResponseEntity.ok(taskDetailsList);
    }
}
